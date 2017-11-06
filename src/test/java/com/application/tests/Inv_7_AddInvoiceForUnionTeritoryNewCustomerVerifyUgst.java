package com.application.tests;

import org.testng.annotations.Test;
import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.CustomerInfo;
import com.application.pages.HomePage;
import com.application.pages.SettingsPage;

public class Inv_7_AddInvoiceForUnionTeritoryNewCustomerVerifyUgst extends BaseClass {
	String sheetName = "INV_7";
	String newCustomer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0) + GenericUtils.simpleDate();
	String email = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 1);
	String phone = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 2);
	String gstNumberNew = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 15);
	String gstNumberOld = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 18);

	@Test(description = "Add an Invoice by adding/selecting a customer who is in a union territory. Verify the UTGST section in the Invoice")
	public void addInvoiceNewCustomer() {
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
		addGstValue(home, setting, gstNumberNew);
		/*
		 * Click on add invoice button
		 */
		GenericUtils.waitForLoadComplete(driver);
		home.clickOnAddInvoiceInInvoice();
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
		customerinfo.AddAllItem(filePath_invoice, sheetName);
		/*
		 * Verify IGSt of same state
		 */
		customerinfo.verifyGSt("UTGST");
		/*
		 * Click on send button
		 * 
		 */
		customerinfo.clickSend1Button();

		GenericUtils.delay(3);
		customerinfo.verifyMessage();
		GenericUtils.waitForLoadComplete(driver);
		customerinfo.clickEmailCanceButton();
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Replace the old gst of company
		 */
		addGstValue(home, setting, gstNumberOld);
	}

	private void addGstValue(HomePage home, SettingsPage setting, String data) {

		home.clickOnSettings();
		GenericUtils.delay(3);
		home.clickCompanySetting();
		GenericUtils.waitForLoadComplete(driver);
		setting.fillGST(data);
		setting.clickOnSaveButton();
		

	}

}
