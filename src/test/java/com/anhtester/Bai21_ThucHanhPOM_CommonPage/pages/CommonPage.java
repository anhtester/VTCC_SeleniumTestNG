package com.anhtester.Bai21_ThucHanhPOM_CommonPage.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonPage {

    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        new WebUI(driver);
    }

    public By inputSearch = By.xpath("//input[@id='search_input']");
    public By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    public By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    public By menuProject = By.xpath("//span[normalize-space()='Projects']");
    public By dropdownProfile = By.xpath("//a[contains(@class,'dropdown-toggle profile')]");
    public By itemLogout = By.xpath("//a[contains(@class,'dropdown-toggle profile')]/following-sibling::ul//a[normalize-space()='Logout']");

    public CustomerPage openCustomerPage() {
        WebUI.clickElement(menuCustomer);
        WebUI.waitForPageLoaded();

        return new CustomerPage(driver);
    }

    public void openProjectPage() {
        WebUI.clickElement(menuProject);
        WebUI.waitForPageLoaded();
    }

    public LoginPage logout() {
        WebUI.clickElement(dropdownProfile);
        WebUI.sleep(1);
        WebUI.clickElement(itemLogout);
        WebUI.waitForPageLoaded();

        return new LoginPage(driver);
    }

    public void searchCommon(String text){
        WebUI.setText(inputSearch, text);
    }

    //Khởi tạo từng class riêng để gọi dùng cho nhanh
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public DashboardPage getDashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(driver);
        }
        return dashboardPage;
    }

    public CustomerPage getCustomerPage() {
        if (customerPage == null) {
            customerPage = new CustomerPage(driver);
        }
        return customerPage;
    }

}
