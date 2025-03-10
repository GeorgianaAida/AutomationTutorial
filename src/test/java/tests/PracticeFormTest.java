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

        WebElement phoneElement = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        String phoneValue = "0745259877";
        phoneElement.sendKeys(phoneValue);

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

        By hobbiesOptionsList = By.xpath("//div[@id='hobbiesWrapper']//label");
        for (int index = 0; index < hobbies.size(); index++) {
            String currentText = hobbiesOptionsList.get(index).getText();
            if (hobbies.contains(currentText)){
                elementHelper.clickJSLocator (hobbiesOptionsList.get(index));
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
        elementHelper.clickLocator(submitElement);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("example-modal-sizes-title-lg")));

        WebElement thankYouElement = driver.findElement(By.id("example-modal-sizes-title-lg"));
        String expectedMessage = "Thanks for submitting the form";
        String actualMessage = thankYouElement.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        List<WebElement> rowList = driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(rowList.get(0).getText().contains("Student Name"));
        Assert.assertTrue(rowList.get(0).getText().contains(firstNameValue));
        Assert.assertTrue(rowList.get(0).getText().contains(lastNameValue));

        Assert.assertTrue(rowList.get(1).getText().contains("Student Email"));
        Assert.assertTrue(rowList.get(1).getText().contains(emailValue));

//        Assert.assertTrue(rowList.get(2).getText().contains("Gender"));
//        Assert.assertTrue(rowList.get(2).getText().contains(genderValue));

        Assert.assertTrue(rowList.get(3).getText().contains("Mobile"));
        Assert.assertTrue(rowList.get(3).getText().contains(phoneValue));


        String subjectsStringValue=String.join(", ",subjects);
        Assert.assertTrue(rowList.get(5).getText().contains("Subjects"));
        System.out.println(rowList.get(5).getText());
        System.out.println(subjectsStringValue);
        Assert.assertTrue(rowList.get(5).getText().contains(subjectsStringValue));

        String hobbiesStringValue=String.join(", ",hobbies);
        Assert.assertTrue(rowList.get(6).getText().contains("Hobbies"));
        Assert.assertTrue(rowList.get(6).getText().contains(hobbiesStringValue));

//        Assert.assertTrue(rowList.get(7).getText().contains("Picture"));
//        Assert.assertTrue(rowList.get(7).getText().contains("src/test/resources/Screenshot 2024-10-28 200509.png"));

        Assert.assertTrue(rowList.get(8).getText().contains("Address"));
        Assert.assertTrue(rowList.get(8).getText().contains(currentAddressValue));



        List<WebElement> RowList =driver.findElements(By.xpath("//tbody/tr"));
        Assert.assertTrue(RowList.get(9).getText().contains("State and City"));
        Assert.assertTrue(RowList.get(9).getText().contains(stateInputValue));
        Assert.assertTrue(RowList.get(9).getText().contains(cityInputValue));




    }
}
