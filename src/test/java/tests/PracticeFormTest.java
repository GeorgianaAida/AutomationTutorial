package tests;

import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.PracticeFormPage;
import shareData.ShareData;
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
        String lastNameValue = "Alexandroniu";
        String emailValue = "aida.georgiana@gmail.com";
        String genderValue = "Female";
        String mobilePhoneValue = "0711223344";
        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");
        subjects.add("Chemistry");
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        hobbies.add("Music");
        String addressValue = "Dumbravita";
        String pathValue = "src/test/resources/Screenshot 2024-10-28 200509.png";


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


//        By stateElement = By.xpath("//div[text()='Select State']");
//        elementHelper.clickJSLocator(stateElement);
//
//        By stateInputElement = By.id("react-select-3-input");
//        String stateInputValue = "NCR";
//        elementHelper.fillPressLocator(stateInputElement,stateInputValue,Keys.ENTER);
//
//        By cityElement = By.xpath("//div[text()='Select City']");
//        elementHelper.clickJSLocator(cityElement);
//
//        By cityInputElement = By.id("react-select-4-input");
//        String cityInputValue = "Delhi";
//        elementHelper.fillPressLocator(cityInputElement,cityInputValue,Keys.ENTER);
//
//
//        By submitElement = By.id("submit");
//        elementHelper.clickJSLocator(submitElement);
//
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));
//
//        By thankYouElement = By.id("example-modal-sizes-title-lg");
//        String expectedMessage = "Thanks for submitting the form";
//        elementHelper.validateTextLocator(thankYouElement,expectedMessage);
////        String actualMessage = thankYouElement.getText();
////        Assert.assertEquals(actualMessage, expectedMessage);
////        System.out.println("Testul a fost validat!");
//
//       By rowListElement = By.xpath("//tbody/tr");
//
//        List<WebElement> rowList = driver.findElements(rowListElement);
//        elementHelper.validateTextContainsElement(rowList.get(0),("Student Name"));
//        elementHelper.validateTextContainsElement(rowList.get(0),(firstNameValue));
//        elementHelper.validateTextContainsElement(rowList.get(0),(lastNameValue));
//
//        elementHelper.validateTextContainsElement(rowList.get(1),("Student Email"));
//        elementHelper.validateTextContainsElement(rowList.get(1),(emailValue));
//
//        elementHelper.validateTextContainsElement(rowList.get(2),("Gender"));
//        elementHelper.validateTextContainsElement(rowList.get(2),(genderValue));
//
//        elementHelper.validateTextContainsElement(rowList.get(3),("Mobile"));
//        elementHelper.validateTextContainsElement(rowList.get(3),(phoneValue));
//
//
//        String subjectsStringValue=String.join(", ",subjects);
//        elementHelper.validateTextContainsElement(rowList.get(5),("Subjects"));
//        System.out.println(rowList.get(5).getText());
//        System.out.println(subjectsStringValue);
//        elementHelper.validateTextContainsElement(rowList.get(5),(subjectsStringValue));
//
//        String hobbiesStringValue=String.join(", ",hobbies);
//        elementHelper.validateTextContainsElement(rowList.get(6),("Hobbies"));
//        elementHelper.validateTextContainsElement(rowList.get(6),(hobbiesStringValue));
//
////        elementHelper.validateTextContainsElement(rowList.get(7),("Picture"));
////        elementHelper.validateTextContainsElement(rowList.get(7),("src/test/resources/Screenshot 2024-10-28 200509.png"));
//
//        elementHelper.validateTextContainsElement(rowList.get(8),("Address"));
//        elementHelper.validateTextContainsElement(rowList.get(8),(currentAddressValue));
//
//
//
////        List<WebElement> RowList =driver.findElements(By.xpath("//tbody/tr"));
//        elementHelper.validateTextContainsElement(rowList.get(9),("State and City"));
//        elementHelper.validateTextContainsElement(rowList.get(9),(stateInputValue));
//        elementHelper.validateTextContainsElement(rowList.get(9),(cityInputValue));
//
//
//
//
    }
}