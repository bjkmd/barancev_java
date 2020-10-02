package bjk.learn.java.barancev.tests;

import bjk.learn.java.barancev.appmanager.ApplicationManager;
import bjk.learn.java.barancev.helpers.CompositeActionsHelper;
//import bjk.learn.java.barancev.helpers.DBHelper;
import bjk.learn.java.barancev.helpers.DBHelper;
import bjk.learn.java.barancev.helpers.NavigationHelper;
import bjk.learn.java.barancev.helpers.UserActionsHelper;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

public abstract class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

//    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);
    protected static final ApplicationManager app =
        new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));
    protected NavigationHelper goTo;
    protected UserActionsHelper user;
    protected CompositeActionsHelper action;
    protected DBHelper db;

    @BeforeTest
    public void setUp() throws IOException {
        app.init();
        user = app.getUserActionsHelper();
        goTo = app.getNavigationHelper();
        action = app.getCompositeActionsHelper();
        db = app.getDBHelper();
    }

    @AfterTest
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void logTestStart(Method method,Object[] parameters){
        logger.info("Start test: "+method.getName()+" With parameters: "+ Arrays.asList(parameters));
    }

    @AfterMethod(alwaysRun = true)
    public void logTestStop(Method method,Object[] parameters){
        logger.info("Stop test: "+method.getName());
    }


}
