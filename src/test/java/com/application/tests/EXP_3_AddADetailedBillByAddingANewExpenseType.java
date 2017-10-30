package com.application.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;

public class EXP_3_AddADetailedBillByAddingANewExpenseType extends BaseClass {

	String expensesSheet = "EXP_3";

	@Test(description = "")
	public void addADetailedBillByAddingANewExpenseType() {
		new Login().loginApp(driver);
		GenericUtils.delay(2);
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
		String expenseTypeArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		int index = GenericUtils.randomNumber("5");
		String expenseType = expensesBill.getRandomStringfromArray(expenseTypeArray, index);
		System.out.println(index + " " + expenseType);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String price = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String quantity = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String tax = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String purchaseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
		String taxCredit = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);

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

		expensesBill.setSelectOrAddAnItemselect1TextareaField(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.clickSaveButton();
		GenericUtils.delay(2);
		
		expenses.clickAddDetailedBillButton();
		GenericUtils.delay(2);

		expensesBill.clickexpenseTypebtn();
		GenericUtils.delay(2);
		

	}

}
