package bjk.learn.java.barancev.helpers;

import bjk.learn.java.barancev.dataObjects.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class UserActionsHelper extends HelperBase {
    public UserActionsHelper(WebDriver driver) {
        super(driver);
    }

    public void fillRegistrationForm(UserData userData) {

        fillUserProfile(userData);
        click(By.name("newAccount"));
    }

    public void fillLoginForm(UserData userData) {
        type(By.name("username"), userData.getName());
        type(By.name("password"), userData.getPassword());
        click(By.name("signon"));
    }

    public void fillUserProfileForm(UserData userData) {

        fillUserProfile(userData);
        click(By.name("editAccount"));
    }

    private void fillUserProfile(UserData userData) {

        if (isElementPresent(By.name("username"))) {
            type(By.name("username"), userData.getName());
        }
        type(By.name("password"), userData.getPassword());
        type(By.name("repeatedPassword"), userData.getPassword());
        type(By.name("account.firstName"), userData.getFirst());
        type(By.name("account.lastName"), userData.getLast());
        type(By.name("account.email"), userData.getEmail());
        type(By.name("account.phone"), userData.getPhone());
        type(By.name("account.address1"), userData.getAddr1());
        type(By.name("account.address2"), userData.getAddr2());
        type(By.name("account.city"), userData.getCity());
        type(By.name("account.state"), userData.getState());
        type(By.name("account.zip"), userData.getZip());
        type(By.name("account.country"), userData.getCountry());
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(By.name("username"));
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }
}
