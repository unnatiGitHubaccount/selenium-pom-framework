package com.automation.selenium_pom_framework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.automation.selenium_pom_framework.utils.DriverFactory;
import com.automation.selenium_pom_framework.utils.ExtentManager;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.silentOutput", "true");

        driver = DriverFactory.initDriver();
        driver.get("https://www.amazon.in/");

        
        ExtentManager.getInstance();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        ExtentManager.flush();
    }
}