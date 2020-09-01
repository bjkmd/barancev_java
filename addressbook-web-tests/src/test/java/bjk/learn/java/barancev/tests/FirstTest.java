package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.helpers.NavigationHelper;
import bjk.learn.java.barancev.dataObjects.RegistrationData;
import org.testng.annotations.Test;

public class FirstTest extends TestBase {


    private NavigationHelper navigate;

    @Test
    public void testOpenAllCategories() {

        navigate = app.getNavigationHelper();

        navigate.openMainPage();
        navigate.openCategory("FISH");
        navigate.openCategory("DOGS");
        navigate.openCategory("CATS");
        navigate.openCategory("REPTILES");
        navigate.openCategory("BIRDS");

    }


    @Test
    public void testRegistration() {

        navigate = app.getNavigationHelper();
        navigate.openLoginPage();
        navigate.openRegistrationForm();
        navigate.fillRegistrationForm(new RegistrationData("name3",
                "password"));

    }


}
