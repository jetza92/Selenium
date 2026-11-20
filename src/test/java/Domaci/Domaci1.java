package Domaci;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Domaci1 {
    public static void main(String[] args) throws InterruptedException {
        //Otvoriti youtube i pustiti pesmu po izboru

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");

        WebElement searchBox = driver.findElement(By.cssSelector(".ytSearchboxComponentInput.yt-searchbox-input.title"));
        searchBox.clear();
        searchBox.sendKeys("nemanja asja");

        WebElement searchButton = driver.findElement(By.className("ytSearchboxComponentSearchButton"));
        searchButton.click();

        Thread.sleep(3000);

        WebElement songLink = driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a"));
        songLink.click();
    }
}
