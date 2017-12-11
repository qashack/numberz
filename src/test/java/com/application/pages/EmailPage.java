package com.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.application.libraries.GenericUtils;

public class EmailPage extends TaxInvoicePage {
	WebDriver driver;
	@FindBy(xpath = "//div[@class='modal-body']//button[text()='Send']")
	private WebElement emailSendButton;

	@FindBy(xpath = "//div[@class='modal-body']//button[text()='Cancel']")
	private WebElement emailcancelButton;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Email ID']")
	private WebElement emailtoField1;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Use comma(,) to add multiple emails']")
	private WebElement emailccField1;

	@FindBy(xpath = "//div[@class='modal-body']//input[@placeholder='Subject']")
	private WebElement emailSubjectField;

	@FindBy(xpath = "//body[@id='tinymce']/p")
	private WebElement emailBody;

	@FindBy(xpath = "(//div[@class='modal-body']//input[@type='checkbox'])[1]")
	private WebElement emailGetFinance;

	@FindBy(xpath = "(//div[@class='modal-body']//input[@type='checkbox'])[2]")
	private WebElement emailPayNow;

	public EmailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public EmailPage addEmailTo(String emailto) {
		emailtoField1.clear();
		emailtoField1.sendKeys(emailto);
		return this;
	}

	public EmailPage addEmailCc(String emailcc) {
		emailccField1.clear();
		emailccField1.sendKeys(emailcc);
		return this;
	}

	public EmailPage verifyEmailTocc() {
		String emailTo = emailtoField1.getAttribute("value");
		String emailcc = emailccField1.getAttribute("value");
		System.out.println("email to" + emailTo + ":emailcc" + emailcc);
		int et = emailTo.length();
		int et1 = emailcc.length();
		System.out.println("t and t1" + et + " :" + et1);
		if ((et1 == 0) || (et == 0)) {
			Assert.assertFalse(true, "Email to and cc not populated Automatically");

		} else {

			Assert.assertTrue(true);
		}
		return this;
	}

	public EmailPage verifyEmailSubject(String data) {
		String subject = emailSubjectField.getAttribute("value");
		if (subject.contains(data)) {
			Assert.assertFalse(true, "Subject not populated properly");
		} else {
			Assert.assertTrue(true);
		}

		return this;
	}

	public EmailPage verifyEmailBody(String data) {
		driver.switchTo().frame("react-tinymce-0_ifr");
		String subject = emailBody.getText();
		if (subject.contains(data)) {
			Assert.assertFalse(true, "Subject not populated properly");
		} else {
			Assert.assertTrue(true);
		}

		return this;
	}

	public EmailPage clickOnGetFinance() {
		GenericUtils.delay(2);
		if (!emailGetFinance.isSelected()) {
			emailGetFinance.click();
		}

		return this;

	}

	public EmailPage verifyGetFianance(int k) {
		System.out.println("k is" + k);
		if (k > 0) {

		} else {
			Assert.fail("Get fianance is not in recieved email");
		}
		return this;
	}

	public EmailPage setEmailTo(String email_to) {
		emailtoField1.clear();
		emailtoField1.sendKeys(email_to);
		return this;
	}

	public EmailPage clickOnPayNow() {
		if (!emailPayNow.isSelected()) {
			emailPayNow.click();
		}
		return this;

	}

	public EmailPage verifyPaynowOptions() {
		GenericUtils.delay(2);
		int op1 = driver.findElements(By.id("rzp-key-number")).size();
		int op2 = driver.findElements(By.id("rzp-secret-number")).size();
		int op0 = driver.findElements(By.xpath("//label[text()='Select Payment Method']")).size();
		if (op1 == 0 || op0 == 0 || op2 == 0) {
			Assert.fail("Pay now  all options are not displayed");
		} else {
			Assert.assertTrue(true);
		}

		return this;
	}

}
