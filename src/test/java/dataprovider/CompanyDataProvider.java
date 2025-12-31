package dataprovider;

import datafactory.CompanyDataFactory;
import datafactory.LoginDataFactory;
import org.testng.annotations.DataProvider;

public class CompanyDataProvider {

    @DataProvider(name = "addCompany")
    public Object[][] addCompany() {
        return new Object[][] {
                {LoginDataFactory.loginData(),
                        CompanyDataFactory.createValidCompany()}
        };
    }
}
