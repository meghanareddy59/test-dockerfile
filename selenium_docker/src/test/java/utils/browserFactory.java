package utils;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import testCases.hyscaleLoginPageTestCase;

import java.net.MalformedURLException;
import java.net.URL;

public class browserFactory {


    static Logger logger = LogManager.getLogger(hyscaleLoginPageTestCase.class);
    public  WebDriver driver;


         public  WebDriver driverSetUp(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();

            driver = new ChromeDriver();

            logger.info(browser + "browser started");
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.out.println("browser"+browser);
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();
            System.out.println(driver+"driver is++++++++++++++");
            logger.info(browser + "browser started");
        }
            driver.manage().window().maximize();

        return driver;
    }


    public  WebDriver gridDriverSetUp(String browser,String platform,String node_url) throws MalformedURLException {

        if(browser.equalsIgnoreCase("chrome")&&platform.equalsIgnoreCase("linux")){
            //System.setProperty("webdriver.chrome.driver", "/Users/username/chromedriver");
            DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.LINUX);
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new RemoteWebDriver(new URL(node_url),cap);
        logger.info("test");


           /* DesiredCapabilities dc = DesiredCapabilities.firefox(); //or dc = DesiredCapabilities.chrome();
            RemoteWebDriver driver=new RemoteWebDriver(new URL("http://172.18.0.2:4445/wd/hub"), dc);

            driver.get("https://www.google.com");*/
        }

        else if(browser.equalsIgnoreCase("firefox")&&platform.equalsIgnoreCase("linux")){

            DesiredCapabilities cap=DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.LINUX);
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new RemoteWebDriver(new URL(node_url),cap);
            logger.info("test IN FIREFOX");

        }
        else if(browser.equalsIgnoreCase("ie")&&platform.equalsIgnoreCase("windows")){

            String nodeUrl = node_url;
            DesiredCapabilities internetExplorerBrowser = DesiredCapabilities.internetExplorer();
            internetExplorerBrowser.setBrowserName("ie");
            internetExplorerBrowser.setPlatform(Platform.WIN10);
            WebDriverManager.getInstance(DriverManagerType.IEXPLORER).setup();
            driver = new RemoteWebDriver(new URL(nodeUrl), internetExplorerBrowser);

        }
        if(browser.equalsIgnoreCase("chrome")&&platform.equalsIgnoreCase("windows")){
            String nodeUrl = node_url;
            DesiredCapabilities chromeBrowser = DesiredCapabilities.chrome();
            chromeBrowser.setBrowserName("chrome");
            chromeBrowser.setPlatform(Platform.WIN10);
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new RemoteWebDriver(new URL(nodeUrl), chromeBrowser);

        }

        else if(browser.equalsIgnoreCase("firefox")&&platform.equalsIgnoreCase("windows")){
            logger.info("test IN  WINDOWS FIREFOX");
            DesiredCapabilities cap=DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");
            cap.setPlatform(Platform.WIN10);
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new RemoteWebDriver(new URL(node_url),cap);
            logger.info("test IN FIREFOX");

        }
        else if(browser.equalsIgnoreCase("safari")&&platform.equalsIgnoreCase("mac")){

            String nodeUrl = node_url;
            DesiredCapabilities safariBrowser = DesiredCapabilities.safari();
            safariBrowser.setBrowserName("safari");
            safariBrowser.setPlatform(Platform.MAC);
            //WebDriverManager.getInstance(DriverManagerType.).setup();
            driver = new RemoteWebDriver(new URL(nodeUrl), safariBrowser);

        }
        else if(browser.equalsIgnoreCase("firefox")&&platform.equalsIgnoreCase("mac")){
            String nodeUrl = node_url;
            DesiredCapabilities firefoxBrowser = DesiredCapabilities.firefox();
            firefoxBrowser.setBrowserName("firefox");
            firefoxBrowser.setPlatform(Platform.MAC);
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new RemoteWebDriver(new URL(nodeUrl), firefoxBrowser);
        }
        else if(browser.equalsIgnoreCase("chrome")&&platform.equalsIgnoreCase("mac")){

            String nodeUrl = node_url;
            DesiredCapabilities chromeBrowser = DesiredCapabilities.chrome();
            chromeBrowser.setBrowserName("chrome");
            chromeBrowser.setPlatform(Platform.MAC);
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new RemoteWebDriver(new URL(nodeUrl), chromeBrowser);
        }





        driver.manage().window().maximize();
        return driver;
         }


}


 /* String nodeUrl=nodeUrl;
          DesiredCapabilities firefoxBrowser = DesiredCapabilities.firefox();

        DesiredCapabilities internetExplorerBrowser = DesiredCapabilities.internetExplorer();

        firefoxBrowser.setBrowserName("chrome");
        firefoxBrowser.setPlatform(Platform.LINUX);

        */


