package com.application.tests;

import org.testng.annotations.Test;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.HomePage;
import com.application.pages.SettingsPage;

public class Init extends BaseClass{
	String sheetName = "Init";
	String gstNumberOld = ExcelLibrary.getExcelData(filePath_invoice, sheetName, 1, 0);

	@Test(description="Initilize the test data")
	public void initialize() {
		// Loging to an application
		new Login().loginApp(driver);
		// Click on add invoice button
		GenericUtils.waitForLoadComplete(driver);
		HomePage home = new HomePage(driver);
		GenericUtils.waitForLoadComplete(driver);
		/*
		 * Move to settings and change GST value
		 */
		SettingsPage setting = new SettingsPage(driver);
		addGstValue(home, setting, gstNumberOld);
	}
	private void addGstValue(HomePage home, SettingsPage setting, String data) {

		home.clickOnSettings();
		GenericUtils.delay(3);
		home.clickCompanySetting();
		GenericUtils.waitForLoadComplete(driver);
		setting.fillGST(data);
		setting.clickOnSaveButton();
		GenericUtils.waitForLoadComplete(driver);

	}

}
