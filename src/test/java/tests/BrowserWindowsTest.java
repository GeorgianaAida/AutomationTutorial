package tests;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import shareData.ShareData;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowsTest extends ShareData {


    private static final Logger log = LoggerFactory.getLogger(BrowserWindowsTest.class);

    @Test
    public void metodaTest() {

        TabWindowHelper tabWindowHelper = new TabWindowHelper(driver);
        ElementHelper elementHelper = new ElementHelper(driver);


//        JavascriptExecutor executor = (JavascriptExecutor) driver;

        By alertsFrameWindowMenu = By.xpath("//h5[text()='Alerts, Frame & Windows']");
//        executor.executeScript("arguments[0].click();", alertsFrameWindowMenu);
        elementHelper.clickJSLocator(alertsFrameWindowMenu);

        By browserWindowsSubmenu = By.xpath("//span[text()='Browser Windows']");
//        browserWindowsSubmenu.click();
        elementHelper.clickJSLocator(browserWindowsSubmenu);

        By newTabClick = By.id("tabButton");
//        newTabClick.click();
        elementHelper.clickJSLocator(newTabClick);

        System.out.println(driver.getCurrentUrl());

//        List<String> tabs= new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        System.out.println(driver.getCurrentUrl());
//        driver.close();


        tabWindowHelper.switchToSpecificTabWindow(1);
        System.out.println(driver.getCurrentUrl());

        tabWindowHelper.closeCurrentTabWIndow();

        tabWindowHelper.switchToSpecificTabWindow(0);

       By newWindowClick = By.id("windowButton");
       elementHelper.clickJSLocator(newWindowClick);
        System.out.println(driver.getCurrentUrl());

        tabWindowHelper.switchToSpecificTabWindow(1);
//        System.out.println(driver.getCurrentUrl());

//        List<String> window= new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(window.get(1));
//        System.out.println(driver.getCurrentUrl());
//        driver.close();


    }
}