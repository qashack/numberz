package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.ItemInfo;
import com.application.pages.PurchaseOrder;
import com.application.pages.Recurring;
import com.application.pages.VendorInformation;

public class EXP_14_AddARecurringBillByAddingANewVendor extends BaseClass {

	String expensesSheet = "EXP_13";

	@Test(description = "")
	public void addARecurringBillByAddingANewVendor() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		PurchaseOrder purchaseOrder = new PurchaseOrder(driver);
		ItemInfo item = new ItemInfo(driver);
		Recurring recurring = new Recurring(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);
		ExpensesBill bill = new ExpensesBill(driver);

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

		recurring.addRecurringBillBtnClick();
		GenericUtils.delay(2);

		recurring.selectOrAddVendorClick();
		GenericUtils.delay(2);

		recurring.addNewVendorClick();
		GenericUtils.delay(2);

		vendorInfo.setVendorNameTextField("123");
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		vendorInfo.setEmailEmailField("123");
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		vendorInfo.setPhoneTextField("123");
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		vendorInfo.setAccountNumberTextField("123");
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		vendorInfo.setIfscTextField("123");
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		vendorInfo.setGstInTextField("123");
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		vendorInfo.clickSave1Button();
		bill.getMessage();

	}

}
