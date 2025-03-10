package tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import shareData.ShareData;

import java.time.Duration;

public class AlertTest extends ShareData {


    @Test
    public void metodaTest() {

        ElementHelper elementHelper=new ElementHelper(driver);
        AlertHelper alertHelper=new AlertHelper(driver);


        By alertsFrameWindowMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
        elementHelper.clickJSLocator(alertsFrameWindowMenu);

        By alertsSubmenu = By.xpath("//span[text()='Alerts']");
        elementHelper.clickJSLocator(alertsSubmenu);

       By alertOkElement = By.id("alertButton");
       elementHelper.clickJSLocator(alertOkElement);

       alertHelper.acceptAlert();

//        Alert alertOk = driver.switchTo().alert();
//        System.out.println(alertOk.getText());
//        alertOk.accept();

        By timerAlertElement = By.id("timerAlertButton");
        elementHelper.clickJSLocator(timerAlertElement);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alertTimer = driver.switchTo().alert();
//        System.out.println(alertTimer.getText());
//        alertTimer.accept();

        alertHelper.acceptAlert();

        By confirmElement = By.id("confirmButton");
        elementHelper.clickJSLocator(confirmElement);

//        Alert alertOkCancel = driver.switchTo().alert();
//        System.out.println(alertOkCancel.getText());
//        alertTimer.dissmis();

        alertHelper.cancelAlert();

        By promtElement = By.id("promtButton");
        elementHelper.clickJSLocator(promtElement);

//        Alert alertPromt = driver.switchTo().alert();
//        System.out.println(alertPromt.getText());
//        String alertValue = "Ai grija!";
//        alertPromt.sendKeys(alertValue);
//        alertPromt.accept();

        alertHelper.fillAlert("Altceva!");

    }
}
