package com.anhtester.Bai15_WaitsSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait {
    public WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void ExplicitWaitDemo() throws InterruptedException {

        driver.get("https://app.hrsale.com/");

        //Set Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        driver.findElement(By.id("iusername")).sendKeys("kelly.flynn");
        driver.findElement(By.id("ipassword")).sendKeys("kelly.flynn");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án có dùng Wait
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Projects')]"))));

        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        Thread.sleep(2000);

    }
}
