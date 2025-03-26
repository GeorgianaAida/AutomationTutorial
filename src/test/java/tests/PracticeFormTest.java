package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import shareData.ShareData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends ShareData {


    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnFormsMenu();
        indexPage.enterOnPracticeFormSubMenu();

        String firstNameValue = "Aida";
        String lastNameValue = "Georgiana";
        String emailValue = "aida.georgiana.com";
        String genderValue = "Female";
        String mobilePhoneValue = "074555555";
        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");
        subjects.add("Chemistry");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        hobbies.add("Music");
        String addressValue = "Timisoara";
        String pathValue = "src/test/resources/Screenshot 2024-10-28 200509.png";
        String stateInputValue = "NCR";
        String cityInputValue = "Delhi";
        String expectedMessage = "Thanks for submitting the form";

        PracticeFormPage practiceFormPage = new PracticeFormPage(driver);
        practiceFormPage.fillFirstName(firstNameValue);
        practiceFormPage.fillLastName(lastNameValue);
        practiceFormPage.fillEmailValue(emailValue);
        practiceFormPage.fillGenderValue(genderValue);
        practiceFormPage.fillMobilePhoneValue(mobilePhoneValue);
        practiceFormPage.fillSubjects(subjects);
        practiceFormPage.fillHobbies(hobbies);
        practiceFormPage.pictureUpload(pathValue);
        practiceFormPage.fillCurrentAddress(addressValue);
        practiceFormPage.fillState(stateInputValue);
        practiceFormPage.fillCity(cityInputValue);
        practiceFormPage.submitClick();
        practiceFormPage.validateThankYouMessage(expectedMessage);
        practiceFormPage.validateEntireTable(firstNameValue, lastNameValue, emailValue, genderValue, mobilePhoneValue, addressValue, stateInputValue, cityInputValue);
    }
}