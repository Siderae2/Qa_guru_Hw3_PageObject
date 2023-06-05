package pages;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.TableResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResultComponent tableResultComponent = new TableResultComponent();
    SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            userEmail = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            birthDay = $("#dateOfBirthInput"),
            subject = $("#subjectsInput"),
            hobbies = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            address = $("#currentAddress"),
            state = $("#stateCity-wrapper").$("#state"),
            city = $(byText("Select City")),
            buttonSubmit = $("#submit");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public RegistrationPage setFirstName(String text){
        firstName.setValue(text);
        return this;
    }
    public RegistrationPage setLastName(String text){
        lastName.setValue(text);
        return this;
    }
    public RegistrationPage setEmail(String text){
        userEmail.setValue(text);
        return this;
    }
    public RegistrationPage setGender(String text){
       genderWrapper.$(byText(text)).click();
        return this;
    }
    public RegistrationPage setNumber(String number){
        userNumber.setValue(number);
        return this;
    }
    public RegistrationPage setBirthDay(String day, String month, String year) {
        birthDay.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubject(String text){
        subject.setValue(text).sendKeys(Keys.ENTER);
        return this;
    }
    public RegistrationPage setHobbi(String text){
        hobbies.$(byText(text)).click();
        return this;
    }
    public RegistrationPage uploadPicture(String fileName){
        picture.uploadFromClasspath(fileName);
        return this;
    }
    public RegistrationPage setAddress(String text){
        address.setValue(text);
        return this;
    }
    public RegistrationPage selectState(String text){
        state.click();
        $("#stateCity-wrapper").$(byText(text)).click();
        return this;
    }
    public RegistrationPage selectCity(String text){
        city.click();
        $(byText(text)).click();
        return this;
    }
    public RegistrationPage clickButtonSumbit(){
        buttonSubmit.click();
        return this;
    }
    public RegistrationPage verifyTitle() {
        tableResultComponent.titleVerify();
        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        tableResultComponent.tableVerify(key, value);
        return this;
    }

}
