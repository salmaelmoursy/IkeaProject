package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){super(driver);}

    private final By emailLocator =By.xpath("//*[@id=\"login-email\"]");
    private final By passLocator =By.xpath("//*[@id=\"login-password\"]");
    private final By loginBtnLocator =By.xpath("//*[@id=\"mv-agent-root\"]/div[7]/div[3]/div/div[2]/div/div/div/form/button[1]");
    private final By loginMsgLocator =By.xpath(" /html/body/div[10]/div");

    public void loin(String email, String password){
        write(emailLocator,email);
        write(passLocator,password);
        waitClick(loginBtnLocator);

    }
    public void userLoginSuccessfully(){
        WebElement loginMsg = driver.findElement(loginMsgLocator);
        Assert.assertTrue(loginMsg.isDisplayed());
    }
}
