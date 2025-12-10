package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.StorePage;

import static hooks.Hooks.driver;

public class StoreDetailsSteps {
    HomePage home =new HomePage(driver);
    StorePage store =new StorePage(driver);
    @When("user clicks on {string} from top menu")
    public void userClicksOnFromTopMenu(String arg0) {
       home.clickStoreMenu();
    }

    @And("user selects any store from the list")
    public void userSelectsAnyStoreFromTheList() {
        store.selectAnyStore();
    }

    @Then("store details should be displayed")
    public void storeDetailsShouldBeDisplayed() {
        store.verifyStoreDetails();
    }
}
