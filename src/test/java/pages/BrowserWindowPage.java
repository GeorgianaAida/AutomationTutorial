package pages;

import helpMethods.ElementHelper;
import helpMethods.TabWindowHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageLocators.BrowserWindowLocators.tabButtonElement;
import static pageLocators.BrowserWindowLocators.windowButtonElement;

public class BrowserWindowPage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private TabWindowHelper tabWindowHelper;

    public BrowserWindowPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        tabWindowHelper = new TabWindowHelper(driver);
    }

    public void interactWithSpecificTab() {
        elementHelper.clickJSLocator(tabButtonElement);

        System.out.println(driver.getCurrentUrl());
        tabWindowHelper.switchToSpecificTabWindow(1);

        System.out.println(driver.getCurrentUrl());

        tabWindowHelper.closeCurrentTabWindow();
    }

    public void interactWithSpecificWindow() {
        tabWindowHelper.switchToSpecificTabWindow(0);

        elementHelper.clickJSLocator(windowButtonElement);

        tabWindowHelper.switchToSpecificTabWindow(1);
    }
}