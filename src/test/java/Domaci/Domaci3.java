package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Domaci3 {
    public static void main (String[] args) {

        //Koristite https://the-internet.herokuapp.com/dynamic_loading/2, gde se element pojavljuje tek posle klika.
        // Kliknite na dugme Start i sačekajte da se pojavi tekst “Hello World!“.
        //Za ovaj zadatak koristiti asertacije i waitere

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));

        WebElement h4 = driver.findElement(By.id("finish"));
        Assert.assertTrue(h4.getText().contains("Hello World!"));

        String expectedURL = "https://the-internet.herokuapp.com/dynamic_loading/2";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        driver.quit();

    }
}
