package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        action = new Actions(driver);
    }

    public void waitClick(By by) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        action.moveToElement(element).perform();
        element.click();

    }

    public void write(By by, String value) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.clear();
        element.sendKeys(value);
    }

}


