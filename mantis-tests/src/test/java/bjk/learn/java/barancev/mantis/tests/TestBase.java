package bjk.learn.java.barancev.mantis.tests;

import bjk.learn.java.barancev.mantis.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

//import bjk.learn.java.barancev.helpers.DBHelper;

public abstract class TestBase {

    protected static final ApplicationManager app =
        new ApplicationManager(System.getProperty("browser",BrowserType.CHROME));

    @BeforeSuite
    public void setUp() throws IOException {
        app.init();

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }



}
