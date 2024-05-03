package com.anhtester.common;

import com.anhtester.Bai21_ThucHanhPOM_CommonPage.pages.CommonPage;
import com.anhtester.keywords.WebUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

        //Khởi tạo WebUI class để nhận giá trị driver cho biến toàn cục
        new WebUI(driver);
    }

    @AfterMethod
    public void closeDriver() {
        sleep(1);
        driver.quit();
    }

    public void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
