package com.automation.selenium_pom_framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    By productTitle = By.id("productTitle");

    
    By addToCart = By.xpath("//input[@id='add-to-cart-button' or @name='submit.add-to-cart']");

    By quantity = By.id("quantity");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductPageDisplayed() {
        return waitForElementVisible(productTitle).isDisplayed();
    }

    public void selectQuantity(String qty) {
        new Select(waitForElementVisible(quantity)).selectByValue(qty);

        
        driver.findElement(By.id("productTitle")).click();
    }

    public void addToCart() {
        click(addToCart);
    }
}