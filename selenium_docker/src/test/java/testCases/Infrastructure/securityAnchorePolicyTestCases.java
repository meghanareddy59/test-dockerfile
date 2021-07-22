package testCases.Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Infrastructure.securityPageObjects;
import testCases.hyscaleLoginPageTestCase;

public class securityAnchorePolicyTestCases {
    securityPageObjects security_object;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(securityAnchorePolicyTestCases.class);
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[1]/em")
    WebElement notifyRadioButton;
    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
        security_object=new securityPageObjects(driver);
        security_object.goToSecurityTab();

    }
    @Test(priority = 51)
    public void policyTextVerify(){

        boolean visible=security_object.policyTextVisibilityVerify();
        Assert.assertTrue(visible,"policy text is not visible");

        String extractedText=security_object.getPolicyText();
        Assert.assertEquals(extractedText,"Policy","policy text is not available");
    }
    @Test(priority = 51)
    public void policyEditIconVerify(){
        boolean visible=security_object.policyEditButtonVisibilityVerify();
        Assert.assertTrue(visible,"policy edit is not visible");
        boolean enable=security_object.policyEditButtonEnableVerify();
        Assert.assertTrue(enable,"policy edit is not enable");
        security_object.click_PolicyEditButton();
    }
    @Test(priority = 51)
    public void policyEdit_warn(){
        String extractedText=security_object.get_NotifyAndProceedHeading();
        Assert.assertEquals(extractedText,"Notify and proceed with deployment","NotifyAndProceedHeading is incorrect");
        boolean visible=security_object.notifyRadioButtonSelectionVerify();
       if(visible)
       {
           security_object.enableWarnPolicy();
            }

        security_object.selectWarnSeverity("Low");
        String result= security_object.warnHandleVerify();
        Assert.assertTrue(result.contains("WARN Low"),"policy handle is not proper according to warn");

    }
    @Test(priority = 52)
    public void policyEdit_stop(){

        boolean visible=security_object.stopDeploymentRadioButtonSelectionVerify();
        System.out.println(visible);
        if(visible==false)
        {
            security_object.enableAbortDeployment();

        }
        security_object.SelectStopDeploymentSeverity("Medium");
        String result= security_object.stopHandleVerify();
        System.out.println(result);
        Assert.assertTrue(result.contains("STOP Medium"),"policy handle is not proper according to Stop");


    }
    @Test(priority = 53)
    public void savePolicy() {
        boolean enable=security_object.saveButtonEnableVerify();
        Assert.assertTrue(enable,"policy save button is not enable");
        security_object.click_saveButton();
        security_object.click_PolicyEditButton();
        security_object.enableAbortDeployment();
        security_object.click_saveButton();
    }



}
