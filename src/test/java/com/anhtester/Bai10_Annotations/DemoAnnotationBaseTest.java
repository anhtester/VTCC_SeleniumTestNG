package com.anhtester.Bai10_Annotations;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoAnnotationBaseTest extends BaseTest {

    @BeforeTest
    public void beforeTest() {
        System.out.println("Đây là before test");
    }

    @Test
    public void testAnhTesterBlog() throws InterruptedException {
        driver.get("https://anhtester.com");
        driver.findElement(By.xpath("//a[normalize-space()='blog']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("anhtester", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//h3[normalize-space()='Anh Tester Automation Testing'])[1]")).click();
        Thread.sleep(2000);
    }

}