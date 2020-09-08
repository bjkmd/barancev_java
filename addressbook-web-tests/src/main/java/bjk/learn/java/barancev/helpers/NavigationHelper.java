package bjk.learn.java.barancev.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void openPageByURL(String url){
        driver.get(url);
    }

    public void openCategory(final String category) {
        click(By.cssSelector("a[href*='" + category + "']"));
    }

    public void openMainPage() {
        boolean isOnTheSamePage = isElementPresent(By.id("Sidebar"))
                && isElementPresent(By.id("MainImage"));
        if (!isOnTheSamePage) {
            click(By.id("LogoContent"));
        }
    }

    public void openPetStore() {
        click(By.linkText("Enter the Store"));
    }

    public void openLoginPage() {
        click(By.linkText("Sign In"));
    }

    public void openRegistrationForm() {
        click(By.linkText("Register Now!"));
    }

    public void openMyAccountPage() {
        click(By.linkText("My Account"));
    }

    public void openPDPbyNumber(int numberInTheList){
        openPDP(numberInTheList);
    }

    private void openPDP(int numberInTheList) {
        driver.findElements(byPartialURI("productId")).get(numberInTheList).click();
    }

    public void openCart() {
        driver.findElement(byPartialURI("viewCart")).click();
    }
}
