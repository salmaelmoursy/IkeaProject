package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FavoritePage;
import pages.HomePage;

import static hooks.Hooks.driver;

public class multipleFavoritesSteps {
    HomePage home = new HomePage(driver);
    FavoritePage favorite = new FavoritePage(driver);

    @When("the user adds three random products to favorites")
    public void theUserAddsThreeRandomProductsToFavorites() {
       for (int i =0 ;i<3;i++){
           home.addToFavRandom();
       }
    }
    @And("the user navigates to the Favorites page")
    public void theUserNavigatesToTheFavoritesPage() {
        home.openFavPage();
    }


    @Then("all three products should be listed")
    public void allThreeProductsShouldBeListed() {
         favorite.verifyNumberOfProduct(3);
    }

    @When("the user removes one product from favorites")
    public void theUserRemovesOneProductFromFavorites() {
        favorite.removeOneProduct();
    }

    @Then("the remaining two products should still be listed")
    public void theRemainingTwoProductsShouldStillBeListed() {
        favorite.verifyNumberOfProduct(2);
    }
}
