package shareData;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class ShareData {
    //aceasta clasa are  ca rol sa deschida/inchida un browser
    //vom face acest lucru folosind adnotari de TestNG

    public WebDriver driver;

    @BeforeMethod
    public void prepareEnviroment(){

        driver = new ChromeDriver();

        driver.get("https://demoqa.com");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        JavascriptExecutor executor = (JavascriptExecutor) driver;

    }
    @AfterMethod
    public void clearEnviroment(){
        driver.quit();

    }
}
