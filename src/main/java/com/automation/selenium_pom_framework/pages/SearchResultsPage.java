package com.automation.selenium_pom_framework.pages;

import org.openqa.selenium.*;

public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResultsDisplayed() {
        return driver.findElements(By.xpath("//h2")).size() > 0;
    }

    public void selectProduct(String productName) {

       
        By productLink = By.xpath("//h2//span[contains(text(),'" + productName + "')]");

        WebElement product = waitForElementVisible(productLink);

       
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", product);

        product.click();

        
        for (String window : driver.getWindowHandles()) {
            driver.switchTo().window(window);
        }
    }
}