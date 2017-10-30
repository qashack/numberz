package com.application.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.libraries.JavascriptLibrary;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.LoginPage;
import com.application.pages.VendorInformation;

public class EXP_1_AddADetailedBillByAddingANewVendor extends BaseClass {

	String expensesSheet = "EXP_1";

	@Test(description = "Add new Vendor and and Item and generating a bill")
	public void addADetailedBillByAddingAnExistingVendor() {
		new Login().loginApp(driver);
		/*
		 * click on the expenses link
		 */

		HomePage homePage = new HomePage(driver);
		homePage.clickGotoExpenseListLink();
		GenericUtils.delay(2);
		/*
		 * click on the Add detailed bill button
		 */
		ExpensesBill bill = new ExpensesBill(driver);
		Expenses expenses = new Expenses(driver);
		expenses.clickAddDetailedBillButton();
		GenericUtils.delay(3);
		bill.dropdownSelectOrAddVendorClick();
		GenericUtils.delay(2);
		bill.clickAddNewVendor();

		VendorInformation vendorInfo = new VendorInformation(driver);
		String vendorName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String emailId = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);
		String phone = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 2);
		String accountNumber = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 3);
		String ifscCode = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 4);
		String gstInString = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 5);
		GenericUtils.delay(2);
		vendorInfo.setVendorNameTextField(vendorName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);
		vendorInfo.setEmailEmailField(emailId);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);
		vendorInfo.setPhoneTextField(phone);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);
		vendorInfo.setAccountNumberTextField(accountNumber);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);
		vendorInfo.setIfscTextField(ifscCode);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);
		vendorInfo.setGstInTextField(gstInString);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		vendorInfo.clickSave1Button();
		bill.getMessage();

		String billNumber = GenericUtils.randomNumber();
		String expenseType = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 6);
		String paymentTerms = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 7);
		String paymentMethod = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 8);
		String itemName = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 9);

		bill.setBillTextField(billNumber);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		bill.setExpenseTypeTextField(expenseType);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		bill.setPaymentTermsDropDownListField(paymentTerms);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		bill.setPaymentMethodDropDownListField(paymentMethod);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);

		bill.setSelectOrAddAnItemselect1TextareaField(itemName);
		GenericUtils.sendEnterKeys(driver);
		GenericUtils.delay(2);
		bill.clickSaveButton();
		bill.verifyMessageAndQuit();

	}

	

}