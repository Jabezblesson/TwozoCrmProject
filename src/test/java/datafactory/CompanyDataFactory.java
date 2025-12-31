package datafactory;

import com.twozo.crm.model.CompanyData;

import net.datafaker.Faker;

public class CompanyDataFactory {

    private static final Faker FAKER = new Faker();

   private CompanyDataFactory(){}

    public static CompanyData createValidCompany() {
       return CompanyData.builder()
               .companyName(FAKER.company().name())
               .webSite(FAKER.internet().url())
               .owner("Jabez Blesson")
               .addressOne(FAKER.address().fullAddress())
               .addressTwo(FAKER.address().secondaryAddress())
               .city(FAKER.address().city())
               .state(FAKER.address().state())
               .country(FAKER.address().country())
               .pinCode(FAKER.address().postcode())
               .build();
    }
}
