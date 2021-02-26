import Pages.FormPage;
import Pages.ThanksPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class Test {
    WebDriver driver;
    FormPage form;
    ThanksPage thanksPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        form = new FormPage();
        thanksPage = new ThanksPage();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @org.junit.Test
    public void test1() {
        form.openPage(driver);
        form.fillOutTheForm(driver);
        String bnnr = thanksPage.getBannerText(driver);
        assertEquals(bnnr, ThanksPage.SUCCESS_BANNER_STRING);
    }
}
