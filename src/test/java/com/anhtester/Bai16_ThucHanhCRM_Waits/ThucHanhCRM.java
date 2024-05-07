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

    private String CUSTOMER_NAME = "VTCC 02/04/2024 A11";

//    public void loginPerfexCRM() {
//        driver.get("https://crm.anhtester.com/admin/authentication");
//        WebUI.waitForElementVisible(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
//        WebUI.waitForElementVisible(By.xpath("//input[@id='password']")).sendKeys("123456");
//        WebUI.waitForElementVisible(By.xpath("//button[normalize-space()='Login']")).click();
//    }

//    @Test
//    public void testAddNewCustomer() {
//        loginPerfexCRM();
//        WebUI.waitForElementToBeClickable(By.xpath("//span[normalize-space()='Customers']"), 5).click();
//        WebUI.waitForElementToBeClickable(By.xpath("//a[normalize-space()='New Customer']")).click();
//        WebUI.waitForElementVisible(driver, By.xpath("//input[@id='company']"), 5).sendKeys(CUSTOMER_NAME);
//        WebUI.waitForElementVisible(By.id("vat")).sendKeys("10");
//        WebUI.waitForElementVisible(By.id("phonenumber")).sendKeys("0123456789");
//        WebUI.waitForElementVisible(By.id("website")).sendKeys("https://crm.anhtester.com/admin/clients/client");
//
//        WebUI.waitForElementToBeClickable(By.xpath("//label[@for='groups_in[]']/following-sibling::div"), 5).click();
//        WebUI.sleep(1);
//        WebUI.waitForElementPresent(By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']")).sendKeys("Gold", Keys.ENTER);
//        WebUI.sleep(1);
//        WebUI.waitForElementToBeClickable(By.xpath("//label[@for='groups_in[]']/following-sibling::div")).click();
//        WebUI.sleep(1);
//
//        WebUI.waitForElementToBeClickable(By.xpath("//label[normalize-space()='Default Language']/following-sibling::div")).click();
//        WebUI.sleep(1);
//        WebUI.waitForElementToBeClickable(By.xpath("//span[normalize-space()='Vietnamese']")).click();
//
//
//        WebUI.waitForElementVisible(By.id("address")).sendKeys("Viet Nam");
//        WebUI.waitForElementVisible(By.id("city")).sendKeys("Can Tho");
//        WebUI.waitForElementVisible(By.id("state")).sendKeys("Can Tho");
//        WebUI.waitForElementVisible(By.id("zip")).sendKeys("92000");
//
//        WebUI.waitForElementToBeClickable(By.xpath("//label[@for='country']/following-sibling::div")).click();
//        WebUI.sleep(1);
//        WebUI.waitForElementVisible(By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']")).sendKeys("Vietnam", Keys.ENTER);
//        WebUI.sleep(1);
//
//        //Click Save button
//        WebUI.waitForElementToBeClickable(By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']")).click();
//
//        //Chờ đợi trang load xong mới kiểm tra các bước tiếp theo
//        WebUI.waitForPageLoaded();
//
//        //Kiểm tra Save thành công chuyển hướng đến trang Customer Details
//        Assert.assertTrue(WebUI.checkElementExist(driver, By.xpath("//a[normalize-space()='Customer Details']")), "Can not navigate to Customer Details page.");
//        Assert.assertEquals(WebUI.getElementAttribute(By.xpath("//input[@id='company']"), "value"), CUSTOMER_NAME, "The CUSTOMER NAME not match.");
//        Assert.assertEquals(WebUI.getElementAttribute(By.xpath("//input[@id='vat']"), "value"), "10", "The VAT not match.");
//        Assert.assertEquals(WebUI.getElementAttribute(By.xpath("//input[@id='phonenumber']"), "value"), "0123456789", "The PHONE not match.");
//        Assert.assertEquals(WebUI.getElementAttribute(By.xpath("//input[@id='website']"), "value"), "https://crm.anhtester.com/admin/clients/client", "The WEBSITE not match.");
//
//        //Kiểm tra Customer hiển thị khi tìm kiếm trong table
//        verifyCustomerDisplayInTable();
//
//        //Kiểm tra Customer hiển thị trong Customer Dropdown của trang Project
//        verifyCustomerDisplayInProjectPage();
//    }
//
//    @Test
//    public void testEditCustomer() {
//        loginPerfexCRM();
//    }
//
//    public void verifyCustomerDisplayInTable() {
//        //Click mở trang Customers lại
//        WebUI.waitForElementToBeClickable(By.xpath("//span[normalize-space()='Customers']")).click();
//        WebUI.waitForPageLoaded(driver);
//        //Search tên customer vừa add
//        WebUI.waitForElementVisible(By.xpath("//input[@class='form-control input-sm']")).sendKeys(CUSTOMER_NAME);
//        WebUI.waitForPageLoaded(driver);
//        WebUI.sleep(1);
//        WebUI.waitForElementVisible(driver, By.xpath("//tbody/tr[1]/td[3]/a"), 10);
//        //Get Text cột customer name
//        String getCustomerName = WebUI.waitForElementVisible(By.xpath("//tbody/tr[1]/td[3]/a")).getText();
//        System.out.println(getCustomerName);
//        //Verify equals với data input
//        Assert.assertEquals(getCustomerName, CUSTOMER_NAME, "FAILED. Customer Name not match.");
//    }
//
//    public void verifyCustomerDisplayInProjectPage() {
//        WebUI.waitForElementToBeClickable(By.xpath("//span[normalize-space()='Projects']"), 5).click();
//        WebUI.waitForPageLoaded(driver);
//        WebUI.waitForElementToBeClickable(By.xpath("//a[normalize-space()='New Project']"), 5).click();
//        WebUI.waitForElementVisible(By.xpath("//label[@for='clientid']/following-sibling::div"), 5).click();
//        WebUI.sleep(1);
//        WebUI.waitForElementVisible(By.xpath("//label[@for='clientid']/following-sibling::div//input"), 5).sendKeys(CUSTOMER_NAME);
//
//        WebUI.sleep(2);
//
//        Assert.assertTrue(WebUI.checkElementExist(driver, By.xpath("//span[@class='text']")), "The Customer not display in Customer Dropdown (Project page)");
//        Assert.assertEquals(WebUI.getElementText(By.xpath("//span[@class='text']")), CUSTOMER_NAME, "The Customer Name not match in Customer Dropdown (Project page)");
//    }
}
