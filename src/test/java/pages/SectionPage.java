package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class SectionPage extends BasePage{
    public SectionPage(WebDriver driver){super(driver);}

   private final By productSLocator = By.className("plp-fragment-wrapper");
   private final By productLocator = By.className("ins-web-smart-recommender-box-item");
   private final By titleLocator = By.className("ins-dynamic-text");
   private final By priceLocator = By.className("ins-parsed-price");
   private final By productPrice = By.className("pipcom-price__integer");
   private final By productTitle  = By.className("//pipcom-price-module__name-decorator");
   private final By materialFilterLocator  = By.xpath("/html/body/main/div[7]/div[1]/div[2]/div[2]/div[2]/ul/li[7]/button");
   private final By priceFilterLocator  = By.xpath("/html/body/main/div[7]/div[1]/div[2]/div[2]/div[2]/ul/li[6]/button");
   private final By bedsLocator  = By.className("plp-fragment-wrapper.plp-fragment-wrapper--grid");
   private final By productPriceLocator  = By.className("plp-price__integer");

    String listedTitle;
    String listedPrice;
    WebElement randomProduct;


    public void selectProductRandom(){
        List<WebElement> products = driver.findElements(productSLocator);
        Random rand = new Random();
        int index = rand.nextInt(products.size());
        WebElement randomProduct = products.get(index);
        randomProduct.click();

    }
    public void noteTitleAndPrice() {
        List<WebElement> items = driver.findElements(productLocator);

        Random rand = new Random();
        int index = rand.nextInt(items.size());

         randomProduct = items.get(index);

        listedTitle = randomProduct.findElement(titleLocator).getText();
        listedPrice = randomProduct.findElement(priceLocator).getText();

    }



    public void clickSelectedProduct() {
        randomProduct.click();
    }
    public void verifyProductDetails() {
        WebElement detailTitle = driver.findElement(productTitle);
        WebElement detailPrice = driver.findElement(productPrice);

        Assert.assertEquals( listedTitle, detailTitle.getText(),"Product title mismatch!");
        Assert.assertEquals( listedPrice, detailPrice.getText(),"Product price mismatch!");
    }
    public void applyFilters(String material, String priceRange) {

        WebElement materialFilter = driver.findElement(materialFilterLocator);
        if (!materialFilter.isSelected()) {
            materialFilter.click();

            WebElement priceFilter = driver.findElement(priceFilterLocator);
            if (!priceFilter.isSelected()) {
                priceFilter.click();
            }

        }}
    public void verifyProductsMatchFilters(String material, String priceRange) {
        List<WebElement> products = driver.findElements(bedsLocator);

        String[] priceLimits = priceRange.replace(" EGP", "").split(" - ");
        double minPrice = Double.parseDouble(priceLimits[0].replace(",", ""));
        double maxPrice = Double.parseDouble(priceLimits[1].replace(",", ""));

        for (WebElement product : products) {
            String productMaterial = product.findElement(By.cssSelector(".product-material")).getText();
            Assert.assertTrue(productMaterial.contains(material),
                    "Material filter mismatch: " + productMaterial);

            String priceText = product.findElement(productPriceLocator).getText();
            double price = Double.parseDouble(priceText.replaceAll("[^0-9]", ""));
            Assert.assertTrue(price >= minPrice && price <= maxPrice,
                    "Price filter mismatch: " + price);
        }
    }
    }
