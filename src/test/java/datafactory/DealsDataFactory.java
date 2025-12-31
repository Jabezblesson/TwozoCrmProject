package datafactory;

import com.twozo.crm.model.DealsData;

import net.datafaker.Faker;

public class DealsDataFactory {

    private static final Faker FAKER = new Faker();

    private DealsDataFactory(){}

    public static DealsData createValidDeals() {

        return DealsData.builder()
                .title(FAKER.company().name())
                .pipeline("General")
                .Stage(FAKER.options().option("New"))
                .primaryContact(FAKER.options().option("jabez","jhon","raj"))
                .relatedContact(FAKER.options().option("jabez","jhon","raj"))
                .company(FAKER.options().option("qwert","Boyle-Keeling","Schulist-Schaden"))
                .dealsValue(String.valueOf(FAKER.number().randomDouble(2,1,10000)))
                .salesOwner("Jabez Blesson")
                .build();
    }
}