package com.application.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;

public class EXP_5_AddADetailedBillByAddingANewItem extends BaseClass {
	String expensesSheet = "EXP_5";

	@FindBy(linkText = "Select or Add an item")
	private WebElement selectOrAddItem;

	@FindBy(id = "line-item-0")
	private WebElement selectOrAddAnItemselect1;

	@Test(description = "")
	public void addADetailedBillByAddingANewItem() {

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
		ExpensesBill bill = new ExpensesBill(driver);
		Expenses expenses = new Expenses(driver);
		expenses.clickAddDetailedBillButton();
		GenericUtils.delay(3);
		// bill.dropdownSelectOrAddVendorClick();
		// GenericUtils.delay(2);
		// bill.clickAddNewVendor();

		/*
		 * click on the select or Add vendor
		 */

		ExpensesBill expensesBill = new ExpensesBill(driver);
		// String vendor = ExcelLibrary.getExcelData(filePath, expensesSheet, 1,
		// 0);
		// String billNumber = ExcelLibrary.getExcelData(filePath,
		// expensesSheet, 1, 1);
		// String expenseType = ExcelLibrary.getExcelData(filePath,
		// expensesSheet, 1, 2);
		// String refHash = ExcelLibrary.getExcelData(filePath, expensesSheet,
		// 1, 3);
		// String paymentTerms = ExcelLibrary.getExcelData(filePath,
		// expensesSheet, 1, 4);
		// String paymentMethod = ExcelLibrary.getExcelData(filePath,
		// expensesSheet, 1, 5);
		// String itemName = ExcelLibrary.getExcelData(filePath, expensesSheet,
		// 1, 6);

		// GenericUtils.delay(2);
		// expensesBill.setBillFromTextField(vendor);
		// GenericUtils.sendEnterKeys(driver);
		// GenericUtils.delay(2);
		//
		// expensesBill.setBillTextField(billNumber);
		// GenericUtils.sendEnterKeys(driver);
		// GenericUtils.delay(2);
		//
		// expensesBill.setExpenseTypeTextField(expenseType);
		// GenericUtils.sendEnterKeys(driver);
		// GenericUtils.delay(2);
		//
		// expensesBill.setRefTextField(refHash);
		// GenericUtils.sendEnterKeys(driver);
		// GenericUtils.delay(2);
		//
		// expensesBill.setPaymentTermsDropDownListField(paymentTerms);
		// GenericUtils.sendEnterKeys(driver);
		// GenericUtils.delay(2);
		//
		// expensesBill.setPaymentMethodDropDownListField(paymentMethod);
		// GenericUtils.sendEnterKeys(driver);
		// GenericUtils.delay(2);

		GenericUtils.delay(2);
		selectOrAddItem.click();
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

	}

}
