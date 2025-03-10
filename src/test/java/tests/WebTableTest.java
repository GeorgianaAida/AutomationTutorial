package tests;

import helpMethods.ElementHelper;
import helpMethods.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import shareData.ShareData;

import java.util.List;

public class WebTableTest extends ShareData {

    @Test
    public void metodaTest() {
        //deschidem un browser

//        JavascriptExecutor executor = (JavascriptExecutor) driver;
        ElementHelper elementHelper=new ElementHelper(driver);
        PageHelper pageHelper=new PageHelper(driver);

        By elementsMenu = By.xpath("//h5[text()='Elements']");
        elementHelper.clickJSLocator(elementsMenu);

        By webTableSubmenu = By.xpath("//span[text()='Web Tables']");
        elementHelper.clickLocator(webTableSubmenu);

        List<WebElement> tableRowList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowList.size(), 3, "Valoarea initiala a tabelului nu este 3");



        //identificam un element
        By addElement = By.id("addNewRecordButton");
        elementHelper.clickJSLocator(addElement);


        By firstNameElement = By.id("firstName");
        String firstNameValue = "Aida";
        elementHelper.fillLocator(firstNameElement,firstNameValue);


        By lastNameElement = By.id("lastName");
        String lastNameValue = "Georgiana";
        elementHelper.fillLocator(lastNameElement,lastNameValue);

        By ageElement = By.id("age");
        String ageValue = "34";
        elementHelper.fillLocator(ageElement,ageValue);

        By userEmailElement = By.id("userEmail");
        String userEmailValue = "aida.georgiana@yahoo.com";
        elementHelper.fillLocator(userEmailElement,userEmailValue);

        By salaryElement = By.id("salary");
        String salaryValue = "5000";
        elementHelper.fillLocator(salaryElement,salaryValue);

        By departmentElement = By.id("department");
        String departmentValue = "IT";
        elementHelper.fillLocator(departmentElement,departmentValue);


        By submitElement = By.id("submit");
        elementHelper.clickJSLocator(submitElement);

        tableRowList = driver.findElements(By.xpath("//div[@class='rt-tbody']/div/div[@class='rt-tr -even' or @class='rt-tr -odd']"));
        Assert.assertEquals(tableRowList.size(), 4, "Valoarea actuala a tabelului nu este 4");
        String expectedRow = tableRowList.get(3).getText();
        Assert.assertTrue(expectedRow.contains(firstNameValue));
        Assert.assertTrue(expectedRow.contains(lastNameValue));
        Assert.assertTrue(expectedRow.contains(userEmailValue));
        Assert.assertTrue(expectedRow.contains(ageValue));
        Assert.assertTrue(expectedRow.contains(salaryValue));
        Assert.assertTrue(expectedRow.contains(departmentValue));


        //edit functionality
        By editElement = By.id("edit-record-4");
        elementHelper.clickJSLocator(editElement);

        By editFirstNameElement = By.id("firstName");
        String editFirstNameValue = "Alexandra";

        elementHelper.fillLocator(editFirstNameElement,editFirstNameValue);

        By editLastNameElement = By.id("lastName");
        String editLastNameValue = "Ioana";

        elementHelper.fillLocator(editLastNameElement,editLastNameValue);

        By editUserEmailElement = By.id("userEmail");
        String editUserEmailValue = "ioana.alexandra@gmail.com";

        elementHelper.fillLocator(editUserEmailElement,editUserEmailValue);

        By editAgeElement = By.id("age");
        String editAgeValue = "30";

        elementHelper.fillLocator(editAgeElement,editAgeValue);

        By editSalaryElement = By.id("salary");
        String editSalaryValue = "9000";

        elementHelper.fillLocator(editSalaryElement,editSalaryValue);

        By editDepartmentElement = By.id("department");
        String editDepartmentValue = "Marketing";

        elementHelper.fillLocator(editDepartmentElement,editDepartmentValue);

        By resubmitElement = By.id("submit");
        elementHelper.clickJSLocator(resubmitElement);



    }
}
