package support;

import com.github.javafaker.Faker;

import java.util.Locale;

public class GeneratorFaker {
    private Faker faker;
    private String email;

    public GeneratorFaker() {
        faker = new Faker(new Locale("pt-BR"));
    }

    public String getEmail() {
        email = faker.internet().emailAddress();
        return email;
    }
}