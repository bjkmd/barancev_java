package bjk.learn.java.barancev.appmanager;

import bjk.learn.java.barancev.helpers.NavigationHelper;
import bjk.learn.java.barancev.helpers.UserActionsHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.remote.BrowserType.*;

public class ApplicationManager {

    protected WebDriver driver;

    NavigationHelper navigationHelper;
    UserActionsHelper userActionsHelper;
    private final String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public UserActionsHelper getUserActionsHelper() {
        return userActionsHelper;
    }
    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void init() {
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

        navigationHelper.openPageByURL("http://localhost:8099/");

        navigationHelper.openPetStore();

    }

    public void stop() {
        driver.quit();
    }

}
