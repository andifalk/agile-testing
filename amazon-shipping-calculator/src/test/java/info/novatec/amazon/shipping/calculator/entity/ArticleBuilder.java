package info.novatec.amazon.shipping.calculator.entity;

import java.math.BigDecimal;

public class ArticleBuilder {
	
	private String name;
	private String description;
	private Category category;
	private BigDecimal price;
	private DeliveryPeriod deliveryPeriod;
	
	public ArticleBuilder() {
		this.name = "myArticle";
		this.description = "my article description";
		this.category = Category.BOOKS;
		this.price = new BigDecimal(10);
		this.deliveryPeriod = DeliveryPeriod.NEXT_DAY;
	}
	
	public ArticleBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public ArticleBuilder withDescription(String description) {
		this.description = description;
		return this;
	}
	
	public ArticleBuilder withCategory(Category category) {
		this.category = category;
		return this;
	}
	
	public ArticleBuilder withPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public ArticleBuilder withDeliveryPeriod(DeliveryPeriod deliveryPeriod) {
		this.deliveryPeriod = deliveryPeriod;
		return this;
	}

	public Article build() {
		return new Article(name, description, category, price, deliveryPeriod);
	}

}
