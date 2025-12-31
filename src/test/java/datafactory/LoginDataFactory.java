package datafactory;

import com.twozo.crm.model.LoginData;

public class LoginDataFactory {

    public static LoginData loginData() {
        return LoginData.builder()
                .username("jabezblesson158@gmail.com")
                .password("Blesson@05")
                .build();
    }
}