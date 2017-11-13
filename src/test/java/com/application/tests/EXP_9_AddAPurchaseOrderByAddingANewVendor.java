package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.PurchaseOrder;
import com.application.pages.PurchaseOrderNewVendor;
import com.application.pages.VendorInformation;

public class EXP_9_AddAPurchaseOrderByAddingANewVendor extends BaseClass {
	String expensesSheet = "EXP_9";

	@Test(description = "Add a Purchase Order by adding a New vendor")
	public void addAPurchaseOrderByAddingANewVendor() {
		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		PurchaseOrderNewVendor newVendorAdd = new PurchaseOrderNewVendor(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		PurchaseOrder purchaseOrder = new PurchaseOrder(driver);
		VendorInformation information = new VendorInformation(driver);

		String newVendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String emailId = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String phone = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String accountNumber = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String ifscCode = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String gstInString = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String poHash = expensesBill.generateRandomBillNumber();
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
		String refHash = expensesBill.generateRandomBillNumber();
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);

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
		expenses.clickPurchaseOrdersLink();
		GenericUtils.delay(1);

		purchaseOrder.addPurchaseOrderClick();
		GenericUtils.delay(1);

		purchaseOrder.selectOrAddVendorClick();
		GenericUtils.delay(1);

		purchaseOrder.addNewVendorClick();
		GenericUtils.delay(1);

		newVendorAdd.newVendorNameSetText(newVendorName+GenericUtils.simpleDate());
		GenericUtils.delay(1);

		newVendorAdd.emailIdSetText(emailId);
		GenericUtils.delay(1);

		newVendorAdd.phoneNumberSetText(phone);
		GenericUtils.delay(1);

		newVendorAdd.accountNmberSetText(accountNumber);
		GenericUtils.delay(1);

		newVendorAdd.ifscCodeSetText(ifscCode);
		GenericUtils.delay(1);

		newVendorAdd.gstInSetText(gstInString);
		GenericUtils.delay(1);

		newVendorAdd.saveButtonClick();
		GenericUtils.delay(2);
		
		//information.gstinAlredyExistYesBtnClick();

		expensesBill.verifyMessage();
		GenericUtils.delay(2);

		purchaseOrder.poHashSetText(poHash);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		purchaseOrder.setPaymentTermsDropDownListField(paymentTerms);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		purchaseOrder.expenseTypeDropdownBtnClick();
		GenericUtils.delay(1);

		purchaseOrder.expenseTypeTextSetText(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		purchaseOrder.refHashSetText(refHash);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		purchaseOrder.selectOrAddItemClick();
		GenericUtils.delay(1);

		purchaseOrder.selectOrAddItemInputSetText(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		purchaseOrder.savePurchaseOrderClick();
		GenericUtils.delay(2);

		expensesBill.verifyMessage();
		GenericUtils.delay(1);

	}
}
