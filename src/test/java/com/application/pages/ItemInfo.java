package com.application.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.application.libraries.GenericUtils;

public class ItemInfo {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "span.valign-middle")
	private WebElement addNewItemSelect;

	@FindBy(xpath = ".//*[@id='LineItemTable']/tbody/tr/td[2]/div/div/div[1]")
	private WebElement addNewItemText;

	@FindBy(xpath = "html/body/div[4]/div/div[2]/div/div/div/div/div[3]/div[2]/div[1]/input")
	private WebElement newItemName;

	@FindBy(xpath = "//div[2]/div[2]/div/span")
	private WebElement findHsnCode;

	@FindBy(xpath = "(//div[@class='container-fluid']//span)[8]")
	private WebElement findHsnCodePurchaseOreder;

	@FindBy(xpath = "//div[2]/button")
	private WebElement searchHsnCodeBtn;

	@FindBy(xpath = "//div[@class='modal-body']//button[@class='btn font-10 padding-20 btn-green-border uppercase']")
	private WebElement searchHsnCodeBtnPurchaseOrder;

	@FindBy(xpath = "html/body/div[4]/div/div[2]/div/div/div[2]/div/div[3]/div/table[1]/tr/td[1]/input")
	private WebElement radioBtnHsnCodeSelect;

	@FindBy(xpath = "//div[@class='form-group col-md-12']/textarea")
	private WebElement newItemDesciptionTextArea;

	@FindBy(xpath = "(//div[@class='form-group']/input)[1]")
	private WebElement sellingPrice;

	@FindBy(xpath = "(//div[@class='modal-body']//input)[3]")
	private WebElement sellingPricePurchaseOreder;

	@FindBy(xpath = "(//div[@class='form-group']/input)[2]")
	private WebElement purchasePrice;

	@FindBy(xpath = "(//div[@class='modal-body']//input)[4]")
	private WebElement purchasePricePurchaseOreder;

	@FindBy(xpath = "(//div[@class='container-fluid']//span[@class='Select-arrow'])[1]")
	private WebElement unitOfMeasureDropdown;

	@FindBy(xpath = "html/body/div[4]/div/div[2]/div/div/div/div/div[3]/div[4]/div[4]/div[1]/div[1]/div/div[1]/div")
	private WebElement unitOfMesureSelect;

	@FindBy(xpath = "html/body/div[4]/div/div[2]/div/div/div/div/div[3]/div[4]/div[3]/div/div/div[1]")
	private WebElement unitOfMesureTextArea;

	public void checkOptionExistsOrNot(int val) {
		String unitOfMesureXpath = "//div[contains(@class,'selectUnitOfMeasure')]//div[@class='Select-menu-outer']/div["
				+ val + "]/div";
		WebElement ele = driver.findElement(By.xpath(unitOfMesureXpath));
		String txt = ele.getText();
		GenericUtils.delay(3);
		WebElement ele1 = driver.findElement(
				By.xpath("//div[contains(@class,'selectUnitOfMeasure')]//div[@class='Select-input ']/input"));
		GenericUtils.delay(3);

		ele1.sendKeys(txt);
		GenericUtils.sendEnterKeys(driver);
	}

	@FindBy(xpath = "//select[@class='form-control grey-border height-40 border-radius-6 font-12']")
	private WebElement taxCreditDropdown;

	@FindBy(xpath = "//div[2]/select/option[4]")
	private WebElement taxCreditTypeClick;

	@FindBy(xpath = "(//div[@class='container-fluid']//span[@class='Select-arrow'])[3]")
	private WebElement purchaseTypedropdownBtn;

	@FindBy(xpath = "(//div[@class='container-fluid']//div[@class='Select-input ']/input)[2]")
	private WebElement purchaseTypeText;

	@FindBy(xpath = "//div[@class='modal-body']//button")
	private WebElement saveButton;

	@FindBy(xpath = "(//div[@class='modal-body']//button)[1]")
	private WebElement saveButtonPurchaseOrder;

	public void addNewItemSelectClick() {
		addNewItemSelect.click();
		// JavascriptLibrary.javascriptClickElement(driver, addNewItemSelect);
	}

	public void addNewItemTextclick() {
		addNewItemText.click();
	}

	public void setTextTonewItemName(String itemName) {
		newItemName.sendKeys(itemName);
	}

	public void findHsnCodeClickOn() {
		new Actions(driver).moveToElement(findHsnCode).click().perform();
		// findHsnCode.click();
	}

	public void searchHsnCodeBtnClick() {
		searchHsnCodeBtn.click();
	}

	public void radioBtnHsnCodeSelectClick() {
		radioBtnHsnCodeSelect.click();
	}

	public void unitOfMeasureDropdownClick() {
		unitOfMeasureDropdown.click();
	}

	public void unitOfMesureSelectClick() {
		unitOfMesureSelect.click();
	}

	public void newItemDesciptionTextAreaSettext(String desc) {
		newItemDesciptionTextArea.sendKeys(desc);
	}

	public void sellingPricesetText(String selling) {
		sellingPrice.clear();
		sellingPrice.sendKeys(selling);
	}

	public void purchasePriceSetText(String purchase) {
		purchasePrice.clear();
		purchasePrice.sendKeys(purchase);
	}

	public void taxCreditDropdownClick(int index) {
		Select select = new Select(taxCreditDropdown);
		select.selectByIndex(index);
	}

	public void taxCreditTypeClickclick() {
		taxCreditTypeClick.click();
		GenericUtils.sendEnterKeys(driver);
	}

	public void purchaseTypedropdownBtnclick() {
		purchaseTypedropdownBtn.click();
	}

	public void purchaseTypeTextSetText(String purchaseTyp) {
		purchaseTypeText.sendKeys(purchaseTyp);
	}

	public void saveButtonclick() {
		saveButton.click();
	}

	public ItemInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void findHsnCodePurchaseOrederClick() {
		findHsnCodePurchaseOreder.click();
	}

	public void searchHsnCodeBtnPurchaseOrderClick() {
		searchHsnCodeBtnPurchaseOrder.click();
	}

	public void sellingPricePurchaseOrederSetText(String sellingPric) {
		sellingPricePurchaseOreder.clear();
		sellingPricePurchaseOreder.sendKeys(sellingPric);
	}

	public void purchasePricePurchaseOrederSetText(String purchasePric) {
		purchasePricePurchaseOreder.clear();
		purchasePricePurchaseOreder.sendKeys(purchasePric);
	}

	public void saveButtonPurchaseOrderClick() {
		saveButtonPurchaseOrder.click();
	}

}
