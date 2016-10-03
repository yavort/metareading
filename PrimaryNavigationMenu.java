package com.metareading.model;

import data.NavigationMenuOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.JQueryUtils;
import utils.SeleniumUtils;
import utils.WaitUtils;

/**
 * Created by yavor on 5/2/2016.
 */
public class PrimaryNavigationMenu {

    WebDriver driver;

    public PrimaryNavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickMenu(NavigationMenuOption option) {
//        JQueryUtils.importJQuery(driver);
        WaitUtils.waitForDocumentReadyState(driver);
        String url = driver.getCurrentUrl();
        element.click();
//        String script = String.format("return $(\".nav a[href*='%s']\")", option.returnStringFromOption(option));
//        WebElement element = (WebElement) SeleniumUtils.executeScript(driver, script);
//        element.click();
        WaitUtils.waitForDocumentReadyState(driver);

    }


    @FindBy(css = ".nav a[href*='events']")
    private WebElement element;
}
