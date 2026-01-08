package com.twozo.crm;

import com.twozo.crm.base.BaseTest;
import com.twozo.crm.component.*;
import com.twozo.crm.model.*;
import com.twozo.crm.page.activity.ActivitiesPage;
import com.twozo.crm.page.company.AddCompanyPage;
import com.twozo.crm.page.company.CompanyPage;
import com.twozo.crm.page.contact.AddContactPage;
import com.twozo.crm.page.contact.ContactsPage;
import com.twozo.crm.page.dealspage.AddDealPage;
import com.twozo.crm.page.dealspage.DealsPage;
import com.twozo.crm.page.duplicatemanagment.DuplicateManagementPage;
import com.twozo.crm.page.login.LoginPage;
import com.twozo.crm.page.signup.CompleteSignupPage;
import com.twozo.crm.page.signup.OtpSignUpPage;
import com.twozo.crm.page.signup.SignUpPage;
import com.twozo.crm.page.signup.YopMailPage;

import dataprovider.CompanyDataProvider;
import dataprovider.ContactDataProvider;
import dataprovider.DealsDataProvider;
import dataprovider.SignupDataProvider;

import utilities.JsonDataProvider;

import org.testng.annotations.Listeners;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

@Listeners(listener.ExtentTestNGListener.class)
public class CRMTest extends BaseTest {

    @Test(dataProvider = "ContactTables", dataProviderClass = JsonDataProvider.class)
    public void webTables(final LoginData loginData, TableCriteria tableCriteria) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final ContactsPage contactsPage = dealsPage.sideBar.clickContacts();
        final TableUtils tableUtils = contactsPage.loadContactsTable();

        tableUtils.printMatchingRow(tableCriteria);
    }

    @Test(dataProvider = "loginAndSearchData", dataProviderClass = JsonDataProvider.class)
    public void performSearch(final LoginData loginData, final SearchData data) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final ContactsPage contactsPage = dealsPage.sideBar.clickContacts();

        contactsPage.searchResult.getSearchResults(data);
    }

    @Test(dataProvider = "companyTables", dataProviderClass = JsonDataProvider.class)
    public void companyTables(final LoginData loginData, final TableCriteria tableCriteria) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final CompanyPage companyPage = dealsPage.sideBar.clickCompany();
        final TableUtils tableUtils = companyPage.loadCompanyTable();

        tableUtils.printMatchingRow(tableCriteria);
    }

    @Test(dataProvider = "dealsTables", dataProviderClass = JsonDataProvider.class)
    public void dealsTables(final LoginData loginData, final TableCriteria tableCriteria) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData)
                .sideBar.clickDeals();
        final TableUtils tableUtils = dealsPage.loadDealsTable();

        tableUtils.printMatchingRow(tableCriteria);
    }

    @Test(dataProvider = "activitiesTable", dataProviderClass = JsonDataProvider.class)
    public void activitiesTables(final LoginData loginData, final TableCriteria tableCriteria) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final ActivitiesPage activitiesPage = dealsPage.sideBar.clickActivities();
        final TableUtils tableUtils = activitiesPage.loadActivitiesTable();

        tableUtils.printMatchingRow(tableCriteria);
    }

    @Test(dataProvider = "mergeContactsTables", dataProviderClass = JsonDataProvider.class)
    public void testMergeDuplicateContacts(final LoginData loginData, final DuplicateData Data) {
        final LoginPage login = new LoginPage(driver);
        final DealsPage dealsPage = login.loginToCRM(loginData);
        final ContactsPage contactsPage = dealsPage.sideBar.clickContacts();
        final DuplicateManagementPage duplicateManagementPage = contactsPage.openManageDuplicates();
        duplicateManagementPage.contactTables();
        final DuplicateReviewComponent reviewComp = duplicateManagementPage.reviewTable(Data);

        Assert.assertNotNull(reviewComp,
                " No duplicate entry found for identifier: " + Data.getSearchKey());
        reviewComp.mergeDuplicateRecord(Data);
    }

    @Test(dataProvider = "mergeCompanyTables", dataProviderClass = JsonDataProvider.class)
    public void testMergeDuplicatesCompany(final LoginData loginData, final DuplicateData Data) {
        final LoginPage login = new LoginPage(driver);
        final DealsPage dealsPage = login.loginToCRM(loginData);
        final ContactsPage contactsPage = dealsPage.sideBar.clickContacts();
        final DuplicateManagementPage duplicateManagementPage = contactsPage.openManageDuplicates();
        duplicateManagementPage.companyTables();
        final DuplicateReviewComponent reviewComp = duplicateManagementPage.reviewTable(Data);

        Assert.assertNotNull(reviewComp,
                " No duplicate entry found for identifier: " + Data.getSearchKey());
        reviewComp.mergeDuplicateRecord(Data);
    }

    @Test(dataProvider = "addContacts", dataProviderClass = JsonDataProvider.class)
    public void testAddNewContacts(final LoginData loginData, final ContactData contactData) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final AddContactPage addContactPage = dealsPage
                .openAddOption()
                .addContact();

        addContactPage.fillContactForm(contactData);
        Assert.assertFalse(addContactPage.isContactCreated(),
                "contact created is not displayed");
    }

    @Test(dataProvider = "addContact", dataProviderClass = ContactDataProvider.class)
    public void addNewContactsUsingFaker(final LoginData loginData, final ContactData contactData) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final AddContactPage addContactPage = dealsPage
                .openAddOption().addContact();

        addContactPage.fillContactForm(contactData);
        Assert.assertTrue(addContactPage.isContactCreated(),
                "contact created is not displayed");
    }

    @Test(dataProvider = "SignupData", dataProviderClass = SignupDataProvider.class)
    public void signupOtpFlow(final SignupData signupData, final CompleteSignupData completeSignupData) {
        final LoginPage login = new LoginPage(driver);
        final SignUpPage sign = login.ClickSignUp();
        final OtpSignUpPage otpSignUpPage = sign.signUp(signupData);
        final WebDriver newtTab = sign.openNewTab("https://yopmail.com/en/");
        final YopMailPage yop = new YopMailPage(driver);
        final String otp = yop.fetchOtp(signupData);

        sign.closeNewTabAndReturn(newtTab);
        otpSignUpPage.otpVerify(otp);
        final CompleteSignupPage completeSignupPage = new CompleteSignupPage(driver);

        completeSignupPage.completeSignup(completeSignupData);
    }

    @Test(dataProvider = "addCompany", dataProviderClass = CompanyDataProvider.class)
    public void addNewCompany(final LoginData loginData, final CompanyData companyData) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final AddCompanyPage addCompanyPage = dealsPage
                .openAddOption().addCompany();
        addCompanyPage.addNewCompanyForm(companyData);
    }

    @Test(dataProvider = "addDeals",dataProviderClass = DealsDataProvider.class)
    public void addNewDeals(final LoginData loginData, final DealsData dealsData) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final AddDealPage addDealPage = dealsPage.openAddOption().addDeal();
        addDealPage.addNewDeals(dealsData);
    }

    @Test(dataProvider = "ContactTables", dataProviderClass = JsonDataProvider.class)
    public void verifyContactDeletion(final LoginData loginData, final TableCriteria tableCriteria) {
        final DealsPage dealsPage = new LoginPage(driver)
                .loginToCRM(loginData);
        final ContactsPage contactsPage = dealsPage.sideBar.clickContacts();
        final TableUtils tableUtils = contactsPage.loadContactsTable();
        boolean isRowSelected = tableUtils.printMatchingRow(tableCriteria);

        Assert.assertTrue(isRowSelected, "Contact row not found");
        contactsPage.deleteContactByEmail();
        boolean isStillPresent = tableUtils.printMatchingRow(tableCriteria);
        Assert.assertTrue(isStillPresent, "Contact was NOT deleted");
    }
}