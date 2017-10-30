package com.application.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.LoginPage;
import com.application.pages.TaxInvoicePage;



public class Inv_2_AddInvoiceToExistingCustomer extends BaseClass {
	String sheetName_invoice="INV_2";
	@Test(description="To test  add invoice to existing customer")
	public void addInvoiceExCustomer()
	{
		/*
		 * Login into application
		 */
		new Login().loginApp(driver);
		
		/*
		 * Open Home page
		 */
		GenericUtils.delay(10);
		HomePage homepage=new HomePage(driver);
		homepage.clickAddInvoice2Link();
		GenericUtils.delay(10);
		
		/*
		 * Add tax invoice to existing customer
		 */
		String existing_customer=ExcelLibrary.getExcelData(filePath_invoice, sheetName_invoice, 1, 0);
		System.out.println(existing_customer);
		TaxInvoicePage invoicePage=new TaxInvoicePage(driver);
		System.out.println(invoicePage.verifyPageLoaded());
		invoicePage.setInvoiceToTextField(existing_customer);
		invoicePage.verifyPageUrl();
		//invoicePage.verifyPageLoaded();
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(10);
		/*
		 * Add an item
		 */
		String item_name=ExcelLibrary.getExcelData(filePath_invoice, sheetName_invoice, 1, 9);
		System.out.println(item_name);
		invoicePage.setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		/*
		 * Add description,price,qty randomly,tax
		 */
		invoicePage.setSelectOrAddAnItemselect2TextareaField(GenericUtils.simpleDate());
		invoicePage.setSelectOrAddAnItemselect3NumberField(GenericUtils.randomNumber());
		invoicePage.setSelectOrAddAnItemselect4NumberField(GenericUtils.randomNumber());
		invoicePage.AddTaxorAlter();
		
		/*
		 * Click on send button
		 * 
		 */
		invoicePage.clickSend1Button();
		GenericUtils.delay(2);
		invoicePage.verifyMessage();
		/*
		 * Send an email
		 */
		invoicePage.clickEmailSendButton();
		GenericUtils.delay(2);
		invoicePage.verifyMessage();
	
	}
	
	
	

}
