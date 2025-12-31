package utilities;

import com.twozo.crm.model.*;

import org.testng.annotations.DataProvider;

public final class JsonDataProvider {

    @DataProvider(name = "ContactTables", parallel = true)
    public Object[][] provideContactTables() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);

        final WebTable tables = JsonReader.readJsonAsPojo(
                "src/test/resources/web_tables.json",
                "webTables",
                WebTable.class);

        return new Object[][]{
                {loginData, tables}
        };
    }

    @DataProvider(name = "loginAndSearchData", parallel = true)
    public Object[][] loginAndSearchData() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);
        final SearchData searchdata = JsonReader.readJsonAsPojo(
                "src/test/resources/search_option_data.json",
                "SearchData",
                SearchData.class);

        return new Object[][]{
                {loginData, searchdata}
        };
    }

    @DataProvider(name = "loginDataOnly", parallel = true)
    public Object[][] provideLoginDataOnly() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);

        return new Object[][]{
                {loginData}
        };
    }

    @DataProvider(name = "signupData", parallel = true)
    public Object[][] provideSignupData() {
        final SignupData signup = JsonReader.readJsonAsPojo(
                "src/test/resources/signup_data.json",
                "Signup",
                SignupData.class);

        return new Object[][]{
                {signup}
        };
    }

    @DataProvider(name = "companyTables", parallel = true)
    public Object[][] provideCompanyTableData() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);

        final CompanyTables companyTables = JsonReader.readJsonAsPojo(
                "src/test/resources/company_tables.json",
                "CompanyTables",
                CompanyTables.class);

        return new Object[][]{
                {loginData, companyTables}
        };
    }

    @DataProvider(name = "dealsTables", parallel = true)
    public Object[][] provideDealsTableData() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);

        final DealsTables dealsTablesData = JsonReader.readJsonAsPojo(
                "src/test/resources/deals_table_data.json",
                "dealsTable",
                DealsTables.class);

        return new Object[][]{
                {loginData, dealsTablesData}
        };
    }

    @DataProvider(name = "activitiesTable", parallel = true)
    public Object[][] provideActivitiesTableData() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);

        final ActivitiesTable activitiesTable = JsonReader.readJsonAsPojo(
                "src/test/resources/activities_table_data.json",
                "activitiesTable",
                ActivitiesTable.class);

        return new Object[][]{
                {loginData, activitiesTable}
        };
    }

    @DataProvider(name = "mergeContactsTables")
    public Object[][] provideMergeContactTablesData() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);

        final DuplicateContactsData duplicateContactsData = JsonReader.readJsonAsPojo(
                "src/test/resources/merge_contacts.json",
                "duplicateContact",
                DuplicateContactsData.class);

        return new Object[][]{
                {loginData, duplicateContactsData}
        };
    }

    @DataProvider(name = "mergeCompanyTables")
    public Object[][] provideMergeCompanyTablesData() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);

        final DuplicateCompanyData duplicateCompanyData = JsonReader.readJsonAsPojo(
                "src/test/resources/merge_company.json",
                "duplicateCompany",
                DuplicateCompanyData.class);

        return new Object[][]{
                {loginData, duplicateCompanyData}
        };
    }

    @DataProvider(name = "addContacts")
    public Object[][] addNewContacts() {
        final LoginData loginData = JsonReader.readJsonAsPojo(
                "src/test/resources/test_login_data.json",
                "login",
                LoginData.class);

        final ContactData contactData = JsonReader.readJsonAsPojo(
                "src/test/resources/contact_data.json",
                "contactData",
                ContactData.class);

        return new Object[][]{
                {loginData, contactData}
        };
    }
}