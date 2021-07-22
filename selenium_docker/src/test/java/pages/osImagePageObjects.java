package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class osImagePageObjects extends common{
    public osImagePageObjects(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait;
    static Logger logger = LogManager.getLogger(osImagePageObjects.class);

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/article/div/section/div/div[2]/div/div/div/ul/li[4]/a/uib-tab-heading/span[2]")
    WebElement osImagePage;

    @FindBy(how = How.ID, using = "import-image-btn")
    WebElement importOsImagePage;

    @FindBy(how = How.ID, using = "name-version")
    WebElement OsImage_nameVersion;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[4]/div/div/p[3]")
    WebElement osImage_maxCharsMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[2]")
    WebElement osImageNameMaxCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[3]")
    WebElement osImageNameMinCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[4]")
    WebElement osImageNameInvalidCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div/div/p[2]")
    WebElement osImageVersionMaxCharMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div/div/p[3]")
    WebElement osImageVersionInvalidCharMessage;

    public void osImagePageClick(){
        osImagePage.click();
    }

    public void importOsImagePage(){
        importOsImagePage.click();
    }

    public String os_nameVersion_maxCharMsg(){
        String osImageInvalidMessage=osImage_maxCharsMessage.getText();
        return osImageInvalidMessage;
    }



    public String osImageVersionMaxCharMsg(){
        String osImageVersionMaxCharMsg=osImageVersionMaxCharMessage.getText();
        return osImageVersionMaxCharMsg;
    }

    public String osImageVersionInvalidCharMsg(){
        String osImageVersionInvalidCharMsg=osImageVersionInvalidCharMessage.getText();
        return osImageVersionInvalidCharMsg;
    }

    public String osImageNameMaxCharInvalidMsg(){
        String osImageNameMaxCharMsg=osImageNameMaxCharMessage.getText();
        return osImageNameMaxCharMsg;
    }
    public String osImageNameMinCharInvalidMsg(){
        String osImageNameMinCharMsg=osImageNameMinCharMessage.getText();
        return osImageNameMinCharMsg;
    }

    public String osImageNameInvalidCharInvalidMsg(){
        String osImageNameInvalidMessage=osImageNameInvalidCharMessage.getText();
        return osImageNameInvalidMessage;
    }







    public boolean osImageButtonVisibilityVerify() {
        boolean result = importOsImagePage.isDisplayed();
        return result;
    }
    public boolean osImageButtonEnableVerify() {
        boolean result = importOsImagePage.isEnabled();
        return result;
    }






    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[2]/div[2]/ng-include/div/div[1]/div/span/div/em")

    WebElement osImageDeleteButton;


    public boolean osImageDeleteButtonVisibility() {
        osImagePage.click();

        boolean result = osImageDeleteButton.isDisplayed();
        return result;
    }
    public boolean osImageDeleteButtonEnableTest() {
        boolean result = osImageDeleteButton.isEnabled();
        return result;
    }
    public boolean  deleteButtonClickVerify(){
        osImageDeleteButton.click();
        boolean result = closeButton.isEnabled();
        closeButton.click();
        return result;
    }



    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[1]/div/div/div[3]/div[1]/input")
    WebElement osImageSearchTextBox;

    public void searchOsImage(String packageName){
        osImageSearchTextBox.sendKeys(packageName);
    }
    public void clearSearchTextBox(){
        osImageSearchTextBox.clear();
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/div[1]/div[2]/div/span")
    WebElement firstOsImage;

    public String getFirstOsImageName(){

        String result=firstOsImage.getText();
        return result;
    }



    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div/button[4]")
    WebElement osImageNextTabButton;

    public boolean osImageNextTabButtonVisibility() {
        boolean result = osImageNextTabButton.isDisplayed();
        return result;
    }
    public boolean osImageNextTabButtonEnableTest() {
        boolean result = osImageNextTabButton.isEnabled();
        System.out.println("result is"+result);
        return result;
    }
    public void osImageNextTabButtonClick() {
        osImageNextTabButton.click();

    }
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div/button[4]")
    WebElement osImageLastTabButton;
    public boolean osImageLastButtonVisibility() {
        boolean result = osImageLastTabButton.isDisplayed();

        return result;
    }
    public boolean osImageLastButtonEnableTest() {
        boolean result = osImageLastTabButton.isEnabled();
        return result;
    }

    public void osImageLastTabButtonClick() {
        osImageLastTabButton.click();

    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[1]/div/div/div[3]/div[2]/div[2]/div/button[1]/em")
    WebElement osImagePreviousButton;
    public boolean osImagePreviousButtonVisibility() {
        boolean result = osImagePreviousButton.isDisplayed();

        return result;
    }
    public boolean osImagePreviousButtonEnableTest() {
        boolean result = osImagePreviousButton.isEnabled();
        return result;
    }
    public void osImagePreviousButtonClick() {
         osImagePreviousButton.click();

    }


    @FindBy(how = How.CLASS_NAME, using = "grid-filter")
    @CacheLookup
    WebElement osImageFilter;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[1]/div/div/div[2]/select")
    WebElement selectFilter;

    public void filterClick( ) {

        osImageFilter.click();

    }
    public int countOfImagesTypes(){
        Select s = new Select(selectFilter); // getting the list of options in the dropdown with getOptions()
        List<WebElement> op = s.getOptions();
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

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[1]/div/div/div[2]/select/option[2]")
    WebElement blockedImageType;
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[1]/div/div/div[2]/select/option[2]")
    WebElement failedImageType;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[2]/div[2]/ng-include/div/div[1]/div/span/p")
    WebElement blockedImageTypeMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[2]/div[2]/ng-include/div/div[1]/div/span/p")
    WebElement failedImageTypeMessage;


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[4]/div/div/div/div/div/div[2]/div[2]/ng-include/wm-loader/div")
    WebElement loader;

    public String verifyBlockImages(){

        blockedImageType.click();
        String msg=null;
        wait = new WebDriverWait(driver, 20);
        boolean result=wait.until(ExpectedConditions.invisibilityOf(loader));
        System.out.println(result+"loader");
        if(result) {
            msg   = blockedImageTypeMessage.getText();

        }
        return msg;
    }
    public String verifyFailedImages(){
        failedImageType.click();
        String msg=null;
        wait = new WebDriverWait(driver, 20);
        boolean result=wait.until(ExpectedConditions.invisibilityOf(loader));
        System.out.println(result+"loader");
        if(result) {

            msg   = failedImageTypeMessage.getText();

        }
        return msg;

    }
    public String verifyImageTypeMsg(){
        Select selectAgentRegistry= new Select(selectFilter);
        selectAgentRegistry.selectByIndex(1);
        String msg=null;
        wait = new WebDriverWait(driver, 20);
        boolean result=wait.until(ExpectedConditions.invisibilityOf(loader));
        System.out.println(result+"loader");
        if(result) {

            msg   = blockedImageTypeMessage.getText();

        }
        return msg;
    }
}