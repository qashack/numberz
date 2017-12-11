package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.CustomerInfo;
import com.application.pages.HomePage;
import com.application.pages.ItemInformationPage;
import com.application.pages.Logout;
import com.application.pages.SettingsPage;

public class Init extends BaseClass{
	String sheetName = "Init";
	String gstNumberOld = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);

	@Test(description="Initilize the test data")
	public void initialize() {
		// Loging to an application
		new Login().loginApp(driver);
		// Click on add invoice button
		GenericUtils.waitForLoadComplete(driver);
		HomePage home = new HomePage(driver);
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Move to settings and change GST value
		 */
		SettingsPage setting = new SettingsPage(driver);
		addGstValue(home, setting, gstNumberOld);
		/*
		 * Add new customer 
		 */
		addNewCustomer(home);
		/*
		 * Add new item
		 */
		addNewItem();
		Logout lo=new Logout(driver);
		lo.logOut();
	}
	private void addGstValue(HomePage home, SettingsPage setting, String data) {

		home.clickOnSettings();
		GenericUtils.delay(3);
		home.clickCompanySetting();
		GenericUtils.waitForLoadComplete(driver);
		setting.fillGST(data);
		setting.clickOnSaveButton();
		GenericUtils.waitForLoadComplete(driver);

	}
	private void addNewCustomer(HomePage home) {
		String sheetName="INV_1";
		String newCustomer=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);
		String email=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 1);
		String phone=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 2);
		/*
		 * Click on add invoice button
		 */
		
		home.clickOnAddInvoiceInInvoice();
		GenericUtils.waitForLoadComplete(driver);
		/*
		 *Click on add new customer 
		 */
		CustomerInfo customerinfo=new CustomerInfo(driver);
		customerinfo.clickAddNewCustomerLink();
		/*
		 * Add new customer
		 */
		GenericUtils.waitForLoadComplete(driver);
		
		customerinfo.fillCustomerName((newCustomer+GenericUtils.simpleDate()));
		customerinfo.fillEmailTo(email);
		customerinfo.fillPhoneNumber(phone);
		//Add Billing address
		customerinfo.addAllBillingAddress(filePath_invoice, sheetName);
		//Add Shipping address
		customerinfo.addAllShippingAddress(filePath_invoice, sheetName);
		/*
		 * Add tds,gst,servicetax
		 */
		customerinfo.addAllTaxPanGSt(filePath_invoice, sheetName);
		customerinfo.ShowTDS();
		customerinfo.clickOnSaveButton();
		customerinfo.clickOnYesButton();
		customerinfo.verifyMessage();
	}
	private void addNewItem()
	{
		String sheetName = "INV_9";
		ItemInformationPage iteminfo = new ItemInformationPage(driver);
		/*
		 * Add new Item
		 */
		iteminfo.clickOnAddnewItem();
		iteminfo.addAllItemField(filePath_invoice, sheetName);
		iteminfo.clickSaveButton();
		GenericUtils.waitForLoadComplete(driver);
	}

}
