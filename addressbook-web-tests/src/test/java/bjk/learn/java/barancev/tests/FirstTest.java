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

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FirstTest extends TestBase {

    @DataProvider
    public Iterator<Object []> userDataCsv() throws IOException {
        List<Object []> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.csv")));
        String line = reader.readLine();
        while (line!=null) {
            String[] split= line.split(";");
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
    public Iterator<Object []> userDataXml() throws IOException {
        List<Object []> list;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.xml")));
        String line = reader.readLine();
        StringBuilder xml = new StringBuilder();
        while (line!=null) {
            xml.append(line);
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.processAnnotations(UserData.class);
        List<UserData> userDataList= (List<UserData>) xStream.fromXML(xml.toString());
        return userDataList.stream().map(userData -> new Object[]{userData}).collect(Collectors.toList()).iterator();

    }

    @DataProvider
    public Iterator<Object []> userDataJson() throws IOException {
        List<Object []> list;
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.json")));
        String line = reader.readLine();
        StringBuilder json = new StringBuilder();
        while (line!=null) {
            json.append(line);
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<UserData> userDataList= gson.fromJson(json.toString(),new TypeToken<List<UserData>>(){}.getType());
        return userDataList.stream().map(userData -> new Object[]{userData}).collect(Collectors.toList()).iterator();

    }

    @Test
    public void testOpenAllCategories() {

        goTo.mainPage();
        goTo.category("FISH");
        goTo.category("DOGS");
        goTo.category("CATS");
        goTo.category("REPTILES");
        goTo.category("BIRDS");

    }

    @Test(dataProvider = "userDataJson")
    public void testRegistration(UserData userData) {

        goTo.openLoginPage();
        goTo.openRegistrationForm();
        user.fillRegistrationForm(userData);

    }

    @Test
    public void testLogin() {

        goTo.mainPage();
        goTo.openLoginPage();

        UserData userData = new UserDataBuilder().
                setName("name3").
                setPassword("password").
                createUserData();

        user.fillLoginForm(userData);

    }

    @Test
    public void testEditUser() {

        UserData userData = new UserDataBuilder().
                setName("name3").
                setPassword("password").
                createUserData();

        UserData userDataEdited = new UserDataBuilder().
                setName("name3").
                setPassword("password").
                setAddr1("Addr1 EDITED").
                createUserData();

        goTo.mainPage();
        goTo.openLoginPage();
        user.fillLoginForm(userData);
        goTo.openMyAccountPage();

        user.fillUserProfileForm(userDataEdited);

    }

    @Test
    public void testAddToCart() {

        goTo.mainPage();
        goTo.category("FISH");
        Assert.assertEquals(user.getProductsList().size(),4);
        goTo.pdpByNumber(2);
        user.addToCartByNumber(1);
        goTo.cart();
        Set<ProductInCartItem> before = user.getProductsInCart();

        goTo.category("DOGS");
        goTo.pdpByNumber(2);
        user.addToCartByNumber(1);
        goTo.cart();
        Set<ProductInCartItem> after = user.getProductsInCart();

        Assert.assertEquals(before.size()+1,after.size());
        ProductInCartItem toRemove = after.iterator().next();
        after.remove(toRemove);
        Assert.assertEquals(before,after);

    }
}
