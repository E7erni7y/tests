import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class HomePage {
    WebDriver driver;

    private static final String LOG_IN = "//div[contains(@class, 'login')]//a[@id='signIn']";
    private static final String SIGN_UP = "//div[contains(@class, 'login')]//a[@id='signUp']";

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage goToHomePage(){
        driver.get("https://dev.aitheon.com/");
        return new HomePage(driver);
    }

    public SignUpPage signUp(){
        driver.findElement(By.xpath(SIGN_UP)).click();
        return new SignUpPage(driver);
    }

    public LogInPage LogIn(){
        driver.findElement(By.xpath(LOG_IN)).click();
        return new LogInPage(driver);
    }

    public String generateEmail(){
        Random rnd = new Random();
        int num = rnd.nextInt(10000000);
        String email = "testovoemilo"+num+"@gmail.com";
        return email;
    }


}

