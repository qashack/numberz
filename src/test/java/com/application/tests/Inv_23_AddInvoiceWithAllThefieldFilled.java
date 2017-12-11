package com.application.tests;

import java.io.File;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.TaxInvoicePage;

public class Inv_23_AddInvoiceWithAllThefieldFilled extends BaseClass{
	String sheetName = "INV_23";
	String item_name = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 9);
	String existing_customer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);
	String file = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 10);
	String paymentDetails=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 11);
	String termsAndConditions=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 12);
	String notes=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 13);
	
	
	@Test(description = "Send the Invoice creation email with all the data populated")
	public void addInvoiceExCustomer() {
		String abspath="./sample/"+file;
		File f=new File(abspath);
		String Abspath=f.getAbsolutePath();
		System.out.println(Abspath);
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
		invoicePage.AddAllItem(filePath_invoice, sheetName, item_name);
		/*
		 * Attach a file
		 */
		invoicePage.addAnAttachment(Abspath);
		//Add payment details
		invoicePage.setInvoicePaymentDetailsTextareaField(paymentDetails);
		//Add Terms and Conditions
		invoicePage.setTermsConditionsTextareaField(termsAndConditions);
		//Add Notes
		invoicePage.setNotesTextareaField(notes);
		/*
		 * Click on send button
		 * 
		 */
		invoicePage.clickSend1Button();
		GenericUtils.delay(1);
		invoicePage.verifyMessage();
		
	}
}
