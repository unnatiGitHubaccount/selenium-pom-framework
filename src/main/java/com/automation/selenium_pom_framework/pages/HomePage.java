package com.automation.selenium_pom_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By searchBox = By.id("twotabsearchtextbox");
    By searchBtn = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchProduct(String product) {
        sendKeys(searchBox, product);
        click(searchBtn);
    }
}