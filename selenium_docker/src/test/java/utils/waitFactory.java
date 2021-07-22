package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public class waitFactory {


    WebDriverWait wait;
    WebDriver driver;


    // Construct your class here
    public waitFactory(WebDriver driver) {
        this.driver = driver;

    }

    public void implicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, SECONDS);

    }

    public boolean explicitWait(int seconds,WebElement loader) {

        System.out.println("explict");
        wait = new WebDriverWait(driver, seconds);
        boolean result=wait.until(ExpectedConditions.invisibilityOf(loader));

        System.out.println(result);
        return result;

    }
    public void enableExplicitWait(int seconds,WebElement element) {
        wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));


    }

// Waiting 30 seconds for an element to be present on the page, checking
// for its presence once every 5 seconds.
public void fluentWait(int timeout,int pollingFrequency,WebElement webElement,WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofSeconds(pollingFrequency))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                System.out.println("wait");
                return webElement;
            }
        });

    }


    }



