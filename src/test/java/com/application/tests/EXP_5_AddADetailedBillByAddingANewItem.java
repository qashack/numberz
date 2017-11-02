package com.application.tests;

import org.testng.annotations.Test;
import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.ItemInfo;

public class EXP_5_AddADetailedBillByAddingANewItem extends BaseClass {
	String expensesSheet = "EXP_5";

	@Test(description = "")
	public void addADetailedBillByAddingANewItem() {
		HomePage homePage = new HomePage(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		ItemInfo item = new ItemInfo(driver);

		String vendor = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String billNumber = expensesBill.generateRandomBillNumber();
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String refHash = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String paymentMethod = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String newItemNameArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String newItemName = expensesBill.getRandomStringfromArray(newItemNameArray, GenericUtils.randomNumber("8"));
		String dscription = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String sellingPriceArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
		String sellingPrice = expensesBill.getRandomStringfromArray(sellingPriceArray, GenericUtils.randomNumber("8"));
		String purchasePriceArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);
		String purchasePrice = expensesBill.getRandomStringfromArray(purchasePriceArray,GenericUtils.randomNumber("8"));
		String unitOfMeasure = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 9);
		String taxCredit = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 10);
		String purchaseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 11);

		new Login().loginApp(driver);
		/*
		 * click on the expenses link
		 */

		homePage.clickGotoExpenseListLink();
		GenericUtils.delay(2);
		/*
		 * click on the Add detailed bill button
		 */

		expenses.clickAddDetailedBillButton();
		GenericUtils.delay(3);
		
		bill.dropdownSelectOrAddVendorClick();
		GenericUtils.delay(2);
		//bill.clickAddNewVendor();

		/*
		 * click on the select or Add vendor
		 */

		GenericUtils.delay(2);
		expensesBill.setBillFromTextField(vendor);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setBillTextField(billNumber);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setExpenseTypeTextField(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setRefTextField(refHash);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setPaymentTermsDropDownListField(paymentTerms);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		expensesBill.setPaymentMethodDropDownListField(paymentMethod);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(5);

		
		item.addNewItemTextclick();
		GenericUtils.delay(3);

		item.addNewItemSelectClick();
		GenericUtils.delay(3);

		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(3);

		item.setTextTonewItemName(newItemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(3);

		item.findHsnCodeClickOn();
		GenericUtils.delay(3);

		item.searchHsnCodeBtnClick();
		GenericUtils.delay(3);

		item.radioBtnHsnCodeSelectClick();
		GenericUtils.delay(3);

		item.unitOfMeasureDropdownClick();
		GenericUtils.delay(3);

		item.checkOptionExistsOrNot(4);
		GenericUtils.delay(3);

		item.unitOfMesureSelectClick();
		GenericUtils.delay(3);

		item.newItemDesciptionTextAreaSettext(dscription);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		item.sellingPricesetText(sellingPrice);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		item.purchasePriceSetText(purchasePrice);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		GenericUtils.delay(3);
		item.taxCreditDropdownClick();
		GenericUtils.delay(2);

		item.taxCreditTypeClickclick();
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		item.purchaseTypedropdownBtnclick();
		GenericUtils.delay(3);

		item.purchaseTypeTextSetText(purchaseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

	}

}
