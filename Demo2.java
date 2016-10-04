package Epam;

import Epam.data.EquipmentAndOther;
import Epam.data.Justification;
import Epam.data.WfhHour;
import Epam.dialogs.BaseModalDialog;
import Epam.model.HistoryPage;
import Epam.model.NewRequestPage;
import Epam.model.contextable.HitsoryItem;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Yavor_Tsanov on 10/4/2016.
 */
public class Demo2 {


    public WebDriver driver;


    @BeforeMethod
    public void setup() {
        String exePath = "D:\\repo\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();


    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }


    @Test
    public void applyAsDeveloper() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("", "", "this is not the right bla");
        softAssert.assertFalse(0<1, "");
        softAssert.assertAll();


    }


    @Test
    public void applyAsDeveloper1() {


//        ##############################################################
        //Set firefox to handle expired or untrusted SSL Certificates
        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(false);
        driver = new FirefoxDriver(profile);
        driver.manage().window().maximize();
//        #################################################################
    }


    @Test
    public void protractorTest() {

//        #########################################
       /*
        E2E test framework for Angular apps http://www.protractortest.org
         */
//        #########################################

    }


}
