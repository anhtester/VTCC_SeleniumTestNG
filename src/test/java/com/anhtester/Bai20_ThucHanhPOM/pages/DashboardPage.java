package com.anhtester.Bai20_ThucHanhPOM.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//a[contains(@class,'dropdown-toggle profile')]");
    private By itemLogout = By.xpath("//a[contains(@class,'dropdown-toggle profile')]/following-sibling::ul//a[normalize-space()='Logout']");

    private By labelTotalTasksNotFinished = By.xpath("((//div[@class='top_stats_wrapper'])[4]//span)[2]");

    public void verifyRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        boolean checkMenuDashboard = WebUI.waitForElementVisible(menuDashboard).isDisplayed();
        System.out.println("Check Menu Dashboard: " + checkMenuDashboard);
        Assert.assertTrue(checkMenuDashboard, "The menu Dashboard page not display.");
    }

    public void openPage(String menuName) {
        WebUI.waitForPageLoaded();
        WebUI.waitForElementToBeClickable(By.xpath("//span[normalize-space()='" + menuName + "']")).click();
    }

    //Liên kết đến trang CustomerPage
    public CustomerPage openCustomerPage() {
        WebUI.waitForElementToBeClickable(menuCustomer).click();
        WebUI.waitForPageLoaded();

        return new CustomerPage(driver);
    }

    public void openProjectPage() {
        WebUI.waitForElementToBeClickable(menuProject).click();
        WebUI.waitForPageLoaded();
    }

    public LoginPage logout() {
        WebUI.waitForElementToBeClickable(dropdownProfile).click();
        WebUI.sleep(1);
        WebUI.waitForElementToBeClickable(itemLogout).click();
        WebUI.waitForPageLoaded();

        return new LoginPage(driver);
    }

    public void verifyTotalOfTasksNotFinished(String totalValue) {
        String total = WebUI.waitForElementVisible(labelTotalTasksNotFinished).getText();
        System.out.println("Total Actual: " + total);
        Assert.assertEquals(total, totalValue, "The total of Tasks Not Finished not match.");
    }

    //=========CODE CMS SYSTEM=============
//    By labelTotalCustomer = By.xpath("//div[normalize-space()='Total Customer']/following-sibling::div");
//    By labelTotalOrder = By.xpath("//div[normalize-space()='Total Order']/following-sibling::div");
//    By labelTotalProductCategory = By.xpath("//div[normalize-space()='Total Product brand']/following-sibling::div");
//
//    public void verifyTotalCustomer(String total){
//        WebUI.waitForPageLoaded();
//        Assert.assertEquals(WebUI.getElementText(labelTotalCustomer), total, "The total of Product Category not match.");
//    }
//    public void verifyTotalOrder(String total){
//        WebUI.waitForPageLoaded();
//        Assert.assertEquals(WebUI.getElementText(labelTotalOrder), total, "The total of Product Category not match.");
//    }
//    public void verifyTotalProductCategory(String total){
//        WebUI.waitForPageLoaded();
//        Assert.assertEquals(WebUI.getElementText(labelTotalProductCategory), total, "The total of Product Category not match.");
//    }

}
