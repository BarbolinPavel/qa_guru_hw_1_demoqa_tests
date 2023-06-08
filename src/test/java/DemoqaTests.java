import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaTests {
    @BeforeAll
    static void beforeAll() {
        //Configuration.browser="firefox";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadTimeout = 50000;
    }

    @Test
    void registrationFormPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Ilon");
        $("#lastName").setValue("Mask");
        $("#userEmail").setValue("Mask@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $("[aria-label=\"Choose Tuesday, June 13th, 2023\"]").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("img/umbrella.png");
        $("#currentAddress").setValue("Heel");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        //Проверка на появление элемента
        $(".modal-dialog").shouldBe(Condition.appear);

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Ilon"), text("Mask"), text("Mask@gmail.com"));
    }
}
