package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import bjk.learn.java.barancev.dataObjects.UserData;
import bjk.learn.java.barancev.dataObjects.userDataBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FirstTest extends TestBase {


    @Test
    public void testOpenAllCategories() {

        navigate.openMainPage();
        navigate.openCategory("FISH");
        navigate.openCategory("DOGS");
        navigate.openCategory("CATS");
        navigate.openCategory("REPTILES");
        navigate.openCategory("BIRDS");

    }

    @Test
    public void testRegistration() {

        UserData userData = new userDataBuilder().
                setName("name3").
                setPassword("password").
                createUserData();

        navigate.openLoginPage();
        navigate.openRegistrationForm();
        userActions.fillRegistrationForm(userData);

    }

    @Test
    public void testLogin() {

        navigate.openMainPage();
        navigate.openLoginPage();

        UserData userData = new userDataBuilder().
                setName("name3").
                setPassword("password").
                createUserData();

        userActions.fillLoginForm(userData);

    }

    @Test
    public void testEditUser() {

        UserData userData = new userDataBuilder().
                setName("name3").
                setPassword("password").
                createUserData();

        UserData userDataEdited = new userDataBuilder().
                setName("name3").
                setPassword("password").
                setAddr1("Addr1 EDITED").
                createUserData();

        navigate.openMainPage();
        navigate.openLoginPage();
        userActions.fillLoginForm(userData);
        navigate.openMyAccountPage();

        userActions.fillUserProfileForm(userDataEdited);

    }

    @Test
    public void testAddToCart() {

        navigate.openMainPage();
        navigate.openCategory("FISH");
        Assert.assertEquals(userActions.getProductsList().size(),4);
        navigate.openPDPbyNumber(2);
        userActions.addToCartByNumber(1);
        navigate.openCart();
        List<ProductInCartItem> before = userActions.getProductsInCartList();

        navigate.openCategory("DOGS");
        navigate.openPDPbyNumber(2);
        userActions.addToCartByNumber(1);
        navigate.openCart();
        List<ProductInCartItem> after = userActions.getProductsInCartList();

        Assert.assertEquals(before.size()+1,after.size());
        after.remove(after.size()-1);
        Assert.assertEquals(before,after);

    }
}
