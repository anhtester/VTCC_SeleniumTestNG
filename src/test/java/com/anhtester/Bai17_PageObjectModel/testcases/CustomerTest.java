package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.CustomerPage;
import com.anhtester.Bai17_PageObjectModel.pages.DashboardPage;
import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.openCustomerPage();

        customerPage = new CustomerPage(driver);
        customerPage.verifyRedirectToCustomerPage();

        customerPage.addNewCustomer("VTCC Viettel 09/04 A4");
        customerPage.verifyAddNewCustomer("VTCC Viettel 09/04 A4");
    }

    @Test
    public void testCheckTotalCustomer() {

    }
}
