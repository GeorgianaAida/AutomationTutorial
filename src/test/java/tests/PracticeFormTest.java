package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import shareData.ShareData;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest extends ShareData {


    @Test
    public void metodaTest() {

        ElementHelper elementHelper=new ElementHelper(driver);
        PageHelper pageHelper=new PageHelper(driver);


        By formsMenu = By.xpath("//h5[text()='Forms']");
        elementHelper.clickJSLocator(formsMenu);

        By practiceFormSubmenu = By.xpath("//span[text()='Practice Form']");
        elementHelper.clickJSLocator(practiceFormSubmenu);

        By firstNameElement = By.xpath("//input[@placeholder='First Name']");
        String firstNameValue = "Aida";
//        firstNameElement.sendKeys(firstNameValue);
        elementHelper.fillLocator(firstNameElement,firstNameValue);

        By lastNameElement = By.xpath("//input[@placeholder='Last Name']");
        String lastNameValue = "Georgiana";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By emailElement = By.xpath("//input[@placeholder='name@example.com']");
        String emailValue = "aida.georgiana@yahoo.com";
        elementHelper.fillLocator(emailElement,emailValue);



        String genderValue = "Female";
       By genderOptionsElement= By.xpath("//input[@name='gender']");
        List<WebElement> genderOptionsList = driver.findElements(genderOptionsElement);
        if (genderValue.equals("Male")) {
            elementHelper.clickJSLocator(genderOptionsList.get(0));
        }
        if (genderValue.equals("Female")) {
            elementHelper.clickJSLocator(genderOptionsList.get(1));
        }
        if (genderValue.equals("Other")) {
           elementHelper.clickJSLocator(genderOptionsList.get(2));
        }

        By phoneElement = By.xpath("//input[@placeholder='Mobile Number']");
        String phoneValue = "0745259877";
        elementHelper.fillLocator(phoneElement,phoneValue);

        pageHelper.scrollByPage(0,500);

        By subjectsElement = By.id("subjectsInput");
       elementHelper.clickJSLocator(subjectsElement);

//        String subjectsValue = "Maths";
//        subjectsElement.sendKeys(subjectsValue);
//        subjectsElement.sendKeys(Keys.ENTER);
//        String subjectsValue2 = "Art";
//        subjectsElement.sendKeys(subjectsValue2);
//        subjectsElement.sendKeys(Keys.ENTER);

        //Lista de stringuri si se adaug elementele pe care vreau sa le selectez
        //Trebuie sa parcurg lista pe care am facut-o cu un for
        //in interiorul for-ului trebuie sa completez pe rand fiecare valoare in subjectsElement


        List<String> subjects = new ArrayList<>();
        subjects.add("Maths");
        subjects.add("Arts");
        subjects.add("Biology");
        subjects.add("Chemistry");


        for (int index = 0; index < subjects.size(); index++) {
//            subjectsElement.sendKeys(subjects.get(index));
//            subjectsElement.sendKeys(Keys.ENTER);
            elementHelper.fillPressLocator(subjectsElement,subjects.get(index),Keys.ENTER);
        }


        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sports");
        hobbies.add("Reading");
        hobbies.add("Music");

        List<WebElement> hobbiesOptionList=driver.findElements(By.xpath("//div[@id='hobbiesWrapper']//label"));
        for (int index=0;index<hobbiesOptionList.size();index++){
            String currentText=hobbiesOptionList.get(index).getText();
            if (hobbies.contains(currentText)){
               elementHelper.clickJSLocator(hobbiesOptionList.get(index));;
//                hobbiesOptionList.get(index).click();
            }

        }


        By pictureElement = By.id("uploadPicture");
        File file = new File("src/test/resources/Screenshot 2024-10-28 200509.png");
        elementHelper.fillLocator(pictureElement,file.getAbsolutePath());

        By currentAddressElement = By.id("currentAddress");
        String currentAddressValue = "Dumbravita, jud Timis";
        elementHelper.fillLocator(currentAddressElement,currentAddressValue);

        By stateElement = By.xpath("//div[text()='Select State']");
        elementHelper.clickJSLocator(stateElement);

        By stateInputElement = By.id("react-select-3-input");
        String stateInputValue = "NCR";
        elementHelper.fillPressLocator(stateInputElement,stateInputValue,Keys.ENTER);

        By cityElement = By.xpath("//div[text()='Select City']");
        elementHelper.clickJSLocator(cityElement);

        By cityInputElement = By.id("react-select-4-input");
        String cityInputValue = "Delhi";
        elementHelper.fillPressLocator(cityInputElement,cityInputValue,Keys.ENTER);


        By submitElement = By.id("submit");
        elementHelper.clickJSLocator(submitElement);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        By thankYouElement = By.id("example-modal-sizes-title-lg");
        String expectedMessage = "Thanks for submitting the form";
        elementHelper.validateTextLocator(thankYouElement,expectedMessage);
//        String actualMessage = thankYouElement.getText();
//        Assert.assertEquals(actualMessage, expectedMessage);
//        System.out.println("Testul a fost validat!");

       By rowListElement = By.xpath("//tbody/tr");

        List<WebElement> rowList = driver.findElements(rowListElement);
        elementHelper.validateTextContainsElement(rowList.get(0),("Student Name"));
        elementHelper.validateTextContainsElement(rowList.get(0),(firstNameValue));
        elementHelper.validateTextContainsElement(rowList.get(0),(lastNameValue));

        elementHelper.validateTextContainsElement(rowList.get(1),("Student Email"));
        elementHelper.validateTextContainsElement(rowList.get(1),(emailValue));

        elementHelper.validateTextContainsElement(rowList.get(2),("Gender"));
        elementHelper.validateTextContainsElement(rowList.get(2),(genderValue));

        elementHelper.validateTextContainsElement(rowList.get(3),("Mobile"));
        elementHelper.validateTextContainsElement(rowList.get(3),(phoneValue));


        String subjectsStringValue=String.join(", ",subjects);
        elementHelper.validateTextContainsElement(rowList.get(5),("Subjects"));
        System.out.println(rowList.get(5).getText());
        System.out.println(subjectsStringValue);
        elementHelper.validateTextContainsElement(rowList.get(5),(subjectsStringValue));

        String hobbiesStringValue=String.join(", ",hobbies);
        elementHelper.validateTextContainsElement(rowList.get(6),("Hobbies"));
        elementHelper.validateTextContainsElement(rowList.get(6),(hobbiesStringValue));

//        elementHelper.validateTextContainsElement(rowList.get(7),("Picture"));
//        elementHelper.validateTextContainsElement(rowList.get(7),("src/test/resources/Screenshot 2024-10-28 200509.png"));

        elementHelper.validateTextContainsElement(rowList.get(8),("Address"));
        elementHelper.validateTextContainsElement(rowList.get(8),(currentAddressValue));



//        List<WebElement> RowList =driver.findElements(By.xpath("//tbody/tr"));
        elementHelper.validateTextContainsElement(rowList.get(9),("State and City"));
        elementHelper.validateTextContainsElement(rowList.get(9),(stateInputValue));
        elementHelper.validateTextContainsElement(rowList.get(9),(cityInputValue));




    }
}
