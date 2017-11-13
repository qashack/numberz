package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;

public class EXP_6_AddAndVerifyADetailedBillByAddingAnExistingItemVerifyThatTheAmountTaxRateAsSelectedItemModal
		extends BaseClass {
	String expensesSheet = "EXP_6";

	@Test(description = "Add and verify a Detailed bill by adding an Existing item verify that the amount, tax rate as selected item modal")
	public void AddAndVerifyADetailedBillByAddingAnExistingItemVerifyThatTheAmountTaxRateAsSelectedItemModal() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);

		String vendor = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String billNumber = expensesBill.generateRandomBillNumber();
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String paymentMethod = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);

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

		/*
		 * click on the select or Add vendor
		 */
		
		GenericUtils.waitForLoadComplete(driver);
		expensesBill.setBillFromTextField(vendor);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setBillTextField(billNumber);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setExpenseTypeTextField(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setPaymentTermsDropDownListField(paymentTerms);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setPaymentMethodDropDownListField(paymentMethod);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setSelectOrAddAnItemselect1TextareaField(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.clickSaveButton();
		GenericUtils.delay(2);
		
		expensesBill.verifyMessage();
		GenericUtils.delay(1);
	}

}
