package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;

public class EXP_4_AddADetailedBillByAdingAExistingExpenseType extends BaseClass {

	String expensesSheet = "EXP_4";

	@Test(description = "Add a Detailed bill by adding a Existing expense type")
	public void addADetailedBillByAdingAExistingExpenseType() {

		HomePage homePage = new HomePage(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);

		String vendor = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String billNumber = expensesBill.generateRandomBillNumber();
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String paymentMethod = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);

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

		/*
		 * click on the select or Add vendor
		 */

		GenericUtils.delay(1);
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

		expensesBill.clickItemNameTextField();
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
