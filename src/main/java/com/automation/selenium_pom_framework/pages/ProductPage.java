package com.automation.selenium_pom_framework.pages;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    By productTitle = By.id("productTitle");

    By addToCart = By.xpath("//input[@id='add-to-cart-button' or @name='submit.add-to-cart']");

    By quantity = By.id("quantity");

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean isOutOfStock() {

        try {

            
            By availability = By.id("availability");

            List<WebElement> elements = driver.findElements(availability);

            if (elements.isEmpty()) {
                return false;
            }

            String text = elements.get(0).getText().toLowerCase();

            return text.contains("out of stock")
                    || text.contains("currently unavailable")
                    || text.contains("we don't know when")
                    || text.contains("temporarily unavailable");

        } catch (Exception e) {
            return false;
        }
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