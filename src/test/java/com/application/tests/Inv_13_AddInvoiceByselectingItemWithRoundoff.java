package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.TaxInvoicePage;

public class Inv_13_AddInvoiceByselectingItemWithRoundoff extends BaseClass {
	String sheetName = "INV_13";
	String item_name = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 9);
	String existing_customer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);
	String Price=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 10);
	@Test(description = "Add an Invoice by having a price with decimals and round it off. Verify the price calculations while checking/unchecking round off")
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
		invoicePage.setInvoiceToTextField(existing_customer);
		invoicePage.verifyPageUrl();
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Add an item
		 */
		invoicePage.setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		invoicePage.setSelectOrAddAnItemselect3NumberField(Price);
		//click on round of button
		invoicePage.clickOnRoundof();
		/*
		 * Verify Net Total
		 */
		invoicePage.verifyNetTotalDecimalValue();
		/*
		 * Click on send button
		 * 
		 */
		invoicePage.clickSend1Button();
		GenericUtils.delay(3);
		invoicePage.verifyMessage();
	
	}
}
