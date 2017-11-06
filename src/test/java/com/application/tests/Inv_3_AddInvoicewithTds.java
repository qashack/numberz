package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.CustomerInfo;
import com.application.pages.HomePage;

public class Inv_3_AddInvoicewithTds extends BaseClass {
	String sheetName = "INV_3";
	String customer[] = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0).split(",");
	String existingCustomer = customer[1];
	String newCustomer = customer[0];
	String email = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 1);
	String phone = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 2);
	String tds = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 16);

	@Test(description = "Add an invoice with TDS enabled")
	public void addInvoice() {
		// Login
		new Login().loginApp(driver);
		// Click on add invoice button
		GenericUtils.waitForLoadComplete(driver);
		new HomePage(driver).clickAddInvoice1Link();
		GenericUtils.waitForLoadComplete(driver);
		// Select existing customer
		CustomerInfo customerinfo = new CustomerInfo(driver);
		customerinfo.setInvoiceToTextField(existingCustomer);
		GenericUtils.sendEnterKeys(driver);
		customerinfo.clickEditCustomer();
		// Update tds value
		customerinfo.updateTDS(tds);
		customerinfo.clickOnUpdate();
		customerinfo.clickOnYesButton();
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Add an item And verify tds amount
		 */
		customerinfo.AddAllItem(filePath_invoice, sheetName);
		customerinfo.verifyTDSAmount();
		/*
		 * Click on send button
		 * 
		 */
		customerinfo.clickSend1Button();
		GenericUtils.delay(3);
		customerinfo.verifyMessage();

	}

}
