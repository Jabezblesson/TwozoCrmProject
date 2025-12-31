package com.twozo.crm.page.signup;

import com.twozo.crm.model.SignupData;
import com.twozo.crm.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    private String originalWindow;

    private final By enterPhone = By.xpath("//input[@placeholder='Enter your mobile number']");
    private final By enterName = By.xpath("//input[@placeholder='Enter your name']");
    private final By enterEmail = By.xpath("//input[@type='email']");
    private final By enterPass = By.cssSelector("input[type='password']");
    private final By agreed = By.xpath("//input[@type='checkbox']");
    private final By submit = By.xpath("//button[@type='submit']");

    public SignUpPage(final WebDriver driver) {
        super(driver);
    }

    public final void enterUserName(final String username) {
        type(enterName, username);
    }

    public final void enterEmail(final String emailId) {
        type(enterEmail, emailId);
    }

    public final void enterPassword(final String password) {
        type(enterPass, password);
    }

    public final void enterPhone(final String phone) {
        type(enterPhone, phone);
    }

    public final void agreedButton() {
        click(agreed);
    }

    public final void submit() {
        click(submit);
    }

    public OtpSignUpPage signUp(final SignupData data) {
        enterUserName(data.getUsername());
        enterEmail(data.getEmailId());
        enterPassword(data.getPassword());
        enterPhone(data.getPhone());
        agreedButton();
        submit();

        return new OtpSignUpPage(driver);
    }

    public WebDriver openNewTab(final String url) {
        originalWindow = getParentWindow();
      final WebDriver newTab = switchToNewTab();

        newTab.get(url);

        return newTab;  // return driver for further steps
    }

    public void closeNewTabAndReturn(final WebDriver newTabDriver) {
        newTabDriver.close();// closes tab
        switchToOriginalWindow(originalWindow);// return to CRM
    }
}