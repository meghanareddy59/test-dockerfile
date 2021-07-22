package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.packagesPageObjects;
import utils.waitFactory;


public class PackageNegativeTestCases {
    packagesPageObjects packages_page;
    hyscaleLoginPageTestCase driver_get;
    waitFactory wait_object;
    static Logger logger = LogManager.getLogger(PackageNegativeTestCases.class);


    @BeforeClass
    public void packageLevelMaxCharacters() throws InterruptedException {

        System.out.println("driver test");
        driver_get = new hyscaleLoginPageTestCase();

        WebDriver driver=driver_get.getDriver();

        packages_page = new packagesPageObjects(driver);

        packages_page.goToRepositoryTab();
        packages_page.packagesCreate();
        logger.info("packages testcase started");

        //package name validation with maximum characters
        packages_page.enterName("maximumcharactersallowedinpackagesname30");
        String packageNameMaxErrorMessage = packages_page.packageNameMaxCharactersMessage();
        Assert.assertEquals(packageNameMaxErrorMessage, "Too Long: Maximum 30 characters allowed", "Package_Name_Max_Char_Assertion_is_Failed");

        packages_page.enterVersionDetails("maxcharis10");


        String packageVersionMaxErrorMessage = packages_page.packageVersionMaxCharactersMessage();
        Assert.assertEquals(packageVersionMaxErrorMessage, "Too Long: Maximum 10 characters allowed", "package_version_Max_Char_Assertion_is_Failed");


        packages_page.enterPackageVendorName("maximumcharallowedis20");
        String packageVendorMaxErrorMessage = packages_page.packageVendorMaxCharactersMessage();
        Assert.assertEquals(packageVendorMaxErrorMessage, "Too Long: Maximum 20 characters allowed", "vendor_Max_Char_Assertion_is_Failed");

        packages_page.enterDescriptionDetails("maximumcharallowedindescriptionnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnis256");

        String packageDescriptionMaxErrorMessage =packages_page.packageDescriptionMacMessage();
                Assert.assertEquals(packageDescriptionMaxErrorMessage, "Too Long: Maximum 256 characters allowed", "description_Max_Char_Assertion_is_Failed");


        packages_page.packageTextBoxClear();

    }


    @Test(priority = 8)
    public void packageLevelMinimumCharacters() throws InterruptedException {


        packages_page. enterName("ma");
        String packageNameMinErrorMessage = packages_page.packageNameMinCharactersMessage();
        Assert.assertEquals(packageNameMinErrorMessage, "Too Short: Minimum 3 characters required", "Package_Name_Min_Char_Assertion_is_Failed");


        packages_page.enterPackageVendorName("ma");
        String packageVendorMaxErrorMessage = packages_page.packageVendorMinCharactersMessage();
        Assert.assertEquals(packageVendorMaxErrorMessage, "Too Short: Minimum 3 characters required", "vendor_Min_Char_Assertion_is_Failed");
        packages_page.packageTextBoxClear();
    }

    @Test(priority = 9)
    public void packageLevelInvalidCharacters() {
        // package name validation with Invalid characters

        packages_page. enterName("invali d{}()");
        String packageNameInvalidCharErrorMessage = packages_page.packageNameInvalidCharactersMessage();
        Assert.assertEquals(packageNameInvalidCharErrorMessage, "Invalid Pattern: Only alphanumeric, hyphen(-) and underscore( _ ) are allowed", "Package_Name_Invalid_Char_Assertion_is_Failed");

        packages_page.enterPackageVendorName("invali d{}()");
        String packageVendorInvalidCharactersMessage = packages_page.packageVendorInvalidCharactersMessage();
        Assert.assertEquals(packageVendorInvalidCharactersMessage, "Invalid Pattern: Only alphanumeric, hyphen(-) and underscore( _ ) are allowed", "Package_Vendor_Invalid_Char_Assertion_is_Failed");

        packages_page.enterVersionDetails("ini {}()");
        String packageVersionInvalidCharactersMessage = packages_page.packageVersionInvalidCharMessage();
        Assert.assertEquals(packageVersionInvalidCharactersMessage, "Invalid Pattern: Only alphanumeric, hyphen(-) and dot(.) are allowed and should not start with dot(.) or hyphen(-)", "Package_Version_Invalid_Char_Assertion_is_Failed");

        packages_page.packageTextBoxClear();
    }

    @Test(priority = 10)
    public void packageLevelPortValidations() throws InterruptedException {
        packages_page. enterName("seleniumpackage");
        packages_page.enterPackageVendorName("selenium");
        packages_page.enterVersionDetails("1.0");
        packages_page.SelectOperatingSystem();
        packages_page.packageInstallCommands("echo \"hi\" ");
        packages_page.enterPort("65536");
        //1-65535
        String packagePortNumberInvalidMessage = packages_page.portNumberInvalidMessage();
        Assert.assertEquals(packagePortNumberInvalidMessage, "Invalid input", "Package_port_Number_outOfRange_Assertion_is_Failed");
        packages_page.packagePortClear();
        packages_page.enterPort("{})(*");
        //1-65535
        String packagePortNumberInvalidMessage_1 = packages_page.portNumberInvalidMessage();
        Assert.assertEquals(packagePortNumberInvalidMessage_1, "Invalid input", "Package_port_Number_outOfRange{}_Assertion_is_Failed");
        packages_page.packagePortClear();
        packages_page.enterPort("0");
        //1-65535 0 is invalid port as per blog *********
        String packagePortNumberInvalidMessage_0 = packages_page.portNumberInvalidMessage();
        Assert.assertEquals(packagePortNumberInvalidMessage_1, "Invalid input", "Package_port_Number_outOfRange0_Assertion_is_Failed");


    }


    @Test(priority = 11)
    public void packagePortNameValidations() {
        packages_page.enterPortName("portnamemax15numbers");
        String packagePortNameMaxCharactersMessage = packages_page.portNameMaxCharacters();
        Assert.assertEquals(packagePortNameMaxCharactersMessage, "Too Long: Maximum 15 characters allowed", "Package_port_Name_Max_Char_Assertion_is_Failed");
        packages_page.packagePortNameClear();
        packages_page.enterPortName("p");
        String packagePortNameMinCharactersMessage = packages_page.portNameMinCharacters();
        Assert.assertEquals(packagePortNameMinCharactersMessage, "Too Short: Minimum 2 characters required", "Package_port_Name_Max_Char_Assertion_is_Failed");
        packages_page.packagePortNameClear();
        packages_page.enterPortName("({)");
        String packagePortNameInvalidCharactersMessage = packages_page.portNameInvalidCharacters();
        Assert.assertEquals(packagePortNameInvalidCharactersMessage, "Pattern must start and end with a lower case alphabet or a digit. Only lower case alphabets, digits and hyphen(-) are allowed", "Package_port_Name_Max_Char_Assertion_is_Failed");
        packages_page.packagePortNameClear();
        packages_page.enterPortName("por-");
        String packagePortNameInvalidCharactersMessage_1 = packages_page.portNameInvalidCharacters();
        Assert.assertEquals(packagePortNameInvalidCharactersMessage_1, "Pattern must start and end with a lower case alphabet or a digit. Only lower case alphabets, digits and hyphen(-) are allowed", "Package_port_Name_Max_Char_Assertion_is_Failed");
        packages_page.packagePortNameClear();
        packages_page.enterPortName("por-}");
        String packagePortNameInvalidCharactersMessage_2 = packages_page.portNameInvalidCharacters();
        Assert.assertEquals(packagePortNameInvalidCharactersMessage_2, "Pattern must start and end with a lower case alphabet or a digit. Only lower case alphabets, digits and hyphen(-) are allowed", "Package_port_Name_Max_Char_Assertion_is_Failed");
        packages_page.packagePortNameClear();
        packages_page.enterPortName("por-P");
        String packagePortNameInvalidCharactersMessage_3 = packages_page.portNameInvalidCharacters();
        Assert.assertEquals(packagePortNameInvalidCharactersMessage_3, "Pattern must start and end with a lower case alphabet or a digit. Only lower case alphabets, digits and hyphen(-) are allowed", "Package_port_Name_Max_Char_Assertion_is_Failed");

    }



@AfterClass
    public void PackageConfigProperties() {


        packages_page.enterPackageConfigValue("configValue");
        String packageConfigKeyError = packages_page.ErrorMessage_PackageConfigKey();
        Assert.assertEquals(packageConfigKeyError, "Please enter key", "Package_config_key_Assertion(if value is provided without key)_is_Failed");

        packages_page.enterPackageConfigKey("{}");
        String packageConfigKeyInvalid = packages_page.invalidMessage_PackageConfigKey();
        Assert.assertEquals(packageConfigKeyInvalid, "Invalid Pattern: Only alphanumeric, dot(.), hyphen(-) and underscore( _ ) are allowed", "Package_config_key_Assertion(invalid{})_is_Failed");

        packages_page.packageConfigPortKey.clear();
        packages_page.enterPackageConfigKey("<?");
        String packageConfigKeyInvalid_1 = packages_page.invalidMessage_PackageConfigKey();
        Assert.assertEquals(packageConfigKeyInvalid_1, "Invalid Pattern: Only alphanumeric, dot(.), hyphen(-) and underscore( _ ) are allowed", "Package_config_key_Assertion(invalid<?)_is_Failed");
        packages_page.closeButton();

    }


}
