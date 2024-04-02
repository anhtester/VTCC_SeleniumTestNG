package com.anhtester.Bai16_ThucHanhCRM_Waits;

import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ThucHanhCRM extends BaseTest {

    private String CUSTOMER_NAME = "VTCC 02/04/2024 A3";

    public void loginPerfexCRM() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    @Test
    public void testAddNewCustomer() {
        loginPerfexCRM();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Customers']")));

        WebUI.waitForElementToBeClickable(driver, By.xpath("//span[normalize-space()='Customers']"), 10).click();
        //driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='New Customer']")));

        WebUI.waitForElementToBeClickable(driver, By.xpath("//a[normalize-space()='New Customer']"), 10).click();

        //driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();

        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='company']"), 5).sendKeys(CUSTOMER_NAME);
        //driver.findElement(By.xpath("//input[@id='company']")).sendKeys("VTCC 02/04/2024 A1");

        driver.findElement(By.id("vat")).sendKeys("10");
        driver.findElement(By.id("phonenumber")).sendKeys("0123456789");
        driver.findElement(By.id("website")).sendKeys("https://crm.anhtester.com/admin/clients/client");

        WebUI.waitForElementToBeClickable(driver, By.xpath("//label[@for='groups_in[]']/following-sibling::div"), 10).click();

        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']")).sendKeys("Gold", Keys.ENTER);
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
        WebUI.sleep(1);

        driver.findElement(By.id("address")).sendKeys("Viet Nam");
        driver.findElement(By.id("city")).sendKeys("Can Tho");
        driver.findElement(By.id("state")).sendKeys("Can Tho");
        driver.findElement(By.id("zip")).sendKeys("92000");

        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div")).click();
        WebUI.sleep(1);
        driver.findElement(By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']")).sendKeys("Vietnam", Keys.ENTER);
        WebUI.sleep(1);

        driver.findElement(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();

        //Chờ đợi trang load xong mới kiểm tra các bước tiếp theo
        WebUI.waitForPageLoaded(driver);

        //Kiểm tra Save thành công chuyển hướng đến trang Customer Details
        Assert.assertTrue(WebUI.checkElementExist(driver, By.xpath("//a[normalize-space()='Customer Details']")), "Can not navigate to Customer Details page.");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id='company']")).getAttribute("value"), CUSTOMER_NAME, "The customer name not match.");
    }

    @Test
    public void testEditCustomer() {
        loginPerfexCRM();
    }

    public void verifyCustomerAdded() {
        //Click mở trang Customers lại
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
        WebUI.waitForPageLoaded(driver);
        //Search tên customer vừa add
        driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys(CUSTOMER_NAME);
        WebUI.sleep(1);
        WebUI.waitForPageLoaded(driver);
        WebUI.waitForElementVisible(driver, By.xpath("//tbody/tr[1]/td[3]/a"), 10);
        //Get Text cột customer name
        String getCustomerName = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
        System.out.println(getCustomerName);
        //Verify equals với data input
        Assert.assertEquals(getCustomerName, CUSTOMER_NAME, "FAILED. Customer Name not match.");
    }
}
