package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.agentPageObjects;


public class agentNegativeTestCases {
    agentPageObjects agent_page;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(PackageNegativeTestCases.class);

    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
    }

    @Test(priority = 33)
    public void maximumCharacters_Agents() {
        agent_page = new agentPageObjects(driver);


        agent_page.agentTabClick();
        logger.info("agent images testcases started");

        // agent name validation with maximum characters
        agent_page.enterName("maximumcharactersallowedforagent30");
        String agentNameMaxErrorMessage = agent_page.maximumCharMsg_agentName();
        Assert.assertEquals(agentNameMaxErrorMessage, "Too Long: Maximum 30 characters allowed", "agent_Name_Max_Char_Assertion_is_Failed");

        // agent version validation with maximum characters
        agent_page.enterVersionDetails("maximumcharsallowed128maximumcharsallowed128maximumcharsallowed128maximumcharsallowed128maximumcharsallowed128maximumcharsallowed128");
        String agentVersionMaxErrorMessage = agent_page.maximumCharMsg_agentVersion();
        Assert.assertEquals(agentVersionMaxErrorMessage, "Too Long: Maximum 128 characters allowed", "agent_Version_Max_Char_Assertion_is_Failed");

        // agent Description validation with maximum characters
        agent_page.enterDescriptionDetails("maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256maximumcharsallowed256");
        String agentDescriptionMaxErrorMessage = agent_page.maximumCharMsg_agentDescription();
        Assert.assertEquals(agentDescriptionMaxErrorMessage, "Too Long: Maximum 256 characters allowed", "agent_Description_Max_Char_Assertion_is_Failed");

        // agent Name_version validation with maximum characters
        agent_page.enter_name_and_version("maximumcharsallowed100maximumcharsallowed100maximumcharsallowed100maximumcharsallowed100maximumcharsallowed100");
        String agentName_versionMaxErrorMessage = agent_page.maximumCharMsg_agent_name_version();
        Assert.assertEquals(agentName_versionMaxErrorMessage, "Too Long: Maximum 100 characters allowed", "agent_Name_version_Max_Char_Assertion_is_Failed");

        agent_page.name_version_clear();
        agent_page.description_clear();

    }

    @Test(priority = 34)
    public void minimumCharacters_Agents() {

        // agent name validation with minimum characters
        agent_page.enterName("m");
        String agentNameMinErrorMessage = agent_page.minimumCharMsg_agentName();
        Assert.assertEquals(agentNameMinErrorMessage, "Too Short: Minimum 2 characters required", "agent_Name_Min_Char_Assertion_is_Failed");

        // agent version validation with minimum characters
        agent_page.enterVersionDetails("m");
        String agentVersionMinErrorMessage = agent_page.minimumCharMsg_agentVersion();
        Assert.assertEquals(agentVersionMinErrorMessage, "Too Short: Minimum 2 characters required", "agent_Version_Min_Char_Assertion_is_Failed");
        agent_page.name_version_clear();
    }

    @Test(priority = 35)
    public void InvalidCharacters_Agents() {


        // agent name validation with Invalid characters
        agent_page.enterName("QWE");
        String agentNameInvalidErrorMessage = agent_page.invalidMsg_agentName();
        Assert.assertEquals(agentNameInvalidErrorMessage, "Invalid Pattern: Only lower case alphabets, digits and hyphen(-) are allowed", "agent_Name_Invalid_Char_Assertion_is_Failed");

        // agent version validation with Invalid characters
        agent_page.enterVersionDetails("}{+_");
        String agentVersionInvalidErrorMessage = agent_page.invalidMsg_agentVersion();
        Assert.assertEquals(agentVersionInvalidErrorMessage, "Invalid Pattern: Only alphanumeric, dot(.), hyphen(-) and underscore( _ ) are allowed", "agent_Version_Invalid_Char_Assertion_is_Failed");
        agent_page.name_version_clear();
    }

    @Test(priority = 36)
    public void InvalidCharacters_AgentsPorts() {


        // agent port validation with Invalid input
        agent_page.enterName("seleniumagent");
        agent_page.enterVersionDetails("1.0");
        agent_page.enterDescriptionDetails("fromSelenium");
        agent_page.selectRegistry("library");
        agent_page.enter_name_and_version("ubuntu");
        agent_page.nextPageClick();
        agent_page.enterPortNumber("80800");

        String agentPortNumberInvalidErrorMessage = agent_page.InvalidPortNumberMsg();
        Assert.assertEquals(agentPortNumberInvalidErrorMessage, "Value must be between 1-65535", "agent_port_number_Invalid_Char_Assertion_is_Failed");

        agent_page.clearPortNumber();

    }

    @Test(priority = 37)
    public void duplicate_AgentsPorts() {

        agent_page.enterPortNumber("8080");
        agent_page.addNewPort("8080");
        String agentPortNumberDuplicateErrorMessage =agent_page.duplicatePortNumberMsg();
        Assert.assertEquals(agentPortNumberDuplicateErrorMessage, "Duplicate Port", "agent_Duplicate_port_number_Assertion_is_Failed");


    }

    @Test(priority = 37)
    public void select_portType() {
        agent_page.DeletePortAgent();
        agent_page.enterPortType("HTTP");

        agent_page.nextPageClick_Agent();

    }
    @Test(priority = 38)
    public void AgentConfigProps_invalid() {

        //after entering config value UI reminds that enter the key value
        agent_page.enterConfigValue("test");
        String agentConfigKeyMessage =agent_page.ConfigKeyAgentMsg();
        Assert.assertEquals(agentConfigKeyMessage, "Please enter key", "AgentConfigProps_after_Entering_configvalue_assertion_is_Failed");

        agent_page.enterConfigKey("}{");
        String agentConfigKeyErrorMessage =agent_page.invalidConfigKey_Agent();
        Assert.assertEquals(agentConfigKeyErrorMessage, "Invalid Pattern: Only alphanumeric, dot(.), hyphen(-) and underscore( _ ) are allowed", "AgentConfigProps_invalid_Assertion_is_Failed");
        agent_page.configKeyClear();
        agent_page.enterConfigKey("test");
        agent_page.nextPageClick();
        agent_page.closeButton();
    }


}
