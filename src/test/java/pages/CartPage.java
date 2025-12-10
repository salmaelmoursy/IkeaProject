package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.Objects;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){super(driver);}
private final By quantityLocator = By.className("cart-quantity-stepper__input");
private final By checkoutButton = By.xpath("//*[@id=\"summary\"]/div/span[2]/button");
private final By totalPriceLocator = By.xpath("//*[@id=\"summary\"]/div/div[1]/div[3]/span[2]/span[1]/span/span[2]");
    public int getQuantityInCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityLocator));
        String qtyNum = Objects.requireNonNull(driver.findElement(quantityLocator).getAttribute("value")).trim();
        return Integer.parseInt(qtyNum);
    }
    public  void editQuantity(int num){
      write(quantityLocator,String.valueOf(num));
    }
    public void totalPrice(double productPrice ,int num){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPriceLocator));
        String totalText = driver.findElement(totalPriceLocator).getText();
        double totalDisplayed = Double.parseDouble(totalText.replaceAll("[^0-9.]", ""));

        Assert.assertEquals(totalDisplayed, productPrice * num, "Total price is incorrect!");
    }
    public void clickCheckout() {
waitClick(checkoutButton);    }
}
