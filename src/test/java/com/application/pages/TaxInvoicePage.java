package com.application.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaxInvoicePage {
	private Map<String, String> data;
	WebDriver driver;
	private int timeout = 15;

	@FindBy(id = "create-invoice-cancel-btn")
	private WebElement cancel;

	@FindBy(id = "create-invoice-city")
	private WebElement city;
	// Add new customer
	@FindBy(xpath = "//div[contains(@class,'CreateInvoiceContainer')]//div[@class='Select-menu-outer']//*[contains(text(),'Add New Customer')]")
	private WebElement addnewCustomerlink;

	@FindBy(id = "olark-form-input-email")
	private WebElement clickHereAndTypeYourEmail1;

	@FindBy(css = "textarea")
	private WebElement clickHereAndTypeYourEmail2;

	@FindBy(id = "olark-form-input-fname")
	private WebElement clickHereAndTypeYourName;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(3) div div:nth-of-type(1) div:nth-of-type(4) div.Select.is-searchable.has-value div.Select-control div:nth-of-type(2) input")
	private WebElement country;

	@FindBy(id = "create-invoice-discount-perc")
	private WebElement discountPercentage;

	@FindBy(id = "create-invoice-flat-discount")
	private WebElement discountAmount;

	@FindBy(css = "#create-invoice-attachments input[type='file']")
	private WebElement dropFilesHereOrClickTo;

	@FindBy(id = "create-invoice-due-date")
	private WebElement dueDate;

	@FindBy(css = "button.olark-launch-button.olark-chat-tab.olark-size-md")
	private WebElement envelopeIconsmallPictureOfAnEnvelope;

	@FindBy(name = "oktab8916270239557056")
	private List<WebElement> exclusiveOfTaxes;

	private final String exclusiveOfTaxesValue = "false";

	@FindBy(id = "create-invoice-guide-me")
	private WebElement guideMeToCreateGstInvoice;

	@FindBy(name = "oktab8916270239557056")
	private List<WebElement> inclusiveOfTaxes;

	private final String inclusiveOfTaxesValue = "true";

	@FindBy(id = "create-invoice-invoice-no-input-checkbox")
	private WebElement invoice1;

	@FindBy(id = "create-invoice-invoice-no-input-text")
	private WebElement invoice2;

	@FindBy(id = "create-invoice-invoice-date")
	private WebElement invoiceDate;

	@FindBy(id = "create-invoice-add-message")
	private WebElement invoicePaymentDetails;

	@FindBy(id = "create-invoice-select-customer")
	private WebElement invoiceTo;

	@FindBy(id = "create-invoice-recurring-invoice-link")
	private WebElement makeThisARecurringInvoice;

	@FindBy(id = "create-invoice-add-message")
	private WebElement notes;

	private final String pageLoadedText = "Select or Add a customer";
	private final String pageUrl = "/app/receivables/invoice";

	@FindBy(id = "create-invoice-payment-terms")
	private WebElement paymentTerms;

	@FindBy(id = "create-invoice-pincode")
	private WebElement pincode1;

	@FindBy(id = "create-invoice-address-2")
	private WebElement pincode2;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(4) div:nth-of-type(1) div:nth-of-type(1) div.Select-control div:nth-of-type(2) input")
	private WebElement placeOfSupply;

	@FindBy(css = "#olark-container div:nth-of-type(3) a")
	private WebElement poweredByOlark;

	@FindBy(id = "create-invoice-preview-btn")
	private WebElement print;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(4) div:nth-of-type(2) input.form-control.grey-border.height-40.font-12[type='text']")
	private WebElement ref;

	@FindBy(id = "olark-form-input-body")
	private WebElement requiredAsterisksignifiesThatThisFieldCan;

	@FindBy(id = "create-invoice-save-btn")
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

	@FindBy(className = "Select-placeholder")
	private WebElement stateName;

	@FindBy(id = "create-invoice-send-btn")
	private WebElement send1;

	@FindBy(css = "button.olark-form-send-button")
	private WebElement send2;

	@FindBy(id = "create-invoice-address-1")
	private WebElement shippingAddress;

	@FindBy(css = "#btn-logout a.link")
	private WebElement signOut;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(3) div div:nth-of-type(1) div:nth-of-type(3) div.Select.select-state.is-searchable div.Select-control div:nth-of-type(2) input")
	private WebElement state;

	@FindBy(id = "create-invoice-header")
	private WebElement taxInvoiceMakeThisARecurring;

	@FindBy(id = "create-invoice-add-message")
	private WebElement termsConditions;

	@FindBy(id = "create-invoice-round-off")
	private WebElement roundoff;

	@FindBy(xpath = "//table[@id='LineItemTable']/tbody/tr[1]/td[8]//span[@class='Select-arrow-zone']/span")
	private WebElement taxSelectField;

	/*
	 * Email window page elements
	 */
	@FindBy(xpath = "//div[@class='modal-body']//button[text()='Send']")
	private WebElement emailSendButton;

	@FindBy(xpath = "//div[@class='modal-body']//button[text()='Cancel']")
	private WebElement emailcancelButton;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Email ID']")
	private WebElement emailtoField;

	@FindBy(xpath = "(//span[@class='big-number'])[1]")
	private WebElement totalAmount;

	@FindBy(xpath = "(//span[@class='big-number'])[2]")
	private WebElement netTotalAmount;

	@FindBy(xpath = "(//span[@class='tax-lines-smallest-number pull-right'])[1]")
	private WebElement cgstAmount;

	@FindBy(xpath = "(//span[@class='tax-lines-smallest-number pull-right'])[2]")
	private WebElement sgstAmount;

	@FindBy(xpath = "//span[@class='pull-right text-align-right']")
	private WebElement TdsAmount;

	@FindBy(xpath = "//span[@class='tax-lines-smallest-number']")
	private WebElement roundOfAmnt;

	/*
	 * Add new item link
	 */
	@FindBy(xpath = "//div[@class='Select-menu-outer']//*[contains(text(),'Add New Item')]")
	private WebElement addnewItem;

	public TaxInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public TaxInvoicePage(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public TaxInvoicePage(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Cancel Button.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickCancelButton() {
		cancel.click();
		return this;
	}

	/**
	 * Click on Envelope Iconsmall Picture Of An Envelope Signifying An Email
	 * Address0how Can We Help Button.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickEnvelopeIconsmallPictureOfAnEnvelopeButton() {
		envelopeIconsmallPictureOfAnEnvelope.click();

		return this;
	}

	/**
	 * Click on Guide Me To Create Gst Invoice Link.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickGuideMeToCreateGstInvoiceLink() {
		guideMeToCreateGstInvoice.click();
		return this;
	}

	/**
	 * Click on Make This A Recurring Invoice Link.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickMakeThisARecurringInvoiceLink() {
		makeThisARecurringInvoice.click();
		return this;
	}

	/**
	 * Click on Powered By Olark Link.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickPoweredByOlarkLink() {
		poweredByOlark.click();
		return this;
	}

	/**
	 * Click on Print Button.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickPrintButton() {
		print.click();
		return this;
	}

	/**
	 * Click on Save Button.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickSaveButton() {
		save.click();
		return this;
	}

	/**
	 * Click on Send Button.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickSend1Button() {
		send1.click();
		return this;
	}

	/**
	 * Click on Send Button.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickSend2Button() {
		send2.click();
		return this;
	}

	/**
	 * Click on Sign Out Link.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickSignOutLink() {
		signOut.click();
		return this;
	}

	/**
	 * Set default value to City Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setCityTextField() {
		return setCityTextField(data.get("CITY"));
	}

	/**
	 * Set value to City Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setCityTextField(String cityValue) {
		city.sendKeys(cityValue);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Email Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setClickHereAndTypeYourEmail1TextareaField() {
		return setClickHereAndTypeYourEmail1TextareaField(data.get("CLICK_HERE_AND_TYPE_YOUR_EMAIL_1"));
	}

	/**
	 * Set value to Click Here And Type Your Email Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setClickHereAndTypeYourEmail1TextareaField(String clickHereAndTypeYourEmail1Value) {
		clickHereAndTypeYourEmail1.sendKeys(clickHereAndTypeYourEmail1Value);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Email Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setClickHereAndTypeYourEmail2TextareaField() {
		return setClickHereAndTypeYourEmail2TextareaField(data.get("CLICK_HERE_AND_TYPE_YOUR_EMAIL_2"));
	}

	/**
	 * Set value to Click Here And Type Your Email Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setClickHereAndTypeYourEmail2TextareaField(String clickHereAndTypeYourEmail2Value) {
		clickHereAndTypeYourEmail2.sendKeys(clickHereAndTypeYourEmail2Value);
		return this;
	}

	/**
	 * Set default value to Click Here And Type Your Name Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setClickHereAndTypeYourNameTextField() {
		return setClickHereAndTypeYourNameTextField(data.get("CLICK_HERE_AND_TYPE_YOUR_NAME"));
	}

	/**
	 * Set value to Click Here And Type Your Name Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setClickHereAndTypeYourNameTextField(String clickHereAndTypeYourNameValue) {
		clickHereAndTypeYourName.sendKeys(clickHereAndTypeYourNameValue);
		return this;
	}

	/**
	 * Set default value to Country Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setCountryTextField() {
		return setCountryTextField(data.get("COUNTRY"));
	}

	/**
	 * Set value to Country Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setCountryTextField(String countryValue) {
		country.sendKeys(countryValue);
		return this;
	}

	/**
	 * Set default value to Discount Number field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setDiscount1NumberField() {
		return setDiscount1NumberField(data.get("DISCOUNT_1"));
	}

	/**
	 * Set value to Discount Number field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setDiscount1NumberField(String discount1Value) {
		discountPercentage.clear();
		discountPercentage.sendKeys(discount1Value);
		return this;
	}

	/**
	 * Set default value to Discount Number field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setDiscount2NumberField() {
		return setDiscount2NumberField(data.get("DISCOUNT_2"));
	}

	/**
	 * Set value to Discount Number field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setDiscount2NumberField(String discount2Value) {
		discountAmount.sendKeys(discount2Value);
		return this;
	}

	/**
	 * Set Drop Files Here Or Click To Upload File field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setDropFilesHereOrClickToFileField() {
		return this;
	}

	/**
	 * Set default value to Due Date Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setDueDateTextField() {
		return setDueDateTextField(data.get("DUE_DATE"));
	}

	/**
	 * Set value to Due Date Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setDueDateTextField(String dueDateValue) {
		dueDate.sendKeys(dueDateValue);
		return this;
	}

	/*
	 * get payment due date
	 */
	private String getDueDateTextField() {

		return dueDate.getAttribute("value");
	}

	/**
	 * Set default value to Exclusive Of Taxes Radio Button field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setExclusiveOfTaxesRadioButtonField() {
		for (WebElement el : exclusiveOfTaxes) {
			if (el.getAttribute("value").equals(exclusiveOfTaxesValue)) {
				if (!el.isSelected()) {
					el.click();
				}
				break;
			}
		}
		return this;
	}

	/**
	 * Set default value to Inclusive Of Taxes Radio Button field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInclusiveOfTaxesRadioButtonField() {
		for (WebElement el : inclusiveOfTaxes) {
			if (el.getAttribute("value").equals(inclusiveOfTaxesValue)) {
				if (!el.isSelected()) {
					el.click();
				}
				break;
			}
		}
		return this;
	}

	/**
	 * Set value to Invoice Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage clickInvoiceOverideSequence() {
		GenericUtils.delay(1);
		if (!invoice1.isSelected()) {
			invoice1.click();
		}
		GenericUtils.delay(2);
		return this;
	}

	/**
	 * Set value to Invoice Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoiceSequenceTextField(String invoice2Value) {
		invoice2.clear();
		invoice2.sendKeys(invoice2Value);
		return this;
	}

	/**
	 * Set default value to Invoice Date Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoiceDateTextField() {
		return setInvoiceDateTextField(data.get("INVOICE_DATE"));
	}

	/**
	 * Set value to Invoice Date Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoiceDateTextField(String invoiceDateValue) {
		invoiceDate.sendKeys(invoiceDateValue);
		return this;
	}

	/**
	 * Set default value to Invoice Payment Details Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoicePaymentDetailsTextareaField() {
		return setInvoicePaymentDetailsTextareaField(data.get("INVOICE_PAYMENT_DETAILS"));
	}

	/**
	 * Set value to Invoice Payment Details Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoicePaymentDetailsTextareaField(String invoicePaymentDetailsValue) {
		invoicePaymentDetails.sendKeys(invoicePaymentDetailsValue);
		return this;
	}

	/**
	 * Set default value to Invoice To Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoiceToTextField() {
		return setInvoiceToTextField(data.get("INVOICE_TO"));
	}

	/**
	 * Set value to Invoice To Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoiceToTextField(String invoiceToValue) {
		invoiceTo.sendKeys(invoiceToValue);

		return this;
	}

	/**
	 * Set default value to Notes Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setNotesTextareaField() {
		return setNotesTextareaField(data.get("NOTES"));
	}

	/**
	 * Set value to Notes Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setNotesTextareaField(String notesValue) {
		notes.sendKeys(notesValue);
		return this;
	}

	/**
	 * Set default value to Payment Terms Drop Down List field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setPaymentTermsDropDownListField() {
		return setPaymentTermsDropDownListField(data.get("PAYMENT_TERMS"));
	}

	/**
	 * Set value to Payment Terms Drop Down List field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setPaymentTermsDropDownListField(String paymentTermsValue) {
		new Select(paymentTerms).selectByVisibleText(paymentTermsValue);
		return this;
	}

	/**
	 * Set default value to Pincode Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setPincode1TextField() {
		return setPincode1TextField(data.get("PINCODE_1"));
	}

	/**
	 * Set value to Pincode Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setPincode1TextField(String pincode1Value) {
		pincode1.sendKeys(pincode1Value);
		return this;
	}

	/**
	 * Set default value to Pincode Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setPincode2TextField() {
		return setPincode2TextField(data.get("PINCODE_2"));
	}

	/**
	 * Set value to Pincode Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setPincode2TextField(String pincode2Value) {
		pincode2.sendKeys(pincode2Value);
		return this;
	}

	/**
	 * Set default value to Place Of Supply Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setPlaceOfSupplyTextField() {
		return setPlaceOfSupplyTextField(data.get("PLACE_OF_SUPPLY"));
	}

	/**
	 * Set value to Place Of Supply Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setPlaceOfSupplyTextField(String placeOfSupplyValue) {
		placeOfSupply.sendKeys(placeOfSupplyValue);
		return this;
	}

	/**
	 * Set default value to Ref Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setRefTextField() {
		return setRefTextField(data.get("REF"));
	}

	/**
	 * Set value to Ref Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setRefTextField(String refValue) {
		ref.sendKeys(refValue);
		return this;
	}

	/**
	 * Set default value to Required Asterisksignifies That This Field Can Not Be
	 * Left Blank Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setRequiredAsterisksignifiesThatThisFieldCanTextareaField() {
		return setRequiredAsterisksignifiesThatThisFieldCanTextareaField(
				data.get("REQUIRED_ASTERISKSIGNIFIES_THAT_THIS_FIELD_CAN"));
	}

	/**
	 * Set value to Required Asterisksignifies That This Field Can Not Be Left Blank
	 * Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setRequiredAsterisksignifiesThatThisFieldCanTextareaField(
			String requiredAsterisksignifiesThatThisFieldCanValue) {
		requiredAsterisksignifiesThatThisFieldCan.sendKeys(requiredAsterisksignifiesThatThisFieldCanValue);
		return this;
	}

	/**
	 * Set value to Select Or Add An Itemselect Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setSelectOrAddAnItemselect1TextareaField(String selectOrAddAnItemselect1Value) {
		selectOrAddAnItemselect1.clear();
		selectOrAddAnItemselect1.sendKeys(selectOrAddAnItemselect1Value);
		return this;
	}

	/**
	 * Set value to Select Or Add An Itemselect Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setSelectOrAddAnItemselect2TextareaField(String selectOrAddAnItemselect2Value) {
		selectOrAddAnItemselect2.clear();
		selectOrAddAnItemselect2.sendKeys(selectOrAddAnItemselect2Value);
		return this;
	}

	/**
	 * Set value to Select Or Add An Itemselect Number field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setSelectOrAddAnItemselect3NumberField(String selectOrAddAnItemselect3Value) {
		selectOrAddAnItemselect3.clear();
		selectOrAddAnItemselect3.sendKeys(selectOrAddAnItemselect3Value);
		return this;
	}

	/**
	 * Set value to Select Or Add An Itemselect Number field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setSelectOrAddAnItemselect4NumberField(String selectOrAddAnItemselect4Value) {
		selectOrAddAnItemselect4.clear();
		selectOrAddAnItemselect4.sendKeys(selectOrAddAnItemselect4Value);
		return this;
	}

	/**
	 * Set value to Select Or Add An Itemselect Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setSelectOrAddAnItemselect5TextField(String selectOrAddAnItemselect5Value) {
		selectOrAddAnItemselect5.clear();
		selectOrAddAnItemselect5.sendKeys(selectOrAddAnItemselect5Value);
		return this;
	}

	/**
	 * Set value to Select Or Add An Itemselect Number field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setSelectOrAddAnItemselect6NumberField(String selectOrAddAnItemselect6Value) {
		selectOrAddAnItemselect6.clear();
		selectOrAddAnItemselect6.sendKeys(selectOrAddAnItemselect6Value);
		return this;
	}

	/**
	 * Set default value to Shipping Address Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setShippingAddressTextField() {
		return setShippingAddressTextField(data.get("SHIPPING_ADDRESS"));
	}

	/**
	 * Set value to Shipping Address Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setShippingAddressTextField(String shippingAddressValue) {
		shippingAddress.sendKeys(shippingAddressValue);
		return this;
	}

	/**
	 * Set default value to State Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setStateTextField() {
		return setStateTextField(data.get("STATE"));
	}

	/**
	 * Set value to State Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setStateTextField(String stateValue) {
		state.sendKeys(stateValue);
		return this;
	}

	/**
	 * Set default value to Tax Invoice Make This A Recurring Invoice Textarea
	 * field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setTaxInvoiceMakeThisARecurringTextareaField() {
		return setTaxInvoiceMakeThisARecurringTextareaField(data.get("TAX_INVOICE_MAKE_THIS_A_RECURRING"));
	}

	/**
	 * Set value to Tax Invoice Make This A Recurring Invoice Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setTaxInvoiceMakeThisARecurringTextareaField(String taxInvoiceMakeThisARecurringValue) {
		taxInvoiceMakeThisARecurring.sendKeys(taxInvoiceMakeThisARecurringValue);
		return this;
	}

	/**
	 * Set default value to Terms Conditions Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setTermsConditionsTextareaField() {
		return setTermsConditionsTextareaField(data.get("TERMS_CONDITIONS"));
	}

	/**
	 * Set value to Terms Conditions Textarea field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setTermsConditionsTextareaField(String termsConditionsValue) {
		termsConditions.sendKeys(termsConditionsValue);
		return this;
	}

	/**
	 * Submit the form to target page.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage submit() {
		clickSend1Button();
		return this;
	}

	/**
	 * Unset default value from Payment Terms Drop Down List field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage unsetPaymentTermsDropDownListField() {
		return unsetPaymentTermsDropDownListField(data.get("PAYMENT_TERMS"));
	}

	/**
	 * Unset value from Payment Terms Drop Down List field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage unsetPaymentTermsDropDownListField(String paymentTermsValue) {
		new Select(paymentTerms).deselectByVisibleText(paymentTermsValue);
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage verifyPageLoaded() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				assertTrue(d.getPageSource().contains(pageLoadedText));
				return d.getPageSource().contains(pageLoadedText);
			}
		});
		return this;
	}

	/**
	 * Verify that current page URL matches the expected URL.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				Assert.assertTrue(d.getCurrentUrl().contains(pageUrl));
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}

	public void AddTaxorAlter() {
		taxSelectField.click();
	}

	public void verifyMessage() {
		String message = driver.findElement(By.className("toast-message")).getText();
		System.out.println(message);

		if (message.contains("created") || message.contains("sent to")) {

		} else {
			Assert.fail("Invoice creation failed");

		}
	}

	/*
	 * Email dilague box
	 * 
	 */

	public void clickEmailSendButton() {
		emailSendButton.click();
	}

	public void clickEmailCanceButton() {
		emailcancelButton.click();
	}

	public void clickAddNewCustomerLink() {
		setInvoiceToTextField("Add");

		addnewCustomerlink.click();
	}

	public TaxInvoicePage AddAllItem(String filePath, String sheetName) {
		GenericUtils.delay(2);
		String item_name = ExcelLibrary.getExcelData(filePath, sheetName, 1, 17);
		System.out.println(item_name);
		setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Add description,price,qty randomly,tax
		 */
		setSelectOrAddAnItemselect2TextareaField(GenericUtils.simpleDate());
		setSelectOrAddAnItemselect3NumberField(GenericUtils.randomNumber());
		setSelectOrAddAnItemselect4NumberField(GenericUtils.randomNumber());
		// AddTaxorAlter();
		selectOrAddAnItemselect5.click();
		return this;
	}

	public TaxInvoicePage AddAllItem(String filePath, String sheetName, String item_name) {
		GenericUtils.delay(2);
		System.out.println(item_name);
		setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Add description,price,qty randomly,tax
		 */
		setSelectOrAddAnItemselect2TextareaField(GenericUtils.simpleDate());
		setSelectOrAddAnItemselect3NumberField(GenericUtils.randomNumber());
		setSelectOrAddAnItemselect4NumberField(GenericUtils.randomNumber());
		// AddTaxorAlter();
		selectOrAddAnItemselect5.click();
		return this;
	}

	public TaxInvoicePage clickOnRoundof() {
		roundoff.click();
		return this;
	}

	public TaxInvoicePage clickEditCustomer() {
		GenericUtils.delay(1);
		driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-pencil text-blue-color link'])[1]")).click();
		return this;
	}

	public TaxInvoicePage verifyTDSAmount() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		float igstamnt = 0;
		float cgstmnt = 0;
		float sgst = 0;
		float utgstamnt = 0;
		float totalAmnt = Float.parseFloat(totalAmount.getText().replaceAll(",", ""));
		if (driver.findElements(By.xpath("//label[contains(text(),'CGST')]")).size() > 0) {
			cgstmnt = Float.parseFloat(cgstAmount.getText().replaceAll(",", ""));
		}
		if (driver.findElements(By.xpath("//label[contains(text(),'SGST')]")).size() > 0) {
			sgst = Float.parseFloat(sgstAmount.getText().replaceAll(",", ""));
		}
		if (driver.findElements(By.xpath("//label[contains(text(),'IGST')]")).size() > 0) {
			igstamnt = Float.parseFloat(
					driver.findElement(By.xpath("//span[@class='tax-lines-smallest-number pull-right']")).getText());
		}
		if (driver.findElements(By.xpath("//label[contains(text(),'UTGST')]")).size() > 0) {
			utgstamnt = Float.parseFloat(
					driver.findElement(By.xpath("//span[@class='tax-lines-smallest-number pull-right']")).getText());
		}
		float tds = Float.parseFloat(TdsAmount.getText().replaceAll(",", ""));
		float roundoff = Float.parseFloat(roundOfAmnt.getText().replaceAll(",", ""));
		int netToatl = Integer.parseInt(netTotalAmount.getText().replaceAll(",", ""));
		System.out.println(netToatl);
		System.out.println(totalAmnt + " " + cgstmnt + " " + sgst + " " + tds + " " + roundoff);
		float verifyamnt = (totalAmnt + cgstmnt + sgst + utgstamnt + igstamnt) - tds;
		verifyamnt = verifyamnt + 0.01f;
		System.out.println("verify amnt" + verifyamnt);
		int v = (int) (verifyamnt + roundoff);
		System.out.println("v is" + v);
		Assert.assertEquals(v, netToatl);
		driver.manage().timeouts().implicitlyWait(
				Long.parseLong(GenericUtils.getConfigProperties("config/config.properties", "IMPLICIT_WAIT")),
				TimeUnit.SECONDS);
		return this;
	}

	public TaxInvoicePage verifyGSt(String val) {
		int i = driver.findElements(By.xpath("//label[contains(text(),'" + val + "')]")).size();
		System.out.println("vgst" + i);
		Assert.assertEquals(i, 1, ("Gst is not apeared in field: " + val));
		return this;
	}

	public TaxInvoicePage clickOnAddnewItem() {
		setSelectOrAddAnItemselect1TextareaField("Add");
		addnewItem.click();
		return this;
	}

	public TaxInvoicePage verifyExistingItem() {
		int t1 = selectOrAddAnItemselect1.getText().length();
		int t2 = selectOrAddAnItemselect2.getText().length();
		int t3 = selectOrAddAnItemselect3.getText().length();
		int t4 = selectOrAddAnItemselect4.getText().length();
		if (t1 > 0 && t2 > 0 && t3 > 0 & t4 > 0) {
			Assert.assertTrue(true, "All items feild are populated correctly");
		} else {
			Assert.assertFalse(true, "All item fields are not populated correctly");
		}

		return this;
	}

	/*
	 * Verify discount amount
	 */
	public TaxInvoicePage verifyDiscountAmount() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		selectOrAddAnItemselect5.click();
		float igstamnt = 0;
		float cgstmnt = 0;
		float sgst = 0;
		float utgstamnt = 0;
		float tds = 0;
		float totalAmnt = Float.parseFloat(totalAmount.getText().replaceAll(",", ""));
		if (driver.findElements(By.xpath("//label[contains(text(),'CGST')]")).size() > 0) {
			cgstmnt = Float.parseFloat(cgstAmount.getText().replaceAll(",", ""));
		}
		if (driver.findElements(By.xpath("//label[contains(text(),'SGST')]")).size() > 0) {
			sgst = Float.parseFloat(sgstAmount.getText().replaceAll(",", ""));
		}
		if (driver.findElements(By.xpath("//label[contains(text(),'IGST')]")).size() > 0) {
			igstamnt = Float.parseFloat(
					driver.findElement(By.xpath("//span[@class='tax-lines-smallest-number pull-right']")).getText());
		}
		if (driver.findElements(By.xpath("//label[contains(text(),'UTGST')]")).size() > 0) {
			utgstamnt = Float.parseFloat(
					driver.findElement(By.xpath("//span[@class='tax-lines-smallest-number pull-right']")).getText());
		}
		if (driver.findElements(By.xpath("//span[@class='pull-right text-align-right']")).size() > 0) {
			tds = Float.parseFloat(TdsAmount.getText().replaceAll(",", ""));
		}
		float discount = Float.parseFloat(discountAmount.getAttribute("value"));
		float roundoff = Float.parseFloat(roundOfAmnt.getText().replaceAll(",", ""));
		int netToatl = Integer.parseInt(netTotalAmount.getText().replaceAll(",", ""));
		System.out.println(netToatl);
		System.out.println("discount amount" + discount);
		totalAmnt = totalAmnt - discount;
		System.out.println("total amnt" + totalAmnt + " " + cgstmnt + " " + sgst + " " + tds + " " + roundoff + "igst"
				+ igstamnt + "" + utgstamnt);
		float verifyamnt = (totalAmnt + cgstmnt + sgst + utgstamnt + igstamnt) - tds;
		System.out.println("verify amnt" + verifyamnt);
		verifyamnt = verifyamnt + 0.01f;
		System.out.println("verify amnt" + verifyamnt);
		int v = (int) (verifyamnt + roundoff);
		System.out.println("verify amount is" + v);
		Assert.assertEquals(v, netToatl);
		return this;
	}

	public TaxInvoicePage verifyNetTotalDecimalValue() {
		GenericUtils.delay(2);
		int netamnt = Integer.parseInt(driver.findElement(By.xpath("(//span[@class='smallest-number'])[2]")).getText());
		System.out.println("Net amount after round off:" + netamnt);
		if (netamnt > 0) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true, "Decimal value not populated");
		}
		return this;
	}

	public TaxInvoicePage setYesInSequenceOverride() {
		driver.findElement(By.xpath("//button[@class='btn btn-modal-blue font-12 uppercase' and text()='Yes']"))
				.click();
		return this;
	}

	public TaxInvoicePage verifyDueDate(String paymentterms) {
		String[] a = paymentterms.split(" ");
		String data=a[1];
		System.out.println(data);
		int terms = Integer.valueOf(data);
		System.err.println("terms"+terms);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, terms);
		Date dueDate = c.getTime();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dueDate1 = format.format(dueDate);
		System.out.println("due date after cal" + dueDate1);
		String acDueDate = getDueDateTextField();
		System.out.println("due date in ui" + acDueDate);
		if (dueDate1.equals(acDueDate)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true, "due date not matching");
		}

		return this;

	}

}
