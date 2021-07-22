package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.osImagePageObjects;

public class osImageTestCases {

    osImagePageObjects osImage_page;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(PackageNegativeTestCases.class);


    WebDriver driver;
    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
        System.out.println(driver);
        osImage_page =new osImagePageObjects(driver);
    }
    @Test (priority = 46)
    public void osImageMaxCharactersValidation() {

        osImage_page.osImagePageClick();
        osImage_page.importOsImagePage();
        osImage_page.enterName("max20charactersallowed");
        String osImageNameMaxErrorMessage = osImage_page.osImageNameMaxCharInvalidMsg();
        Assert.assertEquals(osImageNameMaxErrorMessage, "Too Long: Maximum 20 characters allowed", "osImage_Name_Max_Char_Assertion_is_Failed");


        osImage_page.enterVersionDetails("max10characters");
        String osImageVersionMaxErrorMessage = osImage_page.osImageVersionMaxCharMsg();
        Assert.assertEquals(osImageVersionMaxErrorMessage, "Too Long: Maximum 10 characters allowed", "osImage_version_Max_Char_Assertion_is_Failed");

        osImage_page.enter_name_and_version("pneumonoultramicroscopicsilicovolcanoconiosistenertyuioipneumonoultramicroscopicsilicovolcanoconiosis");
        String os_nameVersion_maxCharMsg = osImage_page.os_nameVersion_maxCharMsg();
        Assert.assertEquals(os_nameVersion_maxCharMsg, "Too Long: Maximum 100 characters allowed", "osImage_Name:version_Max_Char_Assertion_is_Failed");

        osImage_page.name_version_clear();
    }
    @Test (priority = 47)
    public void osImageMinCharactersValidation() {


        osImage_page.enterName("ma");
        String osImageNameMinErrorMessage = osImage_page.osImageNameMinCharInvalidMsg();
        Assert.assertEquals(osImageNameMinErrorMessage, "Too Short: Minimum 3 characters required", "osImage_Name_Min_Char_Assertion_is_Failed");

        osImage_page.name_version_clear();
    }
    @Test (priority = 48)
    public void osImageInvalidCharactersValidation() {

        osImage_page.enterName(".?{}");
        String osImageNameInvalidErrorMessage = osImage_page.osImageNameInvalidCharInvalidMsg();
        Assert.assertEquals(osImageNameInvalidErrorMessage, "Invalid Pattern: Only alphanumeric, hyphen(-), space, underscore(_) and dot(.) are allowed", "osImage_Name_Invalid_Char_Assertion_is_Failed");

        osImage_page.enterVersionDetails("{}+");
        String osImageVersionInvalidErrorMessage = osImage_page.osImageVersionInvalidCharMsg();
        Assert.assertEquals(osImageVersionInvalidErrorMessage, "Invalid Pattern: Only alphanumeric, hyphen(-) and dot(.) are allowed and should not start with dot(.) or hyphen(-)", "osImage_name:version_InvalidChar_Assertion_is_Failed");

        osImage_page.name_version_clear();
        osImage_page.closeButton();
    }

}
