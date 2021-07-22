package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import utils.waitFactory;

public class agentPageObjects extends common{
    waitFactory wait= new waitFactory(driver);


    public agentPageObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/article/div/section/div/div[2]/div/div/div/ul/li[3]/a/uib-tab-heading/span[2]")
    WebElement agentPage;
    @FindBy(how = How.ID, using = "import-image-btn")
    WebElement importAgent;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[2]")
    WebElement maximumCharMsg_agentName;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[3]")
    WebElement minimumCharMsg_agentName;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[4]")
    WebElement invalidMsg_agentName;


    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div/p[2]")
    WebElement maximumCharMsg_agentVersion;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div/p[3]")
    WebElement minimumCharMsg_agentVersion;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div/p[4]")
    WebElement invalidMsg_agentVersion;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[3]/div/p")
    WebElement maximumCharMsg_agentDescription;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[5]/div/div/p[3]")
    WebElement maximumCharMsg_agent_name_version;



   @FindBy(how = How.NAME, using = "portEntity_0")
   WebElement portNumber;

    public void enterPortNumber(String port){
        portNumber.sendKeys(port);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div/ul/li[2]/div/div[1]/p[1]")
    WebElement portNumberInvalidMsg;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div/ul/li[3]/div/div[1]/p[2]")
    WebElement portNumberDuplicateMsg;


    @FindBy(how = How.ID, using = "add_expose_port")
    WebElement addAnotherPort;

    public String InvalidPortNumberMsg(){
        wait.implicitWait(20);
        String InvalidMsg=portNumberInvalidMsg.getText();
        return InvalidMsg;
    }
    public String duplicatePortNumberMsg(){

        String duplicateMsg=portNumberDuplicateMsg.getText();
        return duplicateMsg;
    }
    public void clearPortNumber(){
        portNumber.clear();
    }

    @FindBy(how = How.NAME, using = "portEntity_1")
    WebElement portNumber_new;
    public void addNewPort(String anotherPort){
        addAnotherPort.click();
        portNumber_new.sendKeys(anotherPort);

    }

    @FindBy(how = How.ID, using = "key-0")
    WebElement configKey_Agent;
    @FindBy(how = How.ID, using = "-value")
    WebElement configValue_Agent;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div[1]/div/div/div[1]/div[1]/p[1]")
    WebElement configKeyAgentInvalidMsg;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div[1]/div/div/div[1]/div[1]/p[2]")
    WebElement getConfigKeyAgentMsg;

    public void enterConfigValue(String value){
        configValue_Agent.sendKeys(value);
    }

    public void enterConfigKey(String value){
        configKey_Agent.sendKeys(value);
    }

    public String invalidConfigKey_Agent(){
        String InvalidMsg=configKeyAgentInvalidMsg.getText();
        return InvalidMsg;
    }
    public String ConfigKeyAgentMsg(){
        String InvalidMsg=getConfigKeyAgentMsg.getText();
        return InvalidMsg;
    }




    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div/ul/li[3]/div/em")
    WebElement deletePort_Agent;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div/ul/li[2]/div/select")
    WebElement portType;
    public void nextPageClick_Agent(){
        confirmButton.click();
    }

    public void enterPortType(String port){
        Select selectAgentPortType= new Select(portType);
        selectAgentPortType.selectByVisibleText(port);
        portType.click();

    }


    public void configKeyClear(){
        configKey_Agent.clear();
    }

public void DeletePortAgent(){
    System.out.println("test");
    deletePort_Agent.click();

}
    public void goToAgentPage(){
        agentPage.click();
        wait.explicitWait(20,loader);

    }
    //agent Tab CLick
    public void agentTabClick(){

        importAgent.click();
    }
    //agent Version max characters message
    public String maximumCharMsg_agentName(){
        String agentNameMaxMsg=maximumCharMsg_agentName.getText();
        return agentNameMaxMsg;
    }

    //agent Version min characters message
    public String minimumCharMsg_agentName(){
        String agentNameMinMsg=minimumCharMsg_agentName.getText();
        return agentNameMinMsg;
    }
    //agent Name invalid characters message
    public String invalidMsg_agentName(){
        String agentNameInvalidMsg=invalidMsg_agentName.getText();
        return agentNameInvalidMsg;
    }


    //agent Name max characters message
    public String maximumCharMsg_agentVersion(){
        String agentVersionMaxMsg=maximumCharMsg_agentVersion.getText();
        return agentVersionMaxMsg;
    }

    //agent Name min characters message
    public String minimumCharMsg_agentVersion(){
        String agentVersionMinMsg=minimumCharMsg_agentVersion.getText();
        return agentVersionMinMsg;
    }
    //agent Version invalid characters message
    public String invalidMsg_agentVersion(){
        String agentVersionInvalidMsg=invalidMsg_agentVersion.getText();
        return agentVersionInvalidMsg;
    }
    //agent description max characters message
    public String maximumCharMsg_agentDescription(){
        String agentDescriptionMaxMsg=maximumCharMsg_agentDescription.getText();
        return agentDescriptionMaxMsg;
    }
    //agent Name:version max characters message
    public String maximumCharMsg_agent_name_version(){
        String agent_NameVersion_MaxMsg=maximumCharMsg_agent_name_version.getText();
        return agent_NameVersion_MaxMsg;
    }



    public boolean agentButtonVisibilityVerify() {
        boolean result = importAgent.isDisplayed();
        return result;
    }
    public boolean agentButtonEnableVerify() {
        boolean result = importAgent.isEnabled();
        return result;
    }






    @FindBy(how = How.ID, using = "Delete-action")

    WebElement agentDeleteButton;


    public boolean agentDeleteButtonVisibility() {


        boolean result = agentDeleteButton.isDisplayed();
        return result;
    }
    public boolean agentDeleteButtonEnableTest() {
        boolean result = agentDeleteButton.isEnabled();
        return result;
    }
    public boolean  deleteButtonClickVerify(){
        agentDeleteButton.click();
        boolean result = closeButton.isEnabled();
        closeButton.click();
        return result;
    }



    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div[1]/input")
    WebElement agentSearchTextBox;
    @FindBy(how = How.XPATH, using = "//ng-include/wm-loader/div")
    public WebElement ploader;
    public void searchAgent(String input){

        agentSearchTextBox.sendKeys(input);
        wait.explicitWait(20,ploader);

    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div/div[1]/div[2]/div/span")
    WebElement firstAgent;

    public String getFirstAgentName() throws InterruptedException {
        String result=null;
boolean result1=wait.explicitWait(30,ploader);
        boolean result2=wait.explicitWait(30,loader);
if(result2){
         result=firstAgent.getText();}
        return result;
    }


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button[3]/em")
    WebElement totalAgents;

    public boolean  agentsCount(){
        System.out.println(totalAgents.getText());

        if(totalAgents.getText().equalsIgnoreCase("of 5")||totalAgents.getText().equalsIgnoreCase("of 4")||totalAgents.getText().equalsIgnoreCase("of 3")||totalAgents.getText().equalsIgnoreCase("of 2")||totalAgents.getText().equalsIgnoreCase("of 1")){

            return false;
        }
        else{
            return true;
        }
    }





    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button[3]/em")
    WebElement agentNextTabButton;



    public boolean agentNextTabButtonVisibility() {
        boolean result = agentNextTabButton.isDisplayed();
        return result;
    }
    public boolean agentNextTabButtonEnableTest() {
        boolean result = agentNextTabButton.isEnabled();

        return result;
    }
   public void clickNextPageButton(){
       agentNextTabButton.click();
   }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button[4]/em")
    WebElement agentLastTabButton;

    public boolean agentLastTabButtonVisibility() {
        boolean result = agentLastTabButton.isDisplayed();
        return result;
    }
    public boolean agentLastTabButtonEnableTest() {
        boolean result = agentLastTabButton.isEnabled();
        return result;
    }
    public void clickLastPageButton(){
        agentLastTabButton.click();
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button[2]")
    WebElement agentPreviousButton;
    public boolean agentPreviousButtonVisibility() {
        boolean result = agentPreviousButton.isDisplayed();

        return result;
    }
    public boolean agentPreviousButtonEnableTest() {
        boolean result = agentPreviousButton.isEnabled();
        return result;
    }

    public void clickPreviousPageButton(){
        agentPreviousButton.click();
    }

    @FindBy(how = How.CLASS_NAME, using = "refreshBtn")
    WebElement agentRefreshButton;

    public boolean agentRefreshButtonVisibility() {
        boolean result = agentRefreshButton.isDisplayed();

        return result;
    }
    public boolean agentRefreshButtonEnableTest() {
        boolean result = agentRefreshButton.isEnabled();
        return result;
    }






}
