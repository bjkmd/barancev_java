package bjk.learn.java.barancev.generators;

import bjk.learn.java.barancev.dataObjects.UserData;
import bjk.learn.java.barancev.dataObjects.UserDataBuilder;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class UserDataGenerator {

  @Parameter(names = "-c", description = "Number of users to generate")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String fileName;

  @Parameter(names = "-d", description = "Data format")
  public String dataFormat;


  public static void main(String[] args) throws IOException {

    UserDataGenerator userDataGenerator = new UserDataGenerator();
    JCommander jCommander = new JCommander(userDataGenerator);
    try {
      jCommander.parse(args);
    } catch (ParameterException e) {
      jCommander.usage();
      return;
    }
    userDataGenerator.run();
  }

  private void run() throws IOException {
    List<UserData> users = generateUsers(count);
    switch (dataFormat.toLowerCase()) {
      case "csv":
        saveAsCsv(users, new File(fileName));
        break;
      case "xml":
        saveAsXML(users, new File(fileName));
        break;
      case "json":
        saveAsJson(users, new File(fileName));
        break;
      default:
        System.out.println("Unknown format: " + dataFormat);
        break;
    }

  }

  private void saveAsJson(List<UserData> users, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    try (Writer writer = new FileWriter(file)) {
      writer.write(gson.toJson(users));
    }
  }

  private void saveAsXML(List<UserData> users, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(UserData.class);
    try (Writer writer = new FileWriter(file)) {
      writer.write(xstream.toXML(users));
    }

  }

  private void saveAsCsv(List<UserData> users, File file) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      for (UserData user : users) {
        writer.write(String.format("%s;%s;%s\n",
                user.getName(),
                user.getPassword(),
                user.getEmail()));

      }
    }
  }

  private List<UserData> generateUsers(int count) {
    List<UserData> userData = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      userData.add(new UserDataBuilder().
              setName("TestName" + i).
              createUserData());
    }
    return userData;
  }
}
