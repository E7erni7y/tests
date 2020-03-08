
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Uninterruptibles.*;

public class LogIn {

    String driverPath = "D:\\IDEA\\chromedriver\\80\\chromedriver.exe";
    String hoomePage = "https://dev.aitheon.com/";
    WebDriver driver;
    String email = "testotqwe@gfqw.com";
    String pass = "Test123456";
    HomePage homePage;
    LogInPage logInPage;
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
    public void LogInTest(){
        homePage = new HomePage(driver);
        logInPage = homePage.LogIn();
        sleepUninterruptibly(10, TimeUnit.SECONDS);
        mainPage = logInPage.setUpLogIn(email,pass);
    }


    @AfterSuite
    private void off(){
        driver.quit();
    }


}
