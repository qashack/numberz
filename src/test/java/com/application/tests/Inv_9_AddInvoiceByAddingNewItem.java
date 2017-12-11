package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.ItemInformationPage;
import com.application.pages.TaxInvoicePage;

public class Inv_9_AddInvoiceByAddingNewItem extends BaseClass {
	String sheetName = "INV_9";

	@Test(description = "Add an Invoice by adding a New Item to the list. Verify the entered details in item modal is present in the invoices page")
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
		ItemInformationPage iteminfo = new ItemInformationPage(driver);
		/*
		 * Add tax invoice to existing customer
		 */
		String existing_customer = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);
		System.out.println(existing_customer);

		iteminfo.setInvoiceToTextField(existing_customer);
		iteminfo.verifyPageUrl();
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Add new Item
		 */
		iteminfo.clickOnAddnewItem();
		iteminfo.addAllItemField(filePath_invoice, sheetName);
		iteminfo.clickSaveButton();
		
		/*
		 * Click on send button
		 * 
		 */
		GenericUtils.waitForLoadComplete(driver);
		iteminfo.clickSend1Button();
		GenericUtils.delay(1);
		iteminfo.verifyMessage();

	}

}
