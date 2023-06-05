package tests;


import org.junit.jupiter.api.Test;

public class FillAllFieldsPageObjectTest extends BaseTest {
    @Test
    void successfulRegistrationTest(){

        registrationPage.openPage()
                .setFirstName("Вискарик")
                .setLastName("Вкусный")
                .setEmail("fdsfdf@fsdfdsf.ru")
                .setGender("Male")
                .setNumber("9610001144")
                .setBirthDay("30","April","1995")
                .setSubject("Hindi")
                .setHobbi("Reading")
                .setHobbi("Music")
                .uploadPicture("opsznH5vIhU.png")
                .setAddress("Брянск")
                .selectState("Haryana")
                .selectCity("Karnal")
                .clickButtonSumbit();
    // Проверка значений
        registrationPage.verifyTitle()
                .verifyResult("Student Name", "Вискарик Вкусный")
                .verifyResult("Student Email", "fdsfdf@fsdfdsf.ru")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "9610001144")
                .verifyResult("Date of Birth", "30 April,1995")
                .verifyResult("Subjects", "Hindi")
                .verifyResult("Hobbies", "Reading, Music")
                .verifyResult("Picture", "opsznH5vIhU.png")
                .verifyResult("Address", "Брянск")
                .verifyResult("State and City", "Haryana Karnal");


    }
}
