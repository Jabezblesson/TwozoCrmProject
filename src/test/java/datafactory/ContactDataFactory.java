package datafactory;

import com.twozo.crm.model.ContactData;

import net.datafaker.Faker;

import java.util.List;

public class ContactDataFactory {

  private static final Faker FAKER = new Faker();

    private ContactDataFactory() {
    }

    public static ContactData createValidContact() {
        return ContactData.builder()
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .email(FAKER.internet().emailAddress())
                .emailType("Work")
                .phone(FAKER.phoneNumber().cellPhone())
                .phoneType("Mobile")
                .company("qwert")
                .designation(FAKER.job().title())
                .owner("Jabez Blesson")
                .lifeCycleStage("Customer")
                .lifeCycleStatus("Won")
                .facebookProfile("https://facebook.com/")
                .linkedInProfile("https://linkedin.com/in/")
                .subscriptionStatus("Subscribed")
                .subscriptionType(List.of("Conference and events","Product updates","Promotional"))
                .build();
    }
}
