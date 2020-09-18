package bjk.learn.java.barancev.appmanager;

import bjk.learn.java.barancev.helpers.CompositeActionsHelper;
import bjk.learn.java.barancev.helpers.NavigationHelper;
import bjk.learn.java.barancev.helpers.UserActionsHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.openqa.selenium.remote.BrowserType.*;

public class ApplicationManager {

    protected WebDriver driver;

    Properties properties;
    NavigationHelper navigationHelper;
    UserActionsHelper userActionsHelper;
    CompositeActionsHelper compositeActionsHelper;
    private final String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public UserActionsHelper getUserActionsHelper() {
        return userActionsHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
    public CompositeActionsHelper getCompositeActionsHelper() {
        return compositeActionsHelper;
    }

    public void init() throws IOException {
        String target = System.getProperty("target","local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
        if (browser.equals(CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals(FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().setSize(new Dimension(1680, 991));

        navigationHelper = new NavigationHelper(driver);
        userActionsHelper = new UserActionsHelper(driver);
        compositeActionsHelper = new CompositeActionsHelper(driver);

        navigationHelper.openPageByURL(properties.getProperty("web.baseUrl"));

        navigationHelper.openPetStore();

    }

    public void stop() {
        driver.quit();
    }

}
