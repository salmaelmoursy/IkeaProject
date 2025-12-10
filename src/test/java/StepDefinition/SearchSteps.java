package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchPage;

import static hooks.Hooks.driver;

public class SearchSteps {
    HomePage home = new HomePage(driver);
   SearchPage search = new SearchPage(driver);

        @When("Enter a product keyword in the search bar")
        public void enterAProductKeywordInTheSearchBar(){
            home.search("Bed");
        }
        @And("Click the search icon")
        public void clickTheSearchIcon () {
        home.clickSearch();

        }
        @Then("Ensure the products displayed related to the keyword")
             public void ensureTheProductDisplayedRelatedToTheKeyword(){
        search.verifySearchResult("Bed");
        }

}
