package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;

public class EXP_24_SelectTheRecurringCheckBoxClickSaveVerifyItsGotCreatedInRecurringBill extends BaseClass {
	String expensesSheet = "EXP_24";

	@Test(description = "Select the recurring check box click save verify its got created in recurring bill")
	public void selectTheRecurringCheckBoxClickSaveVerifyItsGotCreatedInRecurringBill() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill bill = new ExpensesBill(driver);

		String amount = bill.generateRandomBillNumber();
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String paymentToVendor = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String PaymentMethod = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String billRefNumber = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String purchaseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String taxCredit = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String frequencyArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String frequency = bill.getRandomStringfromArray(frequencyArray, GenericUtils.randomNumber("6"));
		String endDate = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);

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

		expenses.expenseTypeDropdownClick();
		GenericUtils.delay(1);

		expenses.expenseTypeInputSetText(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.paymentToVendorDropdownClick();
		GenericUtils.delay(1);

		expenses.paymentToVendorInputSetText(paymentToVendor);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.paymentMethodDropdownClick();
		GenericUtils.delay(1);

		expenses.paymentMethodInputSetText(PaymentMethod);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.quickbillRefNumberSetText(billRefNumber);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.purchaseTypeDropDown();
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.purchaseTypeInputSetText(purchaseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.taxCreditDropDown();
		GenericUtils.delay(1);

		expenses.taxCreditInputSetText(taxCredit);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.recurringBillCheckBoxClick();
		GenericUtils.delay(1);

		expenses.frequencyDropdownClick();
		GenericUtils.delay(1);

		expenses.frequencySetText(frequency);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.endDateInputSetText(endDate);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expenses.saveBtnClick();
		GenericUtils.delay(1);

		expenses.clickSaveLink();
		GenericUtils.delay(2);

		bill.verifyMessage();
		GenericUtils.delay(2);

		GenericUtils.waitForLoadComplete(driver);
		expenses.clickRecurringLink();
		GenericUtils.delay(1);

	}
}
