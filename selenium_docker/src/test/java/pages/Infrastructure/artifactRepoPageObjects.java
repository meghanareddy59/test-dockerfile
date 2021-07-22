package pages.Infrastructure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.common;
import utils.waitFactory;

public class artifactRepoPageObjects extends common {

    waitFactory wait = new waitFactory(driver);

    public artifactRepoPageObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/ul/li[3]/a/uib-tab-heading/span")
    WebElement artifactRepoTab;

    @FindBy(how = How.ID, using = "add-secondary-lb-btn")
    WebElement addArtifactRepoButton;
    public boolean addArtifactRepoButtonEnableTest() {
        boolean result = addArtifactRepoButton.isEnabled();
        return result;
    }
    public boolean addArtifactRepoButtonDisplayTest() {
        boolean result = addArtifactRepoButton.isDisplayed();
        return result;
    }
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div/div[1]/div/div/div[2]/div[1]/input")
    WebElement artifactSearchBox;
    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[3]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div/div/div[1]/div[2]/div/span")
    WebElement firstArtifact;

    public void searchArtifactRepo(String input){
        artifactSearchBox.sendKeys(input);
    }
    WebElement repo_loader=driver.findElement(By.xpath("//wm-loader/div/div/span"));

    public String getFirstArtifact(){
        String result=null;
        boolean invisible=wait.explicitWait(20,repo_loader);
        if(invisible) {
            result = firstArtifact.getText();
            System.out.println(result);}
        return result;
    }

    @FindBy(how = How.ID, using = "host")
    WebElement artifactHostTextBox;

    @FindBy(how = How.ID, using = "port")

    WebElement artifactPortTextBox;

    @FindBy(how = How.ID, using = "username")
    WebElement artifactUserNameTextBox;

    @FindBy(how = How.ID, using = "password")

    WebElement artifactPasswordTextBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/p[2]")
    WebElement maximumCharNameMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/p[3]")
    WebElement minimumCharNameMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/p[4]")
    WebElement invalidNameMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div[1]/p[2]")
    WebElement InvalidTextHostMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[2]/div[2]/p[2]")
    WebElement InvalidTextPortMessage;


    public void enterArtifactHost(String input) {
        artifactHostTextBox.sendKeys(input);
    }

    public void enterArtifactPort(String input) {
        artifactPortTextBox.sendKeys(input);
    }

    public void enterUserName(String input) {
        artifactUserNameTextBox.sendKeys(input);
    }

    public void enterPassword(String input) {
        artifactPasswordTextBox.sendKeys(input);
    }

    public String artifactRepoNameMaxCharMsg() {
        String result = maximumCharNameMessage.getText();
        return result;
    }

    public String artifactRepoNameMinCharMsg() {
        String result = minimumCharNameMessage.getText();
        return result;
    }

    public String artifactRepoNameInvalidCharMsg() {
        String result = invalidNameMessage.getText();
        return result;
    }

    public String artifactRepoHostInvalidCharMsg() {
        String result = InvalidTextHostMessage.getText();
        return result;
    }

    public String artifactRepoPortInvalidCharMsg() {
        String result = InvalidTextPortMessage.getText();
        return result;
    }

    public void addArtifactRepo() {
        addArtifactRepoButton.click();
    }

    public void GoToArtifactRepoTab() {
        artifactRepoTab.click();
    }


    @FindBy(how = How.ID, using = "add-btn")
    WebElement addAndSaveButton;

    public boolean addAndSaveButtonButtonEnableTest() {
        boolean result = addAndSaveButton.isEnabled();
        return result;
    }

    public boolean addAndSaveButtonButtonDisplayTest() {
        boolean result = addAndSaveButton.isDisplayed();
        return result;
    }
}