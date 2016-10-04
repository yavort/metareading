package Epam.model.contextable;

import Epam.dialogs.BaseModalDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;


/**
 * Created by Yavor_Tsanov on 8/19/2016.
 */
public class HitsoryItem {

    private WebDriver driver;
    private SearchContext searchContext;

    private String dateLocator = ".wfh-history-date.ng-binding";
    private String reasonLocator = ".wfh-history-reason.ng-binding";
    private String statusLocator = ".wfh-history-status .ng-scope";
    private String actionDetailsLocator = ".wfh-history-actions [title='Details']";
    private String actionCancelLocator = ".wfh-history-actions [title='Cancel']";
    private String actionConfirmLocator = ".wfh-history-actions [title='Confirm']";


    /**
     * Constructor for the New Reqeust page object
     *
     * @param driver the instance of the WebDriver
     */
    public HitsoryItem(WebDriver driver, SearchContext searchContext) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.searchContext = searchContext;
    }


    /**
     * Get the date of the history request
     *
     * @return the date of the request
     */
    public LocalDate getDate() {
        String date = getWebElementFromSearchcontext(dateLocator).getText();
        return LocalDate.parse(date);
    }


    public String getReason() {
        return getWebElementFromSearchcontext(reasonLocator).getText();
    }

    public String getStatus() {
        return getWebElementFromSearchcontext(statusLocator).getText();
    }


    public void performActionCancel() {
getWebElementFromSearchcontext(actionCancelLocator).click();
    }


    public void performActionDetails() {
        getWebElementFromSearchcontext(actionDetailsLocator).click();
    }


    public void performActionConfirm() {
        getWebElementFromSearchcontext(actionConfirmLocator).click();
    }


    private WebElement getWebElementFromSearchcontext(String locator) {
       return searchContext.findElement(By.cssSelector(locator));
    }
}
