package com.demoqa.tests;

import com.demoqa.pages.TestPracticeFormPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.testData.TestData.*;
import static java.lang.String.format;

public class TestPracticeFormPageObjectWithFakerData extends TestBase{
    TestPracticeFormPage testPracticeFormPage = new TestPracticeFormPage();

    @Test
    void practiceFormTest() {
        testPracticeFormPage.openPage()
                .setFirstName(getFirstName())
                .setLastName(getLastName())
                .setEmail(getEmail())
                .setGenter("Female")
                .setNumber(getPhoneNumber())
                .setBirthDate("5", "June", "1994")
                .setSubjects("Physics")
                .setHobbies("Sports")
                .setPathFile("src/test/resources/JSON_Momoa.jpg")
                .setAddress(getCurrentAddress())
                .setState("Haryana")
                .setCity("Karnal");
        $("#submit").pressEnter();

        String expectedFullName = format("%s %s",getFirstName() ,getLastName());
        testPracticeFormPage.checkResultVisible();
        testPracticeFormPage.checkResult("Student Name", expectedFullName)
                .checkResult("Student Email",getEmail())
                .checkResult("Gender", "Female")
                .checkResult("Mobile",getPhoneNumber())
                .checkResult("Date of Birth", "05 June,1994")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "JSON_Momoa.jpg")
                .checkResult("Address",getCurrentAddress())
                .checkResult("State and City", "Haryana Karnal");

    }

    @Test
    void practiceFormTestMini() {
        testPracticeFormPage.openPage()
                .setFirstName("Ivan")
                .setLastName("Navi")
                .setGenter("Female")
                .setNumber("8999000881");

        $("#dateOfBirthInput").click();
        $("#submit").pressEnter();


        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Ivan Navi"),
                text("Female"),
                text("8999000881"));
    }
}