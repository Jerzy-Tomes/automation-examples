package pages;

import helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public static String URL = "http://skleptest.pl";
    private static final String CART_SELECTOR = ".top-cart > a:nth-child(1)";
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }


    public void addToCart(String selector){
        Helpers.waitForElement(By.cssSelector(selector), driver, 30);
        WebElement addBtn = driver.findElement(By.cssSelector(selector));
        Actions actions = new Actions(driver);
        actions.moveToElement(addBtn);
        driver.findElement(By.cssSelector(selector)).click();
    }

    public void viewTheCart() {
        driver.findElement(By.cssSelector(CART_SELECTOR)).click();
    }
}
