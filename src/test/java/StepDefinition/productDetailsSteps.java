package StepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductPage;

import static hooks.Hooks.driver;

public class productDetailsSteps {
HomePage home = new HomePage(driver);
ProductPage product =new ProductPage(driver);


    @When("the user clicks a random product on the home page")
    public void theUserClicksARandomProductOnTheHomePage() {
     home.selectProductRandom();
    }

    @Then("the product details page should be opened")
    public void theProductDetailsPageShouldBeOpened() {
       product.productDetailsLoaded();
    }

    @And("the product details should match the home page details")
    public void theProductDetailsShouldMatchTheHomePageDetails() {

        String homeName = home.getSelectedProductName();
        String homePrice = home.getSelectedProductPrice();

        String pageName = product.getProductPageName();
        String pagePrice = product.getProductPagePrice();

        Assert.assertEquals(pageName.trim(), homeName.trim());
        Assert.assertEquals(pagePrice.trim(), homePrice.trim());

    }
}
