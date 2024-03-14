package com.anhtester.Bai11_Assert;

import com.anhtester.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoHardAndSoftAssert extends BaseTest {
    @Test
    public void testLoginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");

        SoftAssert softAssert = new SoftAssert();

        //Check URL
        String urlActual = driver.getCurrentUrl();
        System.out.println(urlActual);
        //Assert.assertEquals(urlActual, "https://crm.anhtester.com/admin", "The Current URL not match.");
        softAssert.assertTrue(urlActual.contains("/admin"));

        //Check Header content
        String headerText= driver.findElement(By.xpath("//h1")).getText();
        System.out.println(headerText);
        Assert.assertEquals(headerText, "Login", "The header content not match.");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        //Check Title of Dashboard page
        System.out.println(driver.getTitle());
        softAssert.assertEquals(driver.getTitle(), "Customer", "Login fail. Can not redirect to Dashboard page.");

        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();

        softAssert.assertAll();
    }
}
