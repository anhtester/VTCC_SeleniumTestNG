package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.DashboardPage;
import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testLogout(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.logout();

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
