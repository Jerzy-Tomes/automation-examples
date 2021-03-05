package stepdefs;


import helpers.Helpers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CartPage;
import pages.MainPage;

public class MyStepdefs {
    private static final String BASE_URL = "http://skleptest.pl";
    private static final String PRODUCT_1_SELECTOR = "div.col-sm-9:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(3)";
    private static final String PRODUCT_2_SELECTOR = "div.col-sm-9:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(3)";

    WebDriver driver;
    MainPage mainPage;
    CartPage cart;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        mainPage = new MainPage(driver);
        cart = new CartPage(driver);
    }

    @Given("the web browser is on the shop page")
    public void theWebBrowserIsOnThePage() {
        mainPage.open();

    }

    @When("user adds to cart a product")
    public void userAddsToCartAProduct() {
        mainPage.addToCart(PRODUCT_1_SELECTOR);
    }

    @And("views the cart")
    public void viewsTheCart() throws InterruptedException {
        //page can be little slow sometimes so added some sleep to make it pass
        Thread.sleep(1000);
        mainPage.viewTheCart();
    }

    @Then("the product can be found in cart")
    public void theProductCanBeFoundInCart() {
        boolean isEmpty = cart.checkIfEmpty();
        Assert.assertFalse(isEmpty);
    }

    @And("adds another one")
    public void addsAnotherOne() throws InterruptedException {
        Thread.sleep(1000); //it's not a good practice but the page is intentionally buggy and slow, and I want my tests to run
        mainPage.addToCart(PRODUCT_2_SELECTOR);
    }

    @Then("{int} products can be found in cart")
    public void productsCanBeFoundInCart(int expected) {
        int numberOfProducts = cart.getNumberOfProducts();
        Assert.assertEquals(expected, numberOfProducts);
    }

    @Given("there's at least one product in cart") //TODO probably need to change it to something more precise
    public void thereSAtLeastOneProductInCart()  {
        theWebBrowserIsOnThePage();
        userAddsToCartAProduct(); //TODO scenarios should be independent
    }

    @When("user views the cart")
    public void userViewsTheCart() throws InterruptedException {
        viewsTheCart();
    }

    @And("removes a product from cart")
    public void removesAProductFromCart() {
        cart.removeProduct(); //TODO remove concrete product. this will only remove first product
    }

    @Then("product is no longer in cart")
    public void productIsNoLongerInCart() {
        Assert.assertTrue(cart.checkIfEmpty()); //it WILL fail -- removing not implemented
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
    public void tearDown() {
        driver.close();
    }


}
