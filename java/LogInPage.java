import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly;

public class LogInPage {
    WebDriver driver;


    private static final String EMAIL_FIELD = "//input[@id='name-field']";
    private static final String PASSWORD_FIELD = "//input[@id='password-field']";
    private static final String CHECK_BOX = "//span[@class='checkmark']";
    private static final String SUBMIT_BUTTON = "//button[@id='loginBtn']";

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public void setInField(String value, String something){
        driver.findElement(By.xpath(value)).sendKeys(something);
    }

    public void clickButtonLogIn(){
        driver.findElement(By.xpath(SUBMIT_BUTTON)).click();
    }
    public void checkCheckBoxLogIn(){
        driver.findElement(By.xpath(CHECK_BOX)).click();
    }

    public MainPage setUpLogIn(String email, String pass){
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        setInField(EMAIL_FIELD, email);
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        setInField(PASSWORD_FIELD, pass);
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        checkCheckBoxLogIn();
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        clickButtonLogIn();
        return new MainPage(driver);
    }

}
