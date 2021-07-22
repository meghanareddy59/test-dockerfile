package pages.Infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import pages.common;
import utils.waitFactory;

import java.sql.SQLOutput;

public class securityPageObjects extends common {
    waitFactory wait = new waitFactory(driver);


    public securityPageObjects(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/ul/li[2]/a")
    WebElement securityTab;
    public void goToSecurityTab(){
        securityTab.click();
    }
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[1]/label")
    WebElement PolicyText;
    public String getPolicyText(){
        String result = PolicyText.getText();
        return result;
    }
    public boolean policyTextVisibilityVerify() {
        boolean result = PolicyText.isDisplayed();
        return result;
    }
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[1]/button")
    WebElement PolicyEditButton;
    public boolean policyEditButtonVisibilityVerify() {
        boolean result = PolicyEditButton.isDisplayed();
        return result;
    }

    public boolean policyEditButtonEnableVerify() {
        boolean result = PolicyEditButton.isEnabled();
        return result;
    }

    public void click_PolicyEditButton(){
        PolicyEditButton.click();
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[1]/em")
    WebElement notifyRadioButton;

    public boolean notifyRadioButtonEnableVerify() {
        wait.implicitWait(30);
        boolean result = notifyRadioButton.isEnabled();
        return result;
    }

    public boolean notifyRadioButtonSelectionVerify() {
        boolean result = notifyRadioButton.isSelected();
        return result;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[1]/label")
    WebElement NotifyAndProceedHeading;
    public String get_NotifyAndProceedHeading(){
      String result=  NotifyAndProceedHeading.getText();
      return result;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[1]/div/div/div/select")
    WebElement selectWarnSeverity;
    public void selectWarnSeverity(String warnSeverity){
        Select selectAgentRegistry= new Select(selectWarnSeverity);
        selectAgentRegistry.selectByVisibleText(warnSeverity);
        selectWarnSeverity.click();

    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/em")
    WebElement stopDeploymentRadioButton;

    public boolean stopDeploymentRadioButtonVisibilityVerify() {
        boolean result = stopDeploymentRadioButton.isDisplayed();
        return result;
    }

    public boolean stopDeploymentRadioButtonSelectionVerify() {
        boolean result = stopDeploymentRadioButton.isSelected();
        return result;
    }
    public void enableAbortDeployment(){
        stopDeploymentRadioButton.click();
    }
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[2]/div[2]/div/div/div/select")
    WebElement SelectStopSeverity;
    public void SelectStopDeploymentSeverity(String stopSeverity){
        wait.implicitWait(30);
        Select selectAgentRegistry= new Select(SelectStopSeverity);
        selectAgentRegistry.selectByVisibleText(stopSeverity);
        SelectStopSeverity.click();
    }





    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[3]/span[1]/span[3]")
    WebElement stopHandle;


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[3]/span[1]/span[2]")
    WebElement warnHandle;
    public String warnHandleVerify() {
        String text = warnHandle.getAttribute("class");
        System.out.println(text);
        return text;
    }
   public void enableWarnPolicy(){
       notifyRadioButton.click();
   }



    public String stopHandleVerify() {
        String text = stopHandle.getAttribute("class");
        return text;
    }


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div/form/div/div[1]/div/button[2]")
    WebElement saveButton;

    public void click_saveButton(){
        saveButton.click();
    }

    public boolean saveButtonEnableVerify() {
        boolean result = saveButton.isEnabled();
        return result;
    }






}
