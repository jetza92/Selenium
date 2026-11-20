package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Domaci4 {
    //Domaci:
    //https://practice.expandtesting.com/login
    //Odraditi registraciju i login koristeci anotacije

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @BeforeMethod
    public void beforeMethod() {

        driver.manage().deleteAllCookies();
        driver.navigate().to("https://practice.expandtesting.com/login");

    }

    @Test(priority = 1)
    public void registrationSuccessful() {

        WebElement registracijaLink = driver.findElement(By.linkText("here"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(registracijaLink).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registracijaLink);

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        WebElement registerButton = driver.findElement(By.cssSelector("button[type='submit']"));

        String usernameRegistracija = "student" + System.currentTimeMillis();
        String passwordRegistracija = "Password123";
        String confirmPasswordRegistracija = "Password123";

        usernameField.clear();
        usernameField.sendKeys(usernameRegistracija);

        passwordField.clear();
        passwordField.sendKeys(passwordRegistracija);

        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPasswordRegistracija);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", registerButton);

        //String expectedAlert = "An error occurred during registration. Please try again.";
        String expectedAlert = "Successfully registered, you can log in now.";
        WebElement actualAlert = driver.findElement(By.id("flash"));
        Assert.assertEquals(actualAlert.getText(), expectedAlert);

    }

    @Test (priority = 2)
    public void validCredentials() throws InterruptedException {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit-login"));

        String validUsername = "practice";
        String validPassword = "SuperSecretPassword!";

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

        String expectedAlert = "You logged into a secure area!";
        WebElement actualAlert = driver.findElement(By.id("flash"));
        Assert.assertEquals(actualAlert.getText(), expectedAlert);

        WebElement logoutButton = driver.findElement(By.cssSelector(".button.secondary.radius.btn.btn-danger"));
        Assert.assertTrue(logoutButton.isDisplayed());

        Thread.sleep(3000);

        String expectedURL = "https://practice.expandtesting.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        String expectedTitle = "Secure Page page for Automation Testing Practice";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    @Test (priority = 3)
    public void invalidUsername() {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit-login"));

        String invalidUsername = "nijessstudent";
        String validPassword = "SuperSecretPassword!";

        usernameField.clear();
        usernameField.sendKeys(invalidUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));

        String expectedAlert = "Your username is invalid!";
        String actualAlert = alertMessage.getText();
        //WebElement actualAlert = driver.findElement(By.id("flash"));
        Assert.assertEquals(actualAlert, expectedAlert);

    }

    @Test (priority = 4)
    public void invalidPassword() throws InterruptedException {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit-login"));

        String validUsername = "practice";
        String invalidPassword = "SuperSecret!";

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(invalidPassword);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

        Thread.sleep(3000);

        String expectedAlert = "Your password is invalid!";
        WebElement actualAlert = driver.findElement(By.id("flash"));
        Assert.assertEquals(actualAlert.getText(), expectedAlert);
    }

    @Test (priority = 5)
    public void invalidCredentials() {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit-login"));

        String invalidUsername = "student";
        String invalidPassword = "SuperSecret!";

        usernameField.clear();
        usernameField.sendKeys(invalidUsername);

        passwordField.clear();
        passwordField.sendKeys(invalidPassword);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

        String expectedAlert = "Your username and password are invalid!";
        WebElement actualAlert = driver.findElement(By.id("flash"));
        Assert.assertEquals(actualAlert.getText(), expectedAlert);
    }

    @Test (priority = 6)
    public void logout() throws InterruptedException {

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit-login"));

        String validUsername = "practice";
        String validPassword = "SuperSecretPassword!";

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);

        Thread.sleep(3000);

        String expectedAlert = "You logged into a secure area!";
        WebElement actualAlert = driver.findElement(By.id("flash"));
        Assert.assertEquals(actualAlert.getText(), expectedAlert);

        WebElement logoutButton = driver.findElement(By.cssSelector(".button.secondary.radius.btn.btn-danger"));
        Assert.assertTrue(logoutButton.isDisplayed());

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutButton);


        String expectedURL = "https://practice.expandtesting.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        String expectedTitle = "Test Login Page for Automation Testing Practice";
        Assert.assertEquals(driver.getTitle(), expectedTitle);
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
