package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.waitFactory;

import java.util.List;

public class baseImagePageObjects extends common {
    waitFactory waiter= new waitFactory(driver);

    static Logger logger = LogManager.getLogger(baseImagePageObjects.class);

    //BaseImagesTab
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/ul/li[2]/a/uib-tab-heading/span[2]")
    @CacheLookup
    WebElement baseImagesTab;
   public void goToBaseImagesTab(){
       baseImagesTab.click();
   }

    //create  Image
    @FindBy(how = How.ID, using = "create-image-btn")
    @CacheLookup
    WebElement createImage;

    //import Base Image
    @FindBy(how = How.ID, using = "import-image-btn")
    @CacheLookup
    WebElement importImage;


    public boolean importButtonVisibilityVerify() {
        boolean result = importImage.isDisplayed();
        return result;
    }
    public boolean importButtonEnableVerify() {
        boolean result = importImage.isEnabled();
        return result;
    }

    public void importImageButtonClick() {
        importImage.click();
    }

    @FindBy(how = How.NAME, using = "_TCP_9200_true_0")
    @CacheLookup
    WebElement importImagePort;

    public baseImagePageObjects(WebDriver driver) {
        super(driver);
    }


    //Image name maximum  characters message identification
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[1]/div/p[2]")
    WebElement baseImageNameMaxCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[1]/div/p[3]")
    WebElement baseImageNameMinimumCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[1]/div/p[4]")
    WebElement baseImageNameInvalidCharMessage;

    public  String  baseImageNameMaxCharactersMessage() {

        String baseImageNameMaxMessage = baseImageNameMaxCharMessage.getText();
        return baseImageNameMaxMessage;
    }
    public String baseImageNameMinCharactersMessage()  {
        String baseImageNameMinMessage=baseImageNameMinimumCharMessage.getText();
        return baseImageNameMinMessage;
    }
    public String baseImageNameInvalidCharactersMessage()  {

        String baseImageNameInvalidMessage=baseImageNameInvalidCharMessage.getText();
        return baseImageNameInvalidMessage;
    }


    //Image version maximum  characters message identification
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[2]/div/p[2]")
    WebElement baseImageVersionMaxCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[2]/div/p[3]")
    WebElement baseImageVersionMinimumCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[2]/div/p[4]")
    WebElement baseImageVersionInvalidCharMessage;

    public  String  baseImageVersionMaxCharactersMessage() {

   waiter.implicitWait(10);

        String baseImageVersionMaxMessage = baseImageVersionMaxCharMessage.getText();
        return baseImageVersionMaxMessage;
    }
    public String baseImageVersionMinCharactersMessage()  {

        String baseImageVersionMinMessage=baseImageVersionMinimumCharMessage.getText();
        return baseImageVersionMinMessage;
    }
    public String baseImageVersionInvalidCharactersMessage()  {

        String baseImageVersionInvalidMessage=baseImageVersionInvalidCharMessage.getText();
        return baseImageVersionInvalidMessage;
    }


    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div[3]/div/p")
    WebElement baseImageDescriptionMaxCharMessage;

    public  String  baseImageDescriptionMaxCharactersMessage() {

        String baseImageDescriptionMaxMessage = baseImageDescriptionMaxCharMessage.getText();
        return baseImageDescriptionMaxMessage;
    }


    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/ul/li[2]/div[1]/input")
    WebElement baseImagePortName;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/ul/li[2]/div[1]/p[3]")
    WebElement baseImagePortNameMaxMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/ul/li[2]/div[1]/p[2]")
    WebElement baseImagePortNameMinMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/ul/li[2]/div[1]/p[1]")
    WebElement baseImagePortNameInvalidMessage;

    public void baseImagePortName(String imagePort){
        baseImagePortName.sendKeys(imagePort);
    }
    public String baseImagePortNameMaxChar(){
        String baseImagePortNameMaxMsg = baseImagePortNameMaxMessage.getText();
        return baseImagePortNameMaxMsg;
    }
    public String baseImagePortNameMinChar(){
        String baseImagePortNameMinMsg = baseImagePortNameMinMessage.getText();
        return baseImagePortNameMinMsg;
    }
    public String baseImagePortNameInvalidChar(){
        String baseImagePortNameInvalidMsg = baseImagePortNameInvalidMessage.getText();
        return baseImagePortNameInvalidMsg;
    }
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/ul/li[2]/div[2]/input")
    WebElement baseImagePortNumber;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/ul/li[2]/div[2]/p[1]")
    WebElement baseImagePortNumberInvalidMessage;

    public void baseImagePortNumber(String imagePort){
        baseImagePortNumber.sendKeys(imagePort);
    }
    public String baseImagePortNumberInvalidChar(){

        String baseImagePortNumberInvalidMsg = baseImagePortNumberInvalidMessage.getText();
        return baseImagePortNumberInvalidMsg;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/ul/li[2]/select")
    WebElement baseImagePortType;
    public void selectBaseImagePort(String portType){
        Select baseImagePort= new Select(baseImagePortType);
        baseImagePort.selectByVisibleText(portType);

    }
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/ul/li[2]/div[2]/input")


    WebElement baseImagePort;

    public boolean ImagePortNumberFromSourceEnable() {
        boolean result = baseImagePort.isEnabled();

        return result;
    }
    public boolean ImagePortTypeFromSourceEnable() {
        boolean result = baseImagePortType.isEnabled();
        return result;
    }



    @FindBy(how = How.ID, using = "add-more-btn")
    WebElement addProperty_BaseImage;
    @FindBy(how = How.ID, using = "key-1")
    WebElement configKey_BaseImage;
    @FindBy(how = How.ID, using = "-value")
    WebElement configValue_BaseImage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div/div/div[2]/div[1]/p[1]")
    WebElement baseImageConfigKeyErrorMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div/div/div[2]/div[1]/p[2]")
    WebElement baseImageConfigKeyErrorMessage_forConfigValue;



    public String baseImageConfigKeyErrorMessage(){
        String ConfigKeyErrorMessage = baseImageConfigKeyErrorMessage.getText();
        return ConfigKeyErrorMessage;
    }

    public String baseImageConfigKeyErrorMessage_forConfigValue(){
        String ConfigKeyErrorMessage_forConfigValue = baseImageConfigKeyErrorMessage_forConfigValue.getText();
        return ConfigKeyErrorMessage_forConfigValue;
    }

    public void click_addProperty(){

        addProperty_BaseImage.click();
    }

    public void enterConfigKey(String configKey){

        configKey_BaseImage.sendKeys(configKey);
    }
    public void enterConfigValue(String configValue ){

        configValue_BaseImage.sendKeys(configValue);
    }

    @FindBy(how = How.ID, using = "baseImageId")
    WebElement selectOsImage_BaseImageCreation;
    public void selectOs(String os){
        Select selectOs = new Select(selectOsImage_BaseImageCreation);
        selectOs.selectByVisibleText(os);
        selectOsImage_BaseImageCreation.click();
    }



    public void createImagesTab(){
    packagestab.click();
    baseImagesTab.click();
    createImage.click();

}

    public void textBoxClear(){
        nameTextBox.clear();
        versionTextBox.clear();
        descriptionTextBox.clear();
        logger.info("all image text is cleared");

    }

    public  void portNameTextBoxClear(){
        baseImagePortName.clear();
    }

    public  void portNumberTextBoxClear(){
        baseImagePortNumber.clear();
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[3]/div[1]/input")
    WebElement baseImageSearchTextBox;

    public void searchBaseImage(String imageName){
        baseImageSearchTextBox.sendKeys(imageName);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div/span")
    WebElement firstBaseImage;
    WebDriverWait wait;
    public String getFirstImageName() {
        String result=null;
        boolean invisible=waiter.explicitWait(30,loader);

if(invisible) {
    result = firstBaseImage.getText();
    System.out.println(result);
}
        return result;

    }





    public boolean confirmButtonEnableVerify() {
        boolean result = confirmButton.isEnabled();
        return result;
    }



    public boolean nextButtonEnableVerify() {
        boolean result = nextButton.isEnabled();
        return result;
    }
    public boolean previousButtonEnableVerify() {
        boolean result = previousButton.isEnabled();
        return result;
    }


    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div/div/div[1]/div")
    @CacheLookup
    WebElement Distribution_Type;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div/div/div[3]/div")
    @CacheLookup
    WebElement Image_Name;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div/div/div[2]/div")
    @CacheLookup
    WebElement Registry;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/div/form/div[1]/div/div/div[4]/ul/li[2]/label[3]/span")
    @CacheLookup
    WebElement port_Number;


    public String VerifyDistributionType(){
        String result=Distribution_Type.getText();
        return result;
    }
    public String VerifyImage_Name(){
        String result=Image_Name.getText();
        return result;
    }
    public String VerifyRegistry(){
        String result=Registry.getText();
        return result;
    }
    public String VerifyPortNumber(){
        String result=port_Number.getText();
        return result;
    }


    @FindBy(how = How.CLASS_NAME, using = "grid-filter")
    @CacheLookup
    WebElement BaseImageFilter;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/select")
    WebElement selectFilter;

    public void filterClick( ) {

        BaseImageFilter.click();

    }
    public int countOfImagesTypes(){
        Select s = new Select(selectFilter); // getting the list of options in the dropdown with getOptions()
        List <WebElement> op = s.getOptions();
        int size = op.size();

return size;
    }
    public String getImagesType(){
        Select s = new Select(selectFilter); // getting the list of options in the dropdown with getOptions()
        List <WebElement> op = s.getOptions();
        int size = op.size();
        String option=null;
for(int i =0; i<size ; i++){
         option = op.get(i).getText();
        System.out.println(option);
    }
return option;
    }

      WebElement blockedImageType;
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div[1]/div/div/div[2]/select/option[3]")
    WebElement failedImageType;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/ng-include/div/div/div[1]/div[2]/div/span/label")
    WebElement blockedImageTypeMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[2]/div/div/div/div/div/div[2]/div[2]/ng-include/div/div/div[1]/div[2]/div/span/p")
    WebElement failedImageTypeMessage;


    @FindBy(how = How.XPATH, using = "//wm-loader/div/div/span")
    WebElement loader;

    public String verifyBlockImages(){

        new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("Blocked on update");
        String msg=null;
        boolean result=waiter.explicitWait(20,loader);
        if(result) {
            msg   = blockedImageTypeMessage.getText();

        }
        return msg;
    }


    public String verifyFailedImages(){
        failedImageType.click();
        String msg=null;
        boolean result=waiter.explicitWait(20,loader);
        if(result) {
            msg   = failedImageTypeMessage.getText();

        }
        return msg;

    }
    public String verifyImageTypeMsg(){
        blockedImageType.click();;
        String result= blockedImageTypeMessage.getText();
        return result;
    }
}