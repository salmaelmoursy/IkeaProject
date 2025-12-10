package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SearchPage;

import static hooks.Hooks.driver;

public class orderPaymentSteps {
HomePage home =new HomePage(driver);
SearchPage search = new SearchPage(driver);
CartPage cart = new CartPage(driver);
CheckoutPage check = new CheckoutPage(driver);
    @When("the user searches for a random product and adds it to the bag")
    public void theUserSearchesForARandomProductAndAddsItToTheBag() {
        home.search("Bed");
        home.clickSearch();
        search.addFirstResultToBag();
    }

    @And("the user navigates to the shopping bag page")
    public void theUserNavigatesToTheShoppingBagPage() {
        search.goToBag();
    }

    @And("the user clicks on Checkout")
    public void theUserClicksOnCheckout() {
        cart.clickCheckout();
    }

    @And("the user fills in the billing address with valid data")
    public void theUserFillsInTheBillingAddressWithValidData() {
        check.fillBillingAddress("salma","salma@gmail.com","01013014061","future city","Building 814");


    }

    @And("the user selects a delivery date and time if available")
    public void theUserSelectsADeliveryDateAndTimeIfAvailable() {
        check.selectDeliveryDateTimeIfAvailable();

    }

    @And("the user chooses a payment method")
    public void theUserChoosesAPaymentMethod() {
        check.selectPaymentMethod("Credit Card");
    }

    @And("the user stops before confirming the payment")
    public void theUserStopsBeforeConfirmingThePayment() {
        check.stopBeforePaymentConfirmation();
    }

    @Then("the system should require payment details in the final step")
    public void theSystemShouldRequirePaymentDetailsInTheFinalStep() {
        Assert.assertTrue(check.isPaymentDetailsRequired());

    }
}
