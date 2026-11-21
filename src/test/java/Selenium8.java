import org.testng.annotations.*;

public class Selenium8 {
    @BeforeClass
    public void beforeClass() {
        System.out.println("-------------");
        System.out.println("ISPIS IZ BEFORE CLASS");
        System.out.println("-------------");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("**************");
        System.out.println("ISPIS IZ BEFORE METHOD");
        System.out.println("**************");
    }

    @Test(priority = 2)
    public void userCanLogIn() {
        System.out.println("==============");
        System.out.println("OVO JE TEST 1");
        System.out.println("LOG IN");
        System.out.println("==============");
    }

    @Test(priority = 3)
    public void userCanLogOut() {
        System.out.println("==============");
        System.out.println("OVO JE TEST 2");
        System.out.println("LOG OUT");
        System.out.println("==============");
    }

    @Test(priority = 1)
    public void userCanRegister() {
        System.out.println("==============");
        System.out.println("OVO JE TEST 3");
        System.out.println("REGISTER");
        System.out.println("==============");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("/////////////////");
        System.out.println("ISPIS IZ AFTER METHOD");
        System.out.println("/////////////////");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("----------------");
        System.out.println("ISPIS IZ AFTER CLASS");
        System.out.println("----------------");
    }
}
