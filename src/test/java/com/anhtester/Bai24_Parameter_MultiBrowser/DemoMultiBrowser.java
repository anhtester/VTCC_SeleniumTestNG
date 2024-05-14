package com.anhtester.Bai24_Parameter_MultiBrowser;

import com.anhtester.Bai22_23_Keywords.pages.CommonPage;
import com.anhtester.Bai22_23_Keywords.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoMultiBrowser extends BaseTest {

    LoginPage loginPage;

    @Test(priority = 1)
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
        loginPage.logout();
        loginPage.verifyRedirectToLoginPage();
    }

    @Test(priority = 2)
    public void testLoginFailWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@email.com", "123456");
        loginPage.verifyLoginFail("Invalid email or password");
    }
}
