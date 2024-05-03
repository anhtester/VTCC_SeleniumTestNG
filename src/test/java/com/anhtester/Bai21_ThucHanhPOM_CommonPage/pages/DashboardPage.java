package com.anhtester.Bai21_ThucHanhPOM_CommonPage.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends CommonPage{
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

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

    public void verifyTotalOfTasksNotFinished(String totalValue) {
        String total = WebUI.waitForElementVisible(labelTotalTasksNotFinished).getText();
        System.out.println("Total Actual: " + total);
        Assert.assertEquals(total, totalValue, "The total of Tasks Not Finished not match.");
    }
}
