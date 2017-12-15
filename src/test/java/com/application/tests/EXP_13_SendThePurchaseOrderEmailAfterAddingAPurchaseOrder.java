package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.PurchaseOrder;

public class EXP_13_SendThePurchaseOrderEmailAfterAddingAPurchaseOrder extends BaseClass {

	String expensesSheet = "EXP_13";

	@Test(description = "Send the Purchase Order Email after adding a Purchase Order")
	public void SendThePurchaseOrderEmailAfterAddingAPurchaseOrder() {

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
		GenericUtils.waitForLoadComplete(driver);
		homePage.clickGotoExpenseListLink();
		GenericUtils.delay(1);

		GenericUtils.waitForLoadComplete(driver);
		expenses.clickPurchaseOrdersLink();

		GenericUtils.waitForLoadComplete(driver);
		purchaseOrder.addPurchaseOrderClick();
		GenericUtils.delay(1);

		purchaseOrder.selectOrAddVendorClick();
		GenericUtils.delay(1);

		purchaseOrder.selectOrAddVendorClick();
		GenericUtils.delay(1);

		purchaseOrder.selectOrAddVendorClickSetText(vendorName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

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

		purchaseOrder.sendPurchaseButtonClick();
		//GenericUtils.delay(2);

		expensesBill.verifyMessage();
		GenericUtils.delay(2);
		
		expensesBill.checkToEmailIdIsEmpty();

		purchaseOrder.sendEmailButtonClick();
		//GenericUtils.delay(2);

		expensesBill.verifyMessage();
		GenericUtils.delay(1);

	}

}
