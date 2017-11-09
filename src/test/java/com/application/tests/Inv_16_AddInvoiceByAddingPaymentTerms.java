package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.TaxInvoicePage;

public class Inv_16_AddInvoiceByAddingPaymentTerms  extends BaseClass{
	String sheetName = "INV_16";
	String item_name = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 9);
	String existing_customer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);
	String Payment_terms= ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 10);
	
	
	@Test(description = "Add an Invoice by changing the payment terms to different values available. Verify the due date (if NET 7 is selected the due date should be after seven days from the current date)")
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
		
		TaxInvoicePage invoicePage = new TaxInvoicePage(driver);
		//System.out.println(invoicePage.verifyPageLoaded());
		invoicePage.setInvoiceToTextField(existing_customer);
		invoicePage.verifyPageUrl();
		GenericUtils.sendEnterKeys(driver);
		//Send payment terms
		invoicePage.setPaymentTermsDropDownListField(Payment_terms);
		//Verify due date
		invoicePage.verifyDueDate(Payment_terms);
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
		invoicePage.verifyMessage();
		
		
		
		
	
	}
}
