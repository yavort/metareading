package Epam;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

/**
 * Model for all the checkboxes in the WFH project
 * @author Yavor_Tsanov
 */
public class CheckBox {

    private WebDriver driver;

    public CheckBox(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".ng-binding")
    private List<WebElement> webElements;


    /**
     * Return the state of the checkbox represented as true for selected or false as not selected
     * @param webElement the particular checkbox element
     * @return the state of the checkbox
     */
    public Boolean isSelected(WebElement webElement) {
        return webElement.isSelected();
    }


    /**
     * Set the state of the checkbox
     * @param setOption true if the checkbox has to be selected or false otherwise
     * @param checkboxName the name of the particular checkbox to work with
     */
    public void setCheckBox(Boolean setOption, String checkboxName) {
        for (WebElement element : webElements) {

            if (element.isDisplayed() && element.getText().equals(checkboxName)) {
                if (!element.isSelected() && setOption || element.isSelected() && !setOption) {
                    element.click();
                }
            }

        }
    }


    public void getrequest() throws IOException {


        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("google.com");
        HttpResponse response = client.execute(request);
    }

}
