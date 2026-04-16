package com.automation.selenium_pom_framework.tests;

import com.automation.selenium_pom_framework.base.BaseTest;
import com.automation.selenium_pom_framework.pages.CartPage;
import com.automation.selenium_pom_framework.pages.HomePage;
import com.automation.selenium_pom_framework.pages.ProductPage;
import com.automation.selenium_pom_framework.pages.SearchResultsPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AmazonTest extends BaseTest {

	@Test
	public void verifyAmazonFlow() throws InterruptedException {

	    HomePage home = new HomePage(driver);
	    home.searchProduct("HP smart tank");

	    SearchResultsPage results = new SearchResultsPage(driver);

	    Assert.assertFalse(results.isNoResultsFound(), "No search results found!");
	    Assert.assertTrue(results.isResultsDisplayed(), "No products displayed");

	    results.selectProduct("Smart Tank 589");

	    ProductPage product = new ProductPage(driver);

	    if (product.isOutOfStock()) {
	        Assert.fail("Product is out of stock!");
	    }

	    Assert.assertTrue(product.isProductPageDisplayed(), "Product page not opened");

	    product.selectQuantity("2");

	    product.addToCart();

	    String subtotal = product.getCartSubtotal();
	    Assert.assertFalse(subtotal.isEmpty(), "Subtotal not displayed");

	    CartPage cart = new CartPage(driver);
	    cart.clickGoToCart();
	    Thread.sleep(3000);

	    Assert.assertTrue(cart.isCartDisplayed(), "Cart page not displayed");

	    Assert.assertTrue(cart.isProductPresent("Smart Tank 589"),
	            "Incorrect product in cart");

	    Assert.assertTrue(cart.isCorrectQuantity("2"),
	            "Quantity mismatch in cart");
	}
}