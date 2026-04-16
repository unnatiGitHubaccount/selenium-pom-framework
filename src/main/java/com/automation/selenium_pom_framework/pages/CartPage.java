package com.automation.selenium_pom_framework.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    
	private By goToCartBtn = By.xpath("//a[contains(@href,'/cart')]");

    private By cartContainer = By.id("sc-active-cart");

    private By cartItems = By.cssSelector("div.sc-list-item");

    private By productNames = By.cssSelector(".sc-product-title");

    private By quantities = By.cssSelector("span.a-dropdown-prompt");

    private By subtotalLabel = By.id("sc-subtotal-amount-activecart");

  
    public CartPage(WebDriver driver) {
        super(driver);
    }

   

    public void clickGoToCart() {

        List<WebElement> elements = driver.findElements(goToCartBtn);

        for (WebElement el : elements) {

            try {
                if (el.isDisplayed()) {

                    ((JavascriptExecutor) driver)
                            .executeScript("arguments[0].scrollIntoView(true);", el);

                    el.click();
                    return;
                }
            } catch (Exception e) {
                
            }
        }

        throw new RuntimeException("Go to Cart button not found");
    }
    
    

    public boolean isCartDisplayed() {
        return isDisplayed(cartContainer);
    }

    public int getCartItemsCount() {
        List<WebElement> items = driver.findElements(cartItems);
        return items.size();
    }

    public String getProductName() {
        return waitForElementVisible(productNames).getText();
    }

    public String getQuantity() {
        List<WebElement> qtyList = driver.findElements(quantities);

        for (WebElement qty : qtyList) {
            String text = qty.getText().trim();

            
            if (text.matches("\\d+")) {
                return text;
            }
        }
        return "";
    }

    public String getSubtotal() {
        try {
            return waitForElementVisible(subtotalLabel).getText();
        } catch (Exception e) {
            return "";
        }
    }

    

    public boolean isProductPresent(String expectedProductName) {
        List<WebElement> names = driver.findElements(productNames);

        for (WebElement name : names) {
            if (name.getText().toLowerCase()
                    .contains(expectedProductName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean isCorrectQuantity(String expectedQty) {

        try {
           
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sc-list-item")));

            List<WebElement> items = driver.findElements(By.cssSelector("div.sc-list-item"));

            for (WebElement item : items) {

               
                String qty = item.getAttribute("data-quantity");

                System.out.println("Cart item quantity: " + qty);

                if (qty != null && qty.equals(expectedQty)) {
                    return true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}