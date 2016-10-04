package Epam;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


/**
 * Model for all the tooltips of the WFH project
 *
 * @author Yavor_Tsanov
 */
public class ToolTip {

    private WebDriver driver;
    SearchContext searchContext;

    public ToolTip(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".wfh-tooltip-icon")
    private WebElement tooltip;

    @FindBy(css = ".control-label")
    private List<WebElement> controlLabel;


    /**
     * Get the tooltip text from the chosen label
     *
     * @param label the label as a searchcontext for the tooltip
     * @return the tooltip text
     */
    public String getToolTipText(String label) {
        String toolTipText = "";
        try {
            for (WebElement webElement : controlLabel) {
                if (webElement.getText().equals(label)) {
                    searchContext = webElement;
                    tooltip = searchContext.findElement(By.cssSelector(".wfh-tooltip-icon"));
                    SearchContext searchContext1 = searchContext.findElement(By.cssSelector(".wfh-tooltip-icon"));
                    if (tooltip.isDisplayed()) {
                        Actions action = new Actions(driver);
                        action.moveToElement(tooltip).perform();
                        toolTipText = tooltip.getAttribute("data-original-title");
                    }
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("The label that you are searching for is not presented");
        }
        return toolTipText;
    }
}
