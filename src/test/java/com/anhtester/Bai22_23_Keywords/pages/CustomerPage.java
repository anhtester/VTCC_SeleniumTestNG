package com.anhtester.Bai22_23_Keywords.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage extends CommonPage {
    private WebDriver driver;

    public CustomerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    private By headerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By buttonNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By inputSearch = By.xpath("//input[@class='form-control input-sm']");
    private By buttonImportCustomer = By.xpath("//a[normalize-space()='Import Customers']");
    private By labelTotalCustomer = By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span");

    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVAT = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    private By itemFirstCustomerOnTable = By.xpath("//tbody/tr[1]/td[3]/a");

    public CustomerPage verifyRedirectToCustomerPage() {
        WebUI.waitForPageLoaded();
        boolean checkHeader = WebUI.isDisplayed(headerPage);
        System.out.println("Check Header Customer: " + checkHeader);
        Assert.assertTrue(checkHeader, "The header Customer page not display.");
        return this;
    }

    public CustomerPage addNewCustomer(String company) {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(buttonNewCustomer);
        WebUI.setText(inputCompany, company);
        WebUI.setText(inputVAT, "10");
        WebUI.setText(inputPhone, "0123456789");
        WebUI.setText(inputWebsite, "https://viettel.com.vn");
        WebUI.clickElement(buttonSave);
        return this;
    }

    public CustomerPage verifyAddNewCustomer(String company) {
        new DashboardPage(driver).openCustomerPage();
        WebUI.waitForPageLoaded();
        WebUI.setText(inputSearch, company);
        WebUI.waitForPageLoaded();
        WebUI.waitForJQueryLoad();
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.isDisplayed(itemFirstCustomerOnTable), "The Customer not display.");
        Assert.assertEquals(WebUI.getElementText(itemFirstCustomerOnTable), company, "The Company value not match.");
        WebUI.clickElement(itemFirstCustomerOnTable);
        WebUI.waitForPageLoaded();
        Assert.assertEquals(WebUI.getElementAttribute(inputCompany, "value"), company, "The Company name not match.");
        Assert.assertEquals(WebUI.getElementAttribute(inputVAT, "value"), "10", "The VAT value not match.");

        return this;
    }

    public void verifyTotalCustomer(String totalValue) {
        String total = WebUI.getElementText(labelTotalCustomer);
        System.out.println("Total Actual: " + total);
        Assert.assertEquals(total, totalValue, "The total of Customer not match.");
    }
}
