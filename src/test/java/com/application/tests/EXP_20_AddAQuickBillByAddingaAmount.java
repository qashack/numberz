package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;

public class EXP_20_AddAQuickBillByAddingaAmount extends BaseClass {
	String expensesSheet = "EXP_20";

	@Test(description = "Add a Quick Bill by adding a amount")
	public void AddAQuickBillByAddingaAmount() {
		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);

		String amountArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String amount = expensesBill.getRandomStringfromArray(amountArray, GenericUtils.randomNumber("10"));

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

		expenses.amoutInputSetText(amount);
		GenericUtils.delay(1);

		expenses.clickSaveLink();
	//	GenericUtils.delay(2);

		bill.verifyMessage();
		GenericUtils.delay(1);
	}

}
