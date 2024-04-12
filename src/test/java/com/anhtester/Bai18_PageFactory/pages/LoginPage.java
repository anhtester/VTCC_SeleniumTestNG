package com.anhtester.Bai18_PageFactory.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    //Khai báo driver cục bộ để chứa giá trị driver truyền vào
    private WebDriver driver;
    private String URL = "https://crm.anhtester.com/admin/authentication";

    //Khai báo tất cả Element thuộc kiểu đối tượng By
    //private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    //private By inputEmail = By.xpath("//input[@id='email']");
    //private By inputPassword = By.xpath("//input[@id='password']");
    //private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    //private By errorMessage = By.xpath("//div[@id='alerts']");

    //Khai báo element theo kiểu Page Factory với sự hỗ trợ của @FindBy
    //Trả về kiểu WebElement
    @FindBy(xpath = "//h1[normalize-space()='Login']")
    WebElement headerPage;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

//    @FindBy(xpath = "//button[normalize-space()='Login']")
//    WebElement buttonLogin;

    @FindAll({
            @FindBy(xpath = "//button[normalize-space()='Login']"),
            @FindBy(xpath = "button[type='submit']"),
            @FindBy(className = "btn btn-primary btn-block")
    })
    WebElement buttonLogin;

    @CacheLookup
    @FindBy(xpath = "//div[@id='alerts']")
    WebElement errorMessage;

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']/li"))
    List<WebElement> listMenu;

    //Khai báo hàm xây dựng để nhận giá trị driver từ bên ngoài
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
        PageFactory.initElements(driver, this);
    }

    //Khai báo tất cả các hàm chính là mình cần xử lý trong trang này
    public void loginCRM(String email, String password) {
        driver.get(URL);
//        driver.findElement(inputEmail).sendKeys(email);
//        driver.findElement(inputPassword).sendKeys(password);
//        driver.findElement(buttonLogin).click();
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        buttonLogin.click();
    }

    public void verifyLoginSuccess() {
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "FAIL. Vẫn đang ở trang Login");
    }

    public void verifyLoginFail() {
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "FAIL. Không còn ở trang Login");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message NOT displays");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "Content of error massage NOT match.");
    }

    public void verifyRedirectToLoginPage(){
        waitForElementVisible(headerPage);

        boolean checkHeader = headerPage.isDisplayed();
        String textHeader = headerPage.getText();

        Assert.assertTrue(checkHeader, "The header of Login page not display.");
        Assert.assertEquals(textHeader, "Login", "The header content of Login page not match.");
    }

    public WebElement waitForElementVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

}
