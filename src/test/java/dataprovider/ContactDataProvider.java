package dataprovider;

import datafactory.ContactDataFactory;
import datafactory.LoginDataFactory;

import org.testng.annotations.DataProvider;

public class ContactDataProvider {

    @DataProvider(name = "addContact")
    public Object[][] addContact() {
        return  new Object[][]{
                {LoginDataFactory.loginData(),
                ContactDataFactory.createValidContact()},

                {LoginDataFactory.loginData(),
                ContactDataFactory.createValidContact()}
        };
    }
}
