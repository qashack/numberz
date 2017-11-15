package com.application.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderNewVendor {
	private WebDriver driver;

	@FindBy(xpath = "(//input[@value=''])[14]")
	private WebElement newVendorName;

	@FindBy(xpath = "(//div[@class='padding-20 modal-body']//input)[3]")
	private WebElement emailId;

	@FindBy(xpath = "(//div[@class='padding-20 modal-body']//input)[4]")
	private WebElement phoneNumber;

	@FindBy(xpath = ".//*[@id='account-number']")
	private WebElement accNumber;

	@FindBy(xpath = ".//*[@id='ifsc']")
	private WebElement ifscCode;

	@FindBy(xpath = ".//*[@id='gstin-number']")
	private WebElement gstIn;

	@FindBy(xpath = "//div[@class='padding-20 modal-body']//button[1]")
	private WebElement saveButton;

	public PurchaseOrderNewVendor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void newVendorNameSetText(String newVendorNam) {
		newVendorName.sendKeys(newVendorNam);
	}

	public void emailIdSetText(String emailID) {
		emailId.sendKeys(emailID);
	}

	public void phoneNumberSetText(String phoneNum) {
		phoneNumber.sendKeys(phoneNum);
	}

	public void accountNmberSetText(String accNum) {
		accNumber.sendKeys(accNum);
	}

	public void ifscCodeSetText(String ifsc) {
		ifscCode.sendKeys(ifsc);
	}

	public void gstInSetText(String gstin) {
		gstIn.sendKeys(gstin);
	}

	public void saveButtonClick() {
		saveButton.click();
	}

}
