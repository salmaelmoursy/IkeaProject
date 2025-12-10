package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SectionPage;

import static hooks.Hooks.driver;

public class multipleFilterCombinationSteps {
    HomePage home = new HomePage(driver);
    SectionPage section = new SectionPage(driver);
    @When("the user navigates to the {string} category")
    public void theUserNavigatesToTheCategory(String arg0) {
        home.navigateToBeds();
    }

    @And("the user applies the following filters:")
    public void theUserAppliesTheFollowingFilters() {
        section.applyFilters("Wood", "10,000 - 19,999 EGP");

    }

    @Then("all displayed products should match the filters:")
    public void allDisplayedProductsShouldMatchTheFilters() {
        section.verifyProductsMatchFilters("Wood", "10,000 - 19,999 EGP");
    }
}
