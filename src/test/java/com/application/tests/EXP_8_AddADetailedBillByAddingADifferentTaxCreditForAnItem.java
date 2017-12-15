package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.VendorInformation;

public class EXP_8_AddADetailedBillByAddingADifferentTaxCreditForAnItem extends BaseClass {

	String expensesSheet = "EXP_8";

	@Test(description = "Add a Detailed bill by adding a different Tax Credit for an item")
	public void addADetailedBillByAddingADifferentTaxCreditForAnItem() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);

		String vendor = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String billNumber = expensesBill.generateRandomBillNumber();
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String paymentMethod = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String taxCredit = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);

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

		expensesBill.clickorSelectTaxCredit(taxCredit);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.clickSaveButton();
	//	GenericUtils.delay(2);
		
		vendorInfo.clickOnYesButton();

		expensesBill.verifyMessage();
		GenericUtils.delay(1);

	}
}
