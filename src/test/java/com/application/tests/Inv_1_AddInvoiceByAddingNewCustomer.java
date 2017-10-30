package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.CustomerInfo;
import com.application.pages.HomePage;
import com.application.pages.LoginPage;
import com.application.pages.TaxInvoicePage;

public class Inv_1_AddInvoiceByAddingNewCustomer extends BaseClass{
	
	String sheetName="INV_1";
	String newCustomer=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0)+GenericUtils.simpleDate();
	String email=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 1);
	String phone=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 2);
	
	
	
	@Test(description="Add an invoice by adding new customer")
	public void addInvoiceNewCustomer()
	{
		//Loging to an application
		new Login().loginApp(driver);
		//Click on add invoice button
		GenericUtils.delay(10);
		new HomePage(driver).clickAddInvoice1Link();
		GenericUtils.delay(10);
		/*
		 *Click on add new customer 
		 */
		CustomerInfo customerinfo=new CustomerInfo(driver);
		customerinfo.clickAddNewCustomerLink();
		/*
		 * Add new customer
		 */
		GenericUtils.delay(5);
		
		customerinfo.fillCustomerName(newCustomer);
		customerinfo.fillEmailTo(email);
		customerinfo.fillPhoneNumber(phone);
		//Add Billing address
		customerinfo.addAllBillingAddress(filePath_invoice, sheetName);
		//Add Shipping address
		customerinfo.addAllShippingAddress(filePath_invoice, sheetName);
		/*
		 * Add tds,gst,servicetax
		 */
		customerinfo.addAllTaxPan(filePath_invoice, sheetName);
		customerinfo.clickOnSaveButton();
		customerinfo.clickOnYesButton();
		customerinfo.verifyMessage();
		/*
		 * Add item
		 */
		
		String item_name=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 17);
		System.out.println(item_name);
		customerinfo.setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Add description,price,qty randomly,tax
		 */
		customerinfo.setSelectOrAddAnItemselect2TextareaField(GenericUtils.simpleDate());
		customerinfo.setSelectOrAddAnItemselect3NumberField(GenericUtils.randomNumber());
		customerinfo.setSelectOrAddAnItemselect4NumberField(GenericUtils.randomNumber());
	
		
		/*
		 * Click on send button
		 * 
		 */
		customerinfo.clickSend1Button();
		GenericUtils.delay(2);
		customerinfo.verifyMessage();
		/*
		 * Send an email
		 */
		customerinfo.clickEmailSendButton();
		GenericUtils.delay(2);
		customerinfo.verifyMessage();
		
		
		
		
	}
	
	
	

}
