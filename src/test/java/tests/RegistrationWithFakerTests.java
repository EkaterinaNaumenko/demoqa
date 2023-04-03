package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static tests.TestData.*;

public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {

        registrationPage.openPage()
                .removeBanners()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(mobile)
                .setBirthDate(dayOfBirthDate, monthOfBirthDate, yearOfBirthDate)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setUploadPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitButton();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", mobile)
                .verifyResults("Date of Birth", dayOfBirthDate + " " +
                        monthOfBirthDate + "," + yearOfBirthDate)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", picture)
                .verifyResults("Address", address)
                .verifyResults("State and City", state + " " + city);
    }
}
