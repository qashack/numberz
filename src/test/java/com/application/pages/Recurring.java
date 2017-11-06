package com.application.pages;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recurring {
	private Map<String, String> data;
	private WebDriver driver;
	private int timeout = 15;

	@FindBy(xpath = "//div[@class='row divNav']//button")
	private WebElement addRecurringBillBtn;

	public Recurring(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void addRecurringBillBtnClick() {
		addRecurringBillBtn.click();
	}

}
