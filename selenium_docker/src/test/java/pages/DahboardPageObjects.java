package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import testCases.hyscaleLoginPageTestCase;

public class DahboardPageObjects {
    static Logger logger = LogManager.getLogger(hyscaleLoginPageTestCase.class);
    WebDriver driver;
    public DahboardPageObjects(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        logger.info("home page factory constructor");

}
    @FindBy(how = How.XPATH, using = "/html/body/div/ng-include[1]/div/wm-user-info/div/span")
    @CacheLookup
    WebElement loginUser;
    public String loginUserTest() throws InterruptedException {


        String loginUserFound=loginUser.getText();

        return loginUserFound;
    }

    }
