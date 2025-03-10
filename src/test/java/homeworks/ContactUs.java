package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactUs {

    public WebDriver driver;

    @Test
    public void metodaTest(){
        driver=new ChromeDriver();
        driver.get("https://www.automationtesting.co.uk");
        driver.manage().window().maximize();

        WebElement contactUsElement=driver.findElement(By.id("//a[@href='contactForm.htm']"));
        contactUsElement.click();

        WebElement firstNameElement= driver.findElement(By.name("first_name"));
        String firstNameValue="Aida";
        firstNameElement.sendKeys(firstNameValue);
    }
}
