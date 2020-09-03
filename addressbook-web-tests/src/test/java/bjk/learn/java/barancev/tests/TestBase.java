package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.appmanager.ApplicationManager;
import bjk.learn.java.barancev.helpers.NavigationHelper;
import bjk.learn.java.barancev.helpers.UserActionsHelper;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    protected NavigationHelper navigate;
    protected UserActionsHelper userActions;

    @BeforeMethod
    public void setUp() {
        app.init();
        userActions = app.getUserActionsHelper();
        navigate = app.getNavigationHelper();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }


}
