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


public class HyScaleLoginPageObject {

    static Logger logger = LogManager.getLogger(hyscaleLoginPageTestCase.class);
    WebDriver driver;
    public HyScaleLoginPageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
       logger.info("login page factory constructor");

    }


    //method 3 this is recommended pagefactor (drawbacks***),selenium grid
    @FindBy(how = How.ID, using = "email")
    @CacheLookup
    WebElement email_textBox;

    @FindBy(how = How.ID, using = "password")
    @CacheLookup
    WebElement password_textBox;

    @FindBy(how = How.ID, using = "loginrow")
    @CacheLookup
    WebElement login_button;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/a/img")
    @CacheLookup
    WebElement logo;


    @FindBy(how = How.XPATH, using = "//*[@id=\"signin\"]/div/div[1]/p")
    @CacheLookup
    WebElement loginAlert ;


    @FindBy(how = How.XPATH, using = "//*[@id=\"signin\"]/div/div[2]/div/label")
    @CacheLookup
    WebElement passwordText;

    public String EmailTextVerification()
    {
        String EmailTextFound=emailText.getText();

        return EmailTextFound;
    }
    @FindBy(how = How.XPATH, using = "//*[@id=\"signin\"]/div/div[1]/div/label")
    @CacheLookup
    WebElement emailText;


    public void loginHyScale(String userName,String password)
    {
        email_textBox.sendKeys(userName);
        password_textBox.sendKeys(password);
        login_button.click();
        logger.info("login test is successful");

    }

    public String passwordTextVerification()
    {

        String passwordTextFound=passwordText.getText();
        System.out.println("driver in packagepage"+driver);
        return passwordTextFound;
    }
    public WebElement LogoDisplayTest()
    {
        return logo;
    }
    public String loginTest()
    {
        String  loginAlertMsg = null;
        try{
        loginAlertMsg=loginAlert.getText();

    } catch (Exception e) {
        e.printStackTrace();

    }
        return loginAlertMsg;
}


}
/*  //method1
    By email_textBox = By.id("userName");
    By password_textBox = By.id("password");
    By login_button = By.id("loginrow");
    By logo = By.xpath("loginrow");
*/
//method 2
//@FindBy(id="userName") WebElement Email_textBox;


   /* By titleText =By.className("barone");



    public login(WebDriver driver){

        this.driver = driver;

    }

    WebDriver driver= null;

    By email_textBox=By.id("email");
    By password_textBox=By.id("password");
    By login_button=By.id("loginrow");
    public HyScaleLoginPageObject(WebDriver driver){
        this.driver=driver;
    }
    public void setTextInEmailBox(String text){
        driver.findElement(email_textBox).sendKeys(userEmail);
    }
    public void setTextInPasswordBox(String text){
        driver.findElement(By.id("email")).sendKeys(userPassword);
    }
    public void clickLoginButton(){
        driver.findElement(login_button).sendKeys(Keys.RETURN);
    }

}
*/