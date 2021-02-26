package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThanksPage extends BasePage{
    private final static String BANNER_SELECTOR = "[class*=alert]";
    public static String SUCCESS_BANNER_STRING = "The form was successfully submitted!";


    public String getBannerText(WebDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BANNER_SELECTOR)));
        WebElement banner = driver.findElement(By.cssSelector(BANNER_SELECTOR));
        return  banner.getText();
    }
}
