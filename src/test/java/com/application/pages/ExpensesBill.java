package com.application.pages;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.application.libraries.JavascriptLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExpensesBill {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	// ----------------
	@FindBy(xpath = "//div[contains(@class,'Select-arrow-zone')]//span[@class='Select-arrow']")
	private WebElement expenseTypeDropDownButton;

	@FindBy(xpath = "//div[@class='Select-placeholder' and text()='Add New']/../div[@class='Select-input ']/input")
	private WebElement expenseTypebtn;

	@FindBy(xpath = "//label[text()='Expense Type']/..//span[@class='Select-arrow']")
	private WebElement expenseTypebtnArrowBtn;

	@FindBy(xpath = "//div[@class='input-group']/input")
	private WebElement toEmailIdInput;

	public void clickexpenseTypebtn() {
		expenseTypebtnArrowBtn.click();
		JavascriptLibrary.javascriptClickElement(driver, expenseTypebtnArrowBtn);
	}

	public void checkOptionExistsOrNot(String val) {
		String checkOption = "//div[@id='bill-expense-type']//div[@class='Select-menu']//span[text()='" + val + "']";
		int actual = driver.findElements(By.xpath(checkOption)).size();
		int expected = 1;
		Assert.assertEquals(actual, expected);
	}

	@FindBy(xpath = ".//*[@id='LineItemTable']/tbody/tr/td[2]/div/div/div[1]")
	private WebElement ItemNameTextField;

	public void clickItemNameTextField() {
		ItemNameTextField.click();
		// JavascriptLibrary.javascriptClickElement(driver,
		// expenseTypebtnArrowBtn);
	}

	// ---------------------

	@FindBy(id = "bill-ref-number")
	private WebElement bill;

	@FindBy(css = "input.form-control.gb-calendar")
	private WebElement billDate;

	@FindBy(id = "SelectCustomer-Input--1")
	private WebElement billFrom;

	@FindBy(id = "bill-cancel-btn")
	private WebElement cancel;

	@FindBy(css = "button.olark-launch-button.olark-chat-tab.olark-size-md")
	private WebElement chatIconThreeSmallDotsTo;

	@FindBy(id = "olark-form-input-email")
	private WebElement clickHereAndTypeYourEmail;

	@FindBy(id = "olark-form-input-fname")
	private WebElement clickHereAndTypeYourName;

	@FindBy(id = "olark-form-input-phone")
	private WebElement clickHereAndTypeYourPhone1;

	@FindBy(css = "textarea")
	private WebElement clickHereAndTypeYourPhone2;

	@FindBy(css = "button.olark-form-send-button")
	private WebElement clickHereToStartChatting;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(5) div:nth-of-type(3) div:nth-of-type(1) div.row div.col-md-12 div:nth-of-type(2) div.col-md-12 div.row.no-padding.padding-bottom-5 div.form-group div:nth-of-type(1) div:nth-of-type(1) input.form-control.text-align-right.editable-input[type='number']")
	private WebElement discount1;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(5) div:nth-of-type(3) div:nth-of-type(1) div.row div.col-md-12 div:nth-of-type(2) div.col-md-12 div.row.no-padding.padding-bottom-5 div.form-group div:nth-of-type(2) div.col-md-11.no-padding-right input.form-control.text-align-right.editable-input[type='number']")
	private WebElement discount2;

	@FindBy(css = "#bill-attachments div:nth-of-type(1) input[type='file']")
	private WebElement dropFilesHereOrClickTo;

	@FindBy(css = "input.form-control.grey-border.border-radius-6.height-40.font-12")
	private WebElement dueDate;

	@FindBy(id = "Select-Input-undefined")
	private WebElement expenseType;

	@FindBy(id = "create-invoice-guide-me")
	private WebElement guideMeToCreateGstBill;

	@FindBy(css = "#make-recurring-bill a.font-12.link")
	private WebElement makeThisARecurringBill;

	@FindBy(css = "textarea.form-control.blue-border.message-textarea.font-12")
	private WebElement notes1;

	@FindBy(id = "rcm-flag-checkbox")
	private WebElement notes2;

	private final String pageLoadedText = "Select or Add an item";

	private final String pageUrl = "/app/payables/bill";

	@FindBy(id = "bill-payment-mode")
	private WebElement paymentMethod;

	@FindBy(id = "CreateBill-terms")
	private WebElement paymentTerms;

	@FindBy(css = "#olark-container div:nth-of-type(3) a")
	private WebElement poweredByOlark;

	@FindBy(id = "bill-project-ref-number")
	private WebElement ref;

	@FindBy(id = "bill-save-btn")
	private WebElement save;

	@FindBy(id = "line-item-0")
	private WebElement selectOrAddAnItemselect1;

	@FindBy(id = "line-item-description-0")
	private WebElement selectOrAddAnItemselect2;

	@FindBy(id = "line-item-price-0")
	private WebElement selectOrAddAnItemselect3;

	@FindBy(id = "line-item-qty-0")
	private WebElement selectOrAddAnItemselect4;

	@FindBy(id = "line-item-unit-0")
	private WebElement selectOrAddAnItemselect5;

	@FindBy(id = "line-item-amount-0")
	private WebElement selectOrAddAnItemselect6;

	@FindBy(css = "select.form-control.grey-border.border-radius-6.height-40.font-12.padding-5")
	private WebElement selectOrAddAnItemselect7;

	@FindBy(css = "#LineItemTable tbody tr.LineItem td:nth-of-type(10) select.form-control.grey-border.border-radius-6.font-12.padding-5")
	private WebElement selectOrAddAnItemselect8;

	@FindBy(css = "#btn-logout a.link")
	private WebElement signOut;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(5) div:nth-of-type(3) div:nth-of-type(1) div.row div.col-md-12 div:nth-of-type(4) div.col-md-12 div div.row.no-padding.padding-bottom-5 div.col-md-12 div.row.no-padding.padding-bottom-5 div.form-group div:nth-of-type(1) div:nth-of-type(1) input.form-control.text-align-right.editable-input[type='number']")
	private WebElement tds;

	@FindBy(className = "Select-arrow")
	private WebElement tax;

	@FindBy(xpath = "//table[@id='LineItemTable']/tbody/tr/td[10]/select")
	private WebElement purchaseType;

	@FindBy(xpath = "(//select[@class='form-control grey-border border-radius-6 font-12 padding-5'])[1]")
	private WebElement taxCredit;

	@FindBy(xpath = "//div[contains(@class,'CreateInvoiceContainer')]//div[@class='Select-menu-outer']//*[contains(text(),'Add New Vendor')]")
	private WebElement addNewVendor;

	@FindBy(xpath = "//div[contains(@class,'select-customer')]//span[@class='Select-arrow']")
	private WebElement dropdownSelectOrAddVendor;

	@FindBy(xpath = "//div[@id='expensesContainer']//*[contains(text(),'Add New Vendor')]")
	private WebElement addNewVendorquickBill;

	public ExpensesBill(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ExpensesBill(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public ExpensesBill(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Cancel Button.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill clickCancelButton() {
		cancel.click();
		return this;
	}

	/**
	 * Click on Chat Icon Three Small Dots To Indicate That An Agent Is Available To
	 * Chat0how Can We Help Button.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill clickChatIconThreeSmallDotsToButton() {
		chatIconThreeSmallDotsTo.click();
		return this;
	}

	/**
	 * Click on Click Here To Start Chatting Button.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill clickClickHereToStartChattingButton() {
		clickHereToStartChatting.click();
		return this;
	}

	/**
	 * Click on Guide Me To Create Gst Bill Link.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill clickGuideMeToCreateGstBillLink() {
		guideMeToCreateGstBill.click();
		return this;
	}

	/**
	 * Click on Make This A Recurring Bill Link.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill clickMakeThisARecurringBillLink() {
		makeThisARecurringBill.click();
		return this;
	}

	/**
	 * Click on Powered By Olark Link.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill clickPoweredByOlarkLink() {
		poweredByOlark.click();
		return this;
	}

	/**
	 * Click on Save Button.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill clickSaveButton() {
		save.click();
		return this;
	}

	/**
	 * Click on Sign Out Link.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill clickSignOutLink() {
		signOut.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill fill() {
		setBillFromTextField();
		setBillTextField();
		setBillDateTextField();
		setPaymentTermsDropDownListField();
		setDueDateTextField();
		setExpenseTypeTextField();
		setRefTextField();
		setPaymentMethodDropDownListField();
		setSelectOrAddAnItemselect1TextareaField();
		setSelectOrAddAnItemselect2TextareaField();
		setSelectOrAddAnItemselect3NumberField();
		setSelectOrAddAnItemselect4NumberField();
		setSelectOrAddAnItemselect5TextField();
		setSelectOrAddAnItemselect6NumberField();
		setSelectOrAddAnItemselect7DropDownListField();
		setSelectOrAddAnItemselect8DropDownListField();
		setNotes1CheckboxField();
		setNotes2CheckboxField();
		setDiscount1NumberField();
		setDiscount2NumberField();
		setTdsNumberField();

		setClickHereAndTypeYourNameTextField();
		setClickHereAndTypeYourEmailEmailField();
		setClickHereAndTypeYourPhone1TextareaField();
		setClickHereAndTypeYourPhone2TextareaField();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to Bill Date Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setBillDateTextField() {
		return setBillDateTextField(data.get("BILL_DATE"));
	}

	/**
	 * Set value to Bill Date Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setBillDateTextField(String billDateValue) {
		billDate.sendKeys(billDateValue);
		return this;
	}

	/**
	 * Set default value to Bill From Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setBillFromTextField() {
		return setBillFromTextField(data.get("BILL_FROM"));
	}

	/**
	 * Set value to Bill From Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setBillFromTextField(String billFromValue) {
		billFrom.sendKeys(billFromValue);
		return this;
	}

	/**
	 * Set default value to Bill Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setBillTextField() {
		return setBillTextField(data.get("BILL"));
	}

	/**
	 * Set value to Bill Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setBillTextField(String billValue) {
		bill.sendKeys(billValue);
		return this;
	}

	/**
	 * Set 0.00 Checkbox field.
	 *
	 * @return the ExpensesBill class instance.
	 */

	/**
	 * Set default value to Click Here And Type Your Email Email field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setClickHereAndTypeYourEmailEmailField() {
		return setClickHereAndTypeYourEmailEmailField(data.get("CLICK_HERE_AND_TYPE_YOUR_EMAIL"));
	}

	/**
	 * Set value to Click Here And Type Your Email Email field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setClickHereAndTypeYourEmailEmailField(String clickHereAndTypeYourEmailValue) {
		clickHereAndTypeYourEmail.sendKeys(clickHereAndTypeYourEmailValue);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Name Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setClickHereAndTypeYourNameTextField() {
		return setClickHereAndTypeYourNameTextField(data.get("CLICK_HERE_AND_TYPE_YOUR_NAME"));
	}

	/**
	 * Set value to Click Here And Type Your Name Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setClickHereAndTypeYourNameTextField(String clickHereAndTypeYourNameValue) {
		clickHereAndTypeYourName.sendKeys(clickHereAndTypeYourNameValue);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Phone Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setClickHereAndTypeYourPhone1TextareaField() {
		return setClickHereAndTypeYourPhone1TextareaField(data.get("CLICK_HERE_AND_TYPE_YOUR_PHONE_1"));
	}

	/**
	 * Set value to Click Here And Type Your Phone Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setClickHereAndTypeYourPhone1TextareaField(String clickHereAndTypeYourPhone1Value) {
		clickHereAndTypeYourPhone1.sendKeys(clickHereAndTypeYourPhone1Value);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Phone Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setClickHereAndTypeYourPhone2TextareaField() {
		return setClickHereAndTypeYourPhone2TextareaField(data.get("CLICK_HERE_AND_TYPE_YOUR_PHONE_2"));
	}

	/**
	 * Set value to Click Here And Type Your Phone Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setClickHereAndTypeYourPhone2TextareaField(String clickHereAndTypeYourPhone2Value) {
		clickHereAndTypeYourPhone2.sendKeys(clickHereAndTypeYourPhone2Value);
		return this;
	}

	/**
	 * Set default value to Discount Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setDiscount1NumberField() {
		return setDiscount1NumberField(data.get("DISCOUNT_1"));
	}

	/**
	 * Set value to Discount Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setDiscount1NumberField(String discount1Value) {
		discount1.sendKeys(discount1Value);
		return this;
	}

	/**
	 * Set default value to Discount Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setDiscount2NumberField() {
		return setDiscount2NumberField(data.get("DISCOUNT_2"));
	}

	/**
	 * Set value to Discount Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setDiscount2NumberField(String discount2Value) {
		discount2.sendKeys(discount2Value);
		return this;
	}

	/**
	 * Set Drop Files Here Or Click To Upload File field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setDropFilesHereOrClickToFileField() {
		return this;
	}

	/**
	 * Set default value to Due Date Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setDueDateTextField() {
		return setDueDateTextField(data.get("DUE_DATE"));
	}

	/**
	 * Set value to Due Date Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setDueDateTextField(String dueDateValue) {
		dueDate.sendKeys(dueDateValue);
		return this;
	}

	/**
	 * Set default value to Expense Type Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setExpenseTypeTextField() {
		return setExpenseTypeTextField(data.get("EXPENSE_TYPE"));
	}

	/**
	 * Set value to Expense Type Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setExpenseTypeTextField(String expenseTypeValue) {
		expenseType.sendKeys(expenseTypeValue);
		return this;
	}

	/**
	 * Set default value to Notes Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setNotes1CheckboxField() {
		return setNotes1CheckboxField(data.get("NOTES"));
	}

	/**
	 * Set Notes Checkbox field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setNotes1CheckboxField(String notesValue) {
		notes1.sendKeys(notesValue);
		return this;
	}

	/**
	 * Set Notes Checkbox field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setNotes2CheckboxField() {
		if (!notes2.isSelected()) {
			notes2.click();
		}
		return this;
	}

	/**
	 * Set default value to Payment Method Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setPaymentMethodDropDownListField() {
		return setPaymentMethodDropDownListField(data.get("PAYMENT_METHOD"));
	}

	/**
	 * Set value to Payment Method Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setPaymentMethodDropDownListField(String paymentMethodValue) {
		new Select(paymentMethod).selectByVisibleText(paymentMethodValue);
		return this;
	}

	/**
	 * Set default value to Payment Terms Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setPaymentTermsDropDownListField() {
		return setPaymentTermsDropDownListField(data.get("PAYMENT_TERMS"));
	}

	/**
	 * Set value to Payment Terms Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setPaymentTermsDropDownListField(String paymentTermsValue) {
		new Select(paymentTerms).selectByVisibleText(paymentTermsValue);
		return this;
	}

	/**
	 * Set default value to Ref Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setRefTextField() {
		return setRefTextField(data.get("REF"));
	}

	/**
	 * Set value to Ref Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setRefTextField(String refValue) {
		ref.sendKeys(refValue);
		return this;
	}

	/**
	 * Set default value to Select Or Add An Itemselect Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect1TextareaField() {
		return setSelectOrAddAnItemselect1TextareaField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_1"));
	}

	/**
	 * Set value to Select Or Add An Itemselect Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect1TextareaField(String selectOrAddAnItemselect1Value) {
		selectOrAddAnItemselect1.sendKeys(selectOrAddAnItemselect1Value);
		return this;
	}

	/**
	 * Set default value to Select Or Add An Itemselect Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect2TextareaField() {
		return setSelectOrAddAnItemselect2TextareaField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_2"));
	}

	/**
	 * Set value to Select Or Add An Itemselect Textarea field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect2TextareaField(String selectOrAddAnItemselect2Value) {
		selectOrAddAnItemselect2.sendKeys(selectOrAddAnItemselect2Value);
		return this;
	}

	/**
	 * Set default value to Select Or Add An Itemselect Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect3NumberField() {
		return setSelectOrAddAnItemselect3NumberField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_3"));
	}

	/**
	 * Set value to Select Or Add An Itemselect Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect3NumberField(String selectOrAddAnItemselect3Value) {
		selectOrAddAnItemselect3.sendKeys(selectOrAddAnItemselect3Value);
		return this;
	}

	/**
	 * Set default value to Select Or Add An Itemselect Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect4NumberField() {
		return setSelectOrAddAnItemselect4NumberField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_4"));
	}

	/**
	 * Set value to Select Or Add An Itemselect Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect4NumberField(String selectOrAddAnItemselect4Value) {
		selectOrAddAnItemselect4.sendKeys(selectOrAddAnItemselect4Value);
		return this;
	}

	/**
	 * Set default value to Select Or Add An Itemselect Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect5TextField() {
		return setSelectOrAddAnItemselect5TextField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_5"));
	}

	/**
	 * Set value to Select Or Add An Itemselect Text field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect5TextField(String selectOrAddAnItemselect5Value) {
		selectOrAddAnItemselect5.sendKeys(selectOrAddAnItemselect5Value);
		return this;
	}

	/**
	 * Set default value to Select Or Add An Itemselect Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect6NumberField() {
		return setSelectOrAddAnItemselect6NumberField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_6"));
	}

	/**
	 * Set value to Select Or Add An Itemselect Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect6NumberField(String selectOrAddAnItemselect6Value) {
		selectOrAddAnItemselect6.sendKeys(selectOrAddAnItemselect6Value);
		return this;
	}

	/**
	 * Set default value to Select Or Add An Itemselect Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect7DropDownListField() {
		return setSelectOrAddAnItemselect7DropDownListField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_7"));
	}

	/**
	 * Set value to Select Or Add An Itemselect Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect7DropDownListField(String selectOrAddAnItemselect7Value) {
		new Select(selectOrAddAnItemselect7).selectByVisibleText(selectOrAddAnItemselect7Value);
		return this;
	}

	/**
	 * Set default value to Select Or Add An Itemselect Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect8DropDownListField() {
		return setSelectOrAddAnItemselect8DropDownListField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_8"));
	}

	/**
	 * Set value to Select Or Add An Itemselect Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setSelectOrAddAnItemselect8DropDownListField(String selectOrAddAnItemselect8Value) {
		new Select(selectOrAddAnItemselect8).selectByVisibleText(selectOrAddAnItemselect8Value);
		return this;
	}

	/**
	 * Set default value to Tds Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setTdsNumberField() {
		return setTdsNumberField(data.get("TDS"));
	}

	/**
	 * Set value to Tds Number field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill setTdsNumberField(String tdsValue) {
		tds.sendKeys(tdsValue);
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill submit() {
		clickSaveButton();
		return this;
	}

	/**
	 * Unset 0.00 Checkbox field.
	 *
	 * @return the ExpensesBill class instance.
	 */

	/**
	 * Unset Notes Checkbox field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetNotes2CheckboxField() {
		if (notes2.isSelected()) {
			notes2.click();
		}
		return this;
	}

	/**
	 * Unset default value from Payment Method Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetPaymentMethodDropDownListField() {
		return unsetPaymentMethodDropDownListField(data.get("PAYMENT_METHOD"));
	}

	/**
	 * Unset value from Payment Method Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetPaymentMethodDropDownListField(String paymentMethodValue) {
		new Select(paymentMethod).deselectByVisibleText(paymentMethodValue);
		return this;
	}

	/**
	 * Unset default value from Payment Terms Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetPaymentTermsDropDownListField() {
		return unsetPaymentTermsDropDownListField(data.get("PAYMENT_TERMS"));
	}

	/**
	 * Unset value from Payment Terms Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetPaymentTermsDropDownListField(String paymentTermsValue) {
		new Select(paymentTerms).deselectByVisibleText(paymentTermsValue);
		return this;
	}

	/**
	 * Unset default value from Select Or Add An Itemselect Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetSelectOrAddAnItemselect7DropDownListField() {
		return unsetSelectOrAddAnItemselect7DropDownListField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_7"));
	}

	/**
	 * Unset value from Select Or Add An Itemselect Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetSelectOrAddAnItemselect7DropDownListField(String selectOrAddAnItemselect7Value) {
		new Select(selectOrAddAnItemselect7).deselectByVisibleText(selectOrAddAnItemselect7Value);
		return this;
	}

	/**
	 * Unset default value from Select Or Add An Itemselect Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetSelectOrAddAnItemselect8DropDownListField() {
		return unsetSelectOrAddAnItemselect8DropDownListField(data.get("SELECT_OR_ADD_AN_ITEMSELECT_8"));
	}

	/**
	 * Unset value from Select Or Add An Itemselect Drop Down List field.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill unsetSelectOrAddAnItemselect8DropDownListField(String selectOrAddAnItemselect8Value) {
		new Select(selectOrAddAnItemselect8).deselectByVisibleText(selectOrAddAnItemselect8Value);
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill verifyPageLoaded() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the ExpensesBill class instance.
	 */
	public ExpensesBill verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}

	public ExpensesBill clickorSelectTax(String taxPercentage) {
		tax.sendKeys(taxPercentage);
		return this;
	}

	public ExpensesBill clickorSelectPurchaseType(String purType) {
		purchaseType.sendKeys(purType);
		return this;
	}

	public ExpensesBill clickorSelectTaxCredit(String taxCredi) {
		new Select(taxCredit).selectByVisibleText(taxCredi);
		// taxCredit.sendKeys(taxCredi);
		return this;
	}

	public ExpensesBill clickAddNewVendor() {
		addNewVendor.click();
		// JavascriptLibrary.javascriptClickElement(driver, addNewVendor);
		return this;
	}

	public ExpensesBill dropdownSelectOrAddVendorClick() {
		dropdownSelectOrAddVendor.click();
		return this;

	}

	public void verifyMessage() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("toast-message")));
		WebElement element = driver.findElement(By.className("toast-message"));
		String message = element.getText();
		System.out.println(message);

		if (message.contains("Success!") || message.contains("created!") || message.contains("New")
				|| message.contains("sent")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail(message);
		}
	}

	public String getRandomStringfromArray(String arryOfString, int index) {
		String[] arryOfexpenseType = arryOfString.split(",");
		String str = arryOfexpenseType[index];
		return str;
	}

	public String generateRandomBillNumber() {
		Random rand = new Random();
		String str = Integer.toString(rand.nextInt(10000));
		return str;
	}

	public void addNewVendorquickBill() {
		addNewVendorquickBill.click();
	}

	public void checkToEmailIdIsEmpty() {
		if (toEmailIdInput.getText().equals("")) {
			toEmailIdInput.sendKeys("testvendor@gmail.com");
		}
	}

}
