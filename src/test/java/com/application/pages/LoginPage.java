package com.application.pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(id = "Login-email")
    private WebElement usernames;

    @FindBy(id = "Login-password")
    private WebElement password;

    @FindBy(id = "olark-form-input-email")
    private WebElement clickHereAndTypeYourEmail3;

    @FindBy(id = "olark-form-input-fname")
    private WebElement clickHereAndTypeYourName;

    @FindBy(css = "button.olark-launch-button.olark-chat-tab.olark-size-md")
    private WebElement envelopeIconsmallPictureOfAnEnvelope;

    @FindBy(id = "Login-forgot-password")
    private WebElement forgotPassword;

    @FindBy(css = "#app div:nth-of-type(1) div:nth-of-type(2) div.row.col-md-8.col-md-offset-2.loginBox div:nth-of-type(2) div:nth-of-type(3) div.text-center a.link.font-10")
    private WebElement learnMore;

    private final String pageLoadedText = "";
    private final String pageUrl = "/app?redirectTo=/app/home";

    @FindBy(css = "#olark-container div:nth-of-type(3) a")
    private WebElement poweredByOlark;

    @FindBy(id = "olark-form-input-body")
    private WebElement requiredAsterisksignifiesThatThisFieldCan;

    @FindBy(css = "button.olark-form-send-button")
    private WebElement send;

    @FindBy(id = "Login-button")
    private WebElement signIn;

    @FindBy(id = "Login-signup")
    private WebElement signUpHere;

    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        this();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public LoginPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Envelope Iconsmall Picture Of An Envelope Signifying An Email Address0how Can We Help Button.
     *
     * @return the LoginPage class instance.
     */
   

    /**
     * Click on Forgot Password Link.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage clickForgotPasswordLink() {
        forgotPassword.click();
        return this;
    }

   

  

    /**
     * Click on Send Button.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage clickSendButton() {
        send.click();
        return this;
    }

    /**
     * Click on Sign In Button.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage clickSignInButton() {
        signIn.click();
        return this;
    }

    /**
     * Click on Sign Up Here. Link.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage clickSignUpHereLink() {
        signUpHere.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage fill() {
        setClickHereAndTypeYourEmail1PasswordField();
        setClickHereAndTypeYourEmail2PasswordField();
        setClickHereAndTypeYourNameTextField();
        setClickHereAndTypeYourEmail3EmailField();
        setRequiredAsterisksignifiesThatThisFieldCanTextareaField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Click Here And Type Your Email Password field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setClickHereAndTypeYourEmail1PasswordField() {
        return setClickHereAndTypeYourEmail1PasswordField(data.get("CLICK_HERE_AND_TYPE_YOUR_EMAIL_1"));
    }

    /**
     * Set value to Click Here And Type Your Email Password field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setClickHereAndTypeYourEmail1PasswordField(String clickHereAndTypeYourEmail1Value) {
        usernames.sendKeys(clickHereAndTypeYourEmail1Value);
        return this;
    }

    /**
     * Set default value to Click Here And Type Your Email Password field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setClickHereAndTypeYourEmail2PasswordField() {
        return setClickHereAndTypeYourEmail2PasswordField(data.get("CLICK_HERE_AND_TYPE_YOUR_EMAIL_2"));
    }

    /**
     * Set value to Click Here And Type Your Email Password field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setClickHereAndTypeYourEmail2PasswordField(String clickHereAndTypeYourEmail2Value) {
        password.sendKeys(clickHereAndTypeYourEmail2Value);
        return this;
    }

    /**
     * Set default value to Click Here And Type Your Email Email field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setClickHereAndTypeYourEmail3EmailField() {
        return setClickHereAndTypeYourEmail3EmailField(data.get("CLICK_HERE_AND_TYPE_YOUR_EMAIL_3"));
    }

    /**
     * Set value to Click Here And Type Your Email Email field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setClickHereAndTypeYourEmail3EmailField(String clickHereAndTypeYourEmail3Value) {
        clickHereAndTypeYourEmail3.sendKeys(clickHereAndTypeYourEmail3Value);
        return this;
    }

    /**
     * Set default value to Click Here And Type Your Name Text field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setClickHereAndTypeYourNameTextField() {
        return setClickHereAndTypeYourNameTextField(data.get("CLICK_HERE_AND_TYPE_YOUR_NAME"));
    }

    /**
     * Set value to Click Here And Type Your Name Text field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setClickHereAndTypeYourNameTextField(String clickHereAndTypeYourNameValue) {
        clickHereAndTypeYourName.sendKeys(clickHereAndTypeYourNameValue);
        return this;
    }

    /**
     * Set default value to Required Asterisksignifies That This Field Can Not Be Left Blank Textarea field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setRequiredAsterisksignifiesThatThisFieldCanTextareaField() {
        return setRequiredAsterisksignifiesThatThisFieldCanTextareaField(data.get("REQUIRED_ASTERISKSIGNIFIES_THAT_THIS_FIELD_CAN"));
    }

    /**
     * Set value to Required Asterisksignifies That This Field Can Not Be Left Blank Textarea field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setRequiredAsterisksignifiesThatThisFieldCanTextareaField(String requiredAsterisksignifiesThatThisFieldCanValue) {
        requiredAsterisksignifiesThatThisFieldCan.sendKeys(requiredAsterisksignifiesThatThisFieldCanValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage submit() {
        clickSignInButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
    
    public LoginPage FullLogin(String username,String passsword)
    {
    	usernames.sendKeys(username);
    	password.sendKeys(passsword);
    	submit();
		return this;    
    }
    
    
    
}
