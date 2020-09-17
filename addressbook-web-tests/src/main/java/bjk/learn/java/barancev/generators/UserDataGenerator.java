package bjk.learn.java.barancev.generators;

import bjk.learn.java.barancev.dataObjects.UserData;
import bjk.learn.java.barancev.dataObjects.UserDataBuilder;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class UserDataGenerator {

  @Parameter(names = "-c",description = "Number of users to generate")
  public int count;

  @Parameter(names = "-f",description = "Target file")
  public String fileName;

  @Parameter(names = "-d",description = "Data format")
  public String dataFormat;


  public static void main(String[] args) throws IOException {

    UserDataGenerator userDataGenerator = new UserDataGenerator();
    JCommander jCommander = new  JCommander(userDataGenerator) ;
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
    if (dataFormat.toLowerCase().equals("csv"))
      saveAsCsv(users,new File(fileName));
    else if (dataFormat.toLowerCase().equals("xml"))
      saveAsXML(users,new File(fileName));
    else System.out.println("Unknown format: "+dataFormat);

  }

  private void saveAsXML(List<UserData> users, File file) throws IOException {
    Writer  writer = new FileWriter(file);
    XStream xstream = new XStream();
    xstream.processAnnotations(UserData.class);
    writer.write(xstream.toXML(users));
    writer.close();

  }

  private  void saveAsCsv(List<UserData> users, File file) throws IOException {
    Writer  writer = new FileWriter(file);
    for(UserData user : users){
      writer.write(String.format("%s;%s;%s\n",
              user.getName(),
              user.getPassword(),
              user.getEmail()));

    }
    writer.close();
  }

  private  List<UserData> generateUsers(int count) {
    List<UserData> userData = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      userData.add(new UserDataBuilder().
              setName("TestName"+i).
              createUserData());
    }
    return userData;
  }
}
