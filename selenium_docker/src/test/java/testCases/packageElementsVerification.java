package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.packagesPageObjects;

public class packageElementsVerification {

    packagesPageObjects packages_page;
    hyscaleLoginPageTestCase driver_get;

    static Logger logger = LogManager.getLogger(PackageNegativeTestCases.class);


WebDriver driver;
    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
    }

    @Test(priority = 3)
    public void packageCreateButtonVerify() throws InterruptedException {
        packages_page=new packagesPageObjects(driver);
        packages_page.goToRepositoryTab();
        boolean visible=packages_page.packagesCreateButtonVisibility();
        Assert.assertTrue(visible,"packages create button is not visible");
        boolean enable=packages_page.packagesCreateButtonEnableTest();
        Assert.assertTrue(enable,"packages create button is not enabled");

    }
    @Test(priority = 4)
    public void packageEditButtonVerify() {
        packages_page=new packagesPageObjects(driver);
        boolean visible=packages_page.editButtonVisibility();
        Assert.assertTrue(visible,"packages edit button is not visible");
        boolean enable=packages_page.editButtonEnableTest();
        Assert.assertTrue(enable,"packages edit button is not enabled");

    }
    @Test(priority = 5)
    public void packageDeleteButtonVerify() {

        packages_page=new packagesPageObjects(driver);
        boolean visible=packages_page.deleteIconVisibility();
        Assert.assertTrue(visible,"packages delete button is not visible");
        boolean enable=packages_page.deleteIconEnableTest();
        Assert.assertTrue(enable,"packages delete button is not enabled");
        boolean clickable= packages_page.deleteButtonClickVerify();
        Assert.assertTrue(clickable,"packages delete button is not clickable");

    }
    @Test(priority =4)
    public void packageDuplicateButtonVerify() {
        packages_page=new packagesPageObjects(driver);
        boolean visible=packages_page.packagesDuplicateButtonVisibility();
        Assert.assertTrue(visible,"packages Duplicate button is not visible");
        boolean enable=packages_page.packagesDuplicateButtonEnableTest();
        Assert.assertTrue(enable,"packages Duplicate button is not enabled");
        boolean clickable= packages_page.duplicateButtonClickVerify();
        Assert.assertTrue(clickable,"packages Duplicate button is not clickable");
        packages_page.deleteTextInSearchBox();
    }
    @Test(priority =5)
    public void packageNextButtonVerify() {

        boolean visible=packages_page.packagesNextTabButtonVisibility();
        Assert.assertTrue(visible,"packages next Page button is not visible");
        boolean enable=packages_page.packagesNextTabButtonEnableTest();
        Assert.assertTrue(enable,"packages next page button is not enabled");

    }
    @Test(priority =6)
    public void packageGoToLastPageButtonVerify() {

        boolean visible=packages_page.packagesLastTabButtonVisibility();
        Assert.assertTrue(visible,"packages last goToLastPage() is not visible");
        boolean enable=packages_page.packagesLastTabButtonEnableTest();
        Assert.assertTrue(enable,"packages goToLastPage button is not enabled");

    }
    @Test(priority =7)
    public void packagePreviousButtonVerify() {

        boolean visible=packages_page.packagesPreviousButtonVisibility();
        Assert.assertTrue(visible,"packages previous Page button is not visible");
        boolean enable=packages_page.packagesPreviousButtonEnableTest();
        Assert.assertFalse(enable,"packages previous page button is  enabled");

    }
    @Test(priority =3,enabled = false)
    public void packageSearchVerify() throws InterruptedException {

        packages_page.searchPackage("WM_OpenSsh");

        String NameFromPackageDetails=packages_page.verifyPackageDetails();
        Assert.assertEquals(NameFromPackageDetails,"WM_OpenSsh");
        System.out.println("NameFromPackageDetails"+NameFromPackageDetails);
        String packageSetUpFilesDetails=packages_page.verifyPackageSetUpFiles();
        Assert.assertEquals(packageSetUpFilesDetails,"No setup files available");
        System.out.println("packageSetUpFilesDetails"+packageSetUpFilesDetails);
        String packageCommandDetails=packages_page.verifySetCommands();
        Assert.assertEquals(packageCommandDetails,"apt-get install -y openssh-server");
        System.out.println("packageCommandDetails"+packageCommandDetails);
        String packageConfigDetails=packages_page.verifyPackageConfiguration();
        Assert.assertEquals(packageConfigDetails,"22");
        System.out.println("packageCommandDetails"+packageConfigDetails);



    }

}
