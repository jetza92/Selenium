import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        //Otvoriti bing pretrazivac, pretrazite 'Wikipedia'
        //otvorite wikipedia stranicu i na njoj uradite pretragu 'Nikola Tesla'

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);

        WebElement searchBoxBing = driver.findElement(By.id("sb_form_q"));
        searchBoxBing.clear();
        searchBoxBing.sendKeys("Wikipedia");

        Thread.sleep(3000);

        WebElement searchButtonBing = driver.findElement(By.id("sb_hp_go"));
        searchButtonBing.click();

        WebElement wikipediaLink = driver.findElement(By.linkText("Wikipedia"));
        wikipediaLink.click();

        ArrayList<String> listaTabova = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(listaTabova.get(1));

        WebElement searchBoxWikipedia = driver.findElement(By.id("searchInput"));
        searchBoxWikipedia.clear();
        searchBoxWikipedia.sendKeys("Nikola Tesla");

        WebElement searchButtonWikipedia = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButtonWikipedia.click();

        /*
        driver.findElement(By.id("sb_form_q")).sendKeys("wikipedia");
        driver.findElement(By.id("sb_form_q")).submit();

        Thread.sleep(3000);

        driver.findElement(By.partialLinkText("Wikipedia")).click();
        ArrayList<String> tabovi = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabovi.get(1));


        driver.findElement(By.id("searchInput")).sendKeys("Nikola Tesla");
        driver.findElement(By.id("searchInput")).submit();


         */

    }
}
