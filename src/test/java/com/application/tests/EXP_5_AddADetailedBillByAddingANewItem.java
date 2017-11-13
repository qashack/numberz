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

	@Test(description = "Add a Detailed bill by adding a New item")
	public void addADetailedBillByAddingANewItem() {
		HomePage homePage = new HomePage(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		ItemInfo item = new ItemInfo(driver);

		String vendor = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String billNumber = expensesBill.generateRandomBillNumber();
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String refHash = expensesBill.generateRandomBillNumber();
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String paymentMethod = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String newItemNameArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String newItemName = expensesBill.getRandomStringfromArray(newItemNameArray, GenericUtils.randomNumber("11"));
		String dscription = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String sellingPriceArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String sellingPrice = expensesBill.getRandomStringfromArray(sellingPriceArray, GenericUtils.randomNumber("7"));
		String purchasePriceArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
		String purchasePrice = expensesBill.getRandomStringfromArray(purchasePriceArray,
				GenericUtils.randomNumber("8"));
		String purchaseTypeArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);
		String purchaseType = expensesBill.getRandomStringfromArray(purchaseTypeArray, GenericUtils.randomNumber("3"));

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

		/*
		 * click on the select or Add vendor
		 */

		GenericUtils.delay(1);
		expensesBill.setBillFromTextField(vendor);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setBillTextField(billNumber);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setExpenseTypeTextField(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setRefTextField(refHash);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setPaymentTermsDropDownListField(paymentTerms);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		expensesBill.setPaymentMethodDropDownListField(paymentMethod);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		item.addNewItemTextclick();
		GenericUtils.delay(1);

		item.addNewItemSelectClick();
		GenericUtils.delay(1);

		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		item.setTextTonewItemName(newItemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		item.findHsnCodeClickOn();
		GenericUtils.delay(1);

		item.searchHsnCodeBtnClick();
		GenericUtils.delay(1);

		item.radioBtnHsnCodeSelectClick();
		GenericUtils.delay(1);

		item.unitOfMeasureDropdownClick();
		GenericUtils.delay(1);

		int unitOFMesure = GenericUtils.randomNumber("46");

		item.checkOptionExistsOrNot(1);
		GenericUtils.delay(1);

		// item.unitOfMesureSelectClick();
		// GenericUtils.delay(3);

		item.newItemDesciptionTextAreaSettext(dscription);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		item.sellingPricePurchaseOrederSetText(sellingPrice);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		item.purchasePricePurchaseOrederSetText(purchasePrice);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		int taxCredi = GenericUtils.randomNumber("5");

		item.taxCreditDropdownClick(taxCredi);
		GenericUtils.delay(1);

//		item.taxCreditTypeClickclick();
//		GenericUtils.sendEnterKeys(driver);
//		GenericUtils.delay(1);
		
		item.purchaseTypedropdownBtnclick();
		GenericUtils.delay(1);

		item.purchaseTypeTextSetText(purchaseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(1);

		item.saveButtonclick();
		GenericUtils.delay(2);
		
		expensesBill.verifyMessage();
		GenericUtils.delay(2);

		expensesBill.clickSaveButton();
		GenericUtils.delay(1);

		expensesBill.verifyMessage();

	}

}
