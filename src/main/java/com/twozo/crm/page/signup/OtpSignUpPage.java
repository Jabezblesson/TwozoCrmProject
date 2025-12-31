package com.twozo.crm.page.signup;

import com.twozo.crm.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OtpSignUpPage extends BasePage {

    private final By otpInputs = By.xpath("//input[@inputmode='numeric']");
    private final By verify = By.cssSelector("button[type='submit']");

    protected OtpSignUpPage(final WebDriver driver) {
        super(driver);
    }

    public void EnterOTP(final String otp) {
        final List<WebElement> boxes = locateElements(otpInputs);
        final int otpSize = otp.length();

        for (int i = 0; i < otpSize; i++) {
            boxes.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }
    }

    private CompleteSignupPage verifyClick() {
        click(verify);
        return new CompleteSignupPage(driver);
    }

    public void otpVerify(final String otp) {
        EnterOTP(otp);
        verifyClick();
    }
}
