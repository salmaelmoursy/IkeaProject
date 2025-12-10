package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver){super(driver);}

private final By registBtnLocator =By.xpath("//*[@id=\"hnf-header-profile\"]/a[1]");
private final By createAccountLocator = By.xpath("//*[@id=\"mv-agent-root\"]/div[7]/div[3]/div/div[2]/div/div/div/form/button[2]/span");
private final By searchBarLocator =By.xpath("//*[@id=\"ikea-search-input\"]");
private final By searchBtnLocator =By.xpath("/html/body/header/div[2]/div/div[2]/div/div[1]/div[1]/form/div/button[2]");
private final By productLocator = By.className("alfuttaim-product-shelf-carousel__body-wrapper");
private final By productName = By.className("pip-text");
private final By productPrice = By.className("pip-price-module__price");
private final By lightingCategoryLocator = By.xpath("//*[@id=\"hnf-carousel__tabs-navigation-products\"]/div[12]/a");
private final By lampsLocator= By.xpath("//*[@id=\"hnf-dropdown-li001\"]/div/div/ul[2]/li[1]/a");
private final By favBtnLocator = By.className("pip-product-compact__add-to-list-button") ;
private final By favPage = By.xpath("/html/body/header/div[2]/div/div[3]/div[3]/a");
private final By languageSelectorLocator = By.xpath("//*[@id=\"hnf-header-localisationpicker\"]/div");
private final By arabicLocator = By.xpath("/html/body/div[11]/div/div[3]/div/div[2]/div/div/div/button[2]");
private final By titleLocator = By.xpath("//*[@id=\"b89ef2a0-03d4-11f0-81fe-695450becc2d\"]/div/div/div/h1");
private final By acceptCookiesBtn = By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]");
private final By footerSection = By.xpath("/html/body/footer");
private final By footerLink=By.xpath("//*[@id=\"hnf-accordion-section-1\"]/li[1]/a");
private final By customerService=By.xpath("//*[@id=\"hnf-accordion_1\"]/h3/button");
private final By closeBtn = By.xpath("//*[@id=\"close-button-1454703513202\"]");
private final By storeMenuLocator=By.xpath("//*[@id=\"hnf-header-storepicker\"]/a");
private final By categoryLocator =By.xpath("//*[@id=\"hnf-carousel__tabs-navigation-products\"]/div[6]/a");
private final By sectionLocator =By.xpath("//*[@id=\"hnf-dropdown-kt001\"]/div/div/ul[2]/li[1]/a");
private final By bedLocator =By.xpath("//*[@id=\"hnf-carousel__tabs-navigation-products\"]/div[10]/a");
private final By bedSectionLocator =By.xpath("//*[@id=\"hnf-dropdown-bm001\"]/div/div/ul[2]/li[1]/a");
private final By decorationLocator =By.xpath("//*[@id=\"hnf-carousel__tabs-navigation-products\"]/div[7]/a");
private final By logoLocator =By.xpath("/html/body/header/div[2]/div/div[1]/a/img");
private final By welcomeMsgLocator =By.xpath("//*[@id=\"content\"]/div/div/div[3]/article/section[2]");
private final By contactUsLocator =By.xpath("//*[@id=\"hnf-accordion-section-1\"]/li[7]/a");
private final By contactOptions =By.xpath("//*[@id=\"3c718381-cf10-11ea-aeef-cb8da637efd5\"]/div/div/div[1]");
private final By conditionsLocator =By.xpath("//*[@id=\"hnf-accordion-section-1\"]/li[1]/a");

    public String selectedName;
    public String selectedPrice;
    public void handleCookies() { try {waitClick(acceptCookiesBtn);} catch (Exception e) {
        throw new RuntimeException(e);
    } }

        public void openLogin() {
       waitClick(registBtnLocator);

    }
    public void openCreatePage(){
            waitClick(registBtnLocator);
        waitClick(createAccountLocator);
    }

    public void search(String value) {
        write(searchBarLocator, value);
    }
    public void clickSearch(){
        waitClick(searchBtnLocator);
    }

    public void selectProductRandom(){

        List<WebElement> items = driver.findElements(productLocator);

        Random rand = new Random();
        int index = rand.nextInt(items.size());

        WebElement randomProduct = items.get(index);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", randomProduct);

        selectedName = randomProduct.findElement(productName).getText();
        selectedPrice = randomProduct.findElement(productPrice).getText();

        randomProduct.click();
        }
    public String getSelectedProductName() {
        return selectedName;
    }
    public String getSelectedProductPrice() {
        return selectedPrice;
    }
    public void openLightingCategory(){
            waitClick(lightingCategoryLocator);
    }
    public void openLampsSection(){
            waitClick(lampsLocator);
    }
    public void addToFavRandom(){
        List<WebElement> items = driver.findElements(favBtnLocator);
        Random rand = new Random();
        int index = rand.nextInt(items.size());

        WebElement random = items.get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", random);
        random.click();

    }
    public void closeAbs(){
        waitClick(closeBtn);

    }

    public void openFavPage(){
            waitClick(favPage);
    }
    public void languageSelector(){
            waitClick(languageSelectorLocator);
    }
    public void switchToArabic(){
            waitClick(arabicLocator);
    }
    public void arabicApprove(){

           String titleMsg = driver.findElement(titleLocator).getText();
        Assert.assertEquals(titleMsg,"مرحباً في ايكيا مصر!");
    }

    public WebElement getFooterSection() {
        return driver.findElement(footerSection);
    }

    public void clickFooterLink() {
        waitClick(customerService);
        waitClick(footerLink);
    }
    public void termsAndConditionsLoaded(){
        WebElement conditions = wait.until(ExpectedConditions.visibilityOfElementLocated(conditionsLocator));
        Assert.assertTrue(conditions.isDisplayed());
    }
    public String getRandomProductName() {
        List<WebElement> products = driver.findElements(By.cssSelector(".product-title"));
        return products.get(new Random().nextInt(products.size())).getText();
    }
    public void clickStoreMenu(){
        waitClick(storeMenuLocator);
    }
    public void openCategoryPage(){
        waitClick(categoryLocator);
        waitClick(sectionLocator);
    }
    public void navigateToBeds(){
        waitClick(bedLocator);
        waitClick(bedSectionLocator);
    }
    public void navigateToDecoration(){
        waitClick(decorationLocator);
    }
    public void clickOnLogo(){
        waitClick(logoLocator);
    }
    public void verifyUserOnHomePage(){
        WebElement welcomeMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMsgLocator));
        Assert.assertTrue(welcomeMsg.isDisplayed());
    }
    public void clickOnContactUs(){
        waitClick(contactUsLocator);
    }
    public void contactUsLoaded(){
        WebElement options = wait.until(ExpectedConditions.visibilityOfElementLocated(contactOptions));
        Assert.assertTrue(options.isDisplayed());
    }




}