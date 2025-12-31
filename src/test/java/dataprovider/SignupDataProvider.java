package dataprovider;

import datafactory.CompleteSignupDataFactory;
import datafactory.SignupDataFactory;

import org.testng.annotations.DataProvider;

public class SignupDataProvider {

    @DataProvider(name = "SignupData")
    public Object[][] signup() {
        return new Object[][]{
                {SignupDataFactory.signupData(),
                        CompleteSignupDataFactory.completeSignupData()
                }
        };
    }
}
