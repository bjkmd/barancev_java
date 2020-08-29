package bjk.learn.java.barancev.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    protected WebDriver driver;

    NavigationHelper navigationHelper;

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8099/");
        driver.manage().window().setSize(new Dimension(1680, 991));

        navigationHelper = new NavigationHelper(driver);
        navigationHelper.openPetStore();

    }

    public void stop() {
        driver.quit();
    }

}
