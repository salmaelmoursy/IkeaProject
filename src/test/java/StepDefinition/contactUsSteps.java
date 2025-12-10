package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static hooks.Hooks.driver;

public class contactUsSteps {
    HomePage home = new HomePage(driver);
    @When("the user scrolls to the footer")
    public void theUserScrollsToTheFooter() {
        home.getFooterSection();
    }
    @And("the user clicks on Contact Us")
    public void theUserClicksOnContactUs() {
       home.clickOnContactUs();
    }

    @Then("the Contact Us page should load and contact options should be displayed")
    public void theContactUsPageShouldLoad() {
        home.contactUsLoaded();
    }




}
