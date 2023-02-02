package pageObjectsFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.baseFunctionality;

import java.io.IOException;

public class HomePageObjects {
    public WebDriver driver;
    public WebDriverWait wait;
    public baseFunctionality base = new baseFunctionality();
    
    @FindBy(how = How.XPATH, using = "//title[contains(text(),'Online')]")
    private WebElement homepagetitle;

    public void VerifyHomeTitle() throws IOException {
        wait.until(ExpectedConditions.titleIs("Takealot.com: Online Shopping | SA's leading online store"));
        base.TakeScreenShots("VerifyHomeTitle");
    }

    @FindBy(how = How.XPATH, using = "//input[@name='search']")
    private WebElement searchinput;
    public void SearchProductName() throws IOException {
        new WebDriverWait(this.driver, 60).until(ExpectedConditions.visibilityOf(searchinput));
        String SearchName = "Lipton Peach Ice Tea 6 x 500ml";
        searchinput.sendKeys(SearchName);
        base.TakeScreenShots("SearchProductName");

    }
    @FindBy(how = How.XPATH, using = "//button[@data-ref='search-submit-button']")
    private WebElement Seachbtn;
    public void ClickSearchButton() throws IOException {
        Seachbtn.click();
        base.TakeScreenShots("ClickSearchButton");
    }

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'listings-container')]//a[@href])[1]")
    private WebElement firstproductprice;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'listings-container')]//a[@href]//h4)[1]")
    private WebElement productTitle;
    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'listings-container')]//span[contains(@class,'currency plus currency-module_currency')])[1]")
    private WebElement productPrice;
    public void ClickSearchedProduct() throws IOException {

        firstproductprice.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'pdp-module_sidebar-buybox')]//span[contains(@class,'currency plus currency-module_currency')]")));
        base.TakeScreenShots("ClickSearchedProduct");
    }

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'pdp-module_sidebar-buybox')]//span[contains(@class,'currency plus currency-module_currency')]")
    private WebElement ActualProductPrice;

    @FindBy(how = How.XPATH, using = "//div[@class='product-title']//h1")
    private WebElement ActualProductDescription;

    public void ValidateProductPriceAndDescription() throws IOException {
        String actualPrice = ActualProductPrice.getText();
        String actualDescription = ActualProductDescription.getText();
        String ExpectedDescription = productTitle.getText();
        String ExpectedPrice = productPrice.getText();
        Assert.assertEquals(actualPrice,ExpectedPrice);
        Assert.assertEquals(actualDescription,ExpectedDescription);
        base.TakeScreenShots("ValidateProductPriceAndDescription");
    }

    @FindBy(how = How.XPATH, using = "(//div[@class='product-info ']//tr[@class='product-info-row-undefined']//td[text()='Categories']//parent::tr//li/a)[1]")
    private WebElement Categories;
    @FindBy(how = How.XPATH, using = "//div[@class='product-info ']//tr[@class='product-info-row-undefined']//td[text()='Brand']//parent::tr//a")
    private WebElement Brand;
    @FindBy(how = How.XPATH, using = "//div[@class='product-info ']//tr[@class='product-info-row-undefined']//td[text()='Volume']//parent::tr//p")
    private WebElement Volume;
    @FindBy(how = How.XPATH, using = "//div[@class='product-info ']//tr[@class='product-info-row-undefined']//td[text()='Barcode']//parent::tr//li")
    private WebElement Barcode;
    public void VerifyProductInformationIsDisplayed() throws IOException {
      String txtCategories = Categories.getText();
      String txtBrand = Brand.getText();
      String txtVolume = Volume.getText();
      String txtBarcode = Barcode.getText();

//      Assert.assertNotNull(txtCategories);

      Assert.assertTrue(CheckNotEmptyString(txtCategories));
      Assert.assertTrue(CheckNotEmptyString(txtBrand));
      Assert.assertTrue(CheckNotEmptyString(txtVolume));
      Assert.assertTrue(CheckNotEmptyString(txtBarcode));

        base.TakeScreenShots("VerifyProductInformationIsDisplayed");
    }
    public  Boolean CheckNotEmptyString(String check){
        return check.trim().length() > 0;
    }


    //constructor
    public HomePageObjects(WebDriver driver){
        this.driver=driver;

        this.wait = new WebDriverWait(driver,180);
        PageFactory.initElements(driver, this);
    }

}


