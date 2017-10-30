package com.application.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TaxInvoicePage {
	private Map<String, String> data;
	protected WebDriver driver;
	private int timeout = 15;

	@FindBy(id = "create-invoice-cancel-btn")
	@CacheLookup
	private WebElement cancel;

	@FindBy(id = "create-invoice-city")
	@CacheLookup
	private WebElement city;
	//Add new customer
	@FindBy(xpath="//div[contains(@class,'CreateInvoiceContainer')]//div[@class='Select-menu-outer']//*[contains(text(),'Add New Customer')]")
	@CacheLookup
	private WebElement addnewCustomerlink;
	
	@FindBy(id = "olark-form-input-email")
	@CacheLookup
	private WebElement clickHereAndTypeYourEmail1;

	@FindBy(css = "textarea")
	@CacheLookup
	private WebElement clickHereAndTypeYourEmail2;

	@FindBy(id = "olark-form-input-fname")
	@CacheLookup
	private WebElement clickHereAndTypeYourName;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(3) div div:nth-of-type(1) div:nth-of-type(4) div.Select.is-searchable.has-value div.Select-control div:nth-of-type(2) input")
	@CacheLookup
	private WebElement country;

	@FindBy(id = "create-invoice-discount-perc")
	@CacheLookup
	private WebElement discount1;

	@FindBy(id = "create-invoice-flat-discount")
	@CacheLookup
	private WebElement discount2;

	@FindBy(css = "#create-invoice-attachments input[type='file']")
	@CacheLookup
	private WebElement dropFilesHereOrClickTo;

	@FindBy(id = "create-invoice-due-date")
	@CacheLookup
	private WebElement dueDate;

	@FindBy(css = "button.olark-launch-button.olark-chat-tab.olark-size-md")
	@CacheLookup
	private WebElement envelopeIconsmallPictureOfAnEnvelope;

	@FindBy(name = "oktab8916270239557056")
	@CacheLookup
	private List<WebElement> exclusiveOfTaxes;

	private final String exclusiveOfTaxesValue = "false";

	@FindBy(id = "create-invoice-guide-me")
	@CacheLookup
	private WebElement guideMeToCreateGstInvoice;

	@FindBy(name = "oktab8916270239557056")
	@CacheLookup
	private List<WebElement> inclusiveOfTaxes;

	private final String inclusiveOfTaxesValue = "true";

	@FindBy(id = "create-invoice-invoice-no-input-checkbox")
	@CacheLookup
	private WebElement invoice1;

	@FindBy(id = "create-invoice-invoice-no-input-text")
	@CacheLookup
	private WebElement invoice2;

	@FindBy(id = "create-invoice-invoice-date")
	@CacheLookup
	private WebElement invoiceDate;

	@FindBy(id = "create-invoice-add-message")
	@CacheLookup
	private WebElement invoicePaymentDetails;

	@FindBy(id = "create-invoice-select-customer")
	@CacheLookup
	private WebElement invoiceTo;

	@FindBy(id = "create-invoice-recurring-invoice-link")
	@CacheLookup
	private WebElement makeThisARecurringInvoice;

	@FindBy(id = "create-invoice-add-message")
	@CacheLookup
	private WebElement notes;

	private final String pageLoadedText = "Select or Add a customer";

	private final String pageUrl = "/app/receivables/invoice";

	@FindBy(id = "create-invoice-payment-terms")
	@CacheLookup
	private WebElement paymentTerms;

	@FindBy(id = "create-invoice-pincode")
	@CacheLookup
	private WebElement pincode1;

	@FindBy(id = "create-invoice-address-2")
	@CacheLookup
	private WebElement pincode2;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(4) div:nth-of-type(1) div:nth-of-type(1) div.Select-control div:nth-of-type(2) input")
	@CacheLookup
	private WebElement placeOfSupply;

	@FindBy(css = "#olark-container div:nth-of-type(3) a")
	@CacheLookup
	private WebElement poweredByOlark;

	@FindBy(id = "create-invoice-preview-btn")
	@CacheLookup
	private WebElement print;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(4) div:nth-of-type(2) input.form-control.grey-border.height-40.font-12[type='text']")
	@CacheLookup
	private WebElement ref;

	@FindBy(id = "olark-form-input-body")
	@CacheLookup
	private WebElement requiredAsterisksignifiesThatThisFieldCan;

	@FindBy(id = "create-invoice-save-btn")
	@CacheLookup
	private WebElement save;

	@FindBy(id = "line-item-0")
	@CacheLookup
	private WebElement selectOrAddAnItemselect1;

	@FindBy(id = "line-item-description-0")
	@CacheLookup
	private WebElement selectOrAddAnItemselect2;

	@FindBy(id = "line-item-price-0")
	@CacheLookup
	private WebElement selectOrAddAnItemselect3;

	@FindBy(id = "line-item-qty-0")
	@CacheLookup
	private WebElement selectOrAddAnItemselect4;

	@FindBy(id = "line-item-unit-0")
	@CacheLookup
	private WebElement selectOrAddAnItemselect5;

	@FindBy(id = "line-item-amount-0")
	@CacheLookup
	private WebElement selectOrAddAnItemselect6;

	@FindBy(className = "Select-placeholder")
	private WebElement stateName;

	@FindBy(id = "create-invoice-send-btn")
	@CacheLookup
	private WebElement send1;

	@FindBy(css = "button.olark-form-send-button")
	@CacheLookup
	private WebElement send2;

	@FindBy(id = "create-invoice-address-1")
	@CacheLookup
	private WebElement shippingAddress;

	@FindBy(css = "#btn-logout a.link")
	@CacheLookup
	private WebElement signOut;

	@FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(3) div:nth-of-type(2) div.invoice-body div:nth-of-type(3) div div:nth-of-type(1) div:nth-of-type(3) div.Select.select-state.is-searchable div.Select-control div:nth-of-type(2) input")
	@CacheLookup
	private WebElement state;

	@FindBy(id = "create-invoice-header")
	@CacheLookup
	private WebElement taxInvoiceMakeThisARecurring;

	@FindBy(id = "create-invoice-add-message")
	@CacheLookup
	private WebElement termsConditions;
	
	@FindBy(id = "create-invoice-round-off")
	@CacheLookup
	private WebElement roundoff;

	@FindBy(xpath = "//table[@id='LineItemTable']/tbody/tr[1]/td[8]//span[@class='Select-arrow-zone']/span")
	@CacheLookup
	private WebElement taxSelectField;

	/*
	 * Email window page elements
	 */
	@FindBy(xpath = "//div[@class='modal-body']//button[text()='Send']")
	@CacheLookup
	private WebElement emailSendButton;

	@FindBy(xpath = "//div[@class='modal-body']//button[text()='Cancel']")
	@CacheLookup
	private WebElement emailcancelButton;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Email ID']")
	@CacheLookup
	private WebElement emailtoField;
	
	@FindBy(xpath = "(//span[@class='big-number'])[1]")
	@CacheLookup
	private WebElement totalAmount;
	
	@FindBy(xpath = "(//span[@class='big-number'])[2]")
	@CacheLookup
	private WebElement netTotalAmount;
	
	
	@FindBy(xpath = "(//span[@class='tax-lines-smallest-number pull-right'])[1]")
	@CacheLookup
	private WebElement cgstAmount;
	
	@FindBy(xpath = "(//span[@class='tax-lines-smallest-number pull-right'])[2]")
	@CacheLookup
	private WebElement sgstAmount;
	
	@FindBy(xpath = "//span[@class='pull-right text-align-right']")
	@CacheLookup
	private WebElement TdsAmount;
	
	@FindBy(xpath = "//span[@class='tax-lines-smallest-number']")
	@CacheLookup
	private WebElement roundOfAmnt;
	
	

	public TaxInvoicePage() {
	}

	public TaxInvoicePage(WebDriver driver) {
		this();
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
		discount1.sendKeys(discount1Value);
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
		discount2.sendKeys(discount2Value);
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
	 * Set default value to Invoice Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoice1TextField() {
		return setInvoice1TextField(data.get("INVOICE_1"));
	}

	/**
	 * Set value to Invoice Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoice1TextField(String invoice1Value) {
		if (!invoice1.isSelected()) {
			invoice1.click();
		}
		return this;
	}

	/**
	 * Set default value to Invoice Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoice2TextField() {
		return setInvoice2TextField(data.get("INVOICE_2"));
	}

	/**
	 * Set value to Invoice Text field.
	 *
	 * @return the TaxInvoicePage class instance.
	 */
	public TaxInvoicePage setInvoice2TextField(String invoice2Value) {
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
		
		if (message.contains("created")||message.contains("sent to")) {
			
		} else {
			Assert.fail("Invoice creation failed");
			
		}
	}
	/*
	 * Email dilague box
	 * 
	 */
	
	public void clickEmailSendButton()
	{
		emailSendButton.click();
	}
	public void clickAddNewCustomerLink()
	{
		setInvoiceToTextField("Add");
		
		addnewCustomerlink.click();
	}
	public TaxInvoicePage AddAllItem(String filePath,String sheetName)
	{
		GenericUtils.delay(2);
		String item_name=ExcelLibrary.getExcelData(filePath, sheetName, 1, 17);
		System.out.println(item_name);
		setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Add description,price,qty randomly,tax
		 */
		setSelectOrAddAnItemselect2TextareaField(GenericUtils.simpleDate());
		setSelectOrAddAnItemselect3NumberField(GenericUtils.randomNumber());
		setSelectOrAddAnItemselect4NumberField(GenericUtils.randomNumber());
		//AddTaxorAlter();
		selectOrAddAnItemselect5.click();
		return this;
	}
	public TaxInvoicePage clickOnRoundof()
	{
		roundoff.click();
		return this;
	}
	public TaxInvoicePage clickEditCustomer()
	{
		GenericUtils.delay(1);
		driver.findElement(By.xpath("(//i[@class='glyphicon glyphicon-pencil text-blue-color link'])[1]")).click();
		return this;
	}
	public TaxInvoicePage verifyTDSAmount()
	{
		float totalAmnt=Float.parseFloat(totalAmount.getText().replaceAll(",", ""));
		float cgstmnt=Float.parseFloat(cgstAmount.getText().replaceAll(",", ""));
		float sgst=Float.parseFloat(sgstAmount.getText().replaceAll(",", ""));
		float tds=Float.parseFloat(TdsAmount.getText().replaceAll(",", ""));
		float roundoff=Float.parseFloat(roundOfAmnt.getText().replaceAll(",", ""));
		int netToatl=Integer.parseInt(netTotalAmount.getText().replaceAll(",", ""));
		System.out.println(netToatl);
		System.out.println(totalAmnt+" "+cgstmnt+" "+sgst+" "+tds+" "+roundoff);
		float verifyamnt=(totalAmnt+cgstmnt+sgst)-tds;
		System.out.println("verify amnt"+verifyamnt);
		int v=(int) (verifyamnt+roundoff);
		System.out.println("v is"+v);
		Assert.assertEquals(v, netToatl);
		return this;
	}
	
}
