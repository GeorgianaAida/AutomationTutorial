package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageLocators.AlertLocators;

public class AlertPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public AlertPage(WebDriver driver) {
        this.driver = driver;
        elementHelper =  new ElementHelper(driver);
        alertHelper=new AlertHelper(driver);
    }

    public void interactWithAlert(){
        elementHelper.clickJSLocator(AlertLocators.alertOkElement);
        alertHelper.acceptAlert();
    }
    public void interactWithTimerAlert(){
        elementHelper.clickJSLocator(AlertLocators.timerAlertElement);
        alertHelper.acceptAlert();
    }

    public void interactWithCanacelAlert(){

        elementHelper.clickJSLocator(AlertLocators.confirmElement);
        alertHelper.cancelAlert();
    }

    public void interactWithPromtAlert(){

        elementHelper.clickJSLocator(AlertLocators.promtElement);
        alertHelper.fillAlert("Altceva!");
    }
}
