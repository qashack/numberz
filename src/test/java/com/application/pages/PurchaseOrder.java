package com.application.pages;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PurchaseOrder {

	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(xpath = "//div[@class='row divNav']//button")
	private WebElement addPurchaseOrder;

	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-placeholder'])[1]")
	private WebElement selectOrAddVendorClick;

	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-input ']/input)[1]")
	private WebElement selectOrAddNewvendorInput;

	@FindBy(xpath = ".//*[@id='po-select-vendor']/div/div/div[2]/div/div[1]/div/span")
	private WebElement addNewVendor;

	@FindBy(xpath = "(//div[@class='invoice-body']//input)[3]")
	private WebElement purchaseOrderHash;

	@FindBy(xpath = "(//div[@class='invoice-body']//input)[8]")
	private WebElement refHash;

	@FindBy(id = "CreatePO-terms")
	private WebElement paymentTerms;

	@FindBy(id = "Select-Input-undefined")
	private WebElement expenseType;

	@FindBy(xpath = "(//div[@class='invoice-body']//span[@class='Select-arrow'])[2]")
	private WebElement expenseTypeDropdownBtn;

	@FindBy(xpath = "(//div[@class='invoice-body']//input)[7]")
	private WebElement expenseTypeText;

	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-input ']/input)[3]")
	private WebElement selectOrAddItemInput;

	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-control'])[3]")
	private WebElement selectOrAddItem;

	@FindBy(xpath = ".//input[@id='po-ref-number']")
	private WebElement poHash;

	@FindBy(xpath = "//button[@id='create-estimate-save-btn']")
	private WebElement savePurchaseOrder;

	@FindBy(xpath = "html/body/div[4]/div/div[2]")
	private WebElement addNewItem;

	@FindBy(css = "span.valign-middle")
	private WebElement addNewItemSelect;

	@FindBy(xpath = "//div[@class='col-md-12 header-padding']//button[@id='create-estimate-send-btn']")
	private WebElement sendPurchaseButton;

	@FindBy(xpath = "//div[@class='modal-body']//button[@class='btn font-10 padding-20 btn-green-border uppercase left-margin-20 pull-right margin-top-12']")
	private WebElement sendEmailButton;

	@FindBy(xpath = "(//div[@class='row divNav']//a[@class='center-align'])[3]")
	private WebElement recurringBtn;

	public PurchaseOrder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addPurchaseOrderClick() {
		addPurchaseOrder.click();
	}

	public void selectOrAddVendorClick() {
		selectOrAddVendorClick.click();
	}

	public void addNewVendorClick() {
		addNewVendor.click();
	}

	public void selectOrAddVendorClickSetText(String vendorNamee) {
		selectOrAddNewvendorInput.sendKeys(vendorNamee);
	}

	public void setPaymentTermsDropDownListField(String paymentTermsValue) {
		new Select(paymentTerms).selectByVisibleText(paymentTermsValue);
	}

	public void setExpenseTypeTextField(String expenseTypeValue) {
		expenseType.sendKeys(expenseTypeValue);
	}

	public void expenseTypeDropdownBtnClick() {
		expenseTypeDropdownBtn.click();
	}

	public void expenseTypeTextSetText(String expenseTYpe) {
		expenseTypeText.sendKeys(expenseTYpe);
	}

	public void refHashSetText(String ref) {
		refHash.sendKeys(ref);
	}

	public void selectOrAddItemClick() {
		selectOrAddItem.click();
	}

	public void selectOrAddItemInputSetText(String item) {
		selectOrAddItemInput.sendKeys(item);
	}

	public void poHashSetText(String po) {
		poHash.sendKeys(po);
	}

	public void savePurchaseOrderClick() {
		savePurchaseOrder.click();
	}

	public void addNewItemClick() {
		addNewItemSelect.click();
	}

	public void sendPurchaseButtonClick() {
		sendPurchaseButton.click();
	}

	public void sendEmailButtonClick() {
		sendEmailButton.click();
	}

	public void recurringBtnClick() {
		recurringBtn.click();
	}

}
