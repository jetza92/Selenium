import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        //Na linku https://practicetestautomation.com/ otici do login stranice, uradite log in i dodajte asertacije

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practicetestautomation.com/");
        Thread.sleep(3000);

        WebElement practiceButton = driver.findElement(By.id("menu-item-20"));
        practiceButton.click();

        WebElement testLoginPageButton = driver.findElement(By.linkText("Test Login Page"));
        testLoginPageButton.click();

        //------------Login page

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit"));

        String validUsername = "student";
        String validPassword = "Password123";

        usernameField.clear();
        usernameField.sendKeys(validUsername);

        passwordField.clear();
        passwordField.sendKeys(validPassword);

        submitButton.click();

        //-------------Asertacije

        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");

        String actualLogInMessage = driver.findElement(By.className("post-title")).getText();
        String expectedLogInMessage = "Logged In Successfully";
        Assert.assertEquals(actualLogInMessage, expectedLogInMessage);

        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed());

        WebElement message = driver.findElement(By.cssSelector(".has-text-align-center.wp-block-paragraph"));
        Assert.assertEquals(message.getText(), "Congratulations "+validUsername+". You successfully logged in!");

        /*
        WebElement navLink = driver.findElement(By.id("menu-item-20"));
        navLink.click();

        WebElement paragraphLink = driver.findElement(By.linkText("Test Login Page"));
        paragraphLink.click();

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.clear();
        usernameInputField.sendKeys("student");

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.clear();
        passwordInputField.sendKeys("Password123");

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://practicetestautomation.com/logged-in-successfully/";
        Assert.assertEquals(actualURL, expectedURL);

        WebElement pageHeading = driver.findElement(By.className("post-title"));
        String actualHeading = pageHeading.getText();
        String expectedHeading = "Logged In Successfully";
        Assert.assertEquals(actualHeading, expectedHeading);

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Logged In Successfully | Practice Test Automation");

         */







    }
}
