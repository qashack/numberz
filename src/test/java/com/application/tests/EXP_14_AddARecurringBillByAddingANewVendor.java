package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.PurchaseOrder;
import com.application.pages.Recurring;
import com.application.pages.VendorInformation;

public class EXP_14_AddARecurringBillByAddingANewVendor extends BaseClass {

	String expensesSheet = "EXP_14";

	@Test(description = "Add a Recurring Bill by adding a New vendor")
	public void addARecurringBillByAddingANewVendor() {

		HomePage homePage = new HomePage(driver);
		PurchaseOrder purchaseOrder = new PurchaseOrder(driver);
		Recurring recurring = new Recurring(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		
		String vendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String emailId = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String phone = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String accountNumber = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String ifscCode = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String gstInString = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String frequency = ExcelLibrary.getExcelData(filePath_Expence,expensesSheet, 1, 6);
		String endDate = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);
		String paymentTerm = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 9);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 10);
		

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

		recurring.addRecurringBillBtnClick();
		GenericUtils.delay(1);

		recurring.selectOrAddVendorClick();
		GenericUtils.delay(1);

		recurring.addNewVendorClick();
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

		vendorInfo.saveVendorRecurringBillClick();
		GenericUtils.delay(2);
		
		bill.verifyMessage();
		GenericUtils.delay(2);
		
		recurring.frequencyDropDownClick();
		GenericUtils.delay(1);

		recurring.frequencyInput(frequency);
		GenericUtils.sendEnterKeys(driver);
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

		recurring.paymentTermsInputSelect(paymentTerm);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		recurring.itemNameclick();
		GenericUtils.delay(1);

		recurring.itemNameSetText(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		recurring.saveBtnClick();
		GenericUtils.delay(2);

		bill.verifyMessage();
		GenericUtils.delay(1);

	}

}
