import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        // U ovoj komandi postavljam driver

        WebDriver driver = new ChromeDriver();
        // U ovoj komandi kreiram objekat kom cu davati komande

        driver.navigate().to("https://www.google.com");
        //driver.get("https://www.google.com");
        // Drugi nacin da odemo na odredjenu stranicu je da koristimo .get()
        // U oba slucaja je bitno da posaljete validan format linka
        // Odnosno da link pocinje sa https://
        // Ako pocnete link sa www. onda program nece prepoznati da je to URL
        // Mozete proveriti da li ste uneli validan format tako sto proverite da li je link podvucen
        // Ako je podvucen onda je validan format

        driver.manage().window().maximize();
        // Komanda koja ce da prosiri prozor browsera

        System.out.println(driver.getCurrentUrl());
        // Stampam u konzoli URL na kom se trenutno nalazi driver

        driver.navigate().to("https://www.youtube.com");
        // Dajem komandu da promeni URL
        // Primeticete da sve radi u istom prozoru, ne otvara novi prozor kada posaljete novi link

        System.out.println(driver.getCurrentUrl());
        // Ponovo stampam u konzoli URL jer cu sad dobiti drugaciji rezultat

        driver.navigate().back();
        // Komanda za vracanje unazad, odnosno na prethodnu stranicu
        // Vratice se sa youtube na google stranicu

        driver.navigate().refresh();
        // Komanda koja ce uraditi refresh na stranici

        driver.navigate().forward();
        // Komanda za odlazak na narednu stranicu
        // Vratice se sa google na youtube stranicu

        driver.quit();
        // Komanda koja zatvara brower i koja gasi driver objekat

    }
}