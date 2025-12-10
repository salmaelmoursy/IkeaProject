package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private final By productLocator = By.xpath("//*[@id=\"product-list\"]");
    private final By sortFilterLocator = By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div[2]/ul/li[1]/button");
    private final By lowToHighFilterLocator = By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div[2]/div[2]/div/fieldset/label[2]/span[2]");
    private final By productPrice = By.className("plp-price__nowrap");
    private final By addToBagBtn = By.xpath("//*[@id=\"product-list\"]/div[2]/div[1]/div/div/div[3]/button[1]");
    private final By bagBtn = By.xpath("/html/body/header/div[2]/div/div[3]/div[4]/a");
    private final By locator = By.xpath("//*[@id=\"content\"]/div/div/section[2]/div/h1");

    public void verifySearchResult(String value) {
        List<WebElement> products = driver.findElements(productLocator);
        for (WebElement product : products) {
            System.out.println(product.getText());
            Assert.assertTrue(product.getText().toLowerCase().contains(value.toLowerCase()));

        }

    }
    public void filterLowToHigh(){
        waitClick(sortFilterLocator);
        waitClick(lowToHighFilterLocator);
        waitClick(locator);
    }
    public List<Double> getAllProductPrices(){
        List<WebElement> priceElements = driver.findElements(productPrice);

        List<Double> prices = new ArrayList<>();
        for (WebElement p : priceElements) {
            String priceText = p.getText().replaceAll("[^0-9.]", "").trim();
            prices.add(Double.parseDouble(priceText));
        }
        return prices;
    }
    public String addFirstResultToBag() {
        waitClick(addToBagBtn);
        return driver.findElement(productPrice).getText();
    }
    public void goToBag(){
        waitClick(bagBtn);
    }


}

