package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static hooks.Hooks.driver;

public class logoNavigationSteps {
    HomePage home = new HomePage(driver);

    @When("the user navigates to Decoration")
    public void theUserNavigatesToDecoration() {
        home.navigateToDecoration();
    }
    @And("the user clicks on the website logo")
    public void theUserClicksOnTheWebsiteLogo() {
        home.clickOnLogo();
    }

    @Then("the user should be redirected to the HomePage")
    public void theUserShouldBeRedirectedToTheHomePage() {
        home.verifyUserOnHomePage();
    }


}
