package stepdefs;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs {
    private static final String BASE_URL = "http://skleptest.pl";
    private static final String  BTN_SELECTOR = "div.col-sm-9:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(3)";

    WebDriver driver;
    @Given("the web browser is on the shop page")
    public void theWebBrowserIsOnThePage() {
        driver = new FirefoxDriver();
        driver.get(BASE_URL);
    }

    @When("user adds to cart a product")
    public void userAddsToCartAProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(BTN_SELECTOR)));
        WebElement addBtn = driver.findElement(By.cssSelector(BTN_SELECTOR));
        Actions actions = new Actions(driver);
        actions.moveToElement(addBtn);
        driver.findElement(By.cssSelector(BTN_SELECTOR)).click();
    }

    @And("views the cart")
    public void viewsTheCart() {
        driver.findElement(By.cssSelector(".top-cart > a:nth-child(1)")).click();
    }

    @Then("the product can be found in cart")
    public void theProductCanBeFoundInCart() {
        Assert.assertFalse(isElementPresent(By.cssSelector(".cart-empty")));
    }

    @And("adds another one")
    public void addsAnotherOne() {
    }

    @Then("{int} products can be found in cart")
    public void productsCanBeFoundInCart(int arg0) {
    }

    @Given("there's at least one product in cart")
    public void thereSAtLeastOneProductInCart() {
    }

    @When("user views the cart")
    public void userViewsTheCart() {
    }

    @And("removes a product from cart")
    public void removesAProductFromCart() {
    }

    @Then("product is no longer in cart")
    public void productIsNoLongerInCart() {
    }

    @And("performs {string}")
    public void performs(String arg0) {
    }

    @Then("product quantity changes accurately")
    public void productQuantityChangesAccurately() {
    }

    @When("user proceeds to checkout")
    public void userProceedsToCheckout() {
    }

    @And("fills in the form")
    public void fillsInTheForm() {
    }

    @And("Places order")
    public void placesOrder() {
    }

    @Then("order is received")
    public void orderIsReceived() {
    }

    @After
    public void tearDown(){
        driver.close();
    }


    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }}
