package com.anhtester.Bai22_23_Keywords.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends CommonPage {
    private WebDriver driver;

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    private By labelTotalTasksNotFinished = By.xpath("((//div[@class='top_stats_wrapper'])[4]//span)[2]");

    public void verifyRedirectToDashboardPage() {
        WebUI.waitForPageLoaded();
        boolean checkMenuDashboard = WebUI.isDisplayed(menuDashboard);
        WebUI.logConsole("Check Menu Dashboard: " + checkMenuDashboard);
        Assert.assertTrue(checkMenuDashboard, "The menu Dashboard page not display.");
    }

    public void openPage(String menuName) {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(By.xpath("//span[normalize-space()='" + menuName + "']"));
    }

    public void verifyTotalOfTasksNotFinished(String totalValue) {
        String total = WebUI.getElementText(labelTotalTasksNotFinished);
        WebUI.logConsole("Total Actual: " + total);
        Assert.assertEquals(total, totalValue, "The total of Tasks Not Finished not match.");
    }
}
