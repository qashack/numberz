package com.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;

public class ItemInformationPage extends TaxInvoicePage {
	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='Item Name']")
	@CacheLookup
	private WebElement itemName;

	@FindBy(xpath = "//input[@placeholder='Item HSN Code']")
	@CacheLookup
	private WebElement hsnCode;

	@FindBy(xpath = "//textarea[@placeholder='Item Description']")
	@CacheLookup
	private WebElement itemDescription;

	@FindBy(xpath = "(//input[@placeholder='INR'])[1]")
	@CacheLookup
	private WebElement sellingPrice;

	@FindBy(xpath = "(//input[@placeholder='INR'])[2]")
	@CacheLookup
	private WebElement purchasePrice;

	@FindBy(xpath = "(//div[@class='container-fluid'] //span[@class='Select-arrow'])[1]")
	@CacheLookup
	private WebElement unitmessureArrow;

	@FindBy(xpath = "//div[@class='container-fluid'] //div[@class='Select-input ']/input")
	@CacheLookup
	private WebElement unitofMessure;

	@FindBy(xpath = "(//div[@class='container-fluid'] //span[@class='Select-arrow'])[2]")
	@CacheLookup
	private WebElement taxarrow;
	
	@FindBy(xpath = "//div[@class='container-fluid']//div[@class='Select-value']/div")
	@CacheLookup
	private WebElement taxfield;

	@FindBy(xpath = "//div[@class='container-fluid'] //button[text()='Save']")
	@CacheLookup
	private WebElement saveButton;

	@FindBy(xpath = "//div[@class='container-fluid'] //button[text()='Cancel']")
	private WebElement cancelButton;
	// HSn link
	@FindBy(xpath = "//span[text()='Find HSN code']")
	private WebElement findHsnlink;

	@FindBy(xpath = "//input[@class='form-control search-input']")
	private WebElement hsnInput;

	@FindBy(xpath = "//button[text()='Search']")
	private WebElement hsnsearchButton;

	@FindBy(xpath = "(//td[@class='col col-md-1']/input)[1]")
	private WebElement hsnSelect;

	public ItemInformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ItemInformationPage fillAddItem(String item_name) {
		itemName.sendKeys(item_name);
		return this;
	}

	public ItemInformationPage fillHsnCode(String hsncode) {
		hsnCode.sendKeys(hsncode);
		return this;
	}

	public ItemInformationPage fillDescription(String description) {
		itemDescription.sendKeys(description);
		return this;
	}

	public ItemInformationPage fillSellingPrice(String price) {
		sellingPrice.clear();
		sellingPrice.sendKeys(price);
		return this;
	}

	public ItemInformationPage fillPurchasePrice(String price) {
		purchasePrice.clear();
		purchasePrice.sendKeys(price);
		return this;
	}

	public ItemInformationPage fillUnitOf(String price) {
		purchasePrice.sendKeys(price);
		return this;
	}

	public ItemInformationPage fillUnitofMeasure(String unit) {
		unitmessureArrow.click();
		unitofMessure.sendKeys(unit);
		return this;
	}

	public ItemInformationPage clickSaveButton() {
		saveButton.click();
		return this;
	}

	public ItemInformationPage clickCancelButton() {
		cancelButton.click();
		return this;
	}

	public ItemInformationPage addAllItemField(String filePath, String sheetName) {
		String item_name = ExcelLibrary.getExcelData(filePath, sheetName, 1, 2);
		String sellingPrice = ExcelLibrary.getExcelData(filePath, sheetName, 1, 4);
		String purchasePrice = ExcelLibrary.getExcelData(filePath, sheetName, 1, 5);
		fillAddItem(item_name);
		clickOnHsnLink();
		clickHsnSearch();
		selectHSn();
		fillDescription(GenericUtils.simpleDate());
		fillSellingPrice(sellingPrice);
		fillPurchasePrice(purchasePrice);
		
		return this;
	}

	public ItemInformationPage clickOnHsnLink() {
		GenericUtils.delay(2);
		findHsnlink.click();
		return this;
	}

	public ItemInformationPage clickHsnSearch() {
		// hsnInput.sendKeys(data);
		hsnsearchButton.click();
		return this;
	}
	public ItemInformationPage verifyHSNTaxField()
	{
		int t=taxfield.getText().length();
		if(t>0)
		{
			Assert.assertTrue(true,"Tax is auto poupulated");
		}else 
		{
			Assert.assertFalse(true,"Tax rate is not autopoulated");
		}
		
		
		
		return this;
	}

	public ItemInformationPage selectHSn() {
		GenericUtils.delay(5);
		hsnSelect.click();
		return this;
	}

}
