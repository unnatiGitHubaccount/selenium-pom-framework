package com.automation.selenium_pom_framework.tests;

import com.automation.selenium_pom_framework.base.BaseTest;
import com.automation.selenium_pom_framework.pages.HomePage;
import com.automation.selenium_pom_framework.pages.ProductPage;
import com.automation.selenium_pom_framework.pages.SearchResultsPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AmazonTest extends BaseTest {

    @Test
    public void verifyAmazonFlow() {

        HomePage home = new HomePage(driver);
        home.searchProduct("HP smart tank");

        SearchResultsPage results = new SearchResultsPage(driver);
        Assert.assertTrue(results.isResultsDisplayed(), "No results found");

        results.selectProduct("Smart Tank 589");

        ProductPage product = new ProductPage(driver);
        Assert.assertTrue(product.isProductPageDisplayed(), "Product page not opened");

        product.selectQuantity("2");
        product.addToCart();
    }
}