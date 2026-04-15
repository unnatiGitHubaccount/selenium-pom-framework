package com.automation.selenium_pom_framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By goToCart = By.xpath("//a[contains(text(),'Go to Cart')]");
    By cartPage = By.id("sc-active-cart");
    By productName = By.cssSelector(".sc-product-title");
    By quantity = By.cssSelector(".sc-product-quantity");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickGoToCart() {
        click(goToCart);
    }

    public boolean isCartDisplayed() {
        return isDisplayed(cartPage);
    }

    public String getProductName() {
        return waitForElementVisible(productName).getText();
    }

    public String getQuantity() {
        return waitForElementVisible(quantity).getText();
    }
}