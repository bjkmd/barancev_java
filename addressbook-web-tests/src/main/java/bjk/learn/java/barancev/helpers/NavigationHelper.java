package bjk.learn.java.barancev.helpers;

import bjk.learn.java.barancev.dataObjects.RegistrationData;
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
        click(By.id("LogoContent"));
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

    public void fillRegistrationForm(RegistrationData registrationData) {

        type(By.name("username"), registrationData.getName());
        type(By.name("password"), registrationData.getPassword());
        type(By.name("repeatedPassword"), registrationData.getPassword());
        type(By.name("account.firstName"), registrationData.getFirst());
        type(By.name("account.lastName"), registrationData.getLast());
        type(By.name("account.email"), registrationData.getEmail());
        type(By.name("account.phone"), registrationData.getPhone());
        type(By.name("account.address1"), registrationData.getAddr1());
        type(By.name("account.address2"), registrationData.getAddr2());
        type(By.name("account.city"), registrationData.getCity());
        type(By.name("account.state"), registrationData.getState());
        type(By.name("account.zip"), registrationData.getZip());
        type(By.name("account.country"), registrationData.getCountry());
        click(By.name("newAccount"));
    }
}
