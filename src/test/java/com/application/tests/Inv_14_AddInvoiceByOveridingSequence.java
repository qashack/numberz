package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.TaxInvoicePage;

public class Inv_14_AddInvoiceByOveridingSequence extends BaseClass {
	
	String sheetName = "INV_14";
	String item_name = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 9);
	String existing_customer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);

	@Test(description = "Add an Invoice by overriding the Invoice# sequence")
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
		//Click on Sequence override
		invoicePage.clickInvoiceOverideSequence();
		//Send sequence Number
		String number=("1000"+Integer.toString(GenericUtils.randomNumber("1000")));
		invoicePage.setInvoiceSequenceTextField(number);
		/*
		 * Add an item
		 */
		invoicePage.AddAllItem(filePath_invoice, sheetName,item_name);
		/*
		 * Click on send button
		 * 
		 */
		invoicePage.clickSend1Button();
		GenericUtils.delay(2);
		invoicePage.setYesInSequenceOverride();
		GenericUtils.delay(2);
		invoicePage.verifyMessage();
		
		
	}

}
