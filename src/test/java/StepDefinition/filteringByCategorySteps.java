package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;
import pages.SearchPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static hooks.Hooks.driver;

public class filteringByCategorySteps {
        HomePage home = new HomePage(driver);
        SearchPage search =new SearchPage(driver);
    @When("the user searches for {string}")
    public void theUserSearchesFor(String arg0) {
        home.search("living room");
        home.clickSearch();
    }

        @And("the user applies filter Price: Low to High")
        public void theUserAppliesFilter() {
          search.filterLowToHigh();
        }

        @Then("the products should be sorted from lowest to highest price")
        public void theProductsShouldBeSortedFromLowestToHighestPrice() {
            List<Double> actualPrices = search.getAllProductPrices();
            List<Double> expectedPrices = new ArrayList<>(actualPrices);
            Collections.sort(expectedPrices);
            Assert.assertEquals(actualPrices, expectedPrices, "Products are not sorted from lowest to highest price.");
        }
}
