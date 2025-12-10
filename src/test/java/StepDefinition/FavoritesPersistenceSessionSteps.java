package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FavoritePage;
import pages.HomePage;
import pages.ProductPage;

import static hooks.Hooks.driver;

public class FavoritesPersistenceSessionSteps {
    HomePage home = new HomePage(driver);
    ProductPage product = new ProductPage(driver);
    FavoritePage favorite = new FavoritePage(driver);


    @When("the user selects a random product and add to fav")
    public void theUserSelectsARandomProductAndAddToFav() {
       home.addToFavRandom();
    }



    @And("user navigates to the {string} category")
    public void userNavigatesToTheCategory(String arg0) {
        home.openCategoryPage();


    }

    @And("the user goes to the favorites page")
    public void theUserGoesToTheFavoritesPage() {
        home.openFavPage();
    }

    @Then("the previously added product should be displayed in the favorites list")
    public void thePreviouslyAddedProductShouldBeDisplayedInTheFavoritesList() {
        favorite.favItems();
        System.out.println("there is item");
    }

    @When("user removes the product from favorites")
    public void userRemovesTheProductFromFavorites() {
        favorite.removeItems();
    }

    @Then("the product should no longer appear in the favorites list")
    public void theProductShouldNoLongerAppearInTheFavoritesList() {
        favorite.emptyList();
    }
}
