package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import bjk.learn.java.barancev.dataObjects.UserData;
import bjk.learn.java.barancev.dataObjects.UserDataBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRegistrationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> userDataCsv() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.csv")));
    String line = reader.readLine();
    while (line != null) {
      String[] split = line.split(";");
      list.add(new Object[]{new UserDataBuilder().
              setName(split[0]).
              setPassword(split[1]).
              setEmail(split[2]).
              createUserData()});
      line = reader.readLine();
    }
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> userDataXml() throws IOException {
    List<Object[]> list;
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.xml")))) {
      String line = reader.readLine();
      StringBuilder xml = new StringBuilder();
      while (line != null) {
        xml.append(line);
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(UserData.class);
      List<UserData> userDataList = (List<UserData>) xStream.fromXML(xml.toString());
      return userDataList.stream().map(userData -> new Object[]{userData}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> userDataJson() throws IOException {
    List<Object[]> list;
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.json")))) {
      String line = reader.readLine();
      StringBuilder json = new StringBuilder();
      while (line != null) {
        json.append(line);
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<UserData> userDataList = gson.fromJson(json.toString(), new TypeToken<List<UserData>>() {
      }.getType());
      return userDataList.stream().map(userData -> new Object[]{userData}).collect(Collectors.toList()).iterator();

    }
  }



  @Test(dataProvider = "userDataJson")
  public void testRegistration(UserData userData) {
    goTo.openLoginPage();
    goTo.openRegistrationForm();
    user.fillRegistrationForm(userData);
//    user.logOut();

  }

//  @Test
//  public void testLogin() {
//
//    goTo.mainPage();
//    goTo.openLoginPage();
//
//    UserData userData = new UserDataBuilder().
//            setName("name3").
//            setPassword("password").
//            createUserData();
//
//    user.fillLoginForm(userData);
//
//  }


}
