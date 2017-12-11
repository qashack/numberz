package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.EmailPage;
import com.application.pages.HomePage;
import com.application.pages.SettingsPage;
import com.application.pages.TaxInvoicePage;

public class Inv_19_AddInvoiceAndVerifyEmailSubject extends BaseClass {

	String sheetName = "INV_19";
	String item_name = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 9);
	String existing_customer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);
	String email_subject;

	@Test(description = "Verify the Subject of the email contains appropriate details from the invoice as per the expectation in the settings")
	public void addInvoiceExCustomer() {
		/*
		 * Login into application
		 */
		new Login().loginApp(driver);
		// Click on add invoice button
		GenericUtils.waitForLoadComplete(driver);
		HomePage home = new HomePage(driver);
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Move to settings and click on email link
		 */
		home.clickOnSettings();
		GenericUtils.delay(2);
		home.clickCompanySetting();
		GenericUtils.waitForLoadComplete(driver);
		SettingsPage setting = new SettingsPage(driver);
		setting.clickOnEmailLink();
		// Get subject text
		email_subject = setting.getEmailSubject();
		/*
		 * Click on Invoice and add Invoice
		 */
		setting.clickOnSaveButton();
		GenericUtils.waitForLoadComplete(driver);
		home.clickOnAddInvoiceInInvoice();
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Add tax invoice to existing customer
		 */
		TaxInvoicePage invoicePage = new TaxInvoicePage(driver);
		invoicePage.setInvoiceToTextField(existing_customer);
		invoicePage.verifyPageUrl();
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Add item
		 */
		invoicePage.setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Click on send button
		 * 
		 */
		invoicePage.clickSend1Button();
		GenericUtils.delay(1);
		invoicePage.verifyMessage();
		/*
		 * Email verify subject
		 */
		EmailPage emailp = new EmailPage(driver);
		emailp.verifyEmailSubject(email_subject);

	}
}
