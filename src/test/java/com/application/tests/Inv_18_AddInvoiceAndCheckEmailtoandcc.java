package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.CustomerInfo;
import com.application.pages.EmailPage;
import com.application.pages.HomePage;

public class Inv_18_AddInvoiceAndCheckEmailtoandcc extends BaseClass {
	String sheetName = "INV_18";
	String newCustomer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0) + GenericUtils.simpleDate();
	String email = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 1);
	String phone = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 2);
	String emailc=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 18);
	String item_name = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 17);
	
	@Test(description = "Send Invoice verify that the To and Cc is Auto-populated from the Invoice")
	public void addInvoiceNewCustomer() {
		// Loging to an application
		new Login().loginApp(driver);
		// Click on add invoice button
		GenericUtils.waitForLoadComplete(driver);
		new HomePage(driver).clickAddInvoice1Link();
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Click on add new customer
		 */
		CustomerInfo customerinfo = new CustomerInfo(driver);
		customerinfo.clickAddNewCustomerLink();
		/*
		 * Add new customer
		 */
		GenericUtils.waitForLoadComplete(driver);

		customerinfo.fillCustomerName(newCustomer);
		customerinfo.fillEmailTo(email);
		customerinfo.fillEmailcc(emailc);
		customerinfo.fillPhoneNumber(phone);
		// Add Billing address
		customerinfo.addAllBillingAddress(filePath_invoice, sheetName);
		// Add Shipping address
		customerinfo.addAllShippingAddress(filePath_invoice, sheetName);
		/*
		 * Add gst and other field
		 */
		customerinfo.addAllTaxPanGSt(filePath_invoice, sheetName);
		customerinfo.clickOnSaveButton();
		customerinfo.clickOnYesButton();
		customerinfo.verifyMessage();
		/*
		 * Add item
		 */
		GenericUtils.waitForLoadComplete(driver);
		customerinfo.AddAllItem(filePath_invoice, sheetName,item_name);
		/*
		 * Click on send button
		 * 
		 */
		customerinfo.clickSend1Button();
		GenericUtils.delay(3);
		customerinfo.verifyMessage();
		/*
		 * email verification
		 */
		EmailPage email=new EmailPage(driver);
		email.verifyEmailTocc();
		
		
		
	
	}
	
	
	
	
	

}
