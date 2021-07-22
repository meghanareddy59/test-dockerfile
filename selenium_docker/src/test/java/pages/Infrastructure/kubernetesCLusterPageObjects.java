package pages.Infrastructure;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.common;
import utils.waitFactory;

import java.util.ArrayList;
import java.util.List;

public class kubernetesCLusterPageObjects extends common {
    waitFactory wait = new waitFactory(driver);


    public kubernetesCLusterPageObjects(WebDriver driver) {
        super(driver);
    }


    @FindBy(how = How.XPATH, using = "//a[@href ='#!/infrastructure']")
    WebElement infrastructureTab;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/ul/li[3]/a/uib-tab-heading/span[2]")
    WebElement resourcesTab;

    @FindBy(how = How.ID, using = "add-secondary-lb-btn")
    WebElement addClusterButton;

    @FindBy(how = How.ID, using = "server")
    WebElement clusterServerTextBox;

    @FindBy(how = How.ID, using = "caCert")
    WebElement caCertTextBox;

    @FindBy(how = How.ID, using = "username")
    WebElement clusterUserNameTextBox;

    @FindBy(how = How.ID, using = "clientCertifiate")
    WebElement clusterClientCertificateTextBox;

    @FindBy(how = How.ID, using = "clientKey")
    WebElement clusterClientKeyTextBox;


    public void goToInfrastructureTab(){

        boolean invisibility_loader=wait.explicitWait(10,loader);
        if(invisibility_loader) {
            infrastructureTab.click();
        }
    }
    public void goToResourcesTab(){
        resourcesTab.click();
    }
    public void click_AddCluster(){
        addClusterButton.click();
    }

    public void enterApiServer(String input){
        clusterServerTextBox.sendKeys(input);
    }
    public void enterCaCertificate(String input){
        caCertTextBox.sendKeys(input);
    }
    public void enterUsername(String input){
        clusterUserNameTextBox.sendKeys(input);
    }
    public void enterClientCertificate(String input){
        clusterClientCertificateTextBox.sendKeys(input);
    }
    public void enterClientKey(String input){
        clusterClientKeyTextBox.sendKeys(input);
    }
    public void clearAllText(){
        nameClear();
        caCertTextBox.clear();
        clusterServerTextBox.clear();
        clusterUserNameTextBox.clear();
        clusterClientCertificateTextBox.clear();
        clusterClientKeyTextBox.clear();


    }

//messages path extraction

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p")
    WebElement clusterNameMsg;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[3]/div/p")
    WebElement clusterApiServerMsg;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[4]/div/p")
    WebElement clusterCaCertMsg;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[5]/div/p")
    WebElement clusterUserNameMsg;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[7]/div/p")
    WebElement clusterClientCertificateMsg;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[8]/div/p")
    WebElement clusterClientKeyMsg;

    public String getMsg_clusterNameNotProvided(){
        String result = clusterNameMsg.getText();
        return result;
    }

    public String getMsg_clusterApiServerNotProvided(){
        String result = clusterApiServerMsg.getText();
        return result;  
    }
    public String getMsg_clusterCaCertMsgNotProvided(){
        String result = clusterCaCertMsg.getText();
        return result;
    }
    public String getMsg_clusterUserNameMsgNotProvided(){
        String result = clusterUserNameMsg.getText();
        return result;
    }
    public String getMsg_clusterClientCertificateMsgNotProvided(){
        String result = clusterClientCertificateMsg.getText();
        return result;
    }
    public String clusterClientKeyMsgNotProvided(){
        String result = clusterClientKeyMsg.getText();
        return result;
    }

    @FindBy(how = How.ID, using = "add-btn")
    WebElement confirmButton;
    public void testAndSave(){confirmButton.click();}

    @FindBy(how = How.CLASS_NAME, using = "toast-message")
    WebElement alertMsg;
    public String alertMsg_InvalidApiServer(){
        String result=alertMsg.getText();
        return result;

    }
    @FindBy(how = How.CLASS_NAME, using = "toast-close-button")
    WebElement alertMsgClose;
    public void closeAlertMsg(){alertMsgClose.click();}

    public boolean createClusterButtonVisibilityVerify() {
        boolean result = addClusterButton.isDisplayed();
        return result;
    }
    public boolean createClusterButtonEnableVerify() {
        boolean result = addClusterButton.isEnabled();
        return result;
    }
    @FindBy(how = How.ID, using = "scans for hyscale deployed namespaces-action")
    WebElement ScanCluster;

    @FindBy(how = How.ID, using = "add-cluster-member-btn")
    WebElement addMember;

    @FindBy(how = How.ID, using = "delete-btn")
    WebElement deleteButton;


    public  void selectmemeber() throws InterruptedException {
        WebElement memberloader=driver.findElement(By.xpath("/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/wm-loader/div/div/span"));

        /*WebElement member=driver.findElement(By.cssSelector("div.popover.ng-isolate-scope.image-search-popover.member.fade.in.bottom.bottom-left"));
        String result=member.getAttribute("placement");
        System.out.println(result);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        while (true)
        {
            try
            {
                wait.until(ExpectedConditions.visibilityOf(memberloader));
                wait.until(ExpectedConditions.invisibilityOf(memberloader));
            }
            catch (Exception e)
            {
                break;
            }
        }


    member.click();*/
        wait.explicitWait(30,memberloader);
        driver.findElement(By.xpath("//li/div/span")).click();
        addMember.click();


    }


    public  void deleteMember() throws InterruptedException {
        List<WebElement> member=driver.findElements(By.xpath("/html[1]/body[1]/div[1]/article[1]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/ul[1]"));
        List<String> memberSize=new ArrayList<String>(member.size());
        int result= member.size();
        System.out.println(result);
        boolean finalresult = false;
        for(int i=0;i<member.size();i++) {
            memberSize.add(member.get(i).getText());
            System.out.println(memberSize.get(i));
            if(memberSize.get(i).contains("satishqa2")){
                System.out.println("na ");
                Actions act =  new Actions(driver);
                act.moveToElement(driver.findElement(By.xpath("/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div[2]/ul/li[2]/label/em[2]"))).click().perform();
                deleteButton.click();

            }
        }

    }

    public boolean ScanClusterButtonVisibilityVerify() {
        boolean result = ScanCluster.isDisplayed();
        return result;
    }
    public boolean ScanClusterButtonEnableVerify() {
        boolean result = ScanCluster.isEnabled();
        return result;
    }



    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div[1]/input")
    WebElement clusterSearchTextBox;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/div[2]/div/span")
    WebElement firstCluster;

    public void searchCluster(String input){

        clusterSearchTextBox.sendKeys(input);


    }
    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/div/div/wm-loader/div/div/span")
    WebElement wmloader;
    public String getFirstClusterName(){
        String result=null;
      boolean loader_invisibility =wait.explicitWait(50,loader);
      if(loader_invisibility) {
          boolean invisibility = wait.explicitWait(30, wmloader);
          if (invisibility) {
              result = firstCluster.getText();
          }
      }
        return result;
    }


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/ul/li[2]/a/uib-tab-heading/span")
    WebElement clusterMemberTab;

    public void click_ClusterMemberTab(){
        clusterMemberTab.click();
    }


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div[2]/div/div/div/form/div/div[1]/input")
    WebElement enterMemberInputBox;

    public void enterMember(String input){
        enterMemberInputBox.sendKeys(input);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/ul/li[1]/a")
    WebElement deployedEnvironmentsTab;

    public void click_deployedEnvironmentsTab(){
        deployedEnvironmentsTab.click();
    }
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/label")
    WebElement deployedEnvironments_applicationText;
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div/label[1]")
    WebElement deployedEnvironments_environmentText;
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div/label[2]")
    WebElement deployedEnvironments_memoryConsumptionText;
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div/div/div/div/div/div[1]/div/label[3]")
    WebElement deployedEnvironments_podsText;

    public String[] getDeployedEnvironments_headers(){
        String[]  headers = new String[4];
        headers[0]=deployedEnvironments_applicationText.getText();
        headers[1]=deployedEnvironments_environmentText.getText();
        headers[2]=deployedEnvironments_memoryConsumptionText.getText();
        headers[3]=deployedEnvironments_podsText.getText();
        return headers;
    }



}
