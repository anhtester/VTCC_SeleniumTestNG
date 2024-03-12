package com.anhtester.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Đây là before suite");
    }

    @BeforeClass
    public void createDriver() {
        System.out.println("Đây là before class của class CHA");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

}
