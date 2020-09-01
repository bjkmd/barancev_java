package bjk.learn.java.barancev.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.remote.BrowserType.*;

public class ApplicationManager {

    protected WebDriver driver;

    NavigationHelper navigationHelper;
    private final String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void init() {
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

        }
        driver.get("http://localhost:8099/");
        driver.manage().window().setSize(new Dimension(1680, 991));

        navigationHelper = new NavigationHelper(driver);
        navigationHelper.openPetStore();

    }

    public void stop() {
        driver.quit();
    }

}
