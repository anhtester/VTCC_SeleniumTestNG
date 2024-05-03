package com.anhtester.Bai20_ThucHanhPOM.testcases;

import com.anhtester.Bai20_ThucHanhPOM.pages.DashboardPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.LoginPage;
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

        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        //dashboardPage = new DashboardPage(driver);
        loginPage = dashboardPage.logout();

        //Verify trở về được trang Login
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
