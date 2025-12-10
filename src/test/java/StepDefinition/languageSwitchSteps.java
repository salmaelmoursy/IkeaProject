package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static hooks.Hooks.driver;

public class languageSwitchSteps {
    HomePage home = new HomePage(driver);
    @When("the user locates the language selector")
    public void theUserLocatesTheLanguageSelector() {
        home.languageSelector();
    }

    @And("the user switches from English to Arabic")
    public void theUserSwitchesFromEnglishToArabic() {
        home.switchToArabic();
    }

    @Then("the page content should be displayed in Arabic")
    public void thePageContentShouldBeDisplayedInArabic() {
        home.arabicApprove();
    }
}
