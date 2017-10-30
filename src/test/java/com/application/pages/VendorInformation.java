package com.application.pages;

import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VendorInformation {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "div.container-fluid div.row div:nth-of-type(4) div:nth-of-type(1) input.form-control.grey-border.border-radius-6.height-40.font-12")
	private WebElement vendorName;

	@FindBy(css = "div.container-fluid div.row div:nth-of-type(4) div:nth-of-type(3) input.form-control.grey-border.border-radius-6.height-40.font-12[type='email']")
	private WebElement email;

	@FindBy(css = "div.container-fluid div.row div:nth-of-type(4) div:nth-of-type(4) input.form-control.grey-border.border-radius-6.height-40.font-12[type='text']")
	private WebElement phone;

	@FindBy(id = "account-number")
	private WebElement accountNumber;

	@FindBy(id = "ifsc")
	private WebElement ifsc;

	@FindBy(id = "gstin-number")
	private WebElement gstin1;

	// @FindBy(id = "bill-save-btn")

	@FindBy(xpath = "//div[2]/button")
	private WebElement save;

	public VendorInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public VendorInformation(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public VendorInformation(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Set value to Vendor Name Text field.
	 *
	 * @return the VendorInfo class instance.
	 */
	public VendorInformation setVendorNameTextField(String vendorNameValue) {
		vendorName.sendKeys(vendorNameValue);
		return this;
	}

	/**
	 * Set value to Email Email field.
	 *
	 * @return the VendorInfo class instance.
	 */
	public VendorInformation setEmailEmailField(String emailValue) {
		email.sendKeys(emailValue);
		return this;
	}

	/**
	 * Set value to Phone Text field.
	 *
	 * @return the VendorInfo class instance.
	 */
	public VendorInformation setPhoneTextField(String phoneValue) {
		phone.sendKeys(phoneValue);
		return this;
	}

	/**
	 * Set value to Account Number Text field.
	 *
	 * @return the VendorInfo class instance.
	 */
	public VendorInformation setAccountNumberTextField(String accountNumberValue) {
		accountNumber.sendKeys(accountNumberValue);
		return this;
	}

	/**
	 * Set value to Ifsc Text field.
	 *
	 * @return the VendorInfo class instance.
	 */
	public VendorInformation setIfscTextField(String ifscValue) {
		ifsc.sendKeys(ifscValue);
		return this;
	}

	/**
	 * Set value to Ifsc Text field.
	 *
	 * @return the VendorInfo class instance.
	 */
	public VendorInformation setGstInTextField(String gstIn) {
		gstin1.sendKeys(gstIn);
		return this;
	}

	/**
	 * Click on Save Button.
	 *
	 * @return the VendorInfo class instance.
	 */
	public VendorInformation clickSave1Button() {
		save.click();
		return this;
	}
}
