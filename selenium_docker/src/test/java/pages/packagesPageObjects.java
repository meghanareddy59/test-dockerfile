package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.waitFactory;

import javax.crypto.spec.PSource;
import java.util.concurrent.TimeUnit;

public class packagesPageObjects extends common {
    waitFactory wait = new waitFactory(driver);


    static Logger logger = LogManager.getLogger(packagesPageObjects.class);


    //repositoryTab
    @FindBy(how = How.XPATH, using = "//a[@href ='#!/repository']")

    WebElement repositoryTab;


    //create package button

    @FindBy(how = How.ID, using = "create-package-btn")

    WebElement PackagesCreateButton;


    public boolean packagesCreateButtonVisibility() {
        boolean result = PackagesCreateButton.isDisplayed();
        return result;
    }
    public boolean packagesCreateButtonEnableTest() {
        boolean result = PackagesCreateButton.isEnabled();
        return result;
    }
    // package name text box

    // package vendor text box
    @FindBy(how = How.ID, using = "vendor")

    WebElement vendorTextBox;


    // operating system click
    @FindBy(how = How.ID, using = "os")

    WebElement selectOperatingSystem;


    @FindBy(how = How.XPATH, using = "//*[@id=\"os\"]/option[2]")

    WebElement selectFirstOperatingSystem;

    // install commands
    @FindBy(how = How.ID, using = "installCommands")

    WebElement packageInstallCommands;

    // package port name text box
    @FindBy(how = How.NAME, using = "name_0")

    WebElement packagePortNameTextBox;

    // package port number text box
    @FindBy(how = How.NAME, using = "port_0")

    WebElement portInputBox;

    //configproperties
    @FindBy(how = How.ID, using = "portKey0")

    public WebElement packageConfigPortKey;

    @FindBy(how = How.ID, using = "portValue0")

    WebElement packageConfigPortValue;


    //Invalid messages

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[3]/div/p[4]")

    WebElement packageVersionInvalidCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div/ul/li[2]/div[1]/p[1]")

    WebElement packagePortNameInvalidCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div/ul/li[2]/div[2]/p[1]")

    WebElement packagePortInvalidMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[4]/div/p[3]")

    WebElement packageVendorInvalidCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/div[2]/div/div[2]/p[1]")

    WebElement packageInvalidConfigKeyMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/div[2]/div/div[2]/p[2]")

    WebElement packageConfigKeyErrorMessage;


    // maximum characters message

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/p[3]")
    WebElement packageNameMinimumCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/p[4]")
    WebElement packageNameInvalidCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[3]/div/p[2]")

    WebElement packageVersionMaxCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[4]/div/p[1]")

    WebElement packageVendorMaxCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[2]/div/p")

    WebElement packageDescriptionMaxCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div/ul/li[2]/div[1]/p[3]")

    WebElement packagePortNameMaxCharMessage;


    // minimum characters message
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[4]/div/p[2]")

    WebElement packageVendorMinCharMessage;


    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div/ul/li[2]/div[1]/p[2]")

    WebElement packagePortNameMinCharMessage;

    public packagesPageObjects(WebDriver driver) {
        super(driver);
    }


    public void enterPackageConfigValue(String PackageConfigDetails) {

        packageConfigPortValue.sendKeys(PackageConfigDetails);
        logger.info("PackageConfig value is entered");

    }


    public void enterPackageConfigKey(String PackageConfigKeyDetails) {


        packageConfigPortKey.sendKeys(PackageConfigKeyDetails);
        logger.info("PackageConfigKeyDetails  are entered");

    }


    public String ErrorMessage_PackageConfigKey() {

        String packageConfigKeyError = packageConfigKeyErrorMessage.getText();
        return packageConfigKeyError;
    }

    public String invalidMessage_PackageConfigKey() {

        String packageConfigKeyError = packageInvalidConfigKeyMessage.getText();
        return packageConfigKeyError;
    }


    public void packageTextBoxClear() {
        nameTextBox.clear();
        versionTextBox.clear();
        vendorTextBox.clear();
        descriptionTextBox.clear();

    }

    public void packagePortClear() {
        portInputBox.clear();

    }

    public void packagePortNameClear() {
        packagePortNameTextBox.clear();

    }
    public void goToRepositoryTab() throws InterruptedException {

wait.implicitWait(20);
    //250ms frequency limit
        repositoryTab.click();}
    public void packagesCreate() throws InterruptedException {


        logger.info("packages testcase started");
        PackagesCreateButton.click();
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div[2]/form/div[1]/div[1]/div/p[2]")
    @CacheLookup
    WebElement packageNameMaxCharMessage;

    public String packageNameMaxCharactersMessage() {
        String packageNameMaxMessage = packageNameMaxCharMessage.getText();
        return packageNameMaxMessage;
    }

    public String packageNameMinCharactersMessage() {

        String packageNameMinMessage = packageNameMinimumCharMessage.getText();
        return packageNameMinMessage;
    }

    public String packageNameInvalidCharactersMessage() {

        String packageNameInvalidMessage = packageNameInvalidCharMessage.getText();
        return packageNameInvalidMessage;
    }

    public void enterPackageVendorName(String PackageVersionDetails) {

        vendorTextBox.sendKeys(PackageVersionDetails);
        logger.info(" vendorTextBox is successful");
    }

    public String packageVendorMaxCharactersMessage() {

        String packageVendorMaxMessage = packageVendorMaxCharMessage.getText();
        return packageVendorMaxMessage;
    }

    public String packageVendorMinCharactersMessage() {

        String packageVendorMinMessage = packageVendorMinCharMessage.getText();
        return packageVendorMinMessage;
    }

    public String packageVendorInvalidCharactersMessage() {

        String packageVendorInvalidMessage = packageVendorInvalidCharMessage.getText();
        return packageVendorInvalidMessage;
    }


    public String packageVersionMaxCharactersMessage() {

        wait.explicitWait(10, loader);
        String packageVersionMessage = packageVersionMaxCharMessage.getText();

        return packageVersionMessage;
    }

    public String packageVersionInvalidCharMessage() {

        String packageVersionMessage = packageVersionInvalidCharMessage.getText();
        return packageVersionMessage;
    }

    public String packageDescriptionMacMessage() {
        String packageDescriptionMessage = packageDescriptionMaxCharMessage.getText();

        return packageDescriptionMessage;
    }


    public void SelectOperatingSystem() throws InterruptedException {
        selectOperatingSystem.click();
        System.out.println("os selected");
        selectFirstOperatingSystem.click();
        selectOperatingSystem.click();
        wait.enableExplicitWait(10,nextButton);
        nextButton.click();
        nextButton.click();

    }

    public void packageInstallCommands(String command) {
        packageInstallCommands.sendKeys(command);
        nextButton.click();

    }

    public void enterPortName(String PackagePortDetails) {


        packagePortNameTextBox.sendKeys(PackagePortDetails);
        logger.info("packagePortNameTextBox is successful");
    }

    public String portNameMaxCharacters() {
        String packagePortNameMessage = packagePortNameMaxCharMessage.getText();
        return packagePortNameMessage;
    }

    public String portNameMinCharacters() {
        String packagePortNameMessage = packagePortNameMinCharMessage.getText();
        return packagePortNameMessage;
    }

    public String portNameInvalidCharacters() {

        String packagePortNameMessage = packagePortNameInvalidCharMessage.getText();
        return packagePortNameMessage;
    }


    public void enterPort(String PackagePortDetails) {


        portInputBox.sendKeys(PackagePortDetails);
        logger.info("packagePortNumberInputBox is successful");
    }

    public String portNumberInvalidMessage() {
        String packagePortNumberInvalidMessage = packagePortInvalidMessage.getText();

        return packagePortNumberInvalidMessage;

    }



    @FindBy(how = How.ID, using = "Duplicate-action")
    WebElement PackagesDuplicateButton;

    public boolean packagesDuplicateButtonVisibility() {
        boolean result = PackagesDuplicateButton.isDisplayed();
        return result;
    }
    public boolean packagesDuplicateButtonEnableTest() {
        boolean result = PackagesDuplicateButton.isEnabled();
        return result;
    }
    public boolean  duplicateButtonClickVerify(){
        wait.explicitWait(30,loader);
        PackagesDuplicateButton.click();
        boolean result = closeButton.isEnabled();
        closeButton.click();
        return result;
    }




    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button[3]/em")
    WebElement PackagesNextTabButton;

    public boolean packagesNextTabButtonVisibility() {
        boolean result = PackagesNextTabButton.isDisplayed();
        return result;
    }
    public boolean packagesNextTabButtonEnableTest() {
        boolean result = PackagesNextTabButton.isEnabled();
        System.out.println("result is"+result);
        return result;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button[4]")
    WebElement PackagesLastTabButton;

    public boolean packagesLastTabButtonVisibility() {
        boolean result = PackagesLastTabButton.isDisplayed();
        return result;
    }
    public boolean packagesLastTabButtonEnableTest() {
        boolean result = PackagesLastTabButton.isEnabled();
        return result;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div[2]/div[2]/div/button[2]")
    WebElement PackagesPreviousTabButton;
    public boolean packagesPreviousButtonVisibility() {
        boolean result = PackagesPreviousTabButton.isDisplayed();

        return result;
    }
    public boolean packagesPreviousButtonEnableTest() {
        boolean result = PackagesPreviousTabButton.isEnabled();
        return result;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div[1]/input")
    WebElement PackageSearchTextBox;

    public void searchPackage(String packageName){
        PackageSearchTextBox.sendKeys(packageName);
    }


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div/form/div/div[1]/div/label[2]")
    WebElement Details;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/ul/li[2]/a/uib-tab-heading/span")
    WebElement setUpFiles;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/ul/li[3]/a")
    WebElement Commands;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/ul/li[4]/a/uib-tab-heading/span")
    WebElement configuration;



    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div/form/div/div[1]/div/label[2]")
    WebElement packageNameFromDetails;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div/div/p")
    WebElement packageSetUpFiles;


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[3]/div/div/div/div/div/pre")
    WebElement packageCommands;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[1]/div/div/div/div/div[2]/div[2]/div/div[2]/div[2]/div/div/div[4]/div/div/div/div/form/div/div[1]/div/div/ul/li[2]/label[3]")
    WebElement packagePort;



    @FindBy(how = How.XPATH, using ="//div[2]/div[2]/div/div/wm-loader/div/div/span")
    WebElement ploader;

    public String verifyPackageDetails() throws InterruptedException {

        String result=null;
        boolean result1=wait.explicitWait(20,ploader);
        if(result1) {
             result=packageNameFromDetails.getText();
        }
    ;
    return result;
}

    public void  deleteTextInSearchBox(){
        PackageSearchTextBox.clear();
        wait.explicitWait(20,ploader);
    }
    public String verifyPackageSetUpFiles(){
        setUpFiles.click();
        String result=packageSetUpFiles.getText();
        return result;
    }
    public String verifySetCommands(){
        Commands.click();
        String result=packageCommands.getText();
        return result;
    }
    public String verifyPackageConfiguration(){
        configuration.click();
        String result=packagePort.getText();
        return result;
    }


}
