package datafactory;

import com.twozo.crm.model.CompleteSignupData;

import net.datafaker.Faker;

public class CompleteSignupDataFactory {

    private static final Faker FAKER = new Faker();

    public CompleteSignupDataFactory() {
    }

    public static CompleteSignupData completeSignupData() {
        return CompleteSignupData.builder()
                .companyName(FAKER.company().name())
                .jobRole(FAKER.options().option("Admin", "Marketing", "Finance"))
                .currency(FAKER.options().option("INR", "USD", "AED"))
                .timezone(FAKER.options().option("(UTC+05:30) Asia/Kolkata", "(UTC+00:00) Africa/Accra"))
                .build();
    }
}