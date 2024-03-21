package com.anhtester.Bai14_JavascriptExecutor;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {

    @Test
    public void jsExecutorDemo01() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        // Creating the JavascriptExecutor interface object
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Click on "Website Testing" module using JavascriptExecutor
        WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
        js.executeScript("arguments[0].click();", button);
        Thread.sleep(1000);

        // Get page title and Domain using JavascriptExecutor
        String titleText = js.executeScript("return document.title;").toString();
        System.out.println("Page Title is: " + titleText);

        String domainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain is: " + domainName);

        // Add Alert window using JavascriptExecutor
        js.executeScript("alert('Successfully Logged In');");

        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorDemo02() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // sendKeys text on input
        js.executeScript("document.getElementById('email').setAttribute('value','admin@example.com');");
        js.executeScript("document.getElementById('password').setAttribute('value','123456');");

        js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorDemo03() throws InterruptedException {

        driver.get("https://anhtester.com/");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement webElement = driver.findElement(By.xpath("//h2[contains(text(),'Kiến thức Automation Testing')]"));

        //Scroll to element
        //Giá trị true là nằm phía trên
        //Giá trị false là nằm phía dưới
        js.executeScript("arguments[0].scrollIntoView(false);", webElement);

        Thread.sleep(2000);
    }

    @Test
    public void jsExecutorDemo04() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
        js.executeScript("arguments[0].style.border='3px solid red'", inputEmail);
        inputEmail.sendKeys("admin@example.com");
        Thread.sleep(1000);
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
        js.executeScript("arguments[0].style.border='3px solid red'", inputPassword);
        inputPassword.sendKeys("123456");
        Thread.sleep(1000);
        WebElement buttonLogin = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        js.executeScript("arguments[0].style.border='3px solid red'", buttonLogin);
        inputEmail.click();

        Thread.sleep(2000);
    }

    @Test
    public void localStorage() throws InterruptedException {

        String localGetVar = "";

        driver.navigate().to("https://anhtester.com");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Set giá trị
        js.executeScript("window.localStorage.setItem(arguments[0],arguments[1])", "age", "30");

        Thread.sleep(1000);

        //Get giá trị
        localGetVar = (String) js.executeScript("return window.localStorage.getItem(arguments[0])", "age");

        System.out.println(localGetVar);

        Thread.sleep(1000);
    }

    @Test
    public void demoAddCookie() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        Cookie cookie = new Cookie("sp_session", "a6360c1a1d3d40c2987c17a705fd5d06147156b1");
        driver.manage().addCookie(cookie);

        Thread.sleep(1000);
        driver.navigate().refresh();

        Thread.sleep(2000);
    }

}