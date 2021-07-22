package pages.Infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.common;
import utils.waitFactory;

public class containerRegistryPageObjects extends common {

    waitFactory wait = new waitFactory(driver);
    public containerRegistryPageObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/ul/li[2]/a/uib-tab-heading/span")
    WebElement containerRegistryTab;
    public void containerRegistryTabClick(){containerRegistryTab.click();}

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[2]")
    WebElement maximumCharNameMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[3]")
    WebElement minimumCharNameMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[4]")
    WebElement invalidNameMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[1]/div/p[5]")
    WebElement duplicateNameMsg;

    public String registryMaxCharMsg(){
        String result = maximumCharNameMessage.getText();
        return result;
    }
    public String registryMinCharMsg(){
        String result = minimumCharNameMessage.getText();
        return result;
    }
    public String registryInvalidCharMsg(){
        String result = invalidNameMessage.getText();
        return result;
    }
    public String registryDuplicateCharMsg(){
        wait.enableExplicitWait(10,duplicateNameMsg);
        String result = duplicateNameMsg.getText();
        return result;
    }

    @FindBy(how = How.ID, using = "create-docker-registry")
    WebElement add_container_Registry;
    public void addContainerRegistry(){
        add_container_Registry.click();
    }

    @FindBy(how = How.ID, using = "registry-url")
    WebElement registryUrlTextBox;
    public void enterRegistryUrl(String input){
        registryUrlTextBox.sendKeys(input);
    }
    public void registryUrlClear(){
        registryUrlTextBox.clear();
    }




    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[3]/div/p[2]")
    WebElement maximumCharUrlMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[3]/div/p[3]")
    WebElement minimumCharUrlMessage;
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[3]/div/p[4]")
    WebElement invalidUrlMessage;

    public String registryUrlMaxCharMsg(){
        String result = maximumCharUrlMessage.getText();
        return result;
    }
    public String registryUrlMinCharMsg(){
        String result = minimumCharUrlMessage.getText();
        return result;
    }
    public String registryUrlInvalidCharMsg(){
        String result = invalidUrlMessage.getText();
        return result;
    }
    @FindBy(how = How.ID, using = "password")
    WebElement registryPassword;

    public void enterPassword(String input){registryPassword.sendKeys(input);}
    public void passwordClear(){
        registryPassword.clear();
    }

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[1]/div[5]/div[2]/div/p[2]")
    WebElement minimumCharPasswordMessage;

    public String registryPasswordMinCharMsg(){
        String result = minimumCharPasswordMessage.getText();
        return result;
    }
    @FindBy(how = How.ID, using = "username")
    WebElement usernameTextBox;
    public void enterUserName(String input){
        usernameTextBox.sendKeys(input);
    }
    public  void userNameClear(){usernameTextBox.clear();}



}
