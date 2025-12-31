package com.twozo.crm.page.company;

import com.twozo.crm.base.BasePage;
import com.twozo.crm.model.CompanyData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCompanyPage extends BasePage {

    private final By companyNameInput = By.xpath("//input[@placeholder='Eg: Tephey Restaurant']");
    private final By websiteInput = By.xpath("(//input[contains(@class,'MuiInputBase-input MuiOutlinedInput-input')])[3]");
    private final By ownerDropdown = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[1]");
    private final By addressOne = By.xpath("//input[@placeholder='Address Line 1']");
    private final By addressTwo = By.xpath("//input[@placeholder='Address Line 2']");
    private final By cityInput = By.xpath("//input[@placeholder='City']");
    private final By stateInput = By.xpath("//input[@placeholder='State']");
    private final By countryDropdown = By.xpath("(//div[contains(@class,'MuiSelect-select MuiSelect-outlined')])[2]");
    private final By dropdownSearchInput = By.xpath("(//input[@placeholder='Search'])[2]");
    private final By pinCodeInput = By.xpath("//input[@placeholder='Pincode']");
    private final By saveButton = By.xpath("//button[normalize-space(text())='Save']");

    public AddCompanyPage(final WebDriver driver) {
        super(driver);
    }

    private void enterCompanyName(final String text) {
        locateElementWithVisibility(companyNameInput).sendKeys(text);
    }

    private void enterWebsite(final String text) {
        locateElement(websiteInput).sendKeys(text);
    }

    private void selectOwner(final String text) {
        searchAndSelectDropDown(ownerDropdown, dropdownSearchInput,text);
    }

    private void addressOne(final String text) {
        locateElement(addressOne).sendKeys(text);
    }

    private void addressTwo(final String text) {
        locateElement(addressTwo).sendKeys(text);
    }

    private void enterCity(final String text) {
        locateElement(cityInput).sendKeys(text);
    }

    private void enterState(final String text) {
        locateElement(stateInput).sendKeys(text);
    }

    private void selectCountry(final String text) {
        searchAndSelectDropDown(countryDropdown, dropdownSearchInput,text);
    }

    private void enterPinCode(final String text) {
        locateElement(pinCodeInput).sendKeys(text);
    }

    public void save() {
        locateElement(saveButton).click();
    }

    public void addNewCompanyForm(final CompanyData Data) {
        enterCompanyName(Data.getCompanyName());
        enterWebsite(Data.getWebSite());
        selectOwner(Data.getOwner());
        addressOne(Data.getAddressOne());
        addressTwo(Data.getAddressTwo());
        enterCity(Data.getCity());
        enterState(Data.getState());
        selectCountry(Data.getCountry());
        enterPinCode(Data.getPinCode());
        save();
    }
}