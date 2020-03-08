import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Uninterruptibles.*;

public class SignUp {
    String driverPath = "D:\\IDEA\\chromedriver\\80\\chromedriver.exe";
    String hoomePage = "https://dev.aitheon.com/";
    String name = "Kot";
    String lname = "Matroskin";
    String pass = "Test123456";
    WebDriver driver;
    HomePage homePage;
    SignUpPage signUpPage;
    MainPage mainPage;

    @BeforeSuite
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(hoomePage);
    }

    @Test(priority = 1)
    public void SignUpTest(){
        homePage = new HomePage(driver);
        signUpPage = homePage.signUp();
        sleepUninterruptibly(10, TimeUnit.SECONDS);
        mainPage = signUpPage.setUpSignUpPage(name, lname, homePage.generateEmail(), pass);
    }

    @AfterSuite
    private void off(){
        driver.quit();
    }
}
