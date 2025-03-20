package pages;

import helpMethods.ElementHelper;
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
    }

    public void enterOnAlertSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.alertsSubMenu);
    }

    public void enterOnBrowserWindowSubmenu(){
        elementHelper.clickJSLocator((IndexLocators.browserSubMenu));
    }

    public void enterOnFrameSubmenu(){
        elementHelper.clickJSLocator(IndexLocators.frameSubMenu);
    }

    public void enterOnFormsMenu(){
        elementHelper.clickJSLocator(IndexLocators.formsMenu);
    }

    public void enterOnPracticeFormSubMenu(){
        elementHelper.clickJSLocator(IndexLocators.practiceFormSubMenu);
    }

}