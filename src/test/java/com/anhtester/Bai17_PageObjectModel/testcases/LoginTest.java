package com.anhtester.Bai17_PageObjectModel.testcases;

import com.anhtester.Bai17_PageObjectModel.pages.LoginPage;
import com.anhtester.common.BaseTest;
import com.anhtester.keywords.WebUI;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginFail(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@email.com", "123456");
        loginPage.verifyLoginFail();
    }
}
