import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4a {
    public static void main(String[] args) throws InterruptedException {

        //Na linku https://practicetestautomation.com/ otici do login stranice, uradite log in i dodajte asertacije

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");
        Thread.sleep(3000);

        WebElement navLink = driver.findElement(By.id("menu-item-20"));
        navLink.click();

        WebElement paragraphLink = driver.findElement(By.linkText("Test Login Page"));
        paragraphLink.click();

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys("nijeStudent");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
        Thread.sleep(3000);


        WebElement error = driver.findElement(By.id("error"));
        String actualError = error.getText();
        String expectedError = "Your username is invalid!";
        Assert.assertEquals(actualError, expectedError);
    }
}
