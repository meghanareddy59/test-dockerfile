package testCases.Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Infrastructure.kubernetesCLusterPageObjects;
import testCases.hyscaleLoginPageTestCase;

public class clusterAlertMsgTestCases {
    kubernetesCLusterPageObjects cluster_object;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(clusterAlertMsgTestCases.class);

    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
        cluster_object=new kubernetesCLusterPageObjects(driver);
        cluster_object.goToInfrastructureTab();
        cluster_object.goToResourcesTab();
        cluster_object.click_AddCluster();

    }
    @BeforeMethod
    public void enterText() {

        cluster_object.enterName("cluster");
        cluster_object.enterApiServer("apiServer");
        cluster_object.enterCaCertificate("caCertificate");
        cluster_object.enterUsername("userName");
        cluster_object.enterClientCertificate("clientCertificate");
        cluster_object.enterClientKey("clientKey");

    }
    @Test(priority = 49)
    public void messageValidations_IfTextIsNotEntered() {
        cluster_object.clearAllText();
       String clusterNameMessage= cluster_object.getMsg_clusterNameNotProvided();
        String clusterApiServerMessage= cluster_object.getMsg_clusterApiServerNotProvided();
        String clusterUserNameMessage= cluster_object.getMsg_clusterUserNameMsgNotProvided();
        String clusterCaCertMessage= cluster_object.getMsg_clusterCaCertMsgNotProvided();
        String clusterClientCrtMessage= cluster_object.getMsg_clusterClientCertificateMsgNotProvided();
        String clusterClientKeyMessage= cluster_object.clusterClientKeyMsgNotProvided();


        Assert.assertEquals(clusterNameMessage, "Name is required", "if cluster name is not provided then alert message is not coming");
        Assert.assertEquals(clusterApiServerMessage, "Server is required", "if cluster api server is not provided then alert message is not coming");
        Assert.assertEquals(clusterUserNameMessage, "Username is required", "if cluster username is not provided then alert message is not coming");
        Assert.assertEquals(clusterCaCertMessage, "CA Certificate is required", "if cluster ca cert is not provided then alert message is not coming");
        Assert.assertEquals(clusterClientCrtMessage, "Client Certificate is required", "if cluster client crt is not provided then alert message is not coming");
        Assert.assertEquals(clusterClientKeyMessage, "Client Key is required", "if cluster client key is not provided then alert message is not coming");

    }
    @Test(priority = 49)
    public void wrongApiServer_AlertMsg() {

        cluster_object.testAndSave();
        String msg=cluster_object.alertMsg_InvalidApiServer();
        Assert.assertEquals(msg,"Invalid Kubernetes cluster.","no alert message is provided if user gives wrong api server(test and save)");
cluster_object.closeAlertMsg();
cluster_object.closeButton();

    }



}
