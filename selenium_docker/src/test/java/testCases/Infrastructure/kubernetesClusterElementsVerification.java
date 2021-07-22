package testCases.Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Infrastructure.kubernetesCLusterPageObjects;
import testCases.hyscaleLoginPageTestCase;
import utils.waitFactory;

public class kubernetesClusterElementsVerification {

    kubernetesCLusterPageObjects cluster_object;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(kubernetesClusterElementsVerification.class);

    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
        cluster_object=new kubernetesCLusterPageObjects(driver);


    }

    @Test(priority = 50)
    public void addClusterButtonVerify(){
        boolean elementVisible = cluster_object.createClusterButtonVisibilityVerify();
        boolean elementEnable = cluster_object.createClusterButtonEnableVerify();

        Assert.assertTrue(elementVisible, "create cluster button is not visible");
        Assert.assertTrue(elementEnable, "create cluster button is not enabled");

    }
    @Test(priority = 50)
    public void deleteClusterButtonVerify(){
        boolean elementVisible = cluster_object.deleteIconVisibility();
        Assert.assertTrue(elementVisible, "delete cluster button is not visible");
        boolean elementEnable = cluster_object.deleteIconEnableTest();
        Assert.assertTrue(elementEnable, "delete cluster button is not enable");

    }
    @Test(priority = 50)
    public void editClusterButtonVerify(){
        boolean elementVisible = cluster_object.editButtonVisibility();
        boolean elementEnable = cluster_object.editButtonEnableTest();

        Assert.assertTrue(elementVisible, "edit cluster button is not visible");
        Assert.assertTrue(elementEnable, "edit cluster button is not enabled");

    }

    @Test(priority = 51)
    public void refreshButtonVerify(){
        boolean elementVisible = cluster_object.refreshButtonEnableTest();
        boolean elementEnable = cluster_object.refreshButtonEnableTest();

        Assert.assertTrue(elementVisible, "refresh cluster button is not visible");
        Assert.assertTrue(elementEnable, "refresh cluster button is not enabled");

    }
    @Test(priority = 51)
    public void scanClusterButtonVerify(){
        boolean elementVisible = cluster_object.ScanClusterButtonVisibilityVerify();
        boolean elementEnable = cluster_object.ScanClusterButtonEnableVerify();
        Assert.assertTrue(elementVisible, "cluster scan button is not visible");
        Assert.assertTrue(elementEnable, "cluster scan button is not enabled");

    }
    @Test(priority = 52,enabled = false)
    public void VerifyTestAndSaveButton_noDetailsProvided(){
        cluster_object.click_AddCluster();
        boolean elementVisible = cluster_object.VerifyTestAndSaveButtonVisibilityVerify();
        boolean elementEnable = cluster_object.VerifyTestAndSaveButtonEnableVerify();
        Assert.assertTrue(elementVisible, "test and save button is not visible");
        Assert.assertFalse(elementEnable, "test and save button is enabled before entering cluster details");
cluster_object.closeButton();
    }
    @Test(priority = 54)
    public void SearchVerify(){
        cluster_object.searchCluster("GKE");

        String extractedImageName=cluster_object.getFirstClusterName();
        System.out.println(extractedImageName);
       // Assert.assertTrue(extractedImageName.contains("GKE"),"Cluster search is failed");


    }
    @Test(priority = 53,enabled = false)
    public void AddMemberToCluster() throws InterruptedException {
        cluster_object.click_ClusterMemberTab();
        cluster_object.enterMember("satishqa2");
cluster_object.selectmemeber();

    }

    @Test(priority = 53,enabled = false)
    public void DeleteMemberFromMember() throws InterruptedException {

        cluster_object.deleteMember();
    }

    @Test(priority = 55)
    public void deployedEnvironments(){
        cluster_object.click_deployedEnvironmentsTab();

String[] headers=cluster_object.getDeployedEnvironments_headers();

        for (int i = 0; i < headers.length; i++) {
            System.out.println(headers[i]);
        }
        Assert.assertTrue(headers[0].contains("Application"),"deployed environments application header text not matched not matched in cluster");
        Assert.assertEquals(headers[1],"Environments","deployed environments environments header text not matched not matched in cluster");
        Assert.assertEquals(headers[2],"Memory Consumption","deployed environments memory consumption header text not matched not matched in cluster");
        Assert.assertEquals(headers[3],"Pods","deployed environments pods header text not matched not matched in cluster");

    }
}
