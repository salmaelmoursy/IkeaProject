package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.SearchPage;

import static hooks.Hooks.driver;

public class cartEditingSteps {
    Double productPrice;
    HomePage home = new HomePage(driver);
    CartPage cart = new CartPage(driver);
    SearchPage search = new SearchPage(driver);
    @When("the user searches for  {string}")
    public void theUserSearchesFor(String arg0) {
       home.search("chair");
       home.clickSearch();
    }
    @And("the user adds one product to the cart")
    public void theUserAddsOneProductToTheCart() {
       String price = search.addFirstResultToBag();
       productPrice=Double.parseDouble(price.replace("EGP", "").replace(",", "").trim());
    }

    @And("the user navigates to the cart")
    public void theUserNavigatesToTheCart() {
       search.goToBag();
    }

    @And("the user updates the quantity from {int} to {int}")
    public void theUserUpdatesTheQuantityFromTo(int arg0, int arg1) {
        cart.editQuantity(3);
    }

    @Then("the subtotal should be equal to unit price multiplied by {int}")
    public void theSubtotalShouldBeEqualToUnitPriceMultipliedBy(int arg0) {
        cart.totalPrice(productPrice,3);
    }


}
