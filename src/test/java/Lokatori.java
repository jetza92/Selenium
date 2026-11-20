import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Lokatori {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bing.com");

        Thread.sleep(3000);

        //driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea")).sendKeys("ITBootcamp");
        //driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea")).sendKeys(Keys.ENTER);

        WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea"));
        searchBox.sendKeys("ITBootcamp");
        searchBox.sendKeys(Keys.ENTER);

        //--------------------------

        // LOKATORI ili SELEKTORI
        // Sluze nam da bismo pronasli element na stranici
        // Po prioritetu lokatore trazimo:
        // ID, Name, Class, CSS, Link text, Tag name, Relative xpath, Absolute xpath

        // ID je prvi po prioritetu jer je najstabilniji i jedinstven element
        // Ovo je slucaj samo kada atribut glasi 'id'
        // Recimo ako je atribut 'test-id' onda taj element ne moze da se nadje na ovaj nacin
        WebElement lokatorPoID = driver.findElement(By.id("b_results"));

        // Name je drugi po prioritetu ali nije nuzno jedinstven element
        // Ovaj lokator ce cesto da nosi naziv elementa
        // Recimo ako trazite username polje, moguce je da cete naci element
        // name="username"
        WebElement lokatorPoName = driver.findElement(By.name("vrednost lokatora"));

        // Class - cesto nije jedinstven element ali moze se koristiti u listi
        // Ako imate vise razlicitih elemenata sa istom klasom, mozete tu klasu
        // da ubacite u neku listu i da koristite listu za testiranje
        // Primer: Hocete da kliknete na svaki checkbox
        // Da ne biste trazili ID za svaki checkbox ako ih ima mnogo
        // Mozete ih naci preko klase i kroz petlju da odradite klik na sve elemente
        WebElement lokatorPoClassName = driver.findElement(By.className("b_algo"));
        //Liste bismo trazili na ovaj nacin
        List<WebElement> lokatorPoClassNameList = driver.findElements(By.className("b_algo"));
        // Kod liste je potrebno u mnozini da se napise driver.findElements

        // CSS
        // Ovaj prvi nacin se koristi kada imate klasu koja ima vise vrednosti
        // class="ovoJeJednaVrednostKlase"
        // class="ovo je vise vrednosti klase"
        // U slucaju klase sa vise vrednosti element mozete naci preko css
        // Element se trazi tako sto:
        // 1) ne trazite po By.className nego po By.cssSelector
        // 2) na pocetku vrednosti stavite tacku i tacku umesto svakog razmaka
        WebElement lokatorPoClassKojiNeRadi = driver.findElement(By.className("b_msg b_canvas b_hide"));
        WebElement lokatorPoCSS = driver.findElement(By.cssSelector(".b_msg.b_canvas.b_hide"));

        // CSS
        // Univerzalan i veoma koristan nacin da pronadjete elemente koji nemaju nijedan
        // prioritetan lokator
        // Ovaj nacin mozete koristiti tako sto za element pronadjete tag, atribut, vrednost
        // U html kodu to izgleda ovako
        // <textarea type="search"
        // 'textarea' je tag
        // 'type' je atribut
        // 'search' je vrednost atributa
        // Forma za pisanje je tag[atribut='vrednost']
        WebElement lokatorPoCSSSelektor = driver.findElement(By.cssSelector("textarea[type='search']"));
        WebElement lokatorPoCSSTemplate = driver.findElement(By.cssSelector("tag[atribut='vrednost atributa']"));

        // Link text je redak lokator jer moraju biti ispunjena tri uslova
        // 1) Element ima 'a' tag
        // 2) Element ima popunjen 'href' atribut
        // 3) Element ima text
        // Najcesci problem je izostanak texta na elementu
        // Text je oznacen belom bojom u html kodu
        WebElement lokatorPoLinkText = driver.findElement(By.linkText("ITBootcamp - Besplatna IT prekvalifikacija - Free IT …"));

        // Tag name se retko kad koristi kao finalni lokator jer element nece biti jedinstven
        // Osim u situacijama kada imate bas malo elemenata na stranici
        // Moze da se koristi kao parent element kada trazite lokator unutar lokatora
        WebElement lokatorPoTagu = driver.findElement(By.tagName("button"));

        // Xpath lokatori su najnestabilniji i zahtevaju cesto odrzavanje
        // zbog svoje strukture
        // Oni zahtevaju da html code ostane nepromenjen jer svaka promena
        // moze da izazove problem nalazenja elementa

        // Relative xpath
        // Ovaj lokator nalazimo tako sto na element kliknemo Copy - Copy xpath
        WebElement lokatorPoRelativeXpath = driver.findElement(By.xpath("//*[@id=\"b_results\"]/li[8]"));
        WebElement lokatorPoSkracenomXpath = driver.findElement(By.xpath("//div[1]/textarea"));

        // Absolute xpath
        // Ovaj lokator nalazimo tako sto na element kliknemo Copy - Copy full xpath
        WebElement lokatorPoAbsoluteXpath = driver.findElement(By.xpath("/html/body/div[1]/div/form/div[2]/div[1]/textarea"));

        // Xpath svakako ima i svoju svrhu iako se ne koristi u praksi
        // Mozete koristiti kada hocete brzo da proverite da li neki automatski
        // test moze da se napravi
        // U slucaju kada hocete samo da proverite da li je nesto izvodljivo
        // Ako nije izvodljivo onda odustajete od tog testa
        // Ako jeste izvodljivo onda cete editovati lokator u nesto stabilnije

    }
}
