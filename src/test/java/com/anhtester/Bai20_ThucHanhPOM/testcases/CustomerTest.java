package com.anhtester.Bai20_ThucHanhPOM.testcases;

import com.anhtester.Bai20_ThucHanhPOM.pages.CustomerPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.DashboardPage;
import com.anhtester.Bai20_ThucHanhPOM.pages.LoginPage;
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

        String CUSTOMER_NAME = "VTCC Viettel 03/05 A2";

        customerPage.addNewCustomer(CUSTOMER_NAME);
        customerPage.verifyAddNewCustomer(CUSTOMER_NAME);
    }

    @Test
    public void testCheckTotalCustomer() {

    }
}
