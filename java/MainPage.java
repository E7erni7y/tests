
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        initPage();
    }

    public void initPage(){
        WebElement wait = (new WebDriverWait(driver, 10)).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//form")));
    }
}
