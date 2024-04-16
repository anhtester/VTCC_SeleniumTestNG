package com.anhtester.Bai19_NavigationPage.testcases;

import com.anhtester.Bai19_NavigationPage.pages.CustomerPage;
import com.anhtester.Bai19_NavigationPage.pages.DashboardPage;
import com.anhtester.Bai19_NavigationPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        //dashboardPage = new DashboardPage(driver);
        customerPage = dashboardPage.openCustomerPage();

        //customerPage = new CustomerPage(driver);
        customerPage.verifyRedirectToCustomerPage();

        customerPage.addNewCustomer("VTCC Viettel 16/04 A1");
        customerPage.verifyAddNewCustomer("VTCC Viettel 16/04 A1");
    }

    @Test
    public void testCheckTotalCustomer() {

    }
}
