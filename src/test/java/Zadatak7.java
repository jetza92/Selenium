import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Zadatak7 {

//Log out
//Log in sa nevalidnim username
//Log in sa nevalidnim password

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://practicetestautomation.com/");
    }

    @BeforeMethod
    public void beforeMethod() {
        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();
    }

    @Test(priority = 1)
    public void userCanLogOut() {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String validPassword = "Password123";

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        submitButton.click();

        WebElement logOutButton = driver.findElement(By.linkText("Log out"));
        logOutButton.click();

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement h2 = driver.findElement(By.tagName("h2"));
        Assert.assertEquals(h2.getText(), "Test login");
    }


    @Test(priority = 2)
    public void invalidUsername() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String invalidUsername = "nijeStudent";
        String validPassword = "Password123";

        usernameField.clear();
        usernameField.sendKeys(invalidUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        submitButton.click();

        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.id("error"));
        String expectedErrorMessage = "Your username is invalid!";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }


    @Test(priority = 3)
    public void invalidPassword() throws InterruptedException {
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String invalidPassword = "123";

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(invalidPassword);

        submitButton.click();

        Thread.sleep(3000);

        WebElement errorMessage = driver.findElement(By.id("error"));
        Assert.assertEquals(errorMessage.getText(), "Your password is invalid!");

        String expectedURL = "https://practicetestautomation.com/practice-test-login/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    @AfterMethod
    public void afterMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}

