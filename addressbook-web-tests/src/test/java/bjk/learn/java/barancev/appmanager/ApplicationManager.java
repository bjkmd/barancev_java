package bjk.learn.java.barancev.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager extends HelperBase {

    NavigationHelper navigationHelper;

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public void init() {
        navigationHelper = new NavigationHelper();
        driver.get("http://localhost:8099/actions/Catalog.action");

//        navigationHelper.openPetStore();
//        click(By.linkText("Enter the Store"));
    }

    public void stop() {
        driver.quit();
    }


}
