package com.demoqa.testData;

import com.github.javafaker.Faker;

public class TestData {

    //                  Create faker data

    static Faker faker = new Faker();
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = faker.internet().emailAddress();
    public static String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    public static String currentAddress = faker.elderScrolls().quote();

    //                  filling in my data
    public static String gender = "Female";
    public static String birthDate = "05 June,1994";
    public static String subjects = "Physics";
    public static String hobbies = "Sports";
    public static String pathFile = "src/test/resources/JSON_Momoa.jpg";
    public static String state = "Haryana";
    public static String city = "Karnal";


    //                  Fills element

    public static String getFirstName() {return firstName;}
    public static String getLastName() {return lastName;}
    public static String getEmail() {return email;}
    public static String getPhoneNumber() {return phoneNumber;}
    public static String getCurrentAddress() {return currentAddress;}
    public static String getGender() {return gender;}
    public static String getBirthDate() {return birthDate;}
    public static String getSubjects() {return subjects;}
    public static String getHobbies() {return hobbies;}
    public static String getPathFile() {return pathFile;}
    public static String getState() {return state;}
    public static String getCity() {return city;}
}

//    static String firstName = "Ivan",
//        lastName = "Navi",
//        email = "Ivan@navi.com",
//        number = "8999000881",
//        currentAddress = "currentAddress";

