package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver){super(driver);}
    private final By productName = By.className("pip-text");
    private final By productPrice = By.className("pip-price__nowrap");
    private final By deliveryLocator = By.xpath("//*[@id=\"pip-buy-module-content\"]/div[4]/div[2]/div/div");
    private final By addToCartLocator= By.className("pip-btn--emphasised");
    private final By continueShoppingLocator= By.xpath("/html/body/div[10]/div/div[3]/div/div[3]/button");
    private final By cartBtnLocator= By.xpath("/html/body/div[10]/div/div[3]/div/div[3]/a");

    public String getProductPageName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
        return driver.findElement(productName).getText();
    }

    public String getProductPagePrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));
        return driver.findElement(productPrice).getText();
    }
    public void productDetailsLoaded(){
        WebElement delivery = driver.findElement(deliveryLocator);
        Assert.assertTrue(delivery.isDisplayed());
    }
    public void addToCart(){
        waitClick(addToCartLocator);
    }

    public void continueShopping(){
        waitClick(continueShoppingLocator);
    }

    public void goToCart(){
        waitClick(cartBtnLocator);
    }
}

