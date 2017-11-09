package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.ItemInfo;
import com.application.pages.PurchaseOrder;
import com.application.pages.Recurring;

public class EXP_16_AddARecurringBillByAddingANewItem extends BaseClass {

	String expensesSheet = "EXP_16";

	@Test(description = "")
	public void addARecurringBillByAddingANewItem() {

		HomePage homePage = new HomePage(driver);
		PurchaseOrder purchaseOrder = new PurchaseOrder(driver);
		Recurring recurring = new Recurring(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		ExpensesBill expensesBill = new ExpensesBill(driver);
		ItemInfo item = new ItemInfo(driver);

		String vendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String frequencyArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String frequency = expensesBill.getRandomStringfromArray(frequencyArray, GenericUtils.randomNumber("6"));
		String endDate = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String paymentTermsArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String paymentterm = expensesBill.getRandomStringfromArray(paymentTermsArray, GenericUtils.randomNumber("6"));
		String newItemNameArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		String newItemName = expensesBill.getRandomStringfromArray(newItemNameArray, GenericUtils.randomNumber("7"));
		String dscription = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String sellingPriceArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
		String sellingPrice = expensesBill.getRandomStringfromArray(sellingPriceArray, GenericUtils.randomNumber("7"));
		String purchasePriceArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);
		String purchasePrice = expensesBill.getRandomStringfromArray(purchasePriceArray,
				GenericUtils.randomNumber("8"));

		String unitOfMesure = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 9);
		String taxcredit = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 10);
		String purchaseTypeArray = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 11);
		String purchaseType = expensesBill.getRandomStringfromArray(purchaseTypeArray, GenericUtils.randomNumber("3"));

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

		GenericUtils.waitForLoadComplete(driver);
		recurring.addRecurringBillBtnClick();
		GenericUtils.delay(2);

		recurring.selectOrAddVendorClick();
		GenericUtils.delay(2);

		recurring.selectOrAddVendorInputSetText(vendorName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.frequencyDropDownClick();
		GenericUtils.delay(2);

		recurring.frequencyInput(frequency);
		GenericUtils.delay(2);

		recurring.endDateClick();
		GenericUtils.delay(2);

		recurring.endDateSetText(endDate);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.expenseTypeDropDownClick();
		GenericUtils.delay(2);

		recurring.expenseTypeInputSetText(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.paymentTermsDropDownClick();
		GenericUtils.delay(2);

		recurring.paymentTermsInputSelect(paymentterm);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		recurring.itemNameclick();
		GenericUtils.delay(2);

		item.addNewItemSelectClick();
		GenericUtils.delay(3);

		item.setTextTonewItemName(newItemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(3);

		item.findHsnBtnRecurringBillClick();
		GenericUtils.delay(3);

		item.searchHsnRecurringBillClick();
		GenericUtils.delay(3);

		item.radioBtnHsnCodeSelectClick();
		GenericUtils.delay(3);

		item.unitOfMeasureDropdownClick();
		GenericUtils.delay(3);

		int unitOFMesure = GenericUtils.randomNumber("46");

		item.checkOptionExistsOrNot(1);
		GenericUtils.delay(3);

		// item.unitOfMesureSelectClick();
		// GenericUtils.delay(3);

		item.newItemDesciptionTextAreaSettext(dscription);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		item.sellingPriceRecurringBillsetText(sellingPrice);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		item.purchasePriceRecurringBillsetText(purchasePrice);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(5);

		int taxCredi = GenericUtils.randomNumber("5");

		item.taxCreditDropdownClick(taxCredi);
		GenericUtils.delay(2);
		//
		// item.taxCreditTypeClickclick();
		// GenericUtils.sendEnterKeys(driver);
		// GenericUtils.delay(2);

		item.purchaseTypedropdownBtnclick();
		GenericUtils.delay(3);

		item.purchaseTypeTextSetText(purchaseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		item.saveBtnRecurringBillClick();
		GenericUtils.delay(2);

		expensesBill.verifyMessage();
		GenericUtils.delay(2);

		recurring.saveBtnClick();
		GenericUtils.delay(2);

		expensesBill.verifyMessage();
		GenericUtils.delay(2);

	}
}
