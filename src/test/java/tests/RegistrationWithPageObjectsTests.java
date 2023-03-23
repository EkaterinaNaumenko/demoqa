package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        String firstName = "Katya";
        String lastName = "Popova";
        String email = "katya@gmail.com";
        String gender = "Female";
        String mobile = "8923456789";
        String dayOfBirthDate = "20";
        String monthOfBirthDate = "April";
        String yearOfBirthDate = "2002";
        String subject = "Economics";
        String hobbies = "Sports";
        String picture = "3.png";
        String address = "Moscow";
        String state = "NCR";
        String city = "Delhi";

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
