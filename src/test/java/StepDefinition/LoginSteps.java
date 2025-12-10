package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

import static hooks.Hooks.driver;

public class LoginSteps {
    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
  String loginEmail= TestData.getFakeEmail();
  String loginPassword = TestData.getFakePassword();


    @When("Click on the login button")
    public void clickOnTheLoginButton() {
        home.openLogin();
    }

    @And("Enter valid email and password\\(use the same fake email used in register)")
    public void enterValidEmailAndPasswordUseTheSameFakeEmailUsedInRegister() {
        login.loin(loginEmail, loginPassword);
    }

    @Then("The user log in successfully")
    public void theUserLoginSuccessfully() {
        login.userLoginSuccessfully();
    }


}

