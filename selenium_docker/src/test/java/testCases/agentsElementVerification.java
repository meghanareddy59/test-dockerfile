package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.agentPageObjects;

public class agentsElementVerification {


    agentPageObjects agent_object;
    hyscaleLoginPageTestCase driver_get;

    static Logger logger = LogManager.getLogger(agentsElementVerification.class);


    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
    }

    @Test(priority = 27)
    public void importAgentButtonVerification() {
        agent_object = new agentPageObjects(driver);
        agent_object.goToAgentPage();
        boolean elementVisible = agent_object.agentButtonVisibilityVerify();
        boolean elementEnable = agent_object.agentButtonEnableVerify();

        Assert.assertTrue(elementVisible, "import agent button is not visible");
        Assert.assertTrue(elementEnable, "import agent button is not enabled");
    
    }

     @Test(priority = 29)
   public void AgentDeleteVerify(){
       boolean visible=agent_object.agentDeleteButtonVisibility();
       Assert.assertTrue(visible,"agent delete button is not visible");
       boolean enable=agent_object.agentDeleteButtonEnableTest();
       Assert.assertTrue(enable,"agent delete button is not enabled");
   }

 @Test(priority =31,enabled = true)
   public void agentNextButtonVerify() {
boolean result=agent_object.agentsCount();
if(result) {
   boolean visible = agent_object.agentNextTabButtonVisibility();
   Assert.assertTrue(visible, "agent next Page button is not visible");
   boolean enable = agent_object.agentNextTabButtonEnableTest();
   Assert.assertTrue(enable, "agent next page button is not enabled");
   agent_object.clickNextPageButton();
}
else{
   logger.info("agents count is less than 5 so next button verification is skipped");
}
   }
   @Test(priority =29,enabled = true)
   public void agentGoToLastPageButtonVerify() {
       boolean result=agent_object.agentsCount();
       if(result) {

           boolean visible = agent_object.agentLastTabButtonVisibility();
           Assert.assertTrue(visible, "agent last goToLastPage() is not visible");
           boolean enable = agent_object.agentLastTabButtonEnableTest();
           Assert.assertTrue(enable, "agent goToLastPage button is not enabled");
           agent_object.clickLastPageButton();

       }

   }
   @Test(priority =30)
   public void agentPreviousButtonVerify() {
       boolean result=agent_object.agentsCount();
       if(result) {

           boolean visible = agent_object.agentPreviousButtonVisibility();
           Assert.assertTrue(visible, "agent previous Page button is not visible");
           boolean enable = agent_object.agentPreviousButtonEnableTest();
          // Assert.assertTrue(enable, "agent previous page button is  not enabled");
           agent_object.clickPreviousPageButton();
       }

   }
    @Test(priority = 28,enabled = false)
    public void agentSearch() throws InterruptedException {
        agent_object.searchAgent("hrms");
        String extractedImageName=agent_object.getFirstAgentName();
        System.out.println("agent"+extractedImageName);
        Assert.assertTrue(extractedImageName.contains("hrms"),"agent search is failed");
    }
@AfterTest
    public void agentRefreshButtonVerify() {


        boolean visible=agent_object.agentRefreshButtonVisibility();

        Assert.assertTrue(visible,"agent refresh button is not visible");
        boolean enable=agent_object.agentRefreshButtonEnableTest();
        Assert.assertTrue(enable,"agent  refresh button is not enabled");

    }
}
