package info.novatec.amazon.shipping.calculator.service;

import info.novatec.amazon.shipping.calculator.entity.Article;
import info.novatec.amazon.shipping.calculator.entity.Category;
import info.novatec.amazon.shipping.calculator.entity.Customer;
import info.novatec.amazon.shipping.calculator.entity.CustomerType;
import info.novatec.amazon.shipping.calculator.entity.ShippingMethod;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

/**
 * Calculator for shipping costs at Amazon.
 */
public class Calculator {

	/**
	 * Calculates shipping costs.
	 * Throws an {@link IllegalArgumentException} for invalid combinations of
	 * input parameters.
	 * 
	 * @param customerType the {@link CustomerType}
	 * @param shoppingCart the shopping cart as list of {@link Article}s
	 * @param shippingMethod the {@link ShippingMethod}
	 * @return the calculated shipping costs
	 */
	public BigDecimal calculate ( 
			Customer customer, List<Article> shoppingCart, 
			ShippingMethod shippingMethod ) {
		BigDecimal shippingCosts = null;
		switch (shippingMethod) {
			case STANDARD:
				if (CustomerType.STANDARD == customer.getType()) {
					if (shoppingCartContainsAtLeastOneBook(shoppingCart)) {
						shippingCosts = new BigDecimal("0.0");
					} else {
						if (totalPriceOfShoppingCart(shoppingCart).compareTo(new BigDecimal("29.0")) >= 0) {
							shippingCosts = new BigDecimal("0.0");
						} else {
							shippingCosts = new BigDecimal("3.0");
						}
					}
				} else {
					throw new IllegalArgumentException("Premium customers cannot select standard shipping method");
				}
				break;
			case PREMIUM:
			case TWO_DAY_EXPRESS:
				if (CustomerType.PRIME == customer.getType()) {
					shippingCosts = new BigDecimal("0.0");
				} else {
					shippingCosts = new BigDecimal("6.0");
				}
				break;
			case MORNING_EXPRESS:
			case EVENING_EXPRESS:
				if (CustomerType.PRIME == customer.getType()) {
					shippingCosts = new BigDecimal("5.0").multiply(new BigDecimal(shoppingCart.size()));
				} else {
					shippingCosts = new BigDecimal("13.0");
				}
				break;
			default:
				throw new IllegalArgumentException("Invalid shipping method specified: " + shippingMethod);
		}
		
		return shippingCosts;
	}

	/**
	 * Checks if at least one book is included in shopping cart.
	 * @param shoppingCart the shopping cart
	 * @return <code>true</code> if at least one book is included
	 */
	private boolean shoppingCartContainsAtLeastOneBook(List<Article> shoppingCart) {
		boolean containsBook = shoppingCart
			.stream()
			.anyMatch(new Predicate<Article>() {
				@Override
				public boolean test(Article article) {
					return Category.BOOKS == article.getCategory();
				}
			});
		return containsBook;
	}
	
	/**
	 * Calculates the total price for the shopping cart.
	 * @param shoppingCart the shopping cart
	 * @return the total price
	 */
	private BigDecimal totalPriceOfShoppingCart(List<Article> shoppingCart) {
		return shoppingCart
			.stream()
			.map(Article::getPrice)
			.reduce(BigDecimal.ZERO, BigDecimal::add);
	}


}
