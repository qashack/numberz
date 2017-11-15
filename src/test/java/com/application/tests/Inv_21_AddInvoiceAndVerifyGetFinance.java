package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.EmailPage;
import com.application.pages.HomePage;
import com.application.pages.TaxInvoicePage;

public class Inv_21_AddInvoiceAndVerifyGetFinance extends BaseClass {
	String sheetName = "INV_21";
	String item_name = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 9);
	String existing_customer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);

	@Test(description = "Send Invoice creation email by checking the Get Finance check box. Verify the option in the email received")
	public void addInvoiceExCustomer() {
		/*
		 * Login into application
		 */
		new Login().loginApp(driver);

		/*
		 * Open Home page
		 */
		GenericUtils.waitForLoadComplete(driver);
		HomePage homepage = new HomePage(driver);
		homepage.clickAddInvoice2Link();
		GenericUtils.waitForLoadComplete(driver);

		/*
		 * Add tax invoice to existing customer
		 */
		System.out.println(existing_customer);
		TaxInvoicePage invoicePage = new TaxInvoicePage(driver);
		System.out.println(invoicePage.verifyPageLoaded());
		invoicePage.setInvoiceToTextField(existing_customer);
		invoicePage.verifyPageUrl();
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Add an item
		 */
		invoicePage.setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Click on send button
		 * 
		 */
		invoicePage.clickSend1Button();
		GenericUtils.delay(2);
		invoicePage.verifyMessage();
		/*
		 * Click on get finance method 
		 */
		EmailPage email=new EmailPage(driver);
		email.clickOnGetFinance();
		
		
	}

}
