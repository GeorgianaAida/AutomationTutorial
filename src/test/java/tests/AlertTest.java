package tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AlertPage;
import pages.IndexPage;
import shareData.ShareData;

import java.time.Duration;

public class AlertTest extends ShareData {


    @Test
    public void metodaTest() {

        ElementHelper elementHelper = new ElementHelper(driver);
        AlertHelper alertHelper = new AlertHelper(driver);

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnAlertSubmenu();

        AlertPage alertPage=new AlertPage(driver);
        alertPage.interactWithAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCanacelAlert();
        alertPage.interactWithPromtAlert("1");


    }
}
