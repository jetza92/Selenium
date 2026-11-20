package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci2a {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));


        String invalidUsername = "willsmith";
        String invalidPassword = "NotSecretPassword!";

        usernameField.clear();
        usernameField.sendKeys(invalidUsername);

        passwordField.clear();
        passwordField.sendKeys(invalidPassword);

        loginButton.click();

        String expectedURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement notificationMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(notificationMessage.getText().contains("Your username is invalid!"));

        driver.quit();

    }
}
