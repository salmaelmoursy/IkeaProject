package StepDefinition;



import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static hooks.Hooks.driver;

public class commonSteps {
HomePage home = new HomePage(driver);

    @Given("the user is on IKEA homepage")
    public void the_user_is_on_IKEA_homepage() {

        driver.get("https://www.ikea.com/eg/en/");
        home.handleCookies();
        home.closeAbs();
    }



}