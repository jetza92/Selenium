import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Domaci2 {
    public static void main(String[] args) throws InterruptedException {

       // Na sajtu https://the-internet.herokuapp.com/login testirati logovanje koristeci validne i nevalidne kredencijale.
       // Koristiti asertacije

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/login");


        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector(".fa.fa-2x.fa-sign-in"));


        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        loginButton.click();

        Thread.sleep(3000);

        String expectedURL = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        WebElement notificationMessage = driver.findElement(By.id("flash"));
        Assert.assertTrue(notificationMessage.getText().contains("You logged into a secure area!"));

        WebElement h4 = driver.findElement(By.className("subheader"));
        Assert.assertEquals(h4.getText(), "Welcome to the Secure Area. When you are done click logout below.");

        driver.quit();






    }
}
