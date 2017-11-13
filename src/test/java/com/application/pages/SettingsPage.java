package com.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.application.libraries.GenericUtils;

public class SettingsPage  {
	WebDriver driver;

	@FindBy(id = "gstin-number")

	private WebElement gst;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement canceButton;
	
	@FindBy(xpath="//a/span[text()='Emails']")
	private WebElement emailLink;
	

	@FindBy(id="invoice-subject")
	private WebElement emailSubject;
	
	@FindBy(id="invoice-body")
	private WebElement emailBody;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public SettingsPage fillGST(String data) {
		gst.clear();
		gst.sendKeys(data);
		return this;
	}

	public SettingsPage clickOnSaveButton()
	{
		saveButton.click();
		return this;
	}
	public SettingsPage clickOnEmailLink()
	{
		emailLink.click();
		return this;
	}
	public String getEmailSubject()
	{
		GenericUtils.delay(2);
		return emailSubject.getAttribute("value");
	}
	public String getEmailBody()
	{
		GenericUtils.delay(2);
		return emailBody.getAttribute("value");
	}
	
	
}
