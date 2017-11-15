package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;

public class EXP_21_AddFileAttachmentInTheQuickBill extends BaseClass {
	String expensesSheet = "EXP_21";

	@Test(description = "Add file attachment in the quick bill")
	public void addFileAttachmentInTheQuickBill() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill bill = new ExpensesBill(driver);

		String amount = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String path = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);

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

		expenses.quickbillAttachmentclick();
		GenericUtils.delay(1);

		expenses.attachFilePathSetPath(path);
		GenericUtils.delay(1);
		
		expenses.saveAttachmentBtnClick();
		GenericUtils.delay(1);

		expenses.clickSaveLink();
		GenericUtils.delay(2);

		bill.verifyMessage();
		GenericUtils.delay(1);

	}
}
