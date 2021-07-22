package testCases.Infrastructure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Infrastructure.containerRegistryPageObjects;
import testCases.hyscaleLoginPageTestCase;

public class containerRegistryNegativeTestCases {


    containerRegistryPageObjects registry_object;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(containerRegistryNegativeTestCases.class);

    WebDriver driver;



    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
        driver = driver_get.getDriver();
        registry_object=new containerRegistryPageObjects(driver);

    }
    @Test(priority = 56)
    public void containerRegistryMaxCharacters(){


        registry_object.containerRegistryTabClick();
        registry_object.addContainerRegistry();
        logger.info("containerRegistry testcases started");

        // registry name validation with maximum characters
        registry_object.enterName("maximumcharactersallowedforregistry20");
        String NameMaxErrorMessage = registry_object.registryMaxCharMsg();
        Assert.assertEquals(NameMaxErrorMessage, "Too Long: Maximum 20 characters allowed", "container Registry_Name_Max_Char_Assertion_is_Failed");

       registry_object.selectRegistryType("Private");
      registry_object.enterRegistryUrl("maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255maximum255");
        String urlMaxErrorMessage = registry_object.registryUrlMaxCharMsg();
        Assert.assertEquals(urlMaxErrorMessage, "Too Long: Maximum 255 characters allowed", "container Registry_url_Max_Char_Assertion_is_Failed");
        registry_object.nameClear();
        registry_object.registryUrlClear();
    }
    @Test(priority = 56)
    public void containerRegistryMinCharacters(){

        // registry name validation with minimum characters
        registry_object.enterName("mi");
        String NameMinErrorMessage = registry_object.registryMinCharMsg();
        Assert.assertEquals(NameMinErrorMessage, "Too Short: Minimum 3 characters required", "container Registry_Name_Min_Char_Assertion_is_Failed");

        registry_object.enterRegistryUrl("mi");
        String urlminErrorMessage = registry_object.registryUrlMinCharMsg();
        Assert.assertEquals(urlminErrorMessage, "Too Short: Minimum 3 characters required", "container Registry_url_Min_Char_Assertion_is_Failed");

        registry_object.enterPassword("mi");
        String passwordMinMessage = registry_object.registryPasswordMinCharMsg();
        Assert.assertEquals(passwordMinMessage, "Too Short: Minimum 3 characters required", "container Registry_password_Min_Char_Assertion_is_Failed");


        registry_object.nameClear();
        registry_object.registryUrlClear();
        registry_object.passwordClear();
    }
    @Test(priority = 57)
    public void AcontainerRegistryInvalidCharacters(){


        // registry name validation with minimum characters
        registry_object.enterName("MI");
        String NameInvalidErrorMessage = registry_object.registryInvalidCharMsg();
        Assert.assertEquals(NameInvalidErrorMessage, "Invalid Pattern: Only lower case alphabets, hyphen(-), underscore(_), dot(.) and space are allowed", "container Registry_Name_invalid_Char_Assertion_is_Failed");


        registry_object.enterRegistryUrl("http://");
        String urlInvalidErrorMessage = registry_object.registryUrlInvalidCharMsg();
        Assert.assertEquals(urlInvalidErrorMessage, "URL should not start with http(s)://", "container Registry_url_invalid_Char_Assertion_is_Failed");



        registry_object.nameClear();
        registry_object.registryUrlClear();
        registry_object.closeButton();
    }

    @Test(priority = 57)
    public void containerRegistryDuplicateName(){

        registry_object.addContainerRegistry();
        registry_object.enterName("library");
        String NameDuplicateErrorMessage = registry_object.registryDuplicateCharMsg();
        Assert.assertEquals(NameDuplicateErrorMessage, "Duplicate Container Registry name is not allowed", "container Registry_Duplicate_Name__Char_Assertion_is_Failed");
        boolean elementVisible = registry_object.VerifyTestAndSaveButtonVisibilityVerify();
        boolean elementEnable = registry_object.VerifyTestAndSaveButtonEnableVerify();
        Assert.assertTrue(elementVisible, "test and save button is not visible");
        Assert.assertFalse(elementEnable, "test and save button is enabled before entering container registry details");
        registry_object.closeButton();

    }

}
