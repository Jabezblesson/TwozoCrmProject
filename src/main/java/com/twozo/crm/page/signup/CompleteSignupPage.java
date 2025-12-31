package com.twozo.crm.page.signup;

import com.twozo.crm.model.CompleteSignupData;
import com.twozo.crm.page.dealspage.DealsPage;
import com.twozo.crm.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CompleteSignupPage extends BasePage {

    private final By companyName = By.xpath("//input[@placeholder='What’s your company name?']");
    private final By jobRole = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]");
    private final By currency = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[2]");
    private final By timeZone = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[3]");
    private final By signup = By.xpath("//button[contains(text(),'Complete Sign Up')]");
    private final By search = By.xpath("//input[@placeholder='Search']");
    private final By skipButton = By.xpath("//div[@class='twozo-css-prefix-1e17sv3']/following-sibling::div[1]");

    public CompleteSignupPage(final WebDriver driver) {
        super(driver);
    }

    private void enterCompanyName(final String text) {
      wait.until(ExpectedConditions.elementToBeClickable(companyName)).sendKeys(text); //locateElement(companyName).sendKeys(text);
    }

    private void enterJobRole(final String text) {
        selectDropDownOption(jobRole,text);
    }

    private void enterCurrency(final String text){
        searchAndSelectDropDown(currency,search,text);
    }

    private void enterTimeZone(final String text) {
        searchAndSelectDropDown(timeZone,search,text);
    }

    private  void signupButton() {
        locateElement(signup).click();
    }

    private DealsPage skipToHome() {
        wait.until(ExpectedConditions.elementToBeClickable(skipButton)).click();
        return new DealsPage(driver);
    }

    public void completeSignup(CompleteSignupData Data) {
        enterCompanyName(Data.getCompanyName());
        enterJobRole(Data.getJobRole());
        enterCurrency(Data.getCurrency());
        enterTimeZone(Data.getTimezone());
        signupButton();
        skipToHome();
    }
}