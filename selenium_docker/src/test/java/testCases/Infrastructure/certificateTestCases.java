package testCases.Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Infrastructure.certificatePageObjects;
import testCases.hyscaleLoginPageTestCase;

public class certificateTestCases {
    certificatePageObjects certificate_object;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(clusterAlertMsgTestCases.class);
    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
        certificate_object=new certificatePageObjects(driver);
       certificate_object.GoToCertificatesTab();

    }
    @Test(priority = 69)
    public void addCertificateButtonVerification(){
        boolean visible=certificate_object.addCertificateButtonDisplayTest();

        Assert.assertTrue(visible,"add certificate button is not visible");
        boolean enable=certificate_object.addCertificateButtonEnableTest();
        Assert.assertTrue(enable,"add certificate button is not enabled");
    }
    @Test(priority = 70)
    public void RefreshButtonVerification(){
        boolean visible=certificate_object.refreshButtonVisibility();

        Assert.assertTrue(visible,"certificate refresh button is not visible");
        boolean enable=certificate_object.refreshButtonEnableTest();
        Assert.assertTrue(enable,"certificate  refresh button is not enabled");


    }
    @Test(priority = 70)
    public void UploadButtonVerification(){
        certificate_object.addCertificatesButtonClick();
        certificate_object.enterDomain("domain");
        
        boolean visible=certificate_object.certificateUploadDisplayTest();

        Assert.assertTrue(visible,"certificate upload button is not visible");
        boolean enable=certificate_object.certificateUploadEnableTest();
        Assert.assertTrue(enable,"certificate upload button is not enabled");


    }
    @Test(priority = 70)
    public void addButtonVerificationWithoutEnteringDetails(){

        boolean visible=certificate_object.addButtonDisplayTest();

        Assert.assertTrue(visible,"certificate add(save) button is not visible");
        boolean enable=certificate_object.addButtonEnableTest();
        Assert.assertFalse(enable,"certificate add(save)  button is  enabled");
        certificate_object.closeButton();

    }

    @Test(priority = 70)
    public void SearchTextBoxVerification(){
        boolean visible=certificate_object.searchTextBoxDisplayTest();

        Assert.assertTrue(visible,"certificate search text box is not visible");
        boolean enable=certificate_object.searchTextBoxEnableTest();
        Assert.assertTrue(enable,"certificate search text box is not enabled");

        certificate_object.searchCertificate("certificate");

/*
String result= certificate_object.getTextFromSearchTextBox();
        Assert.assertEquals(result,"certificate");
*/

    }


}
