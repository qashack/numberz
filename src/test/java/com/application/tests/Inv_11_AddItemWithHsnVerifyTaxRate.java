package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.ItemInformationPage;

public class Inv_11_AddItemWithHsnVerifyTaxRate extends BaseClass {
	String sheetName = "INV_11";

	@Test(description = "Add an item with the HSN tax rate should get auto populated")
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
		iteminfo.verifyHSNTaxField();
		

	}

}
