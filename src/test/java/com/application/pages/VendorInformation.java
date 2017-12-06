package com.application.pages;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.application.libraries.GenericUtils;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//div[2]/button")
	private WebElement save;
	
	@FindBy(xpath = "(//div[@class='padding-20 modal-body']//span[@class='col-md-6 no-padding'])[1]/input")
	private WebElement cityInput;
	
	@FindBy(xpath = "//div[@class='padding-20 modal-body']//span[@class='Select-arrow']")
	private WebElement stateDropdown;
	
	@FindBy(xpath ="//div[@class='padding-20 modal-body']//div[@class='Select-input ']/input")
	private WebElement stateInput;
	
	@FindBy(xpath = "(//button[@class='btn btn-modal-blue font-12 uppercase'])[1]")
	private WebElement yesBtn;
	
	@FindBy(xpath = "//button[@class='btn font-10 padding-20 btn-green-border uppercase left-margin-20 pull-right margin-top-12']")
	private WebElement saveVendorRecurringBill;
	
	@FindBy(xpath = "(//button[@class='btn btn-modal-blue font-12 uppercase'])[1]")
	private WebElement gstinAlredyExistYesBtn;

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
	
	public void cityInputSetText(String city) {
		cityInput.sendKeys(city);
	}
	
	public void stateDropdownClick() {
		stateDropdown.click();
	}
	
	public void stateInputSetText(String state) {
		stateInput.sendKeys(state);		
	}
	
	public void yesBtnClick() {
		yesBtn.click();
	}
	
	public void saveVendorRecurringBillClick() {
		saveVendorRecurringBill.click();
	}
	
	public void gstinAlredyExistYesBtnClick() {
		gstinAlredyExistYesBtn.click();
	}
	
	public void clickOnYesButton() {
		boolean status = verifyPopUp();
		System.out.println(status);
		if (status) {
			
		} else {
			driver.findElement(By.xpath(
					"//div[@class='modal-body']//button[@class='btn btn-modal-blue font-12 uppercase' and text()='Yes']"))
					.click();
		}
	}
	private boolean verifyPopUp() {
		boolean status;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		int size = driver.findElements(By.className("toast-message")).size();

		System.out.println("size" + size);

		if (size > 0) {

			status = true;
		} else {

			status = false;
		}
		driver.manage().timeouts().implicitlyWait(
				Long.parseLong(GenericUtils.getConfigProperties("config/config.properties", "IMPLICIT_WAIT")),
				TimeUnit.SECONDS);
		return status;
	}
}
