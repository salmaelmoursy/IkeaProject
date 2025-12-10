package StepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.RegistrationPage;

import static hooks.Hooks.driver;

    public class RegistrationSteps {
        HomePage home = new HomePage(driver);
        RegistrationPage register = new RegistrationPage(driver);
        Faker fake = new Faker();
        String firstName=fake.name().firstName();
        String lastName=fake.name().lastName();

        String email = fake.internet().emailAddress();
        String password = fake.internet().password(8, 12, true, true);


        @When("the user navigates to create account page")
        public void theUserNavigatesToCreateAccountPage() {
            home.openCreatePage();
        }

        @And("the user enters valid registration data")
        public void theUserEntersValidRegistrationData() {
            register.CreateAccount(firstName,lastName,email, password);
            TestData.setFakeEmail(email);
            TestData.setFakePassword(password);
        }

        @And("the user clicks register")
        public void theUserClicksRegister() {
            register.confirmRegistration();
        }

        @Then("the account should be created successfully")
        public void theAccountShouldBeCreatedSuccessfully() {
            register.verifyAccountCreated();
        }


    }



