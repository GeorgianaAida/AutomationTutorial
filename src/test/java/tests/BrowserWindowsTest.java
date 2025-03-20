package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.BrowserWindowPage;
import pages.IndexPage;
import shareData.ShareData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTest extends ShareData {

    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();

        indexPage.enterOnBrowserWindowSubmenu();

        BrowserWindowPage browserWindowPage = new BrowserWindowPage(driver);
        browserWindowPage.interactWithSpecificTab();
        browserWindowPage.interactWithSpecificWindow();

    }
}