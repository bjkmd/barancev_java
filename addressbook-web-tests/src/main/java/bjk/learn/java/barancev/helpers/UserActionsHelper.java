package bjk.learn.java.barancev.helpers;

import bjk.learn.java.barancev.dataObjects.Product;
import bjk.learn.java.barancev.dataObjects.ProductInCartItem;
import bjk.learn.java.barancev.dataObjects.ProductItem;
import bjk.learn.java.barancev.dataObjects.UserData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

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

    public int countProducts(){
       return driver.findElements(byPartialURI("productId")).size();
    }

    public ArrayList<Product> getProductsList() {
        List<Product> products= new ArrayList<>();
        List<WebElement> elements= driver.findElements(By.xpath("//*[tr]/*[td]/*[a]/.."));
        for (WebElement element:
             elements) {
            String productId = element.findElement(By.xpath("//td[1]")).getText();
            String productName = element.findElement(By.xpath("//td[2]")).getText();
            Product product = new Product(productName,productId);
            products.add(product);
        }

        return (ArrayList<Product>) products;


    }

    public void addToCartByNumber(int itemNumber) {

        driver.findElements(By.xpath("//*[tr]/*[td]/*[a][2]")).get(itemNumber).click();

    }

    public List<ProductInCartItem> getProductsInCartList() {
        List<ProductInCartItem> productInCartItems = new ArrayList<>();
        List<WebElement> elements= driver.findElements(By.xpath("//*[tr]/*[td]/*[a]/.."));
        for (WebElement element:
                elements) {
            String itemId = element.findElement(By.xpath("//td[1]/a")).getText();
            String productId = element.findElement(By.xpath("//td[2]")).getText();
            String description = element.findElement(By.xpath("//td[3]")).getText();
            boolean inStock = Boolean.parseBoolean(element.findElement(By.xpath("//td[4]")).getText());
            int quantity = Integer.parseInt(element.findElement(By.xpath("//td[5]/input")).getAttribute("value"));
            String price = element.findElement(By.xpath("//td[6]")).getText();
            String totalCost = element.findElement(By.xpath("//td[7]")).getText();


            ProductInCartItem productInCartItem = new ProductInCartItem(null,
                    productId,
                    itemId,
                    description,
                    inStock,
                    quantity,
                    price,
                    totalCost);
            productInCartItems.add(productInCartItem);
        }

        return productInCartItems;
    }
}
