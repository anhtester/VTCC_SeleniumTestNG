package com.anhtester.Bai22_23_Keywords.testcases;

import com.anhtester.Bai22_23_Keywords.pages.CommonPage;
import com.anhtester.Bai22_23_Keywords.pages.LoginPage;
import com.anhtester.common.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    CommonPage commonPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setupPage(){
        commonPage = new CommonPage(driver);
    }

    @Test(priority = 1)
    public void testLoginSuccess(){
//        commonPage.getLoginPage().loginCRM("admin@example.com", "123456");
//        commonPage.getLoginPage().verifyLoginSuccess();
//        commonPage.logout();

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

    @Test(priority = 3)
    public void testLoginFailWithEmailNull(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("", "123456");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }

    @Test(priority = 4)
    public void testLoginFailWithPasswordInvalid(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123");
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test(priority = 5)
    public void testLoginFailWithPasswordNull(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }
}
