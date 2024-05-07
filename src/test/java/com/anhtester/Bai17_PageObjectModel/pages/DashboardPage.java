package com.anhtester.Bai17_PageObjectModel.pages;

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
        boolean checkMenuDashboard = WebUI.isDisplayed(menuDashboard);
        System.out.println("Check Menu Dashboard: " + checkMenuDashboard);
        Assert.assertTrue(checkMenuDashboard, "The menu Dashboard page not display.");
    }

    public void openCustomerPage() {
        WebUI.clickElement(menuCustomer);
        WebUI.waitForPageLoaded();
    }

    public void openProjectPage() {
        WebUI.clickElement(menuProject);
        WebUI.waitForPageLoaded();
    }

    public void logout() {
        WebUI.clickElement(dropdownProfile);
        WebUI.sleep(1);
        WebUI.clickElement(itemLogout);
        WebUI.waitForPageLoaded();
    }

    public void verifyTotalOfTasksNotFinished(String totalValue) {
        String total = WebUI.getElementText(labelTotalTasksNotFinished);
        System.out.println("Total Actual: " + total);
        Assert.assertEquals(total, totalValue, "The total of Tasks Not Finished not match.");
    }

}
