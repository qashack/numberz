package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.VendorInformation;

public class EXP_26_VerifyTheTaxRateWhetherCGSTandSGSTAndIGSTByValidingWithTheSelectedState extends BaseClass {
	String expensesSheet = "EXP_26";

	@Test(description = "Verify the tax rate whether CGST, SGST and IGST by validing with the selected state")
	public void verifyTheTaxRateWhetherCGSTandSGSTAndIGSTByValidingWithTheSelectedState() {
		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);

		String vendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String state = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);

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

		/*
		 * click on the Add detailed bill button
		 */
		GenericUtils.waitForLoadComplete(driver);
		expenses.clickAddDetailedBillButton();

		GenericUtils.waitForLoadComplete(driver);
		bill.dropdownSelectOrAddVendorClick();
		GenericUtils.delay(1);

		bill.clickAddNewVendor();
		GenericUtils.delay(1);

		vendorInfo.setVendorNameTextField(vendorName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		vendorInfo.stateDropdownClick();
		GenericUtils.delay(1);

		vendorInfo.stateInputSetText(state);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		vendorInfo.clickSave1Button();
		GenericUtils.delay(1);

		vendorInfo.yesBtnClick();
		GenericUtils.delay(2);

		bill.verifyMessage();
		GenericUtils.delay(2);

		bill.setSelectOrAddAnItemselect1TextareaField(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

	}
}
