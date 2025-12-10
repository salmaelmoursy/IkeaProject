package StepDefinition;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SectionPage;

import static hooks.Hooks.driver;

public class addToCartSteps {
HomePage home =new HomePage(driver);
SectionPage section =new SectionPage(driver);
CartPage cart = new CartPage(driver);
ProductPage product = new ProductPage(driver);


    @When("the user opens the lighting category")
    public void theUserOpensTheLightingCategory() {
        home.openLightingCategory();
    }

    @And("the user navigates to Lamps section")
    public void theUserNavigatesToLampsSection() {
        home.openLampsSection();
    }

    @And("the user adds a random product to the bag")
    public void theUserAddsARandomProductToTheCart() {
        section.selectProductRandom();
        product.addToCart();
    }

    @And("the user opens the same product and adds it again")
    public void theUserOpensTheSameProductAndAddsItAgain() {
    product.continueShopping();
    product.addToCart();
    }

    @Then("the cart should show quantity as two")
    public void theCartShouldShowQuantityAsTwo() {
        product.goToCart();
        int qty = cart.getQuantityInCart();
        Assert.assertEquals(qty, 2, "Quantity in cart is not 2");
    }
    }

