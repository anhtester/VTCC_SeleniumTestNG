package com.anhtester.Bai22_23_Keywords.testcases;

import com.anhtester.Bai22_23_Keywords.pages.DashboardPage;
import com.anhtester.Bai22_23_Keywords.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testOpenPage(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage.openPage("Customers");
        sleep(2);
        dashboardPage.openPage("Projects");
        sleep(2);
        dashboardPage.openPage("Tasks");
        sleep(2);
    }

    @Test
    public void testLogout(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage();
    }

    @Test
    public void testTotalOfTasksNotFinished(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.verifyRedirectToDashboardPage();
        dashboardPage.verifyTotalOfTasksNotFinished("1 / 1");
    }
}
