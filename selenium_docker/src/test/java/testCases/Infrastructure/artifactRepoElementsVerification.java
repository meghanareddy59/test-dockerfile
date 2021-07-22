package testCases.Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Infrastructure.artifactRepoPageObjects;
import testCases.hyscaleLoginPageTestCase;

public class artifactRepoElementsVerification {
    artifactRepoPageObjects artifactRepo_object;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(artifactRepoElementsVerification.class);

    WebDriver driver;



    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
        artifactRepo_object=new artifactRepoPageObjects(driver);

    }

    @Test(priority = 65)
    public void addArtifactRepoButtonVerification(){
        boolean visible=artifactRepo_object.addArtifactRepoButtonDisplayTest();

        Assert.assertTrue(visible,"add artifactRepo button is not visible");
        boolean enable=artifactRepo_object.addArtifactRepoButtonEnableTest();
        Assert.assertTrue(enable,"add artifactRepo button is not enabled");
    }
    @Test(priority = 66)
    public void RefreshButtonVerification(){
        boolean visible=artifactRepo_object.refreshButtonVisibility();

        Assert.assertTrue(visible,"artifactRepo refresh button is not visible");
        boolean enable=artifactRepo_object.refreshButtonEnableTest();
        Assert.assertTrue(enable,"artifactRepo  refresh button is not enabled");

    }
    @Test(priority = 66)
    public void editButtonVerification(){
        boolean visible=artifactRepo_object.editButtonVisibility();

        Assert.assertTrue(visible,"artifactRepo edit button is not visible");
        boolean enable=artifactRepo_object.editButtonEnableTest();
        Assert.assertTrue(enable,"artifactRepo  edit button is not enabled");


        boolean result=artifactRepo_object.editButtonClickVerify();
        Assert.assertTrue(result,"artifactRepo name text box is  enabled at edit level");
        artifactRepo_object.closeButton();

    }
    @Test(priority = 66)
    public void deleteButtonVerification(){
        boolean visible=artifactRepo_object.deleteIconVisibility();

        Assert.assertTrue(visible,"artifactRepo delete icon is not visible");
        boolean enable=artifactRepo_object.deleteIconEnableTest();
        Assert.assertTrue(enable,"artifactRepo  delete icon is not enabled");

        boolean enableDeleteAction=artifactRepo_object.deleteButtonClickVerify();
        Assert.assertTrue(enableDeleteAction,"artifactRepo  delete action button is not enabled");

    }
    @Test(priority = 64)
    public void searchArtifactRepo(){
        artifactRepo_object.searchArtifactRepo("JenkinsNew");
        String extractedName=artifactRepo_object.getFirstArtifact();
        System.out.println(extractedName+"extractedName");
        Assert.assertTrue(extractedName.contains("JenkinsNew"),"artifact repo search is failed");
    }






}
