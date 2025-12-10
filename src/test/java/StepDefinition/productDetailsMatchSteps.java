package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SectionPage;

import static hooks.Hooks.driver;

public class productDetailsMatchSteps {
    HomePage home = new HomePage(driver);
    SectionPage section = new SectionPage(driver);
    @When("user navigates to category")
    public void userNavigatesToCategory() {
        home.openCategoryPage();
    }

    @And("user notes the title and price of the first product")
    public void userNotesTheTitleAndPriceOfTheFirstProduct() {
        section.noteTitleAndPrice();
    }

    @And("user clicks on the same product to open details page")
    public void userClicksOnTheSameProductToOpenDetailsPage() {
        section.clickSelectedProduct();
    }

    @Then("the product title and price should match the listing page")
    public void theProductTitleAndPriceShouldMatchTheListingPage(){
        section.verifyProductDetails();
    }
}
