package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.IndexLocators;

public class IndexPage {

    private WebDriver driver;
    private ElementHelper elementHelper;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void enterOnAlertFrameWindowMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsFrameWindowsMenu);
        LoggerUtility.infoTest("The user clicks on Alert Frame Window Menu");
    }

    public void enterOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsSubMenu);
        LoggerUtility.infoTest("The user clicks on Alerts SubMenu");
    }

    public void enterOnBrowserWindowSubmenu(){
        elementHelper.clickJSLocator((IndexLocators.browserSubMenu));
        LoggerUtility.infoTest("The user clicks on Browser SubMenu");
    }

    public void enterOnFrameSubmenu(){
        elementHelper.clickJSLocator(IndexLocators.frameSubMenu);
        LoggerUtility.infoTest("The user clicks on Frame SubMenu");
    }

    public void enterOnFormsMenu(){
        elementHelper.clickJSLocator(IndexLocators.formsMenu);
        LoggerUtility.infoTest("The user clicks on Forms Menu");
    }

    public void enterOnPracticeFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormSubMenu);
        LoggerUtility.infoTest("The user clicks on Forms SubMenu");
    }

}