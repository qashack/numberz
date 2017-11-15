package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.VendorInformation;

public class EXP_25_WhenTheUserGivesTheGSTINVerifyThatTheReverseChargeAndCompositionVendorHaveBothCheckAndUncheckOption extends BaseClass {
	String expensesSheet = "EXP_25";

	@Test(description = "When the user gives the GSTIN verify that the reverse charge and Composition Vendor have both check and uncheck option")
	public void whenTheUserGivesTheGSTINVerifyThatTheReverseChargeAndCompositionVendorHaveBothCheckAndUncheckOption() {
		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);
		
		String gstInString = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		
		/**
		 * Login to website using username and password
		 */
		new Login().loginApp(driver);
		/*
		 * click on the expenses link
		 */
		GenericUtils.waitForLoadComplete(driver);
		homePage.clickGotoExpenseListLink();
		GenericUtils.delay(1);
		
		/*
		 * click on the Add detailed bill button
		 */
		GenericUtils.waitForLoadComplete(driver);
		expenses.clickAddDetailedBillButton();
		
		GenericUtils.waitForLoadComplete(driver);
		bill.dropdownSelectOrAddVendorClick();
		GenericUtils.delay(1);

		bill.clickAddNewVendor();
		GenericUtils.delay(1);
		
		vendorInfo.setGstInTextField(gstInString);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(10);
		
		
		
	}
}
