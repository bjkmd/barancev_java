package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.appmanager.ApplicationManager;
import bjk.learn.java.barancev.helpers.CompositeActionsHelper;
import bjk.learn.java.barancev.helpers.NavigationHelper;
import bjk.learn.java.barancev.helpers.UserActionsHelper;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    protected NavigationHelper goTo;
    protected UserActionsHelper user;
    protected CompositeActionsHelper action;

    @BeforeSuite
    public void setUp() {
        app.init();
        user = app.getUserActionsHelper();
        goTo = app.getNavigationHelper();
        action = app.getCompositeActionsHelper();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}
