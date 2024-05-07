package com.anhtester.Bai20_ThucHanhPOM.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    //Khai báo driver cục bộ để chứa giá trị driver truyền vào
    private WebDriver driver;
    private String URL = "https://crm.anhtester.com/admin/authentication";

    //Khai báo hàm xây dựng để nhận giá trị driver từ bên ngoài
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    //Khai báo tất cả Element thuộc về trang này, ở dạng đối tượng By
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert alert-danger')]");

    //Chỉnh sửa hàm loginCRM để tạo liên kết trang đến trang DashboardPage
    public DashboardPage loginCRM(String email, String password) {
        WebUI.openURL(URL);
        WebUI.waitForPageLoaded();
        WebUI.setText(inputEmail, email);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonLogin);

        return new DashboardPage(driver);
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail(String errorMassageContent) {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), errorMassageContent, "Content of error massage NOT match.");
    }

//    public void verifyLoginFailValueNull() {
//        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
//        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message NOT displays");
//        Assert.assertEquals(driver.findElement(errorMessage).getText(), "The Email Address field is required.", "Content of error massage NOT match.");
//    }

    public void verifyRedirectToLoginPage() {
        boolean checkHeader = WebUI.isDisplayed(headerPage);
        String textHeader = WebUI.getElementText(headerPage);

        Assert.assertTrue(checkHeader, "The header of Login page not display.");
        Assert.assertEquals(textHeader, "Login", "The header content of Login page not match.");
    }

}
