package Epam.model;


import Epam.CheckBox;
import Epam.ToolTip;
import Epam.data.EquipmentAndOther;
import Epam.data.Justification;
import Epam.data.WfhHour;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


/**
 * Page model for the New Request object page
 *
 * @author Yavor_Tsanov
 */
public class NewRequestPage {

    private WebDriver driver;

//    private  static Logger mainLogger = LogManager.getLogger(NewRequestPage.class.getName());

    /**
     * Constructor for the New Reqeust page object
     *
     * @param driver the instance of the WebDriver
     */
    public NewRequestPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "label[for='wfh-no-objections']")
    private WebElement withNoObjections;

    @FindBy(css = "#select")
    private WebElement justificationDropdown;

    @FindBy(css = "#datepicker-input")
    private WebElement calendar;

    @FindBy(css = "#timepicker-from")
    private WebElement timePickerFrom;

    @FindBy(css = "#timepicker-to")
    private WebElement timePickerTo;

    @FindBy(css = ".uui-checkbox label")
    private List<WebElement> neededEquipment;

    @FindBy(css = "input[type='submit']")
    private WebElement submit;

    @FindBy(css = ".day:not(.disabled)")
    private List<WebElement> availableDays;

    @FindBy(css = ".wfh-full-hour")
    private List<WebElement> availableHours;

    @FindBy(css = "h1")
    private WebElement headingText;

    @FindBy(css = "#wfh-input-employee")
    private WebElement employeeName;


    /**
     * Select the no objection from my managers option
     */
    public void selectWithNoObjections() {
        try {
            withNoObjections.click();
        } catch (NoSuchElementException e) {
            System.out.println("The element no objkection from my managers is not present");
        }
    }


    /**
     * Set the state of the needed equipment or other checkbox
     *
     * @param set    the state of the checkbox to set
     * @param option the needed equipment or other checkbox option
     */
    public void setCheckBoxOption(Boolean set, EquipmentAndOther option) {
        CheckBox checkBox = new CheckBox(driver);
        checkBox.setCheckBox(set, option.returnText());
    }


    /**
     * Choose form the justufication options
     *
     * @param option the justification option to select
     */
    public void chooseJustification(Justification option) {
        Select dropdown = new Select(justificationDropdown);
        dropdown.selectByVisibleText(option.returnText());
    }


    /**
     * Select the required date of working from home
     *
     * @param date the inserted date fro working from home
     */
    public void selectDate(Integer date) {
        try {
            calendar.click();
        } catch (NoSuchElementException e) {
            System.out.println("The date element is not present");
        }
        for (WebElement element : availableDays) {
            if (element.getText().equals(date.toString())) {
                element.click();
                break;
            }
        }

    }


    public void selectTime(WfhHour hourFrom, WfhHour hourTo) {
        Actions actions = new Actions(driver);
        WebElement elementFrom = null;
        WebElement elementTo = null;
        for (WebElement element : availableHours) {
            if (element.getText().equals(hourFrom.returnText())) {
                elementFrom = element;
            }
            if (element.getText().equals(hourTo.returnText())) {
                elementTo = element;
            }
        }

        Action dragAndDrop = null;
        if (elementTo != null && elementFrom != null) {
            dragAndDrop = actions.clickAndHold(elementFrom)

                    .moveToElement(elementTo)

                    .release(elementTo)

                    .build();
            dragAndDrop.perform();
        } else {
            System.out.println("Elements form and to are not present");
        }

    }

    /**
     * Submits the request for working from home
     */
    public void submitRequest() {
        try {
            submit.click();
        } catch (NoSuchElementException e) {
            System.out.println("The submit button does not apppear to be present");
        }
    }

    /**
     * Return the title of the page as a text
     *
     * @return the title of the page
     */
    public String getTitle() {
        String title = "";
        if (headingText.isDisplayed()) {
            title = headingText.getText();
        }
        return title;
    }


    /**
     * Return the name of the employee that makes the request
     *
     * @return the name of the employee
     */
    public String getEmployeeName() {
        String name = "";
        if (employeeName.isDisplayed()) {
            name = employeeName.getText();
        }
        return name;
    }

    /**
     * Get the tooltip text from itd parent label
     * @param label the parent label
     * @return the tooltip text
     */
    public String getToolTipTextFromLabel(String label) {
        String text = "";
        ToolTip toolTip = new ToolTip(driver);
        text = toolTip.getToolTipText(label);
        return text;
    }

}
