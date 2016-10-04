package Epam;

import Epam.data.EquipmentAndOther;
import Epam.data.Justification;
import Epam.data.WfhHour;
import Epam.dialogs.BaseModalDialog;
import Epam.model.HistoryPage;
import Epam.model.NewRequestPage;
import Epam.model.contextable.HitsoryItem;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

/**
 * Created by Yavor_Tsanov on 10/4/2016.
 */
public class Demo2 {


    public WebDriver driver;
    private int invalidLinksCount;


    @BeforeMethod
    public void setup() {
        String exePath = "D:\\repo\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://google.com");


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


    @Test
    public void validateInvalidLinks() {

        try {
            invalidLinksCount = 0;
            List<WebElement> anchorTagsList = driver.findElements(By
                    .tagName("a"));
            System.out.println("Total no. of links are "
                    + anchorTagsList.size());
            for (WebElement anchorTagElement : anchorTagsList) {
                if (anchorTagElement != null) {
                    String url = anchorTagElement.getAttribute("href");
                    if (url != null && !url.contains("javascript")) {
                        verifyURLStatus(url);
                    } else {
                        invalidLinksCount++;
                    }
                }
            }

            System.out.println("Total no. of invalid links are "
                    + invalidLinksCount);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    public void verifyURLStatus(String URL) {

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(URL);
        try {
            HttpResponse response = client.execute(request);
            // verifying response code and The HttpStatus should be 200 if not,
            // increment invalid link count
            ////We can also check for 404 status code like response.getStatusLine().getStatusCode() == 404
            if (response.getStatusLine().getStatusCode() != 200)
                invalidLinksCount++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
