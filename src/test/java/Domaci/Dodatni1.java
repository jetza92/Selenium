package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Dodatni1 {
    public static void main (String[] args) {

        //Otvoriti https://the-internet.herokuapp.com/dynamic_controls
        //
        //Kliknite na dugme Remove, sačekajte da checkbox nestane i asertujte poruku.
        //Kliknite na dugme Enable, sačekajte da input postane aktivan, unesite tekst i asertujte poruku “It’s enabled!“.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = driver.findElement(By.cssSelector("#checkbox-example > #checkbox"));
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        WebElement pMessage = driver.findElement(By.id("message"));
        Assert.assertEquals(pMessage.getText(), "It's gone!");

        WebElement enableButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[2]/button"));
        enableButton.click();
        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys("Neki tekst");

        WebElement pMessageEnable = driver.findElement(By.id("message"));
        Assert.assertEquals(pMessageEnable.getText(), "It's enabled!");

        //driver.quit();

    }
}
