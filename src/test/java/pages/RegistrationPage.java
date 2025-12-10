package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RegistrationPage extends BasePage {
    public RegistrationPage(WebDriver driver){super(driver);}

    private final By firstNameLocator =By.xpath("//*[@id=\"first-name\"]");
    private final By lastNameLocator=By.xpath("//*[@id=\"last-name\"]");
    private final By emailLocator=By.xpath("//*[@id=\"email\"]");
    private final By passwordLocator=By.xpath("//*[@id=\"password\"]");
    private final By checkBoxLocator =By.xpath("//*[@id=\"privacy-policy-checkbox\"]");
    private final By createBtnLocator=By.xpath("//*[@id=\"root\"]/main/section[2]/div/form/button");
    private final By registerMsgLocator=By.xpath("//*[@id=\"root\"]/main/section[2]/div/section/div/div");

    public void CreateAccount(String firstName,String lastName, String email ,String password){
        write(firstNameLocator,firstName);
        write(lastNameLocator,lastName);
        write(emailLocator,email);
        write(passwordLocator,password);
    }
    public void confirmRegistration(){
        WebElement checkbox = driver.findElement(checkBoxLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        waitClick(createBtnLocator);
    }
    public void verifyAccountCreated(){
        WebElement registerMsg = driver.findElement(registerMsgLocator);
        Assert.assertTrue(registerMsg.isDisplayed());
    }
}
