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
                .setGenter(getGender())
                .setNumber(getPhoneNumber())
                .setBirthDate(getDay(), getMonth(), getYear())
                .setSubjects(getSubjects())
                .setHobbies(getHobbies())
                .setPathFile(getPathFile())
                .setAddress(getCurrentAddress())
                .setState(getState())
                .setCity(getCity());
        $("#submit").pressEnter();

        String expectedFullName = format("%s %s",getFirstName() ,getLastName());
        testPracticeFormPage.checkResultVisible();
        testPracticeFormPage.checkResult("Student Name", expectedFullName)
                .checkResult("Student Email",getEmail())
                .checkResult("Gender", getGender())
                .checkResult("Mobile",getPhoneNumber())
                .checkResult("Date of Birth", getBirthDay())
                .checkResult("Subjects", getSubjects())
                .checkResult("Hobbies", getHobbies())
                .checkResult("Picture", getFileName())
                .checkResult("Address",getCurrentAddress())
                .checkResult("State and City", getStateAndCity());

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