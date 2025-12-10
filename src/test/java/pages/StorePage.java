package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class StorePage extends BasePage{
    public StorePage(WebDriver driver){super(driver);}

    private final By storesLocator=By.className("hnf-choice__list-item");
    private final By storeLocator=By.xpath("//*[@id=\"hnf-header-storepicker\"]/a");
    private final By storeDetailsLocator=By.xpath("/html/body/div[11]/div/div[3]/div/div[2]/div/div");



    public void selectAnyStore() {
        List<WebElement> stores = driver.findElements(storesLocator);
        Assert.assertFalse(stores.isEmpty());
        stores.getFirst().click();
    }
    public void verifyStoreDetails() {
        waitClick(storeLocator);
        WebElement storeDetails = driver.findElement(storeDetailsLocator);
        Assert.assertTrue( storeDetails.isDisplayed());
    }
}
