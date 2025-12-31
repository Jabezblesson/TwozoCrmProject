package com.twozo.crm.page.dealspage;

import com.twozo.crm.page.company.AddCompanyPage;
import com.twozo.crm.page.contact.AddContactPage;
import com.twozo.crm.base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOption extends BasePage {

    private final By clickDeal = By.xpath("//li[contains(.,'Add Deal')]");
    private final By clickContact = By.xpath("//li[contains(.,'Add Contact')]");
    private final By clickCompany = By.xpath("//li[contains(.,'Add Company')]");

    public AddOption(final WebDriver driver) {
        super(driver);
    }

    public AddDealPage addDeal() {
        clickWithWait(clickDeal);
        return new AddDealPage(driver);
    }

    public AddContactPage addContact() {
        clickWithWait(clickContact);
        return new AddContactPage(driver);
    }

    public AddCompanyPage addCompany() {
        clickWithWait(clickCompany);
        return new AddCompanyPage(driver);
    }
}
