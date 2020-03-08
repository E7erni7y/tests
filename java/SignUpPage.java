import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.google.common.util.concurrent.Uninterruptibles.*;

public class SignUpPage {

    WebDriver driver;

    private static final String FIRST_NAME = "//input[@formcontrolname='firstName']";
    private static final String LAST_NAME = "//input[@formcontrolname='lastName']";
    private static final String EMAIL = "//input[@id='email']";
    private static final String PASSWORD = "//input[@formcontrolname='password']";
    private static final String CONFIRMPASSWORD = "//input[@formcontrolname='confirmPassword']";
    private static final String CONFIRMCHECKBOX = "//input[@formcontrolname='termsAgree']";
    private static final String SUBMITBUTTON = "//button[@type = 'submit']";


    public SignUpPage (WebDriver driver){
     this.driver = driver;
    }

    public void inputInFieldSignUp(String value, String something){
        driver.findElement(By.xpath(value)).sendKeys(something);
    }

    public void clickButtonSignUp(){
        driver.findElement(By.xpath(SUBMITBUTTON)).click();
    }

    public void checkCheckBoxSignUp(){
        driver.findElement(By.xpath(CONFIRMCHECKBOX)).click();
    }

    public MainPage setUpSignUpPage(String name, String lname, String email, String pass){
        inputInFieldSignUp(FIRST_NAME, name);
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        inputInFieldSignUp(LAST_NAME, lname);
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        inputInFieldSignUp(EMAIL, email);
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        inputInFieldSignUp(PASSWORD, pass);
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        inputInFieldSignUp(CONFIRMPASSWORD, pass);
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        checkCheckBoxSignUp();
        sleepUninterruptibly(1, TimeUnit.SECONDS);
        clickButtonSignUp();
        return new MainPage(driver);
    }





}
