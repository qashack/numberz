package com.application.pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.application.libraries.JavascriptLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Expenses {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "button.title")
	private WebElement addDetailedBill;

	@FindBy(css = "a.active.link")
	private WebElement all20;

	@FindBy(css = "input.form-control.get-fiscal-search.no-right-border")
	private WebElement all20Overdue8DueLater;

	@FindBy(css = "#expensesContainer div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(1) div.row.divNav nav.tabNav.col-md-5 ul li:nth-of-type(2) a.center-align")
	private WebElement bills;

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

	@FindBy(css = "#expensesContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div.gb-filter-list div:nth-of-type(1) span.gb-filter-items.uppercase a:nth-of-type(5)")
	private WebElement closed1;

	@FindBy(css = "#expensesContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(1) div:nth-of-type(2) div span.gb-filter-items.uppercase a:nth-of-type(2)")
	private WebElement detailed10;

	@FindBy(css = "#expensesContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div.gb-filter-list div:nth-of-type(1) span.gb-filter-items.uppercase a:nth-of-type(3)")
	private WebElement dueLater3;

	@FindBy(id = "import-bills-nav")
	private WebElement importBills;

	@FindBy(id = "quickbill-amount")
	private WebElement amoutInput;

	@FindBy(css = "input.form-control.gb-calendar")
	private WebElement jul2017parollgopiPaid12345020018;

	@FindBy(id = "Select-Input-undefined")
	private WebElement jul2017parollgopiPaid12345030018;

	@FindBy(id = "SelectCustomer-Input--1")
	private WebElement jul2017parollgopiPaid12345040018;

	@FindBy(id = "Select-Input-undefined")
	private WebElement jul2017parollgopiPaid12345050018;

	@FindBy(id = "quickbill-ref-number")
	private WebElement quickbillRefNumber;

	@FindBy(css = "#expensesContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div.gb-filter-list div:nth-of-type(1) span.gb-filter-items.uppercase a:nth-of-type(2)")
	private WebElement overdue8;

	private final String pageLoadedText = "Payment To/Vendor &nbsp;&nbsp;";

	private final String pageUrl = "/app/payables/bills";

	@FindBy(css = "#expensesContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(2) div.gb-filter-list div:nth-of-type(1) span.gb-filter-items.uppercase a:nth-of-type(4)")
	private WebElement paid8;

	@FindBy(css = "#olark-container div:nth-of-type(3) a")
	private WebElement poweredByOlark;

	@FindBy(xpath = "//div[@class='row divNav']//a[@class='center-align']")
	private WebElement purchaseOrders;

	@FindBy(css = "#expensesContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(1) div:nth-of-type(2) div span.gb-filter-items.uppercase a:nth-of-type(1)")
	private WebElement quick10;

	@FindBy(css = "#expensesContainer div:nth-of-type(2) div:nth-of-type(1) div:nth-of-type(1) div.row.divNav nav.tabNav.col-md-5 ul li:nth-of-type(3) a.center-align")
	private WebElement recurring;

	@FindBy(id = "quickbill-save-btn")
	private WebElement save;

	@FindBy(css = "#btn-logout a.link")
	private WebElement signOut;

	@FindBy(xpath = "(//div[@id='expensesContainer']//div[@class='Select-placeholder'])[2]")
	private WebElement selectOrAddVendor;

	@FindBy(xpath = "//span[@id='quickbill-attachment']")
	private WebElement quickbillAttachment;

	@FindBy(xpath = "//div[@class='modal-body']//input[@type='file']")
	private WebElement attachFilePath;

	@FindBy(xpath = "//button[@class='btn font-10 padding-20 btn-green-border uppercase left-margin-20 pull-right']")
	private WebElement saveAttachmentBtn;

	@FindBy(xpath = "//span[@id='quickbill-note']")
	private WebElement noteBtn;

	@FindBy(xpath = "//span[@id='quickbill-note']/div/textarea")
	private WebElement noteTextArea;

	@FindBy(xpath = ".//*[@id='expensesContainer']/div[2]/div[2]/div[2]/div/div/div[2]/div[4]")
	private WebElement saveNoteBtn;

	@FindBy(xpath = "(//div[@class='Select-placeholder'])[3]")
	private WebElement paymentMethod;

	@FindBy(xpath = "(//div[@class='Select-input '])[3]/input")
	private WebElement paymentMethodInput;

	@FindBy(xpath = "(//div[@id='expensesContainer']//span[@class='Select-arrow'])[1]")
	private WebElement expenseTypeDropdown;

	@FindBy(xpath = "(//div[@id='expensesContainer']//div[@class='Select-input '])[1]/input")
	private WebElement expenseTypeInput;
	
	@FindBy(xpath = "(//div[@id='expensesContainer']//span[@class='Select-arrow'])[2]")
	private WebElement paymentToVendorDropdown;
	
	@FindBy(xpath = "(//div[@id='expensesContainer']//div[@class='Select-input '])[2]/input")
	private WebElement paymentToVendorInput;
	
	@FindBy(xpath = "(//div[@id='expensesContainer']//span[@class='Select-arrow'])[3]")
	private WebElement paymentMethodDropDown;
	

	public Expenses(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Expenses(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public Expenses(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Add Detailed Bill Button.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickAddDetailedBillButton() {
		// addDetailedBill.click();
		JavascriptLibrary.javascriptClickElement(driver, addDetailedBill);
		return this;
	}

	/**
	 * Click on All 20 Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickAll20Link() {
		all20.click();
		return this;
	}

	/**
	 * Click on Bills Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickBillsLink() {
		bills.click();
		return this;
	}

	/**
	 * Click on Chat Icon Three Small Dots To Indicate That An Agent Is
	 * Available To Chat0how Can We Help Button.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickChatIconThreeSmallDotsToButton() {
		chatIconThreeSmallDotsTo.click();
		return this;
	}

	/**
	 * Click on Click Here To Start Chatting Button.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickClickHereToStartChattingButton() {
		clickHereToStartChatting.click();
		return this;
	}

	/**
	 * Click on Closed 1 Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickClosed1Link() {
		closed1.click();
		return this;
	}

	/**
	 * Click on Detailed 10 Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickDetailed10Link() {
		detailed10.click();
		return this;
	}

	/**
	 * Click on Due Later 3 Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickDueLater3Link() {
		dueLater3.click();
		return this;
	}

	/**
	 * Click on Import Bills Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickImportBillsLink() {
		importBills.click();
		return this;
	}

	/**
	 * Click on Overdue 8 Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickOverdue8Link() {
		overdue8.click();
		return this;
	}

	/**
	 * Click on Paid 8 Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickPaid8Link() {
		paid8.click();
		return this;
	}

	/**
	 * Click on Powered By Olark Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickPoweredByOlarkLink() {
		poweredByOlark.click();
		return this;
	}

	/**
	 * Click on Purchase Orders Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickPurchaseOrdersLink() {
		purchaseOrders.click();
		return this;
	}

	/**
	 * Click on Quick 10 Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickQuick10Link() {
		quick10.click();
		return this;
	}

	/**
	 * Click on Recurring Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickRecurringLink() {
		recurring.click();
		return this;
	}

	/**
	 * Click on Save Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickSaveLink() {
		save.click();
		return this;
	}

	/**
	 * Click on Sign Out Link.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses clickSignOutLink() {
		signOut.click();
		return this;
	}

	/**
	 * Fill every fields in the page.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses fill() {
		setAll20Overdue8DueLaterTextField();
		setJul2017parollgopiPaid1234501TextField0018();
		setJul2017parollgopiPaid1234502TextField0018();
		setJul2017parollgopiPaid1234503TextField0018();
		setJul2017parollgopiPaid1234504TextField0018();
		setJul2017parollgopiPaid1234505TextField0018();
		setJul2017parollgopiPaid1234506TextField0018();
		setClickHereAndTypeYourNameTextField();
		setClickHereAndTypeYourEmailEmailField();
		setClickHereAndTypeYourPhone1TextareaField();
		setClickHereAndTypeYourPhone2TextareaField();
		return this;
	}

	/**
	 * Fill every fields in the page and submit it to target page.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses fillAndSubmit() {
		fill();
		return submit();
	}

	/**
	 * Set default value to All 20 Overdue 8 Due Later 3 Paid 8closed 1add
	 * Multiple Quick Billsimport From Bank Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setAll20Overdue8DueLaterTextField() {
		return setAll20Overdue8DueLaterTextField(data.get("ALL_20_OVERDUE_8_DUE_LATER"));
	}

	/**
	 * Set value to All 20 Overdue 8 Due Later 3 Paid 8closed 1add Multiple
	 * Quick Billsimport From Bank Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setAll20Overdue8DueLaterTextField(String all20Overdue8DueLaterValue) {
		all20Overdue8DueLater.sendKeys(all20Overdue8DueLaterValue);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Email Email field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setClickHereAndTypeYourEmailEmailField() {
		return setClickHereAndTypeYourEmailEmailField(data.get("CLICK_HERE_AND_TYPE_YOUR_EMAIL"));
	}

	/**
	 * Set value to Click Here And Type Your Email Email field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setClickHereAndTypeYourEmailEmailField(String clickHereAndTypeYourEmailValue) {
		clickHereAndTypeYourEmail.sendKeys(clickHereAndTypeYourEmailValue);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Name Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setClickHereAndTypeYourNameTextField() {
		return setClickHereAndTypeYourNameTextField(data.get("CLICK_HERE_AND_TYPE_YOUR_NAME"));
	}

	/**
	 * Set value to Click Here And Type Your Name Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setClickHereAndTypeYourNameTextField(String clickHereAndTypeYourNameValue) {
		clickHereAndTypeYourName.sendKeys(clickHereAndTypeYourNameValue);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Phone Textarea field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setClickHereAndTypeYourPhone1TextareaField() {
		return setClickHereAndTypeYourPhone1TextareaField(data.get("CLICK_HERE_AND_TYPE_YOUR_PHONE_1"));
	}

	/**
	 * Set value to Click Here And Type Your Phone Textarea field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setClickHereAndTypeYourPhone1TextareaField(String clickHereAndTypeYourPhone1Value) {
		clickHereAndTypeYourPhone1.sendKeys(clickHereAndTypeYourPhone1Value);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Phone Textarea field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setClickHereAndTypeYourPhone2TextareaField() {
		return setClickHereAndTypeYourPhone2TextareaField(data.get("CLICK_HERE_AND_TYPE_YOUR_PHONE_2"));
	}

	/**
	 * Set value to Click Here And Type Your Phone Textarea field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setClickHereAndTypeYourPhone2TextareaField(String clickHereAndTypeYourPhone2Value) {
		clickHereAndTypeYourPhone2.sendKeys(clickHereAndTypeYourPhone2Value);
		return this;
	}

	/**
	 * Set default value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234501TextField0018() {
		return amoutInputSetText(data.get("JUL_2017PAROLLGOPI_PAID123450_1_0018"));
	}

	/**
	 * Set value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses amoutInputSetText(String amount) {
		amoutInput.sendKeys(amount);
		return this;
	}

	/**
	 * Set default value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234502TextField0018() {
		return setJul2017parollgopiPaid1234502TextField0018(data.get("JUL_2017PAROLLGOPI_PAID123450_2_0018"));
	}

	/**
	 * Set value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234502TextField0018(String jul2017parollgopiPaid1234502Value0018) {
		jul2017parollgopiPaid12345020018.sendKeys(jul2017parollgopiPaid1234502Value0018);
		return this;
	}

	/**
	 * Set default value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234503TextField0018() {
		return setJul2017parollgopiPaid1234503TextField0018(data.get("JUL_2017PAROLLGOPI_PAID123450_3_0018"));
	}

	/**
	 * Set value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234503TextField0018(String jul2017parollgopiPaid1234503Value0018) {
		jul2017parollgopiPaid12345030018.sendKeys(jul2017parollgopiPaid1234503Value0018);
		return this;
	}

	/**
	 * Set default value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234504TextField0018() {
		return setJul2017parollgopiPaid1234504TextField0018(data.get("JUL_2017PAROLLGOPI_PAID123450_4_0018"));
	}

	/**
	 * Set value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234504TextField0018(String jul2017parollgopiPaid1234504Value0018) {
		jul2017parollgopiPaid12345040018.sendKeys(jul2017parollgopiPaid1234504Value0018);
		return this;
	}

	/**
	 * Set default value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234505TextField0018() {
		return setJul2017parollgopiPaid1234505TextField0018(data.get("JUL_2017PAROLLGOPI_PAID123450_5_0018"));
	}

	/**
	 * Set value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234505TextField0018(String jul2017parollgopiPaid1234505Value0018) {
		jul2017parollgopiPaid12345050018.sendKeys(jul2017parollgopiPaid1234505Value0018);
		return this;
	}

	/**
	 * Set default value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses setJul2017parollgopiPaid1234506TextField0018() {
		return quickbillRefNumberSetText(data.get("JUL_2017PAROLLGOPI_PAID123450_6_0018"));
	}

	/**
	 * Set value to 0018 Jul 2017parollgopi Paid123450 Text field.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses quickbillRefNumberSetText(String refNum) {
		quickbillRefNumber.sendKeys(refNum);
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses submit() {
		clickAddDetailedBillButton();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the Expenses class instance.
	 */
	public Expenses verifyPageLoaded() {
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
	 * @return the Expenses class instance.
	 */
	public Expenses verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}

	public void selectOrAddVendor() {
		selectOrAddVendor.click();
	}

	public void quickbillAttachmentclick() {
		quickbillAttachment.click();
	}

	public void attachFilePathSetPath(String path) {
		attachFilePath.sendKeys(path);
	}

	public void saveAttachmentBtnClick() {
		saveAttachmentBtn.click();
	}

	public void noteBtnClick() {
		noteBtn.click();
	}

	public void noteTextAreaSetText(String note) {
		noteTextArea.sendKeys(note);
	}

	public void saveNoteBtnClick() {
		saveNoteBtn.click();
	}

	public void paymentMethodClick() {
		paymentMethod.click();
	}

	public void paymentMethodInputSetText(String paymentMethod) {
		paymentMethodInput.sendKeys(paymentMethod);
	}

	public void expenseTypeDropdownClick() {
		expenseTypeDropdown.click();
	}

	public void expenseTypeInputSetText(String expenseType) {
		expenseTypeInput.sendKeys(expenseType);
	}

	public void paymentToVendorDropdownClick() {
		paymentToVendorDropdown.click();
	}

	public void paymentToVendorInputSetText(String vendor) {
		paymentToVendorInput.sendKeys(vendor);
	}
	
	public void paymentMethodDropdownClick() {
		paymentMethodDropDown.click();
	}
}
