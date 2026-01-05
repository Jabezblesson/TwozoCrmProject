package utilities;

import net.datafaker.Faker;

public class EmailUtils {

public static final Faker faker = new Faker();

private static String generatedEmail;

private EmailUtils() {}

    public static String getRandomYopMail () {
    if(generatedEmail == null) {
        generatedEmail = faker.internet().emailAddress().replace("@", "").replace(".com","")
                + faker.number().digits(3)
                + "@yopmail.com";
    }
        return generatedEmail;
    }
    public static String getYopMailInbox() {
        return generatedEmail.split("@")[0];
    }
}