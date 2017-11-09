package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.TaxInvoicePage;

public class Inv_12_AddInvoiceByAddingDiscountAndVerifyit extends BaseClass{
	
	String sheetName = "INV_12";
	String item_name = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 9);
	String discount=ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 10);
	String existing_customer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);

	@Test(description = "Add an Invoice by adding a discount to the actual price. Verify the price calculation")
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
		System.out.println(invoicePage.verifyPageLoaded());
		invoicePage.setInvoiceToTextField(existing_customer);
		invoicePage.verifyPageUrl();
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Add an item
		 */
		invoicePage.AddAllItem(filePath_invoice, sheetName,item_name);
		//Add discount
		invoicePage.setDiscount1NumberField(discount);
		//Verify Amount
		invoicePage.verifyDiscountAmount();
		/*
		 * Click on send button
		 * 
		 */
		invoicePage.clickSend1Button();
		GenericUtils.delay(3);
		invoicePage.verifyMessage();
	}
	

}
