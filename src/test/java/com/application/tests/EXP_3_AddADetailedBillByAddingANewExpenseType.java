package com.application.tests;

import org.testng.annotations.Test;
import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.VendorInformation;

public class EXP_3_AddADetailedBillByAddingANewExpenseType extends BaseClass {

	String expensesSheet = "EXP_3";

	@Test(description = "Add a Detailed bill by adding a New expense type")
	public void addADetailedBillByAddingANewExpenseType() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);
		
		String vendor = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String billNumber = expensesBill.generateRandomBillNumber();
		String expenseTypeArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String expenseType = expensesBill.getRandomStringfromArray(expenseTypeArray, GenericUtils.randomNumber("2"));
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);

		/**
		 * Login to website using username and password
		 */
		new Login().loginApp(driver);
		GenericUtils.delay(1);
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

		expensesBill.setSelectOrAddAnItemselect1TextareaField(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.clickSaveButton();
		//GenericUtils.delay(2);
		
		vendorInfo.clickOnYesButton();
		
		expensesBill.verifyMessage();
		GenericUtils.delay(2);
		
		GenericUtils.waitForLoadComplete(driver);
		expenses.clickAddDetailedBillButton();

		GenericUtils.waitForLoadComplete(driver);
		expensesBill.clickexpenseTypebtn();
		GenericUtils.delay(1);

		expensesBill.checkOptionExistsOrNot(expenseType);
		GenericUtils.delay(2);

	}

}
