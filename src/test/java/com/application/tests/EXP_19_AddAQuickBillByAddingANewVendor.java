package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.VendorInformation;

public class EXP_19_AddAQuickBillByAddingANewVendor extends BaseClass {

	String expensesSheet = "EXP_19";

	@Test(description = "Add a Quick bill by adding a New vendor")
	public void AddAQuickBillByAddingANewVendor() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);

		String vendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String emailId = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String phone = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String accountNumber = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String ifscCode = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String gstInString = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String amountArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String amount = expensesBill.getRandomStringfromArray(amountArray, GenericUtils.randomNumber("10"));

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

		expenses.selectOrAddVendor();
		GenericUtils.delay(1);

		expensesBill.addNewVendorquickBill();
		GenericUtils.delay(1);

		vendorInfo.setVendorNameTextField(vendorName+GenericUtils.simpleDate());
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		vendorInfo.setEmailEmailField(emailId);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		vendorInfo.setPhoneTextField(phone);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		vendorInfo.setAccountNumberTextField(accountNumber);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		vendorInfo.setIfscTextField(ifscCode);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		vendorInfo.setGstInTextField(gstInString);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		vendorInfo.clickSave1Button();
		//GenericUtils.delay(2);
		
		bill.verifyMessage();
		GenericUtils.delay(2);

		expenses.amoutInputSetText(amount);
		GenericUtils.delay(1);

		expenses.clickSaveLink();
	//	GenericUtils.delay(2);

		bill.verifyMessage();
		GenericUtils.delay(1);

	}
}
