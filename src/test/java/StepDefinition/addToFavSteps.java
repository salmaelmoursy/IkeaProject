package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FavoritePage;
import pages.HomePage;

import static hooks.Hooks.driver;

public class addToFavSteps {
    HomePage home =new HomePage(driver);
    FavoritePage favorite =new FavoritePage(driver);


    @When("the user adds a random product to favorites")
    public void theUserAddsARandomProductToFavorites() {
        home.addToFavRandom();
    }

    @And("the user clicks View to open Favorites page")
    public void theUserClicksViewToOpenFavoritesPage() {
       home.openFavPage();
    }

    @Then("the product should be displayed in the Favorites list")
    public void theProductShouldBeDisplayedInTheFavoritesList() {
        favorite.favItems();
    }

    @When("the user removes the product from favorites")
    public void theUserRemovesTheProductFromFavorites() {
        favorite.removeItems();
    }

    @Then("the Favorites list should be empty")
    public void theFavoritesListShouldBeEmpty() {
       favorite.emptyList();
    }
}
