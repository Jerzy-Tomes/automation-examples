package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public static String URL;
    protected WebDriver driver;



    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void open();

}
