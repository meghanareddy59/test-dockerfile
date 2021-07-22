package testCases.Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Infrastructure.artifactRepoPageObjects;
import testCases.hyscaleLoginPageTestCase;

public class artifactRepoNegativeScenarios {
    artifactRepoPageObjects artifactRepo_object;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(containerRegistryNegativeTestCases.class);

    WebDriver driver;



    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
        artifactRepo_object=new artifactRepoPageObjects(driver);

    }
    @Test(priority = 59)
    public void artifactRepoMaxCharacters(){
        
        artifactRepo_object.GoToArtifactRepoTab();
        artifactRepo_object.addArtifactRepo();
        logger.info("artifactRepo testcases started");

        // registry name validation with maximum characters
        artifactRepo_object.enterName("maximumcharactersallowedforartifactrepo80maximumcharactersallowedforartifactrepo80");
        String NameMaxErrorMessage = artifactRepo_object.artifactRepoNameMaxCharMsg();
        Assert.assertEquals(NameMaxErrorMessage, "Too Long: Maximum 80 characters allowed", "artifact_Repo_Name_Max_Char_Assertion_is_Failed");

        artifactRepo_object.nameClear();
       
    }
    @Test(priority = 59)
    public void artifactRepoMinCharacters(){

        // registry name validation with maximum characters
        artifactRepo_object.enterName("mi");
        String NameMinErrorMessage = artifactRepo_object.artifactRepoNameMinCharMsg();
        Assert.assertEquals(NameMinErrorMessage, "Too Short: Minimum 3 characters required", "artifactRepo_Name_Min_Char_Assertion_is_Failed");

        artifactRepo_object.nameClear();

    }

    @Test(priority = 60)
    public void artifactRepoMInvalidCharacters(){
        artifactRepo_object.enterName("}{)");
        String NameInvalidErrorMessage = artifactRepo_object.artifactRepoNameInvalidCharMsg();
        Assert.assertEquals(NameInvalidErrorMessage, "Pattern must start with alphabet. Only alphanumeric and underscore(_) are allowed", "artifact_Name_invalid_Char_Assertion_is_Failed");


        artifactRepo_object.enterArtifactHost("ipaddress");
        String hostInvalidErrorMessage = artifactRepo_object.artifactRepoHostInvalidCharMsg();
        Assert.assertEquals(hostInvalidErrorMessage, "IP Address must be between 0.0.0.0 - 255.255.255.255", "artifact_Name_host_invalid_Char_Assertion_is_Failed");

        artifactRepo_object.enterArtifactPort("65536");
        String portInvalidErrorMessage = artifactRepo_object.artifactRepoPortInvalidCharMsg();
        Assert.assertEquals(portInvalidErrorMessage, "Value must be between 1-65535", "artifact_Name_port_invalid_Char_Assertion_is_Failed");


    }
    @Test(priority = 61)
    public void verifySaveAndTestButton_beforeEnteringDetails(){
        artifactRepo_object.closeButton();
        artifactRepo_object.addArtifactRepo();
        boolean visible=artifactRepo_object.addAndSaveButtonButtonDisplayTest();

        Assert.assertTrue(visible,"artifact repo add(save) button is not visible");
        boolean enable=artifactRepo_object.addAndSaveButtonButtonEnableTest();
        Assert.assertFalse(enable,"artifact repo add(save)  button is  enabled");
        artifactRepo_object.closeButton();
    }
    
}
