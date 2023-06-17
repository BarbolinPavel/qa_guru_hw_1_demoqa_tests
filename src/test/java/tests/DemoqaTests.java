package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestBase;
import pages.components.RandomUtilsFaker;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaTests extends TestBase{


    @Test
    void registrationFormPage() {
        String userName = RandomUtilsFaker.getName();
        String userLastName = RandomUtilsFaker.getLastName();
        String userEmail = RandomUtilsFaker.getEmail();
        String userGender = "Female";
        String userNumber = RandomUtilsFaker.getNumber();
        String userSubjects = "Maths";
        String userHobbies = "Reading";
        String userCurrentAddress = RandomUtilsFaker.getAddress();
        String userState = "Haryana";
        String userCity = "Karnal";

        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setNumber(userNumber)
                .setDateOfBirth("01","June","2000")
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadPicture("img/umbrella.png")
                .setCurrentAddress(userCurrentAddress)
                .setState(userState)
                .setCity(userCity)
                .clickSubmit()
                .openTable();

        registrationPage.checkResult("Student Name", userName + " " + userLastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", userGender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", "01 June,2000")
                .checkResult("Subjects", userSubjects)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", "umbrella.png")
                .checkResult("Address", userCurrentAddress)
                .checkResult("State and City", userState + " " + userCity);
    }
}
