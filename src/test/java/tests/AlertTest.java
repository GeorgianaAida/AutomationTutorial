package tests;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.*;
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
        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnAlertSubMenu();

        AlertPage alertPage = new AlertPage(driver);
        alertPage.interactWithAcceptAlert();
        alertPage.interactWithTimerAlert();
        alertPage.interactWithCancelAlert();
        alertPage.interactWithPromtAlert("1");
    }
}