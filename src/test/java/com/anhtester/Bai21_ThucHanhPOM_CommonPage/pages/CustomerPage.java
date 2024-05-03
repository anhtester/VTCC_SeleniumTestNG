package com.anhtester.Bai21_ThucHanhPOM_CommonPage.pages;

import com.anhtester.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CustomerPage extends CommonPage{
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
        boolean checkHeader = WebUI.waitForElementVisible(headerPage).isDisplayed();
        System.out.println("Check Header Customer: " + checkHeader);
        Assert.assertTrue(checkHeader, "The header Customer page not display.");
        return this;
    }

    public CustomerPage addNewCustomer(String company) {
        WebUI.waitForElementToBeClickable(buttonNewCustomer).click();
        //WebUI.waitForElementVisible(inputCompany).sendKeys(company);
        WebUI.setText(inputCompany, company);
        WebUI.waitForElementVisible(inputVAT).sendKeys("10");
        WebUI.waitForElementVisible(inputPhone).sendKeys("0123456789");
        WebUI.waitForElementVisible(inputWebsite).sendKeys("https://viettel.com.vn");
        //WebUI.waitForElementToBeClickable(buttonSave).click();
        WebUI.clickElement(buttonSave);
        WebUI.waitForPageLoaded();

        return this;
    }

    public CustomerPage verifyAddNewCustomer(String company){
        new DashboardPage(driver).openCustomerPage();
        WebUI.waitForPageLoaded();
        WebUI.waitForElementVisible(inputSearch).sendKeys(company);
        WebUI.waitForPageLoaded();
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.waitForElementVisible(itemFirstCustomerOnTable).isDisplayed(), "The Customer not display.");
        Assert.assertEquals(WebUI.waitForElementVisible(itemFirstCustomerOnTable).getText(), company, "The Company value not match.");
        WebUI.waitForElementToBeClickable(itemFirstCustomerOnTable).click();
        WebUI.waitForPageLoaded();
        Assert.assertEquals(WebUI.waitForElementVisible(inputCompany).getAttribute("value"), company, "The Company name not match.");
        Assert.assertEquals(WebUI.waitForElementVisible(inputVAT).getAttribute("value"), "10", "The VAT value not match.");

        return this;
    }

    public void verifyTotalCustomer(String totalValue) {
        String total = WebUI.waitForElementVisible(labelTotalCustomer).getText();
        System.out.println("Total Actual: " + total);
        Assert.assertEquals(total, totalValue, "The total of Customer not match.");
    }
}
