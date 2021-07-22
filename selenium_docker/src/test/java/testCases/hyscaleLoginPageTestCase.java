package testCases;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.HyScaleLoginPageObject;
import utils.browserFactory;
import java.net.MalformedURLException;



public class hyscaleLoginPageTestCase {
    static Logger logger = LogManager.getLogger(hyscaleLoginPageTestCase.class);
    public static WebDriver driver;

    HyScaleLoginPageObject login_page;
    utils.browserFactory browserFactory;

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
        logger.info("ended");
    }
   @Parameters({"browser", "platform", "node_url", "seleniumType"})
    @BeforeClass
    public WebDriver driverSetUp(String browser, String platform, String node_url, String seleniumType) throws MalformedURLException {
        browserFactory = new browserFactory();
        if (seleniumType.equalsIgnoreCase("normal")) {
            driver = browserFactory.driverSetUp(browser);
        } else if (seleniumType.equalsIgnoreCase("grid")) {
            logger.info("grid");
            driver = browserFactory.gridDriverSetUp(browser, platform, node_url);
        }


        return driver;
    }

    public WebDriver getDriver() {
        logger.info("get driver");
        return driver;

    }
    @Parameters({"domain", "username", "Password"})
@Test(priority = 1)
    public void TitleAndLogoTest(String domain,String username,String Password) {

        driver.get(domain);
        System.out.println(domain+"domain");
        //Title test
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "HyScale");
        logger.info("titletest");


        //logo test

        login_page = new HyScaleLoginPageObject(driver);
        WebElement logo = login_page.LogoDisplayTest();
        Assert.assertTrue(logo.isDisplayed());
        logger.info("Logo test");

    }
    @Parameters({"domain", "username", "Password"})
    @Test(priority=2)
    public void LoginTest(String domain,String username,String Password) {

        //extract email and password text and assert
        Assert.assertEquals("Email", login_page.EmailTextVerification());
        Assert.assertEquals("Password", login_page.passwordTextVerification());


        //enter username and password
        login_page.loginHyScale(username, Password);

        logger.info("Email  and passowrd entered");

    }

    //verifying logintest is successful or not
    @AfterClass
    public void LoginTestVerification() {
        String alertText=login_page.loginTest();

        Assert.assertNotEquals(alertText, "Incorrect Email / Password combination. Please try again","login test verification is failed");
    }


}
  /*@Test(priority = 3, dependsOnMethods = {"LoginTest"})
    public void LoginTestVerification() {

        try {

            Dashboard_page = new DahboardPageObjects(driver);
            String loginUserFound = Dashboard_page.loginUserTest();
            System.out.println("loginUserFound is  " + loginUserFound);
            Assert.assertEquals(loginUserFound, "jmeter qa");
            logger.info("verified the login user");

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
*/



