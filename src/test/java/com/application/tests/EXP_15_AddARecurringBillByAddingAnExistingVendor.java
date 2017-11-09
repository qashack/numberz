package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.ItemInfo;
import com.application.pages.PurchaseOrder;
import com.application.pages.Recurring;
import com.application.pages.VendorInformation;

public class EXP_15_AddARecurringBillByAddingAnExistingVendor extends BaseClass {

	String expensesSheet = "EXP_15";

	@Test(description = "")
	public void addARecurringBillByAddingAnExistingVendor() {

		HomePage homePage = new HomePage(driver);
		PurchaseOrder purchaseOrder = new PurchaseOrder(driver);
		Recurring recurring = new Recurring(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);

		String vendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String frequencyArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String frequency = expensesBill.getRandomStringfromArray(frequencyArray, GenericUtils.randomNumber("6"));
		String endDate = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String paymentTermsArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String paymentterm = expensesBill.getRandomStringfromArray(paymentTermsArray, GenericUtils.randomNumber("6"));
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
		GenericUtils.delay(2);

		GenericUtils.waitForLoadComplete(driver);
		purchaseOrder.recurringBtnClick();
		GenericUtils.delay(2);

		GenericUtils.waitForLoadComplete(driver);
		recurring.addRecurringBillBtnClick();
		GenericUtils.delay(2);

		recurring.selectOrAddVendorClick();
		GenericUtils.delay(2);

		recurring.selectOrAddVendorInputSetText(vendorName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.frequencyDropDownClick();
		GenericUtils.delay(2);

		recurring.frequencyInput(frequency);
		GenericUtils.delay(2);

		recurring.endDateClick();
		GenericUtils.delay(2);

		recurring.endDateSetText(endDate);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.expenseTypeDropDownClick();
		GenericUtils.delay(2);

		recurring.expenseTypeInputSetText(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.paymentTermsDropDownClick();
		GenericUtils.delay(2);

		recurring.paymentTermsInputSelect(paymentterm);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.itemNameclick();
		GenericUtils.delay(2);

		recurring.itemNameSetText(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.saveBtnClick();
		GenericUtils.delay(2);

		bill.getMessage();
		GenericUtils.delay(2);

	}

}
