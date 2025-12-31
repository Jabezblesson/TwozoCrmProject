package com.twozo.crm.page.dealspage;

import com.twozo.crm.base.BasePage;
import com.twozo.crm.model.DealsData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddDealPage extends BasePage {

    private final By title = By.xpath("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[2]");
    private final By pipeline = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]");
    private final By stage = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[2]");
    private final By primaryContact = By.xpath("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]");
    private final By relatedContacts = By.xpath("(//input[@role='combobox'])[2]");
    private final By company = By.xpath("(//input[@type='text'])[6]");
    private final By dealValue = By.xpath("//input[@type='number']");
    private final By salesOwner = By.xpath("(//div[@aria-haspopup='listbox'])[4]");
    private final By searchDropDown = By.xpath("(//input[contains(@placeholder,'Search')])[2]");
    private final By save = By.xpath("(//button[contains(text(), 'Save')])[1]");

    public AddDealPage(final WebDriver driver) {
        super(driver);
    }

    private void enterTitle(final String text) {
        locateElement(title).sendKeys(text);
    }

    private void pipelineType(final String text) {
        selectDropDownOption(pipeline, text);
    }

    private void stageType(final String text) {
        searchAndSelectDropDown(stage,searchDropDown, text);
    }

    public void enterPrimaryContact(final String text) {
        selectFromMuiAutoCompleteSecondOption(primaryContact, text);
    }

    private void enterRelatedContacts(final String text) {
        selectFromMuiAutoCompleteSecondOption(relatedContacts, text);
    }

    private void enterCompanyName(final String text) {
        selectFromMuiAutoComplete(company, text);
    }

    private void enterDealValue(final String text) {
        locateElement(dealValue).sendKeys(text);
    }

    private void enterSalesOwner(final String text) {
        searchAndSelectDropDown(salesOwner, searchDropDown, text);
    }

    private void saveButton() {
        locateElement(save).click();
    }

    public void addNewDeals(DealsData dealsData) {
        enterTitle(dealsData.getCompany());
        pipelineType(dealsData.getPipeline());
        stageType(dealsData.getStage());
        enterPrimaryContact(dealsData.getPrimaryContact());
        enterRelatedContacts(dealsData.getRelatedContact());
        enterCompanyName(dealsData.getCompany());
        enterDealValue(dealsData.getDealsValue());
        enterSalesOwner(dealsData.getSalesOwner());
        saveButton();
    }
}