package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.baseImagePageObjects;

public class baseImagesElementsVerification {

    baseImagePageObjects base_image_object;
    hyscaleLoginPageTestCase driver_get;

    static Logger logger = LogManager.getLogger(baseImagesElementsVerification.class);


    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
    }

    @Test(priority = 12)
    public void importImageButtonVerification() {
        base_image_object = new baseImagePageObjects(driver);
        base_image_object.goToBaseImagesTab();
        boolean elementVisible = base_image_object.importButtonVisibilityVerify();
        boolean elementEnable = base_image_object.importButtonEnableVerify();

        Assert.assertTrue(elementVisible, "import image button is not visible");
        Assert.assertTrue(elementEnable, "import image button is not enabled");
        base_image_object.importImageButtonClick();

    }

    @Test(priority = 13)
    public void verifyNextButton() {
        boolean elementEnable = base_image_object.nextButtonEnableVerify();
        Assert.assertFalse(elementEnable, "import image next button is enabled");
       }

    @Test(priority = 14)
    public void importImageDetails() {
        base_image_object.enterName("importimage");
        base_image_object.enterVersionDetails("1.0");
        base_image_object.enterDescriptionDetails("from selenium");
        boolean elementEnable = base_image_object.nextButtonEnableVerify();
        Assert.assertTrue(elementEnable, "import image next button is not enabled after filling details");
        base_image_object.nextPageClick();
    }

    @Test(priority = 15)
    public void importImageRegistryDetails() {
        base_image_object.selectRegistry("library");
        base_image_object.enter_name_and_version("mysql:5.6");
        boolean elementEnable = base_image_object.nextButtonEnableVerify();
        Assert.assertTrue(elementEnable, "import image next button is not enabled after filling  registry details");
        boolean previousElementEnable = base_image_object.previousButtonEnableVerify();
        Assert.assertTrue(previousElementEnable, "import image previous button is  not enabled after filling the registry details");

        base_image_object.nextPageClick();

    }

    @Test(priority = 16)
    public void importImagePortDetailsVerify() {

        boolean elementEnable = base_image_object.ImagePortNumberFromSourceEnable();
        Assert.assertFalse(elementEnable, "import image port number from source is able to change");

        boolean portTypeElementEnable = base_image_object.ImagePortTypeFromSourceEnable();
        Assert.assertTrue(portTypeElementEnable, "import image port type from source is not able to change");

        base_image_object.baseImagePortName("port1");


        boolean nextButtonElementEnable = base_image_object.nextButtonEnableVerify();
        Assert.assertTrue(nextButtonElementEnable, "import image next button is not enabled after entering port details");

        boolean PreviousButtonElementEnable = base_image_object.previousButtonEnableVerify();
        Assert.assertTrue(PreviousButtonElementEnable, "import image previous button is not enabled after entering port details");
        base_image_object.nextPageClick();

    }


    @Test(priority = 17)
    public void importImageReviewWizardVerify() {
        String Distribution_Type=base_image_object.VerifyDistributionType();
        Assert.assertEquals(Distribution_Type,"DEBIAN","Image_Import_Distribution_Type is not matched");
            String Image_Name=base_image_object.VerifyImage_Name();
            Assert.assertEquals(Image_Name,"mysql:5.6","Image Import Image_Name is not matched");
            String Registry=base_image_object.VerifyRegistry();
            Assert.assertEquals(Registry,"library","Image Import Registry is  not matched");
            String port_Number=base_image_object.VerifyPortNumber();
            Assert.assertEquals(port_Number,"3306","Image Import port_Number is  not matched");

    }
    @Test(priority = 18)
    public void VerifyConfirmButton(){
        boolean confirmButtonElementEnable = base_image_object.confirmButtonEnableVerify();
        Assert.assertTrue(confirmButtonElementEnable, "Image import confirm Button  is not enabled after entering all details");

        boolean PreviousButtonElementEnable = base_image_object.previousButtonEnableVerify();
        Assert.assertTrue(PreviousButtonElementEnable, "import image previous button is not enabled after entering all details");

        base_image_object.closeButton();
    }
    @Test(priority = 12,enabled = false)
    public void ASearchImage() throws InterruptedException {

        base_image_object.searchBaseImage("tomcat");
        String extractedImageName=base_image_object.getFirstImageName();
        Assert.assertTrue(extractedImageName.contains("tomcat"));

    }
    @AfterClass
    public void baseImageRefreshButtonVerify() {

        boolean visible=base_image_object.refreshButtonVisibility();
        Assert.assertTrue(visible,"baseImage refresh  button is not visible");
        boolean enable=base_image_object.refreshButtonEnableTest();
        Assert.assertTrue(enable,"baseImage refresh  button is NOT enabled");

    }
    @Test(priority = 20)
    public void ImageFilterVerification(){
        base_image_object.filterClick();
        System.out.println("test");

        int count=base_image_object.countOfImagesTypes();
        System.out.println("count"+count);
        if(count==3){

            String failedImagesMessage=base_image_object.verifyFailedImages();
            String baseImagesMessage= base_image_object.verifyBlockImages();
            System.out.println("baseImagesMessage"+baseImagesMessage);
            Assert.assertEquals(baseImagesMessage,"Auto update blocked");
            System.out.println("failed msg"+failedImagesMessage);
            Assert.assertTrue(failedImagesMessage.contains("ailed"));


        }
        else if(count==2){
           String imageType= base_image_object.getImagesType();
           if(imageType.equalsIgnoreCase("Blocked on update")){

               String baseImagesMessage= base_image_object.verifyImageTypeMsg();
               Assert.assertEquals(baseImagesMessage,"Auto update blocked");

           }
           else if(imageType.equalsIgnoreCase("Failed on update")){
               String failedImagesMessage=base_image_object.verifyImageTypeMsg();
               Assert.assertEquals(failedImagesMessage,"failed");

           }

        }
    }
}
