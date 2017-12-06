package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.PurchaseOrder;
import com.application.pages.Recurring;

public class EXP_15_AddARecurringBillByAddingAnExistingVendor extends BaseClass {

	String expensesSheet = "EXP_15";

	@Test(description = "Add a Recurring Bill by adding an Existing vendor")
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
		GenericUtils.delay(1);

		GenericUtils.waitForLoadComplete(driver);
		purchaseOrder.recurringBtnClick();
		GenericUtils.delay(1);

		GenericUtils.waitForLoadComplete(driver);
		recurring.addRecurringBillBtnClick();
		GenericUtils.delay(1);

		recurring.selectOrAddVendorClick();
		GenericUtils.delay(1);

		recurring.selectOrAddVendorInputSetText(vendorName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		recurring.frequencyDropDownClick();
		GenericUtils.delay(1);

		recurring.frequencyInput(frequency);
		GenericUtils.delay(1);

		recurring.endDateClick();
		GenericUtils.delay(1);

		recurring.endDateSetText(endDate);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		recurring.expenseTypeDropDownClick();
		GenericUtils.delay(1);

		recurring.expenseTypeInputSetText(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		recurring.paymentTermsDropDownClick();
		GenericUtils.delay(1);

		recurring.paymentTermsInputSelect(paymentterm);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		recurring.itemNameclick();
		GenericUtils.delay(1);

		recurring.itemNameSetText(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		recurring.saveBtnClick();
		//GenericUtils.delay(2);

		bill.verifyMessage();
		GenericUtils.delay(1);

	}

}
