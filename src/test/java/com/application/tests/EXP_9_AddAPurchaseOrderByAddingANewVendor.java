package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.PurchaseOrder;
import com.application.pages.PurchaseOrderNewVendor;

public class EXP_9_AddAPurchaseOrderByAddingANewVendor extends BaseClass {
	String expensesSheet = "EXP_9";

	@Test(description = "")
	public void addAPurchaseOrderByAddingANewVendor() {
		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		PurchaseOrderNewVendor newVendorAdd = new PurchaseOrderNewVendor(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		PurchaseOrder purchaseOrder = new PurchaseOrder(driver);

		String newVendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String emailId = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String phone = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String accountNumber = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String ifscCode = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String gstInString = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String poHash = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);
		String refHash = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 9);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 10);

		/**
		 * Login to website using username and password
		 */
		new Login().loginApp(driver);
		/*
		 * click on the expenses link
		 */

		homePage.clickGotoExpenseListLink();
		GenericUtils.delay(2);

		expenses.clickPurchaseOrdersLink();
		GenericUtils.delay(2);

		purchaseOrder.addPurchaseOrderClick();
		GenericUtils.delay(2);

		purchaseOrder.selectOrAddVendorClick();
		GenericUtils.delay(2);

		purchaseOrder.addNewVendorClick();
		GenericUtils.delay(2);

		newVendorAdd.newVendorNameSetText(newVendorName);
		GenericUtils.delay(2);

		newVendorAdd.emailIdSetText(emailId);
		GenericUtils.delay(2);

		newVendorAdd.phoneNumberSetText(phone);
		GenericUtils.delay(2);

		newVendorAdd.accountNmberSetText(accountNumber);
		GenericUtils.delay(2);

		newVendorAdd.ifscCodeSetText(ifscCode);
		GenericUtils.delay(2);

		newVendorAdd.gstInSetText(gstInString);
		GenericUtils.delay(2);

		newVendorAdd.saveButtonClick();
		GenericUtils.delay(2);

		expensesBill.verifyMessage();
		GenericUtils.delay(2);

		purchaseOrder.poHashSetText(poHash);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		purchaseOrder.setPaymentTermsDropDownListField(paymentTerms);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		purchaseOrder.expenseTypeDropdownBtnClick();
		GenericUtils.delay(2);

		purchaseOrder.expenseTypeTextSetText(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		purchaseOrder.refHashSetText(refHash);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		purchaseOrder.selectOrAddItemClick();
		GenericUtils.delay(2);

		purchaseOrder.selectOrAddItemInputSetText(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		purchaseOrder.savePurchaseOrderClick();
		GenericUtils.delay(2);

		expensesBill.verifyMessageAndQuit();
		GenericUtils.delay(2);

	}
}
