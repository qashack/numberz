package com.application.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.application.libraries.ExcelLibrary;
import com.application.libraries.GenericUtils;
import com.application.libraries.JavascriptLibrary;

public class CustomerInfo extends TaxInvoicePage {
	WebDriver driver;
	private int timeout = 15;

	@FindBy(xpath = "//input[@placeholder='Customer Name']")
	private WebElement customerName;

	@FindBy(xpath = "//input[@placeholder='Contact Name']")
	private WebElement contactName;

	@FindBy(id = "emailTo")
	private WebElement emailTo;

	@FindBy(xpath = "//input[@placeholder='Use comma(,) to add multiple emails']")
	private WebElement emailcc;

	@FindBy(xpath = "//input[@placeholder='Phone']")
	private WebElement phone;

	@FindBy(xpath = "(//div[@class='modal-content']//input[@placeholder='Address Line 1'])[1]")
	private WebElement baddressLine1;

	@FindBy(xpath = "(//div[@class='modal-content']//input[@placeholder='Address Line 2'])[1]")
	private WebElement baddressLine2;

	@FindBy(xpath = "(//span[@class='col-md-6 no-padding']/input[@placeholder='City'])[1]")
	private WebElement bacityName;

	@FindBy(xpath = "(//span[@class='col-md-6 no-padding']/input[@placeholder='Pincode'])[1]")
	private WebElement bapincode;

	@FindBy(xpath = "(//div[@class='modal-content']//div[@class='Select-input ']/input)[1]")
	private WebElement bastate;

	@FindBy(xpath = "(//div[@class='modal-content']//div[@class='Select-placeholder' and text()='State']/..//span[@class='Select-arrow'])[1]")
	private WebElement bastatearrow;

	@FindBy(xpath = "(//div[@class='modal-content']//div[@class='Select-placeholder' and text()='State']/..//span[@class='Select-arrow'])[1]")
	private WebElement sastatearrow;

	@FindBy(xpath = "(//div[@class='modal-content']//div[@class='Select-value'])[1]")
	private WebElement banation;

	@FindBy(xpath = "(//div[@class='modal-content']//input[@placeholder='Address Line 1'])[2]")
	private WebElement saddressLine1;

	@FindBy(xpath = "(//div[@class='modal-content']//input[@placeholder='Address Line 2'])[2]")
	private WebElement saddressLine2;

	@FindBy(xpath = "(//span[@class='col-md-6 no-padding']/input[@placeholder='City'])[2]")
	private WebElement sacityName;

	@FindBy(xpath = "(//div[@class='modal-content']//span[@class='col-md-6 no-padding']/input[@placeholder='Pincode'])[2]")
	private WebElement sapincode;

	@FindBy(xpath = "(//div[@class='modal-content']//div[@class='Select-input ']/input)[3]")
	private WebElement sastate;

	@FindBy(xpath = "(//div[@class='modal-content']//div[@class='Select-input ']/input)[4]")
	private WebElement sanation;

	@FindBy(xpath = "(//div[@class='modal-content']//span[@class='Select-arrow'])[4]")
	private WebElement sanationarrow;

	@FindBy(xpath = "//div[@class='modal-content']//select[@class='form-control grey-border border-radius-6 height-40 font-12']")
	private WebElement curency;

	@FindBy(id = "pan-number")
	private WebElement panNumber;

	@FindBy(id = "servicetax-number")
	private WebElement serviceTaxnumber;

	@FindBy(id = "tin-number")
	private WebElement tinNumber;

	@FindBy(id = "gstin-number")
	private WebElement gstinNumber;

	@FindBy(id = "default-tds")
	private WebElement tds;

	@FindBy(xpath = "(//div[@class='modal-content']//div[@class='react-toggle-thumb'])[1]")
	private WebElement showTDS;

	@FindBy(xpath = "(//div[@class='modal-content']//div[@class='react-toggle-thumb'])[2]")
	private WebElement composition_customer;

	@FindBy(xpath = "//div[@class='modal-content']//textarea[@placeholder='Add notes about the customer...']")
	private WebElement notes;

	@FindBy(xpath = "//div[@class='modal-content']//span[@class='font-12']/input")
	private WebElement sezDeveloper;

	public CustomerInfo(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	/*
	 * Fill customer information name
	 */
	public CustomerInfo fillCustomerName(String name) {
		customerName.sendKeys(name);
		return this;
	}
	/*
	 * Fill contact name
	 */

	public CustomerInfo fillContactName(String name) {
		contactName.sendKeys(name);
		return this;
	}

	/*
	 * Fill email to person
	 */
	public CustomerInfo fillEmailTo(String email) {

		emailTo.sendKeys(email);
		return this;
	}

	/*
	 * Fill email cc
	 */
	public CustomerInfo fillEmailcc(String emailc) {

		emailcc.sendKeys(emailc);
		return this;
	}

	/*
	 * Fill phone number
	 */
	public CustomerInfo fillPhoneNumber(String phonenum) {

		phone.sendKeys(phonenum);
		return this;
	}

	/*
	 * Fill Shipping Address line1
	 */
	public CustomerInfo fillShipAddressLine1(String address) {

		saddressLine1.sendKeys(address);
		return this;
	}

	/*
	 * Fill Shipping Address line2
	 */
	public CustomerInfo fillShipAddressLine2(String address) {

		saddressLine2.sendKeys(address);
		return this;
	}

	/*
	 * Fill Shipping city name
	 */
	public CustomerInfo fillShipAddressCity(String address) {

		sacityName.sendKeys(address);
		return this;
	}

	/*
	 * Fill Billing Nation name
	 */
	public CustomerInfo fillShipAddressNation(String address) {
		sanationarrow.click();
		GenericUtils.delay(2);
		sanation.sendKeys(address);
		GenericUtils.sendEnterKeys(driver);
		return this;
	}

	/*
	 * Fill Shipping state name
	 */
	public CustomerInfo fillShipAddressState(String address) {

		sastatearrow.click();
		GenericUtils.delay(2);
		sastate.sendKeys(address);
		GenericUtils.sendEnterKeys(driver);
		return this;
	}

	/*
	 * Fill shipping address pincode
	 */
	public CustomerInfo fillShipAddressPincode(String address) {

		sapincode.sendKeys(address);
		return this;
	}

	/*
	 * Fill Billing Address line1
	 */
	public CustomerInfo fillBillAddressLine1(String address) {

		baddressLine1.sendKeys(address);
		return this;
	}

	/*
	 * Fill Billing Address line2
	 */
	public CustomerInfo fillBillAddressLine2(String address) {

		baddressLine2.sendKeys(address);
		return this;
	}

	/*
	 * Fill city name
	 */
	public CustomerInfo fillBillAddressCity(String address) {

		bacityName.sendKeys(address);
		return this;
	}

	/*
	 * Fill nation name
	 */
	public CustomerInfo fillBillAddressNation(String address) {

		banation.sendKeys(address);
		return this;
	}

	/*
	 * Fill state name
	 */
	public CustomerInfo fillBillAddressState(String address) {
		bastatearrow.click();
		bastate.sendKeys(address);
		GenericUtils.sendEnterKeys(driver);
		return this;
	}

	/*
	 * Fill pincode name
	 */
	public CustomerInfo fillBillAddressPincode(String address) {

		bapincode.sendKeys(address);
		return this;
	}

	/*
	 * Select curency
	 */
	public CustomerInfo selectCurrencyType(String curencyName) {
		Select selectCurency = new Select(curency);
		selectCurency.selectByVisibleText(curencyName);
		return this;
	}

	/*
	 * Fill pan number
	 */
	public CustomerInfo fillPanNumber(String panNo) {
		panNumber.sendKeys(panNo);
		return this;
	}

	/*
	 * Fill Service tax number
	 */
	public CustomerInfo fillServiceTax(String tax) {
		serviceTaxnumber.sendKeys(tax);
		return this;
	}

	/*
	 * Fill Tin(vat)
	 */
	public CustomerInfo fillTin(String vat) {
		tinNumber.sendKeys(vat);
		return this;
	}

	/*
	 * Fill Gstn
	 */
	public CustomerInfo fillGSTIN(String gst) {
		gstinNumber.sendKeys(gst);
		return this;
	}

	/*
	 * Fill TDS
	 */
	public CustomerInfo fillTDS(String tdsn) {

		tds.sendKeys(tdsn);
		return this;
	}

	public CustomerInfo updateTDS(String tdsn) {
		tds.clear();
		tds.sendKeys(tdsn);
		return this;
	}

	/*
	 * Show TDS
	 */
	public CustomerInfo ShowTDS() {
		showTDS.click();
		return this;
	}

	/*
	 * Click Composition customer
	 */
	public CustomerInfo clickOn() {
		composition_customer.click();
		return this;
	}

	public CustomerInfo addNotes(String value) {
		notes.sendKeys(value);
		return this;
	}

	public CustomerInfo addAllBillingAddress(String filePath, String sheetName) {
		int num = GenericUtils.randomNumber("5");
		System.out.println(num);
		String addressline1 = ExcelLibrary.getExcelData(filePath, sheetName, 1, 3);
		String addressline2 = ExcelLibrary.getExcelData(filePath, sheetName, 1, 4);
		String billingcity = ExcelLibrary.getExcelData(filePath, sheetName, 1, 5);
		String pincode = ExcelLibrary.getExcelData(filePath, sheetName, 1, 6) + num;
		String state = ExcelLibrary.getExcelData(filePath, sheetName, 1, 7);
		String arraOfCity[] = billingcity.split(",");
		String arrofState[] = state.split(",");
		System.out.println(arraOfCity[num]);

		fillBillAddressLine1(addressline1);
		fillBillAddressLine2(addressline2);
		fillBillAddressCity(arraOfCity[num]);
		fillBillAddressPincode(pincode);
		fillBillAddressState(arrofState[num]);

		return this;
	}

	public CustomerInfo addAllShippingAddress(String filePath, String sheetName) {
		int num = GenericUtils.randomNumber("5");
		String[] addresl12 = ExcelLibrary.getExcelData(filePath, sheetName, 1, 8).split(",");
		String city[] = ExcelLibrary.getExcelData(filePath, sheetName, 1, 9).split(",");
		String[] state = ExcelLibrary.getExcelData(filePath, sheetName, 1, 10).split(",");
		String pincode = ExcelLibrary.getExcelData(filePath, sheetName, 1, 11) + GenericUtils.randomNumber("5");

		fillShipAddressLine1(addresl12[0]);
		fillShipAddressLine2(addresl12[1]);
		fillShipAddressCity(city[num]);
		fillShipAddressPincode(pincode);
		fillShipAddressState(state[num]);

		return this;
	}

	public CustomerInfo addAllTaxPanGSt(String filePath, String sheetName) {
		String panno = ExcelLibrary.getExcelData(filePath, sheetName, 1, 12);
		String stax = ExcelLibrary.getExcelData(filePath, sheetName, 1, 13);
		String tinno = ExcelLibrary.getExcelData(filePath, sheetName, 1, 14);
		String gst = ExcelLibrary.getExcelData(filePath, sheetName, 1, 15);
		String tds = ExcelLibrary.getExcelData(filePath, sheetName, 1, 16);
		fillPanNumber(panno);
		fillServiceTax(stax);
		fillTin(tinno);
		fillGSTIN(gst);
		fillTDS(tds);
		return this;
	}

	public CustomerInfo clickOnSaveButton() {
		driver.findElement(By.xpath("//div[@class='modal-content']//button[text()='Save']")).click();
		return this;

	}

	public CustomerInfo clickOnYesButton() {
		boolean status = verifyPopUp();
		if (status) {

		} else {
			driver.findElement(By.xpath(
					"//div[@class='modal-content']//button[@class='btn btn-modal-blue font-12 uppercase' and text()='Yes']"))
					.click();
		}
		return this;
	}

	public CustomerInfo clickOnUpdate() {

		driver.findElement(By.xpath("//div[@class='modal-content']//button[text()='Update']")).click();
		return this;
	}

	private boolean verifyPopUp() {
		boolean status;
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		int size = driver.findElements(By.className("toast-message")).size();

		System.out.println("size" + size);

		if (size > 0) {

			status = true;
		} else {

			status = false;
		}
		driver.manage().timeouts().implicitlyWait(
				Long.parseLong(GenericUtils.getConfigProperties("config/config.properties", "IMPLICIT_WAIT")),
				TimeUnit.SECONDS);
		return status;
	}

	public CustomerInfo clickOnSezDeveloper() {
		sezDeveloper.click();
		return this;
	}
}
