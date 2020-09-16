package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import bjk.learn.java.barancev.dataObjects.UserData;
import bjk.learn.java.barancev.dataObjects.UserDataBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class FirstTest extends TestBase {


    @Test
    public void testOpenAllCategories() {

        goTo.mainPage();
        goTo.category("FISH");
        goTo.category("DOGS");
        goTo.category("CATS");
        goTo.category("REPTILES");
        goTo.category("BIRDS");

    }

    @Test
    public void testRegistration() {

        UserData userData = new UserDataBuilder().
                setName("name3").
                setPassword("password").
                createUserData();

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
