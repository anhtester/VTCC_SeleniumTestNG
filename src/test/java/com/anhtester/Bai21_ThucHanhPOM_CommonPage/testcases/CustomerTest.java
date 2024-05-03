package com.anhtester.Bai21_ThucHanhPOM_CommonPage.testcases;

import com.anhtester.Bai21_ThucHanhPOM_CommonPage.pages.CommonPage;
import com.anhtester.Bai21_ThucHanhPOM_CommonPage.pages.CustomerPage;
import com.anhtester.Bai21_ThucHanhPOM_CommonPage.pages.DashboardPage;
import com.anhtester.Bai21_ThucHanhPOM_CommonPage.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testAddNewCustomer() {
        String CUSTOMER_NAME = "VTCC Viettel 03/05 A6";

        loginPage = new LoginPage(driver);

        //Fluent design pattern
        loginPage.loginCRM("admin@example.com", "123456")
                .openCustomerPage()
                .verifyRedirectToCustomerPage()
                .addNewCustomer(CUSTOMER_NAME)
                .verifyAddNewCustomer(CUSTOMER_NAME);
    }
}
