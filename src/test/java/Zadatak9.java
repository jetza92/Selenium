import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak9 {

    WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");
        WebElement popupButton = driver.findElement(By.cssSelector("button[type='submit']"));
        popupButton.click();

        Thread.sleep(3000);
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");


    }

    @BeforeMethod
    public void pageSetUp() {

        WebElement continueButton = driver.findElement(By.className("a-button-inner"));
        continueButton.click();
        driver.navigate().to("https://www.amazon.com/Selenium-Framework-Design-Data-Driven-Testing/dp/1788473574/ref=sr_1_2?dchild=1&keywords=selenium+test&qid=1631829742&sr=8-2");

    }

    @Test (priority = 1)
    public void addToCart() {

        WebElement itemName = driver.findElement(By.id("productTitle"));
        String itemNameText = itemName.getText();

        WebElement cartNumber = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartNumber.getText(), "0");

        cartNumber.click();
        WebElement emptyCart = driver.findElement(By.id("sc-empty-cart"));
        Assert.assertTrue(emptyCart.isDisplayed());

        driver.navigate().back();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement addedToCartMessage = driver.findElement(By.id("NATC_SMART_WAGON_CONF_MSG_SUCCESS"));
        Assert.assertTrue(addedToCartMessage.isDisplayed());
        Assert.assertEquals(cartNumber.getText(), "1");
        cartNumber.click();

        WebElement itemNameInCart = driver.findElement(By.className("a-truncate-cut"));
        Assert.assertEquals(itemNameInCart.getText(), itemNameText);
    }


    @AfterMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        WebElement emptyCart = driver.findElement(By.id("sc-empty-cart"));
        Assert.assertTrue(emptyCart.isDisplayed());
        WebElement cartNumber = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(cartNumber.getText(), "0");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
