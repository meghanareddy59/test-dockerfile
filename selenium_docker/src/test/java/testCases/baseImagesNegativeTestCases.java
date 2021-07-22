package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.baseImagePageObjects;
import pages.packagesPageObjects;

public class baseImagesNegativeTestCases {

    baseImagePageObjects baseImage_page;
    hyscaleLoginPageTestCase driver_get;
    static Logger logger = LogManager.getLogger(PackageNegativeTestCases.class);


    WebDriver driver;
    @BeforeClass
    public void getDriver() {
        driver_get = new hyscaleLoginPageTestCase();
         driver = driver_get.getDriver();
    }

    @Test(priority = 21)
    public void maximumCharacters_BaseImage() {
        baseImage_page = new baseImagePageObjects(driver);


        baseImage_page.createImagesTab();
        logger.info("base images testcases started");

        // base image validation with maximum characters
        baseImage_page.enterName("maximumcharactersallowedinpackagesname30");
        String imageNameMaxErrorMessage = baseImage_page.baseImageNameMaxCharactersMessage();
        Assert.assertEquals(imageNameMaxErrorMessage, "Too Long: Maximum 30 characters allowed", "image_Name_Max_Char_Assertion_is_Failed");

        baseImage_page.enterVersionDetails("maxccgaterurlkjhharissssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss128182818281828282882ssssssssssssssssss128");
        String imageVersionMaxErrorMessage = baseImage_page.baseImageVersionMaxCharactersMessage();
        Assert.assertEquals(imageVersionMaxErrorMessage, "Too Long: Maximum 128 characters allowed", "image_version_Max_Char_Assertion_is_Failed");

        baseImage_page.enterDescriptionDetails("maximumcharallowedindescriptionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnis256");
        String imageDescriptionMaxErrorMessage = baseImage_page.baseImageDescriptionMaxCharactersMessage();
        Assert.assertEquals(imageDescriptionMaxErrorMessage, "Too Long: Maximum 256 characters allowed", "image_version_Max_Char_Assertion_is_Failed");

        baseImage_page.textBoxClear();
    }
    @Test(priority = 21)
    public void minimumCharacters_BaseImage() {
        baseImage_page.enterName("m");
        String packageNameMinErrorMessage = baseImage_page.baseImageNameMinCharactersMessage();
        Assert.assertEquals(packageNameMinErrorMessage, "Too Short: Minimum 2 characters required", "Package_Name_Max_Char_Assertion_is_Failed");


        baseImage_page.enterVersionDetails("m");
        String imageVersionMinErrorMessage = baseImage_page.baseImageVersionMinCharactersMessage();
        Assert.assertEquals(imageVersionMinErrorMessage, "Too Short: Minimum 2 characters required", "Package_Name_Max_Char_Assertion_is_Failed");
    }
    @Test(priority = 22)
    public void invalidCharacters_BaseImage() {

        baseImage_page.textBoxClear();
        baseImage_page.enterName("AQWE");
        String packageNameInvalidErrorMessage = baseImage_page.baseImageNameInvalidCharactersMessage();
        Assert.assertEquals(packageNameInvalidErrorMessage, "Invalid Pattern: Only lower case alphabets, digits and hyphen(-) are allowed", "Package_Name_Max_Char_Assertion_is_Failed");

        baseImage_page.enterVersionDetails("*&^");
        String imageVersionInvalidErrorMessage = baseImage_page.baseImageVersionInvalidCharactersMessage();
        Assert.assertEquals(imageVersionInvalidErrorMessage, "Invalid Pattern: Only alphanumeric, dot(.), hyphen(-) and underscore( _ ) are allowed", "Package_Name_Max_Char_Assertion_is_Failed");


        baseImage_page.textBoxClear();
        baseImage_page.enterName("[]*&");
        String packageNameInvalidErrorMessage_1 = baseImage_page.baseImageNameInvalidCharactersMessage();
        Assert.assertEquals(packageNameInvalidErrorMessage_1, "Invalid Pattern: Only lower case alphabets, digits and hyphen(-) are allowed", "Package_Name_Max_Char_Assertion_is_Failed");
        baseImage_page.enterVersionDetails("./'ll");
        String imageVersionInvalidErrorMessage_1 = baseImage_page.baseImageVersionInvalidCharactersMessage();
        Assert.assertEquals(imageVersionInvalidErrorMessage_1, "Invalid Pattern: Only alphanumeric, dot(.), hyphen(-) and underscore( _ ) are allowed", "Package_Name_Max_Char_Assertion_is_Failed");
        baseImage_page.textBoxClear();
    }
    @Test(priority = 23)
    public void enterImageDetails() {

        baseImage_page.enterName("seleniumimage");
        baseImage_page.enterVersionDetails("1.0");
        baseImage_page.enterDescriptionDetails("selenium");
        baseImage_page.selectOs("Ubuntu 14.04 LTS");
        baseImage_page.nextPageClick();
    }
    @Test(priority = 24)
    public void negativeScenarios_BaseImagePortName() {

        driver.findElement(By.id("open-jdk-1.8-checkbox")).click();
        baseImage_page.nextPageClick();
        baseImage_page.baseImagePortName("maxium15charsallowed");
        String baseImagePortNameMaxChar = baseImage_page.baseImagePortNameMaxChar();
        Assert.assertEquals(baseImagePortNameMaxChar, "Too Long: Maximum 15 characters allowed", "Package_Name_Max_Char_Assertion_is_Failed");
        baseImage_page.portNameTextBoxClear();
        baseImage_page.baseImagePortName("m");
        String baseImagePortNameMinChar = baseImage_page.baseImagePortNameMinChar();
        Assert.assertEquals(baseImagePortNameMinChar, "Too Short: Minimum 2 characters required", "Package_Name_Max_Char_Assertion_is_Failed");
        baseImage_page.portNameTextBoxClear();
        baseImage_page.baseImagePortName("+_}");
        String baseImagePortNameInvalidChar = baseImage_page.baseImagePortNameInvalidChar();
        Assert.assertEquals(baseImagePortNameInvalidChar, "Pattern must start and end with a lower case alphabet or a digit. Only lower case alphabets, digits and hyphen(-) are allowed", "Package_Name_Max_Char_Assertion_is_Failed");
        baseImage_page.portNameTextBoxClear();
    }
    @Test(priority = 25)
    public void negativeScenarios_BaseImagePortNumber() {

        baseImage_page.baseImagePortNumber("ytff");
        String baseImagePortNumberInvalidChar = baseImage_page.baseImagePortNumberInvalidChar();
        Assert.assertEquals(baseImagePortNumberInvalidChar, "Invalid input", "Image_Port_Number_Invalid_Char(giving alphabets)_Assertion_is_Failed");
        baseImage_page.portNumberTextBoxClear();
        baseImage_page.baseImagePortNumber("65536");
        String baseImagePortNumberInvalidChar_1 = baseImage_page.baseImagePortNumberInvalidChar();
        Assert.assertEquals(baseImagePortNumberInvalidChar_1, "Invalid input", "Image_Port_Number_Invalid(65536)_Char_Assertion_is_Failed");
        baseImage_page.portNumberTextBoxClear();
        baseImage_page.baseImagePortNumber("}{)");
        String baseImagePortNumberInvalidChar_2 = baseImage_page.baseImagePortNumberInvalidChar();
        Assert.assertEquals(baseImagePortNumberInvalidChar_2, "Invalid input", "Image_Port_Number_Invalid_Char(}{})_Assertion_is_Failed");
        baseImage_page.portNumberTextBoxClear();
    }
    @Test(priority = 26,enabled = false)
    public void abnormalScenarios_BaseImagePortLevel() {
        baseImage_page.selectBaseImagePort("HTTP");
        baseImage_page.baseImagePortNumber("ytff");
        String baseImagePortNumberInvalidChar_afterSelectingPortType = baseImage_page.baseImagePortNumberInvalidChar();
        Assert.assertEquals(baseImagePortNumberInvalidChar_afterSelectingPortType, "Invalid input", "Image_Port_Number_Invalid_Char(giving_alphabets_after_selecting_port_type)_Assertion_is_Failed");
        baseImage_page.portNumberTextBoxClear();
        baseImage_page.baseImagePortName("PORTY");
        String baseImagePortNameInvalidChar_afterSelectingPortType = baseImage_page.baseImagePortNameInvalidChar();
        Assert.assertEquals(baseImagePortNameInvalidChar_afterSelectingPortType, "Pattern must start and end with a lower case alphabet or a digit. Only lower case alphabets, digits and hyphen(-) are allowed", "Image_Port_Name_Invalid_Char(giving_alphabets_after_selecting_port_type)_Assertion_is_Failed");
        baseImage_page.portNameTextBoxClear();
    }

      @AfterClass
        public void negativeScenarios_BaseImageConfigProperties() {
        baseImage_page.click_addProperty();
        baseImage_page.enterConfigValue("test");
        String baseImageConfigKeyErrorMessage_forConfigValue = baseImage_page.baseImageConfigKeyErrorMessage_forConfigValue();
        Assert.assertEquals(baseImageConfigKeyErrorMessage_forConfigValue, "Please enter key", "Image_configKey_Invalid_Char(baseImageConfigKeyErrorMessage_forConfigValue)_Assertion_is_Failed");

        baseImage_page.enterConfigKey("})>?");
        String baseImageConfigKeyErrorMessage = baseImage_page.baseImageConfigKeyErrorMessage();
        Assert.assertEquals(baseImageConfigKeyErrorMessage, "Invalid Pattern: Only alphanumeric, dot(.), hyphen(-) and underscore( _ ) are allowed", "Image_configKey_Invalid_Char(})>?)_Assertion_is_Failed");

        baseImage_page.closeButton();

    }
}
