package com.application.tests;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.Expenses;
import com.application.pages.ExpensesBill;
import com.application.pages.HomePage;
import com.application.pages.VendorInformation;

public class EXP_21_AddFileAttachmentInTheQuickBill extends BaseClass {
	String expensesSheet = "EXP_21";

	@Test(description = "Add file attachment in the quick bill")
	public void addFileAttachmentInTheQuickBill() {

		HomePage homePage = new HomePage(driver);
		Expenses expenses = new Expenses(driver);
		ExpensesBill bill = new ExpensesBill(driver);
		VendorInformation vendorInfo = new VendorInformation(driver);

		String amount = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 0);
		String file = ExcelLibrary.getExcelData(filePath_Expence, expensesSheet, 1, 1);

		String abspath = "./sample/" + file;
		File f = new File(abspath);
		String Abspath = "";
		try {
			Abspath = f.getCanonicalPath();
			Abspath = Abspath.replaceAll("\\\\", "/");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		expenses.amoutInputSetText(amount);
		GenericUtils.delay(1);

		expenses.quickbillAttachmentclick();
		GenericUtils.delay(1);

		expenses.attachFilePathSetPath(Abspath);
		GenericUtils.delay(1);

		expenses.saveAttachmentBtnClick();
		GenericUtils.delay(1);

		expenses.clickSaveLink();
		// GenericUtils.delay(2);

		vendorInfo.clickOnYesButton();

		bill.verifyMessage();
		GenericUtils.delay(1);

	}
}
