package atdd.concordion;

import info.novatec.amazon.shipping.calculator.entity.Article;
import info.novatec.amazon.shipping.calculator.entity.ArticleBuilder;
import info.novatec.amazon.shipping.calculator.entity.Category;
import info.novatec.amazon.shipping.calculator.entity.Customer;
import info.novatec.amazon.shipping.calculator.entity.CustomerBuilder;
import info.novatec.amazon.shipping.calculator.entity.CustomerType;
import info.novatec.amazon.shipping.calculator.entity.ShippingMethod;
import info.novatec.amazon.shipping.calculator.service.Calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.concordion.api.ExpectedToPass;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@ExpectedToPass
@RunWith(ConcordionRunner.class)
public class CalculateShippingCostsTest {

	public final String calculateShippingCosts(String customerType, String category1, String price1, String category2, 
			String price2, String shippingMethod) {
		String result = null;
		Calculator calculator = new Calculator();
		
		List<Article> shoppingCart = new ArrayList<>();
		shoppingCart.add(new ArticleBuilder()
								.withCategory(Category.valueOf(category1))
								.withPrice(new BigDecimal(price1))
								.build());
		shoppingCart.add(new ArticleBuilder()
								.withCategory(Category.valueOf(category2))
								.withPrice(new BigDecimal(price2))
								.build());
		Customer customer = new CustomerBuilder()
									.withCustomerType(CustomerType.valueOf(customerType))
									.build();
		
		try {
			BigDecimal shippingCosts = calculator.calculate(customer, shoppingCart, ShippingMethod.valueOf(shippingMethod));
			result = shippingCosts.toPlainString();
		} catch (IllegalArgumentException ex) {
			result = "Error: " + ex.getMessage();
		}
		return result;
	}

}
