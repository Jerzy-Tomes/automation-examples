package pages;

import helpers.Helpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public static String URL = "http://skleptest.pl/cart/";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get(URL);
    }

    public boolean checkIfEmpty() {
        return Helpers.isElementPresent(driver, By.cssSelector(".cart-empty"));
    }

    public int getNumberOfProducts() {
        return driver.findElements(By.cssSelector("tr.woocommerce-cart-form__cart-item")).size();
    }

    public void removeProduct() {
        driver.findElement(By.cssSelector("a.remove")).click();
    }
}
