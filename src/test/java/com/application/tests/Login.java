package com.application.tests;

import org.openqa.selenium.WebDriver;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.pages.LoginPage;

public class Login extends BaseClass{
 final	String sheetName_login="Login";
  private String username=ExcelLibrary.getExcelData(filePath_invoice, sheetName_login,1,0);
 private	String passsword=ExcelLibrary.getExcelData(filePath_invoice, sheetName_login, 1, 1);
 
 
 	public void loginApp(WebDriver driver)
	{
		LoginPage login=new LoginPage(driver);
		login.FullLogin(username, passsword);
		GenericUtils.waitForLoadComplete(driver);
	}
	
	
}
