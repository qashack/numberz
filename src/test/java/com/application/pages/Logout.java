package com.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
WebDriver driver;
	
	
	
	@FindBy(xpath=".//*[@id='btn-logout']/a/span")
	private WebElement logoutButton;
	
	public Logout(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void logOut(){
		logoutButton.click();
	}

}
