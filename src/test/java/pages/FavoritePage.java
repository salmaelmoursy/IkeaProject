package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class FavoritePage extends BasePage {
    public FavoritePage (WebDriver driver){super(driver);}
    private final By imageLocator = By.className("fav-image");
    private final By listLocator = By.xpath("//*[@id=\"root\"]/div/main/div/ul/li/section/button");
    private final By removeListLocator = By.xpath("//*[@id=\"fav-listview-3\"]");
    private final By removeBtnLocator = By.xpath("//*[@id=\"confirmation-prompt-modal\"]/div[2]/div[2]/button[1]");
    private final By msgLocator = By.xpath("//*[@id=\"root\"]/div/main/div/section[1]/h1");
    private final By removeProduct = By.xpath("//*[@id=\"fav-listview-1\"]/button");
    private final By itemOptions = By.className("fav-typography-label-s");

    public void favItems(){
        WebElement item = wait.until(ExpectedConditions.visibilityOfElementLocated(imageLocator));
        Assert.assertTrue(item.isDisplayed(),"the favorites page is empty");
    }
    public void removeItems(){
        waitClick(listLocator);
        waitClick(removeListLocator);
        waitClick(removeBtnLocator);
    }
    public void removeOneProduct(){
        waitClick(imageLocator);
        waitClick(itemOptions);
        waitClick(removeProduct);
    }
    public void emptyList(){
        WebElement emptyMsg =wait.until(ExpectedConditions.visibilityOfElementLocated(msgLocator));
        Assert.assertTrue(emptyMsg.isDisplayed());
    }
    public void verifyNumberOfProduct(int  index){
        List<WebElement> favoritesItems =driver.findElements(imageLocator);
        int count= favoritesItems.size();
        Assert.assertEquals(count,index);
    }
}
