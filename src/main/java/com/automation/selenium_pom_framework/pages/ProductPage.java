package com.automation.selenium_pom_framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends BasePage {

   

    private By productTitle = By.id("productTitle");

    private By addToCartBtn = By.xpath("//input[@id='add-to-cart-button' or @name='submit.add-to-cart']");

    private By quantityDropdown = By.id("quantity");

    private By availability = By.id("availability");

    private By subtotal = By.xpath("//span[contains(@id,'subtotal')]");

    private By cartSubtotal = By.xpath("//span[contains(@id,'subtotal') or contains(@class,'subtotal')]");

    private By goToCartBtn = By.xpath("//a[contains(text(),'Go to Cart') or contains(@href,'cart')]");


    
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    

    public boolean isProductPageDisplayed() {
        return isDisplayed(productTitle);
    }

    public String getProductTitle() {
        return waitForElementVisible(productTitle).getText();
    }

    

    public boolean isOutOfStock() {
        try {
            List<WebElement> elements = driver.findElements(availability);

            if (elements.isEmpty()) return false;

            String text = elements.get(0).getText().toLowerCase();

            return text.contains("out of stock")
                    || text.contains("currently unavailable")
                    || text.contains("temporarily unavailable")
                    || text.contains("we don't know when");
        } catch (Exception e) {
            return false;
        }
    }

    

    public void selectQuantity(String qty) {
        Select select = new Select(waitForElementVisible(quantityDropdown));
        select.selectByValue(qty);

       
        wait.until(ExpectedConditions.elementToBeClickable(productTitle));

       
        waitForElementVisible(productTitle).click();
    }

    public void addToCart() {
        click(addToCartBtn);
    }

    public void clickGoToCart() {
        click(goToCartBtn);
    }
   

    public String getCartSubtotal() {
        try {
            return waitForElementVisible(subtotal).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isSubtotalDisplayed() {
        return !getCartSubtotal().isEmpty();
    }
} 	