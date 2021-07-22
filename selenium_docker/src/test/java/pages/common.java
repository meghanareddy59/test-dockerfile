package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class common {
    static Logger logger = LogManager.getLogger(packagesPageObjects.class);

    protected WebDriver driver;
    public common(WebDriver driver){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    baseImagePageObjects base_obj;

    //  version text box
    @FindBy(how = How.ID, using = "version")
    WebElement versionTextBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/ng-include[1]/div/ng-include/div/a[3]")
    WebElement packagestab;


    //  description text box
    @FindBy(how = How.ID, using = "description")
    WebElement descriptionTextBox;

    @FindBy(how = How.XPATH, using = "//wm-loader/div/div/span")
   public WebElement loader;

    @FindBy(how = How.ID, using = "name-version")
    WebElement nameVersion;
    public void enter_name_and_version(String imageName){
        nameVersion.sendKeys(imageName);
    }

    //package close button
    @FindBy(how = How.CLASS_NAME, using = "close")
    WebElement closeButton;

    // package next Button
    @FindBy(how = How.ID, using = "next-btn")
    WebElement nextButton;



    @FindBy(how = How.ID, using = "prev-btn")
    WebElement previousButton;

public void nameClear(){
    nameTextBox.clear();
}
    public void name_version_clear(){
        nameTextBox.clear();
        versionTextBox.clear();

        nameVersion.clear();

    }
    public void description_clear(){    descriptionTextBox.clear();}

    public void closeButton() {
        closeButton.click();
    }
public  void nextPageClick(){
    nextButton.click();
}

    @FindBy(how = How.ID, using = "name")
    WebElement nameTextBox;

    @FindBy(how = How.ID, using = "confirm-btn")
    WebElement confirmButton;


    public void enterName(String nameDetails)  {
        logger.info("package name entered");
        nameTextBox.sendKeys(nameDetails);
    }

    public void enterVersionDetails(String versionDetails)  {
        logger.info("package version entered");
        versionTextBox.sendKeys(versionDetails);
    }
    public void enterDescriptionDetails(String descriptionDetails)  {

        logger.info("package description entered");
        descriptionTextBox.sendKeys(descriptionDetails);
    }

    @FindBy(how = How.NAME, using = "imageRegistryId")
    WebElement selectRegistry;

    public void selectRegistry(String registry){
        Select selectAgentRegistry= new Select(selectRegistry);
        selectAgentRegistry.selectByVisibleText(registry);
        selectRegistry.click();

    }

    @FindBy(how = How.XPATH, using = "//*[@id=\"registry-type\"]")
    WebElement selectRegistryType;

    public void selectRegistryType(String registry){
        Select selectAgentRegistry= new Select(selectRegistryType);
        selectAgentRegistry.selectByVisibleText(registry);
        selectRegistryType.click();

    }
    public  boolean VerifyTestAndSaveButtonVisibilityVerify(){ boolean result = confirmButton.isDisplayed();
        System.out.println("confirm button"+result);
        return result;}

    public  boolean VerifyTestAndSaveButtonEnableVerify(){ boolean result = confirmButton.isEnabled();
        return result;}


    @FindBy(how = How.ID, using = "Edit-action")
    WebElement editButton;

    public boolean editButtonVisibility() {
        boolean result = editButton.isDisplayed();
        return result;
    }
    public boolean editButtonEnableTest() {
        boolean result = editButton.isEnabled();
        return result;
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/input")
    WebElement editNameTextBox;
    public boolean editButtonClickVerify(){
        editButton.click();
        boolean result = editNameTextBox.isEnabled();
        return result;
    }




    @FindBy(how = How.ID, using = "Delete-action")

    WebElement deleteIcon;

    @FindBy(how = How.ID, using = "delete-btn")

    WebElement deleteButton;


    public boolean deleteIconVisibility() {
        boolean result = deleteIcon.isDisplayed();
        return result;
    }
    public boolean deleteIconEnableTest() {
        boolean result = deleteIcon.isEnabled();
        return result;
    }
    public boolean  deleteButtonClickVerify(){
        deleteIcon.click();
        boolean result = closeButton.isEnabled();
        closeButton.click();
        return result;

    }

    @FindBy(how = How.CLASS_NAME, using = "refreshBtn")
    WebElement refreshButton;

    public boolean refreshButtonVisibility() {
        boolean result = refreshButton.isDisplayed();

        return result;
    }
    public boolean refreshButtonEnableTest() {
        boolean result = refreshButton.isEnabled();
        return result;
    }

}
