import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");

        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea")).sendKeys("ITbootcamp");
        driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea")).sendKeys(Keys.ENTER);

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[3]/main/ol/li[1]/div[1]/div[2]/h2/a")).click();


    }
}
