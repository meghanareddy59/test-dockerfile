package pages.Infrastructure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.common;
import utils.waitFactory;

public class certificatePageObjects extends common {

    waitFactory wait = new waitFactory(driver);
    public certificatePageObjects(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/ul/li[4]/a/uib-tab-heading/span")
    WebElement certificatesTabButton;
    public void GoToCertificatesTab(){certificatesTabButton.click();}

    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[4]/div/div/div/div/div[1]/div/div/div[1]/button/span")
    WebElement AddCertificatesButton;
    public void addCertificatesButtonClick(){AddCertificatesButton.click();}

    public boolean addCertificateButtonEnableTest() {
        boolean result = AddCertificatesButton.isEnabled();
        return result;
    }
    public boolean addCertificateButtonDisplayTest() {
        boolean result = AddCertificatesButton.isDisplayed();
        return result;
    }

    @FindBy(how = How.NAME, using = "domain")
    WebElement domainTextBox;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div/div/div[2]/div[2]/div/form/div[2]/button[1]")
    WebElement addButton;
    public boolean addButtonEnableTest() {
        boolean result = addButton.isEnabled();
        return result;
    }
    public boolean addButtonDisplayTest() {
        boolean result = addButton.isDisplayed();
        return result;
    }


    @FindBy(how = How.XPATH, using = "/html/body/div/article/div/section/div/div[2]/div/div/div/div/div[3]/div/div/div/div/div/div/div[4]/div/div/div/div/div[1]/div/div/div[2]/div[1]/input")
    WebElement searchTextBox;
    public boolean searchTextBoxEnableTest() {
        boolean result = searchTextBox.isEnabled();
        return result;
    }
    public boolean searchTextBoxDisplayTest() {
        boolean result = searchTextBox.isDisplayed();
        return result;
    }

    public void searchCertificate(String input){
        searchTextBox.sendKeys(input);
    }
    public String  getTextFromSearchTextBox() {
        String result = searchTextBox.getText();
        return result;
    }

    public void enterDomain(String input){domainTextBox.sendKeys(input);}

    @FindBy(how = How.XPATH, using = "//*[@id=\"uploadButton\"]/span")
    WebElement uploadButton;






    public boolean certificateUploadEnableTest() {
        boolean result = uploadButton.isEnabled();
        return result;
    }
    public boolean certificateUploadDisplayTest() {
        boolean result = uploadButton.isDisplayed();
        return result;
    }



}
