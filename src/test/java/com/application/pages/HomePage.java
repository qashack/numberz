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

public class HomePage {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(8) div:nth-of-type(1) div div center div:nth-of-type(3) a.btn.btn-green.font-12.font-weight-300")
	private WebElement addBankAccount;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(6) div.home-widget-container div div:nth-of-type(1) div:nth-of-type(1) a.btn.grey-text-color.font-13")
	private WebElement addExpense;

	@FindBy(id = "add-invoice-btn-navbar-home")
	private WebElement addInvoice1;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(4) div.home-widget-container div div:nth-of-type(1) div:nth-of-type(1) a.btn.grey-text-color.font-13")
	private WebElement addInvoice2;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(8) div:nth-of-type(2) div div center div:nth-of-type(3) a.btn.btn-green.font-12.font-weight-300")
	private WebElement applyForCreditLine;

	@FindBy(id = "olark-form-input-email")
	private WebElement clickHereAndTypeYourEmail;

	@FindBy(id = "olark-form-input-fname")
	private WebElement clickHereAndTypeYourName;

	@FindBy(css = "button.olark-launch-button.olark-chat-tab.olark-size-md")
	private WebElement envelopeIconsmallPictureOfAnEnvelope;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(6) div.home-widget-container div div:nth-of-type(2) div:nth-of-type(3) a")
	private WebElement gotoExpenseList;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(4) div.home-widget-container div div:nth-of-type(2) div:nth-of-type(3) a")
	private WebElement gotoInvoiceList;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) div div:nth-of-type(2) a:nth-of-type(2)")
	private WebElement helpSupportnumberzIn;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) div div:nth-of-type(2) a:nth-of-type(1)")
	private WebElement moreHowtoGuides;

	private final String pageLoadedText = "View all your bank transactions in one place &amp; match those with your invoices &amp; expenses";
	private final String pageUrl = "/app/home";

	@FindBy(css = "#olark-container div:nth-of-type(3) a")
	private WebElement poweredByOlark;

	@FindBy(id = "olark-form-input-body")
	private WebElement requiredAsterisksignifiesThatThisFieldCan;

	@FindBy(css = "button.olark-form-send-button")
	private WebElement send;

	@FindBy(css = "a.link")
	private WebElement signOut;

	@FindBy(css = "#homeContainer div:nth-of-type(2) div:nth-of-type(2) div:nth-of-type(2) div div:nth-of-type(1) div:nth-of-type(2) a.btn.btn-green.font-12.font-weight-300")
	private WebElement tryItNow;

	@FindBy(xpath = "//span[text()='Settings']")
	private WebElement settings;

	@FindBy(xpath = "//div[text()='Company Settings']")
	private WebElement companysettings;

	@FindBy(id = "add-invoice-btn-navbar")
	private WebElement invoiceAdd;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage(WebDriver driver, Map<String, String> data) {
		this(driver);
		this.data = data;
	}

	public HomePage(WebDriver driver, Map<String, String> data, int timeout) {
		this(driver, data);
		this.timeout = timeout;
	}

	/**
	 * Click on Add Bank Account Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickAddBankAccountLink() {
		addBankAccount.click();
		return this;
	}

	public HomePage clickOnAddInvoiceInInvoice() {
		invoiceAdd.click();
		return this;
	}

	/**
	 * Click on Add Expense Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickAddExpenseLink() {
		addExpense.click();
		return this;
	}

	/**
	 * Click on Add Invoice Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickAddInvoice1Link() {
		JavascriptLibrary.javascriptClickElement(driver, addInvoice1);
		//addInvoice1.click();
		return this;
	}

	/**
	 * Click on Add Invoice Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickAddInvoice2Link() {
		JavascriptLibrary.javascriptClickElement(driver, addInvoice2);
		//addInvoice2.click();
		return this;
	}

	/*
	 * click on settings
	 */
	public HomePage clickOnSettings() {
		settings.click();
		return this;
	}

	/**
	 * Click on Apply For Credit Line Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickApplyForCreditLineLink() {
		applyForCreditLine.click();
		return this;
	}

	/**
	 * Click on Envelope Iconsmall Picture Of An Envelope Signifying An Email
	 * Address0how Can We Help Button.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickEnvelopeIconsmallPictureOfAnEnvelopeButton() {
		envelopeIconsmallPictureOfAnEnvelope.click();
		return this;
	}

	/**
	 * Click on Goto Expense List Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickGotoExpenseListLink() {
		gotoExpenseList.click();
		return this;
	}

	/*
	 * Click on company settings
	 */
	public HomePage clickCompanySetting() {
		companysettings.click();
		return this;
	}

	/**
	 * Click on Goto Invoice List Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickGotoInvoiceListLink() {
		gotoInvoiceList.click();
		return this;
	}

	/**
	 * Click on Help Supportnumberz.in Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickHelpSupportnumberzInLink() {
		helpSupportnumberzIn.click();
		return this;
	}

	/**
	 * Click on More Howto Guides Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickMoreHowtoGuidesLink() {
		moreHowtoGuides.click();
		return this;
	}

	/**
	 * Click on Send Button.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickSendButton() {
		send.click();
		return this;
	}

	/**
	 * Click on Sign Out Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickSignOutLink() {
		signOut.click();
		return this;
	}

	/**
	 * Click on Try It Now Link.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage clickTryItNowLink() {
		tryItNow.click();
		return this;
	}

	/**
	 * 
	 * 
	 * 
	 * /** Submit the form to target page.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage submit() {
		clickAddInvoice1Link();
		return this;
	}

	/**
	 * Verify that the page loaded completely.
	 *
	 * @return the HomePage class instance.
	 */
	public HomePage verifyPageLoaded() {
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
	 * @return the HomePage class instance.
	 */
	public HomePage verifyPageUrl() {
		(new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getCurrentUrl().contains(pageUrl);
			}
		});
		return this;
	}
}
