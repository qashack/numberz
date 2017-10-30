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

	@Test(description = "")
	public void AddAndVerifyADetailedBillByAddingAnExistingItemVerifyThatTheAmountTaxRateAsSelectedItemModal() {

		new Login().loginApp(driver);
		/*
		 * click on the expenses link
		 */
		HomePage homePage = new HomePage(driver);
		homePage.clickGotoExpenseListLink();
		GenericUtils.delay(2);
		/*
		 * click on the Add detailed bill button
		 */
		Expenses expenses = new Expenses(driver);
		expenses.clickAddDetailedBillButton();
		GenericUtils.delay(2);

		/*
		 * click on the select or Add vendor
		 */

		ExpensesBill expensesBill = new ExpensesBill(driver);
		String vendor = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String billNumber = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String paymentMethod = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);

		GenericUtils.delay(2);
		expensesBill.setBillFromTextField(vendor);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setBillTextField(billNumber);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setExpenseTypeTextField(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setPaymentTermsDropDownListField(paymentTerms);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setPaymentMethodDropDownListField(paymentMethod);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setSelectOrAddAnItemselect1TextareaField(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.clickSaveButton();

		expensesBill.verifyMessage();

	}

}
