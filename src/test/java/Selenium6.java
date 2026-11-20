import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Selenium6 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/");

        WebElement card = driver.findElement(By.className("card-body"));

        List<WebElement> cards = driver.findElements(By.className("card-body"));
        cards.get(2).click();

        for (int i = 0; i < cards.size(); i++) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cards.get(i));
            if (cards.get(i).getText().equals("Forms")) {
               cards.get(i).click();
               break;
            }
        }
    }
}
