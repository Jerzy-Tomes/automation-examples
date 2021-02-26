package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage extends BasePage {
    private final static String URL = "https://formy-project.herokuapp.com/form";
    private final static String FIRST_NAME_SELECTOR = "#first-name";
    private final static String LAST_NAME_SELECTOR = "#last-name";
    private final static String JOB_TITLE_SELECTOR = "#job-title";
    private final static String LEVEL_OF_EDUCATION_SELECTOR = "#radio-button-3";
    private final static String GENDER_SELECTOR = "#checkbox-1";
    private final static String YEARS_OF_EXPERIENCE_SELECTOR = "#select-menu > option:nth-child(3)";
    private final static String DATE_SELECTOR = "#datepicker";
    private final static String SUBMIT_BTN_SELECTOR = ".btn.btn-lg.btn-primary";


    public void fillOutTheForm(WebDriver driver) {
        driver.findElement(By.cssSelector(FIRST_NAME_SELECTOR)).sendKeys("Genowefa");
        driver.findElement(By.cssSelector(LAST_NAME_SELECTOR)).sendKeys("Węgieł");
        driver.findElement(By.cssSelector(JOB_TITLE_SELECTOR)).sendKeys("Architect");
        driver.findElement(By.cssSelector(LEVEL_OF_EDUCATION_SELECTOR)).click();
        driver.findElement(By.cssSelector(GENDER_SELECTOR)).click();
        driver.findElement(By.cssSelector(YEARS_OF_EXPERIENCE_SELECTOR)).click();
        WebElement datepicker = driver.findElement(By.cssSelector(DATE_SELECTOR));
        datepicker.sendKeys("11/12/1979");
        datepicker.sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(SUBMIT_BTN_SELECTOR)).click();

    }

    public void openPage(WebDriver driver) {
        driver.get(URL);
    }

}
