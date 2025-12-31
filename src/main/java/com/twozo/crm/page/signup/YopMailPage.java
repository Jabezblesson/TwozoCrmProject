package com.twozo.crm.page.signup;

import com.twozo.crm.base.BasePage;
import com.twozo.crm.model.SignupData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YopMailPage extends BasePage {

    private final By yopMail = By.xpath("//input[@placeholder ='Enter your inbox here']");
    private final By click = By.xpath("//button[@title='Check Inbox @yopmail.com']");
    private final By otpFrame = By.id("ifmail");
    private final By otpText = By.xpath("//div[@id='mail']//span");
    private final By consent = By.xpath("//button[@aria-label='Consent']");


    public YopMailPage(final WebDriver driver){
        super(driver);
    }

    private void consent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(consent)).click();}

    private void TypeEmailBox(final String email){
        type(yopMail,email);
    }

    private void clickArrow(){clickWithWait(click);}

    private String readOtp() {
        driver.navigate().refresh();
        switchToFrameId(otpFrame);
        final WebElement elementOtp = locateElement(otpText);
        final String otp = elementOtp.getText().replaceAll("\\D", "");  //only digits extracting
        switchToDefaultFrame();
        System.out.println(otp);

        return otp;
    }

    public final String fetchOtp(final SignupData data )  {
        TypeEmailBox(data.getEmailId());
        clickArrow();

        return readOtp();
    }
}
