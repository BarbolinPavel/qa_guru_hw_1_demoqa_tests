package guru.qa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import guru.qa.TestBase;
import guru.qa.components.RandomUtilsFaker;

import static io.qameta.allure.Allure.step;


public class DemoqaTests extends TestBase{

    @Tag("regTest")
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

        step("Open page",()->{
            registrationPage.openPage();
        });

        step("Fill form",()->{
            registrationPage.setFirstName(userName)
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
        });

        step("Verify results",()->{
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
        });
    }
}
