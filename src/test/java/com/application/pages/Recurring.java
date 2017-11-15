package com.application.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Recurring {
	private WebDriver driver;

	@FindBy(xpath = "//div[@class='row divNav']//button")
	private WebElement addRecurringBillBtn;

	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-placeholder'])[1]")
	private WebElement selectOrAddVendor;

	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-input ']/input)[1]")
	private WebElement selectOrAddVendorInput;

	@FindBy(xpath = "//div[contains(@class,'invoice-body')]//div[@class='Select-menu-outer']//*[contains(text(),'Add New Vendor')]")
	private WebElement addNewVendor;

	@FindBy(xpath = "(//div[@class='invoice-body']//input)[5]")
	private WebElement endDate;

	@FindBy(xpath = "//div[@class='invoice-body']//input[@id='recurrence-widget-end-date']")
	private WebElement endDateInput;

	@FindBy(xpath = "(//div[@class='invoice-body']//span[@class='Select-arrow-zone'])[2]")
	private WebElement frequencyDropDown;

	@FindBy(xpath = "(//div[@class='invoice-body']//span[@class='Select-arrow-zone'])[3]")
	private WebElement expenseTypeDropDown;

	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-input '])[3]/input")
	private WebElement expenseTypeInput;

	@FindBy(id = "CreateRecurringBill-terms")
	private WebElement paymentTermsDropDown;

	@FindBy(id = "CreateRecurringBill-terms")
	private WebElement paymentTermsInput;
	
	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-control'])[5]")
	private WebElement itemName;
	
	@FindBy(xpath = "(//div[@class='invoice-body']//div[@class='Select-input '])[5]/input")
	private WebElement itemNameInput;
	
	@FindBy(xpath = "//div[@class='col-md-12 header-padding']//button[@id='recurring-bill-save-btn']")
	private WebElement saveBtn;
	

	public Recurring(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addRecurringBillBtnClick() {
		addRecurringBillBtn.click();
	}

	public void selectOrAddVendorClick() {
		selectOrAddVendor.click();
	}

	public void addNewVendorClick() {
		addNewVendor.click();
	}

	public void selectOrAddVendorInputSetText(String vendorName) {
		selectOrAddVendorInput.sendKeys(vendorName);
	}

	public void endDateClick() {
		endDate.click();
	}

	public void frequencyDropDownClick() {
		frequencyDropDown.click();
	}

	public void frequencyInput(String frequnc) {
		String selectOption = "//div[@class='invoice-body']//div[@class='Select-menu-outer']//div[text()='" + frequnc
				+ "']";
		WebElement ele = driver.findElement(By.xpath(selectOption));
		ele.click();

	}

	public void endDateSetText(String endDate) {
		endDateInput.sendKeys(endDate);
	}

	public void expenseTypeDropDownClick() {
		expenseTypeDropDown.click();
	}

	public void expenseTypeInputSetText(String expensetype) {
		expenseTypeInput.sendKeys(expensetype);
	}

	public void paymentTermsDropDownClick() {
		paymentTermsDropDown.click();
	}

	public void paymentTermsInputSelect(String paymentTerm) {
		Select paymentter = new Select(paymentTermsInput);
		paymentter.selectByVisibleText(paymentTerm);
	}
	
	public void itemNameclick() {
		itemName.click();
	}
	
	public void itemNameSetText(String item) {
		itemNameInput.sendKeys(item);;
	}
	
	public void saveBtnClick() {
		saveBtn.click();
	}
}
