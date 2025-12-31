package dataprovider;

import datafactory.DealsDataFactory;
import datafactory.LoginDataFactory;

import org.testng.annotations.DataProvider;

public class DealsDataProvider {

    @DataProvider(name="addDeals")
    public Object[][] addNewDeals() {
        return new Object[][]{
                {LoginDataFactory.loginData(),
                        DealsDataFactory.createValidDeals()}
        };
    }
}