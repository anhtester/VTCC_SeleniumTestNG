package com.anhtester.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {

    private static WebDriver driver;
    private static int second = 10;
    private static int PAGE_LOAD_TIMEOUT = 30;

    //Nhận driver từ BaseTest truyền vào
    public WebUI(WebDriver _driver){
        driver = _driver;
    }

    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static WebElement waitForElementToBeClickable(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(by)); //Chờ đợi
        return driver.findElement(by); //Tìm kiếm Element
    }
    public static WebElement waitForElementToBeClickable(By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(by)); //Chờ đợi
        return driver.findElement(by); //Tìm kiếm Element
    }
    public static WebElement waitForElementToBeClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.elementToBeClickable(by)); //Chờ đợi
        return driver.findElement(by); //Tìm kiếm Element
    }

    public static WebElement waitForElementVisible(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }
    public static WebElement waitForElementVisible(By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }
    public static WebElement waitForElementVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    public static WebElement waitForElementPresent(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }
    public static WebElement waitForElementPresent(By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }
    public static WebElement waitForElementPresent(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElement(by);
    }

    public static void waitForElementInVisible(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public static void waitForElementInVisible(By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public static void waitForElementInVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static String getElementText(By by){
        return driver.findElement(by).getText();
    }

    public static String getElementAttribue(By by, String attributeName){
        return driver.findElement(by).getAttribute(attributeName);
    }

    public static String getElementCssValue(By by, String propertyName){
        return driver.findElement(by).getCssValue(propertyName);
    }

    public static Boolean checkElementExist(WebDriver driver, By by) {
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }

    public static Boolean checkElementExist(By by) {
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }

    public static Boolean checkElementExist(WebDriver driver, String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if (listElement.size() > 0) {
            System.out.println("Element " + xpath + " existing.");
            return true;
        } else {
            System.out.println("Element " + xpath + " NOT exist.");
            return false;
        }
    }
    public static Boolean checkElementExist(String xpath) {
        List<WebElement> listElement = driver.findElements(By.xpath(xpath));

        if (listElement.size() > 0) {
            System.out.println("Element " + xpath + " existing.");
            return true;
        } else {
            System.out.println("Element " + xpath + " NOT exist.");
            return false;
        }
    }

    /**
     * Wait for Page loaded
     * Chờ đợi trang tải xong (Javascript tải xong)
     */
    public static void waitForPageLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

}
