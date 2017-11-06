package com.application.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.TaxInvoicePage;

public class Inv_10_AddInvoiceForExistingItem extends BaseClass {
	String sheetName= "INV_10";

	@Test(description = "Add an Invoice by adding an Existing Item to the list. Verify with the previous data in existing item")
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
		String existing_customer=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);
		System.out.println(existing_customer);
		TaxInvoicePage invoicePage=new TaxInvoicePage(driver);
		System.out.println(invoicePage.verifyPageLoaded());
		invoicePage.setInvoiceToTextField(existing_customer);
		invoicePage.verifyPageUrl();
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Add an item
		 */
		String item_name=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 9);
		System.out.println(item_name);
		invoicePage.setSelectOrAddAnItemselect1TextareaField(item_name);
		GenericUtils.sendEnterKeys(driver);
		invoicePage.verifyExistingItem();
		/*
		 * Click on send button
		 * 
		 */
		invoicePage.clickSend1Button();
		GenericUtils.delay(3);
		invoicePage.verifyMessage();
		

	}
}