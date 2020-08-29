package bjk.learn.java.barancev.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void openCategory(final String category) {
        click(By.cssSelector("a[href*='" + category + "']"));
    }

    public void openMainPage() {
        click(By.id("LogoContent"));
    }

    public void openPetStore() {
        click(By.linkText("Enter the Store"));
    }
}
