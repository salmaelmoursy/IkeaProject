package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    private final By nameInput =By.xpath("//*[@id=\"NewAddress_FirstName\"]");
    private final By cityInput =By.xpath("//*[@id=\"NewAddress_Address1\"]");
    private final By streetInput =By.xpath("//*[@id=\"NewAddress_Address2\"]");
    private final By phoneInput =By.xpath("//*[@id=\"NewAddress_PhoneNumber\"]");
    private final By emailInput =By.xpath("//*[@id=\"NewAddress_Email\"]");
    private final By governorateOptions =By.xpath("//*[@id=\"NewAddress_AreaId\"]");
    private final By areaOptions =By.xpath("//*[@id=\"NewAddress_CityAreaId\"]");
    private final By continueBtn =By.xpath("//*[@id=\"billingSubmitButton\"]");
    private final By continBtn =By.xpath("//*[@id=\"deliveryAndAssemblyContinue\"]");
    private final By clickAndCollectBtn =By.xpath("//*[@id=\"selectDeliveryDetails\"]/div/div[1]/div/label/span");
    private final By deliveryOptions =By.xpath("//*[@id=\"shippingmethods\"]/div[2]/div/select");
    private final By paymentForm =By.xpath("//*[@id=\"paymob_walletpayment\"]/div/div/div");
    private final By paymentoption =By.xpath("//*[@id=\"payment-load\"]/div[7]/div/div/div/div/div/div/div/div[5]/div/label/span[2]");

    public void fillBillingAddress(String name, String email, String phone, String address, String address2) {
write(nameInput,name);
         waitClick(governorateOptions);
       // Select select = new Select(options);
       // select.deselectByIndex(1);
        WebElement dropdown = driver.findElement(areaOptions);
        dropdown.click();
        Select selec = new Select(dropdown);
        selec.deselectByIndex(1);
write(emailInput,email);
write(phoneInput,phone);
write(cityInput,address);
write(streetInput,address2);
        waitClick(continueBtn);
    }

    public void selectDeliveryDateTimeIfAvailable() {
        waitClick(clickAndCollectBtn);
        List<WebElement> options = driver.findElements(deliveryOptions);
        if(!options.isEmpty()) options.getFirst().click();
        waitClick(continBtn);
    }

    public void selectPaymentMethod(String value) {
        WebElement dropdown = driver.findElement(areaOptions);
        Select select = new Select(dropdown);
        select.selectByValue(value);    }

    public void stopBeforePaymentConfirmation() {
        // لا نضغط Confirm،
    }
    public boolean isPaymentDetailsRequired() {
        return driver.findElement(paymentForm).isDisplayed();
    }
    }
