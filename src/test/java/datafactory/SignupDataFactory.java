package datafactory;

import com.twozo.crm.model.SignupData;

import net.datafaker.Faker;

import utilities.EmailUtils;

public class SignupDataFactory {

    private static final String email = EmailUtils.getRandomYopMail();

    private static final Faker FAKER = new Faker();

    public static SignupData signupData() {
        return SignupData.builder()
                .username(FAKER.name().firstName())
                .emailId(email)
                .password("Test@1234")
                .phone(FAKER.phoneNumber().phoneNumber())
                .build();
    }
}
