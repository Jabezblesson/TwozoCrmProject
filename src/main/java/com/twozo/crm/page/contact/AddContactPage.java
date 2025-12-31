package com.twozo.crm.page.contact;

import com.twozo.crm.model.ContactData;
import com.twozo.crm.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AddContactPage extends BasePage {

    private final By firstName = By.xpath("//input[@placeholder='Eg: John']");
    private final By lastName = By.xpath("//input[@placeholder='Eg: Mathew']");
    private final By email = By.xpath("(//input[@type='text'])[5]");
    private final By emailType = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]");
    private final By phoneNo = By.xpath("(//input[@type='text'])[6]");
    private final By phoneType = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[2]");
    private final By companyName = By.xpath("(//input[@type='text'])[7]");
    private final By designation = By.xpath("(//input[@placeholder='Enter'])[2]");
    private final By owner = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[3]");
    private final By lifeCycleStage = By.xpath("(//div[@aria-expanded='false'])[4]");
    private final By lifeCycleStatus = By.xpath("(//div[@aria-expanded='false'])[5]");
    private final By facebookProfile = By.xpath("(//input[@placeholder='Enter'])[3]");
    private final By linkedInProfile = By.xpath("(//input[@placeholder='Enter'])[4]");
    private final By subscriptionType = By.xpath("(//div[@aria-expanded='false'])[6]");
    private final By subscriptionCard = By.xpath("//input[@placeholder='Select']");
    private final By save = By.xpath("//button[contains(text(), 'Save')]");
    private final By saveAndNew = By.xpath("//button[contains(text(), 'Save & New')]");
    private final By checkForDuplicates = By.xpath("//button[contains(text(),'Check for Duplicates')]");
    private final By successToast = By.xpath("//div[contains(@class,'notistack-Snackbar')]//p[normalize-space()='Contact added.']");
    private final By searchDropDown = By.xpath("(//input[contains(@placeholder,'Search')])[2]");

   public AddContactPage(final WebDriver driver) {
        super(driver);
    }

    private void enterFirstName(final String text) {
        locateElement(firstName).sendKeys(text);
    }

    private void enterSecondName(final String text) {
        locateElement(lastName).sendKeys(text);
    }

    private void enterEmailId(final String text) {
        locateElement(email).sendKeys(text);
    }

    private void emailDropDown(final String text) {
        selectDropDownOption(emailType, text);
    }

    private void enterPhoneNumber(final String text) {
        locateElement(phoneNo).sendKeys(text);
    }

    private void phoneDropDown(final String text) {
        selectDropDownOption(phoneType, text);
    }

    private void enterCompanyName(final String text) {
        selectFromMuiAutoComplete(companyName, text);
    }

    private void enterDesignation(final String text) {
        locateElementWithVisibility(designation).sendKeys(text);
    }

    private void selectSalesOwner(final String text) {
        searchAndSelectDropDown(owner,searchDropDown, text);
    }

    private void selectLifeCycleStage(final String text) {
        selectDropDownOption(lifeCycleStage, text);
    }

    private void selectLifeCycleStatus(final String text) {
        searchAndSelectDropDown(lifeCycleStatus,searchDropDown, text);
    }

    private void enterFacebookProfile(final String text) {
        locateElement(facebookProfile).sendKeys(text);
    }

    private void enterLinkedInProfile(final String text) {
        locateElement(linkedInProfile).sendKeys(text);
    }

    private void selectSubscription(final String text) {
        selectDropDownOption(subscriptionType, text);
    }

    private void subscriptionType(List<String> values) {
     selectDropDownMultipleInputs(subscriptionCard,values);
    }

    public void checkForDuplicateButton () {
       locateElement(checkForDuplicates).click();
    }

    private void save() {
        locateElement(save).click();
    }

    private void saveAndNew() {
        locateElement(saveAndNew).click();
    }

    public boolean isContactCreated() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successToast));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void fillContactForm(final ContactData data) {
        enterFirstName(data.getFirstName());
        enterSecondName(data.getLastName());
        enterEmailId(data.getEmail());
        emailDropDown(data.getEmailType());
        enterPhoneNumber(data.getPhone());
        phoneDropDown(data.getPhoneType());
        enterCompanyName(data.getCompany());
        enterDesignation(data.getDesignation());
        selectSalesOwner(data.getOwner());
        selectLifeCycleStage(data.getLifeCycleStage());
        selectLifeCycleStatus(data.getLifeCycleStatus());
        enterFacebookProfile(data.getFacebookProfile());
        enterLinkedInProfile(data.getLinkedInProfile());
        selectSubscription(data.getSubscriptionStatus());
        subscriptionType(data.getSubscriptionType());
        save();
    }
}