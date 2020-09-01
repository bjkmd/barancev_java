package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.dataObjects.UserDataBuilder;
import bjk.learn.java.barancev.helpers.NavigationHelper;
import bjk.learn.java.barancev.dataObjects.UserData;
import bjk.learn.java.barancev.helpers.UserActionsHelper;
import org.testng.annotations.Test;

public class FirstTest extends TestBase {


    private NavigationHelper navigate;
    private UserActionsHelper userActions;

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
        userActions = app.getUserActionsHelper();
        UserData userData = new UserDataBuilder().
                setName("name3").
                setPassword("password").
                createUserData();

        navigate.openLoginPage();
        navigate.openRegistrationForm();
        userActions.fillRegistrationForm(userData);

    }


}
