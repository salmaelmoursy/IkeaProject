package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.HomePage;

import static hooks.Hooks.driver;

public class footerLinkNavigationSteps {
HomePage home = new HomePage(driver);
        @When("the user scrolls to the footer section")
        public void theUserScrollsToTheFooterSection() {
            WebElement footer = home.getFooterSection();
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footer);
        }


    @And("the user clicks on the Terms and conditions link")
    public void theUserClicksOnTheTermsAndConditionsLink() {
        home.clickFooterLink();
    }

    @Then("the page title should contain Terms and conditions")
    public void thePageTitleShouldContainTermsAndConditions() {
        home.termsAndConditionsLoaded();
    }
}
