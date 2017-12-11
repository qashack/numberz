package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.VendorInformation;

public class EXP_22_AddNotesInTheQuickBill extends BaseClass {
	String expensesSheet = "EXP_22";

	@Test(description = "Add notes in the quick bill")
	public void addNotesInTheQuickBill() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);

		String amount = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String note = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		

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

		GenericUtils.waitForLoadComplete(driver);
		expenses.amoutInputSetText(amount);
		GenericUtils.delay(1);
		
		expenses.noteBtnClick();
		GenericUtils.delay(1);
		
		expenses.noteTextAreaSetText(note);
		GenericUtils.delay(1);
		
		expenses.saveNoteBtnClick();
		GenericUtils.delay(1);
		
		expenses.clickSaveLink();
		//GenericUtils.delay(2);
		
		vendorInfo.clickOnYesButton();

		bill.verifyMessage();
		GenericUtils.delay(1);
		
	}
	

}
