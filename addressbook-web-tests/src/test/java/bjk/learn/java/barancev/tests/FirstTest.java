package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import bjk.learn.java.barancev.dataObjects.UserData;
import bjk.learn.java.barancev.dataObjects.UserDataBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FirstTest extends TestBase {

    @DataProvider
    public Iterator<Object []> userData() throws IOException {
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

    @Test
    public void testOpenAllCategories() {

        goTo.mainPage();
        goTo.category("FISH");
        goTo.category("DOGS");
        goTo.category("CATS");
        goTo.category("REPTILES");
        goTo.category("BIRDS");

    }

    @Test(dataProvider = "userData")
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
