package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Domaci5 {

    //https://demoqa.com/text-box
    //Popuniti formu, kliknuti na dugme submit i proveriti da li se podaci iz forme pravilno prikazuju

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void pageSetUp() {
        driver.navigate().to("https://demoqa.com/text-box");
    }

    @Test (priority = 1)
    public void test() {

        WebElement fullNameField = driver.findElement(By.id("userName"));
        WebElement emailField = driver.findElement(By.id("userEmail"));
        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddressField = driver.findElement(By.id("permanentAddress"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String fullName = "Jelena Ozegovic";
        String email = "ozegovic.v.jelena@gmail.com";
        String currentAddress = "Kralja Milana 15a";
        String permanentAddress = "Sindjeliceva 36";

        fullNameField.clear();
        fullNameField.sendKeys(fullName);

        emailField.clear();
        emailField.sendKeys(email);

        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);

        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);

        ((JavascriptExecutor) driver).executeScript( "arguments[0].scrollIntoView({block: 'center'});", submitButton);

        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));
        waiter.until(ExpectedConditions.elementToBeClickable(submitButton));

        submitButton.click();

        WebElement nameParagraph = driver.findElement(By.id("name"));
        Assert.assertTrue(nameParagraph.getText().contains(fullName));

        WebElement emailParagraph = driver.findElement(By.id("email"));
        Assert.assertTrue(emailParagraph.getText().contains(email));

        WebElement currentAddressParagraph = driver.findElement(By.cssSelector("p#currentAddress"));
        Assert.assertTrue(currentAddressParagraph.getText().contains(currentAddress));

        WebElement permanentAddressParagraph = driver.findElement(By.cssSelector("p#permanentAddress"));
        Assert.assertTrue(permanentAddressParagraph.getText().contains(permanentAddress));

    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
