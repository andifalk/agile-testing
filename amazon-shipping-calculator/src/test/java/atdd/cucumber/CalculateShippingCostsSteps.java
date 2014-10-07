package atdd.cucumber;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import info.novatec.amazon.shipping.calculator.entity.Article;
import info.novatec.amazon.shipping.calculator.entity.ArticleBuilder;
import info.novatec.amazon.shipping.calculator.entity.Category;
import info.novatec.amazon.shipping.calculator.entity.Customer;
import info.novatec.amazon.shipping.calculator.entity.CustomerBuilder;
import info.novatec.amazon.shipping.calculator.entity.ShippingMethod;
import info.novatec.amazon.shipping.calculator.service.Calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalculateShippingCostsSteps {
	private Customer customer; 
	private List<Article> shoppingCart = new ArrayList<>();
	private ShippingMethod shippingMethod;
	
	@Given("^I am a Prime customer$")
	public void iAmAPrimeCustomer() throws Throwable {
		customer = new CustomerBuilder()
						.asPrimeCustomer()
						.build();
	}
	
	@Given("^I am a Standard customer$")
	public void iAmAStandardCustomer() throws Throwable {
		customer = new CustomerBuilder()
						.asStandardCustomer()
						.build();
	}
	
	@When("^I have an article of (\\w+) with (\\d+\\.\\d+) Euro in my shopping cart$")
	public void iHaveAnArticleOfCategoryInMyShoppingCart(Category category, BigDecimal price) throws Throwable {
		shoppingCart.add(new ArticleBuilder()
							.withCategory(category)
							.withPrice(price)
							.build());
	}

	@When("^I selected shipping method (\\w+)$")
	public void iSelectedShippingMethod(ShippingMethod shippingMethod) throws Throwable {
		this.shippingMethod = shippingMethod;
	}

	@Then("^my calculated shipping costs should be (\\d+\\.\\d+) Euro$")
	public void myCalculatedShippingCostsShouldBe(BigDecimal shippingCosts) throws Throwable {
		Calculator calculator = new Calculator();
		BigDecimal calculatedShippingCosts = calculator.calculate(customer, shoppingCart, shippingMethod);
		
		assertThat("Calculated expected shipping costs", calculatedShippingCosts, is(shippingCosts));
	}

	@When("^I have articles of any category in my shopping cart$")
	public void iHaveArticlesOfAnyCategoryInMyShoppingCart() throws Throwable {
		shoppingCart.add(new ArticleBuilder()
							.withCategory(Category.BOOKS)
							.withPrice(new BigDecimal("200"))
							.build());
	}

	@Then("^I should get an error with message \"(.*?)\"$")
	public void iShouldGetAnErrorWithMessagePremiumCustomersCannotSelectStandardShippingMethod(String errorMessage) throws Throwable {
		Calculator calculator = new Calculator();
		try {
			calculator.calculate(customer, shoppingCart, shippingMethod);
			fail("Expected an IllegalArgumentException");
		} catch(IllegalArgumentException ex) {
			assertThat("Got the expected error message", ex.getMessage(), is(errorMessage));
		}
	}

}
