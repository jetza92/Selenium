import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2b {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");

        JavascriptExecutor js = (JavascriptExecutor) driver; // za otvaranje tabova i za klik na element
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");
        js.executeScript("window.open()");

        ArrayList<String> tabovi = new ArrayList<>(driver.getWindowHandles());


        driver.switchTo().window(tabovi.get(1));
        driver.navigate().to("https://youtube.com");

        driver.switchTo().window(tabovi.get(2));
        driver.navigate().to("https://linkedin.com");

        driver.switchTo().window(tabovi.get(3));
        driver.navigate().to("https://joberty.com");

        driver.switchTo().window(tabovi.get(4));
        driver.navigate().to("https://github.com");

        driver.switchTo().window(tabovi.get(5));
        driver.navigate().to("https://gmail.com");

        for (int i = 1; i < tabovi.size(); i++) {
            driver.switchTo().window(tabovi.get(i));
            driver.close();
        }
    }
}
