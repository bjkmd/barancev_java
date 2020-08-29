import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstTest extends TestBase{

    private void openCategory(final String category) {
        click(By.cssSelector("a[href*='" + category + "']"));
    }

    @Test
    public void testOpenAllCategories() {

        openCategory("FISH");
        openCategory("DOGS");
        openCategory("CATS");
        openCategory("REPTILES");
        openCategory("BIRDS");









        //        driver.findElement(By.cssSelector("#SidebarContent > a:nth-child(1) > img")).click();
//        By searchInput = By.cssSelector("a[href*='FISH']");
//        wait.until(presenceOfElementLocated(searchInput));
//        driver.findElement(By.linkText("FI-SW-01")).click();
//        driver.findElement(By.linkText("Add to Cart")).click();
////        driver.findElement(By.id("stripes-1415605895")).click();
////        driver.findElement(By.cssSelector("p:nth-child(2)")).click();
//        driver.findElement(By.name("login")).sendKeys("ACID");
//        driver.findElement(By.name("password")).sendKeys("ACID");
////        driver.findElement(By.id("stripes-1415605895")).click();
////        driver.findElement(By.name("password")).click();
//        driver.findElement(By.name("signon")).click();
//        driver.findElement(By.linkText("My Account")).click();
//        driver.findElement(By.linkText("Proceed to Checkout")).click();
    }
}
