import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8099/");
        driver.manage().window().setSize(new Dimension(1680, 991));
        openMainPage();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private void openMainPage() {
        click(By.linkText("Enter the Store"));
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }
}
