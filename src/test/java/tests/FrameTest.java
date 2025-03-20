package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageLocators.IndexLocators;
import pages.FramePage;
import pages.IndexPage;
import shareData.ShareData;

import java.time.Duration;

public class FrameTest extends ShareData {


    @Test
    public void metodaTest() {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.enterOnAlertFrameWindowMenu();
        indexPage.enterOnFrameSubmenu();

        FramePage framePage = new FramePage(driver);

        framePage.switchToSpecificTab();

        framePage.switchToParent();
    }
}