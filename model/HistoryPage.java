package Epam.model;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Yavor_Tsanov on 8/19/2016.
 */
public class HistoryPage {

    private WebDriver driver;

//    private  static Logger mainLogger = LogManager.getLogger(NewRequestPage.class.getName());

    /**
     * Constructor for the New Reqeust page object
     *
     * @param driver the instance of the WebDriver
     */
    public HistoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(css = "h1")
    private WebElement headingText;

    @FindBy(css="#wfh-history-desktop-view .wfh-history-addnew-button a")
    private WebElement addNewRequest;



   public SearchContext getHistorySearchContextFromDateAndStatus(String date, String status) {
       String script = String.format("return $(\"table.wfh-history tr:has(td:contains('Approved')):contains('19.8.2016')\")[0];", date, status);
       return (WebElement)((JavascriptExecutor)driver).executeScript(script);
   }

}
