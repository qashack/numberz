package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.ItemInfo;
import com.application.pages.Logout;
import com.application.pages.VendorInformation;

public class InitExpense extends BaseClass {
	String expensesSheet = "EXP_Init";

	String vendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
	String emailId = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
	String phone = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
	String accountNumber = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
	String ifscCode = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
	String gstInString = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);

	String newItemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
	String dscription = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);
	String sellingPrice = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 9);
	String purchasePrice = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 10);
	String purchaseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 11);

	@Test()
	public void createVendor() {
		HomePage homePage = new HomePage(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		Expenses expenses = new Expenses(driver);
		Logout logout = new Logout(driver);
		ItemInfo item = new ItemInfo(driver);
		/**
		 * Login to website using username and password
		 */
		new Login().loginApp(driver);
		/*
		 * click on the expenses link
		 */
		GenericUtils.waitForLoadComplete(driver);
		homePage.clickGotoExpenseListLink();
		/*
		 * click on the Add detailed bill button
		 */
		GenericUtils.waitForLoadComplete(driver);
		expenses.clickAddDetailedBillButton();

		GenericUtils.waitForLoadComplete(driver);
		bill.dropdownSelectOrAddVendorClick();

		bill.clickAddNewVendor();

		vendorInfo.setVendorNameTextField(vendorName);
		GenericUtils.sendEnterKeys(driver);

		vendorInfo.setEmailEmailField(emailId);
		GenericUtils.sendEnterKeys(driver);

		vendorInfo.setPhoneTextField(phone);
		GenericUtils.sendEnterKeys(driver);

		vendorInfo.setAccountNumberTextField(accountNumber);
		GenericUtils.sendEnterKeys(driver);

		vendorInfo.setIfscTextField(ifscCode);
		GenericUtils.sendEnterKeys(driver);

		vendorInfo.setGstInTextField(gstInString);
		GenericUtils.sendEnterKeys(driver);

		vendorInfo.clickSave1Button();
		GenericUtils.delay(1);

		vendorInfo.clickOnYesButton();

		bill.verifyMessage();
		GenericUtils.delay(1);

		createItem(item, bill);

		logout.logOut();
	}

	public void createItem(ItemInfo item, ExpensesBill bill) {
		item.addNewItemTextclick();
		GenericUtils.delay(1);

		item.addNewItemSelectClick();

		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		item.setTextTonewItemName(newItemName);
		GenericUtils.sendEnterKeys(driver);

		item.findHsnCodeClickOn();

		item.searchHsnCodeBtnClick();

		item.radioBtnHsnCodeSelectClick();

		item.unitOfMeasureDropdownClick();

		int unitOFMesure = GenericUtils.randomNumber("46");

		item.checkOptionExistsOrNot(1);
		GenericUtils.delay(1);

		item.newItemDesciptionTextAreaSettext(dscription);
		GenericUtils.sendEnterKeys(driver);

		item.sellingPricePurchaseOrederSetText(sellingPrice);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		item.purchasePricePurchaseOrederSetText(purchasePrice);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		int taxCredi = GenericUtils.randomNumber("5");

		item.taxCreditDropdownClick(taxCredi);

		item.purchaseTypedropdownBtnclick();

		item.purchaseTypeTextSetText(purchaseType);
		GenericUtils.sendEnterKeys(driver);

		item.saveButtonclick();

		bill.verifyMessage();
		GenericUtils.delay(1);

	}
}
