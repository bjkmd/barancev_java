package bjk.learn.java.barancev.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1680, 991));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }


}
