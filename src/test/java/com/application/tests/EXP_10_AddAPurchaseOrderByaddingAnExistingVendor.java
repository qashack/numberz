package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.PurchaseOrder;
import com.application.pages.PurchaseOrderNewVendor;

public class EXP_10_AddAPurchaseOrderByaddingAnExistingVendor extends BaseClass {
	String expensesSheet = "EXP_10";

	@Test(description = "")
	public void addAPurchaseOrderByaddingAnExistingVendor() {
		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		PurchaseOrder purchaseOrder = new PurchaseOrder(driver);

		String vendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String poHash = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String refHash = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);

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

		purchaseOrder.selectOrAddVendorClick();
		GenericUtils.delay(2);

		purchaseOrder.selectOrAddVendorClickSetText(vendorName);
		GenericUtils.sendEnterKeys(driver);
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
