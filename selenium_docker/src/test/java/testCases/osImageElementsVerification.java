package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.osImagePageObjects;

public class osImageElementsVerification {

    osImagePageObjects os_image_object;
    hyscaleLoginPageTestCase driver_get;

    static Logger logger = LogManager.getLogger(osImageElementsVerification.class);


    WebDriver driver;

    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();

    }

    @Test(priority = 39)
    public void osImageButtonVerification() {
        os_image_object = new osImagePageObjects(driver);
        os_image_object.osImagePageClick();

        boolean elementVisible = os_image_object.osImageButtonVisibilityVerify();
        boolean elementEnable = os_image_object.osImageButtonEnableVerify();

        Assert.assertTrue(elementVisible, "import osImage button is not visible");
        Assert.assertTrue(elementEnable, "import osImage button is not enabled");
    }
    @Test(priority = 40)
    public void osImageDeleteVerify(){
        boolean visible=os_image_object.osImageDeleteButtonVisibility();
        Assert.assertTrue(visible,"osImage delete button is not visible");
        boolean enable=os_image_object.osImageDeleteButtonEnableTest();
        Assert.assertTrue(enable,"osImage delete button is not enabled");

    }
    @Test(priority = 46,enabled = false)
    public void osImageSearch(){
        os_image_object.searchOsImage("CentOS");
        String extractedImageName=os_image_object.getFirstOsImageName();
        Assert.assertTrue(extractedImageName.contains("CentOS"),"osImage search is failed");
        os_image_object.clearSearchTextBox();
    }

    @Test(priority = 45)
    public void osImageNextButtonVerify() {

        boolean visible=os_image_object.osImageNextTabButtonVisibility();
        Assert.assertTrue(visible,"osImage next Page button is not visible");
        boolean enable=os_image_object.osImageNextTabButtonEnableTest();
        //Assert.assertTrue(enable,"osImage next page button is not enabled");
        os_image_object.osImageNextTabButtonClick();

    }
    @Test(priority = 44)
    public void osImageGoToLastPageButtonVerify() {
        boolean visible=os_image_object.osImageLastButtonVisibility();
        Assert.assertTrue(visible,"osImage last Page button is not visible");
        boolean enable=os_image_object.osImageLastButtonEnableTest();
        Assert.assertTrue(enable,"osImage last page button is not enabled");
        os_image_object.osImageLastTabButtonClick();

    }
    @Test(priority = 43)
    public void osImagePreviousButtonVerify() {

        boolean visible=os_image_object.osImagePreviousButtonVisibility();
        Assert.assertTrue(visible,"osImage previous Page button is not visible");
        boolean enable=os_image_object.osImagePreviousButtonEnableTest();
        Assert.assertTrue(enable,"osImage previous page button is not enabled");
        os_image_object.osImagePreviousButtonClick();

    }
    @Test(priority = 42)
    public void osImageRefreshButtonVerify() {

        boolean visible=os_image_object.refreshButtonVisibility();
        Assert.assertTrue(visible,"osImage refresh  button is not visible");
        boolean enable=os_image_object.refreshButtonEnableTest();
        Assert.assertTrue(enable,"osImage refresh  button is not  enabled");

    }
    @Test(priority = 47,enabled = false)
    public void osImageFilterVerification(){
        os_image_object.filterClick();
        System.out.println("test");

        int count=os_image_object.countOfImagesTypes();
        System.out.println("count"+count);
        if(count==3){
            String baseImagesMessage= os_image_object.verifyBlockImages();
            String failedImagesMessage=os_image_object.verifyFailedImages();
            System.out.println("baseImagesMessage"+baseImagesMessage);
            Assert.assertEquals(baseImagesMessage,"Auto update blocked");
            Assert.assertEquals(failedImagesMessage,"Failed");


        }
        else if(count==2){
            String imageType= os_image_object.getImagesType();
            if(imageType.equalsIgnoreCase("Blocked on update")){

                String baseImagesMessage= os_image_object.verifyImageTypeMsg();
                Assert.assertEquals(baseImagesMessage,"Auto update blocked");

            }
            else if(imageType.equalsIgnoreCase("Failed on update")){
                String failedImagesMessage=os_image_object.verifyImageTypeMsg();
                Assert.assertEquals(failedImagesMessage,"Failed");

            }

        }
    }
}
