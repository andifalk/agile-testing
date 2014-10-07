package info.novatec.amazon.shipping.calculator.entity;

import java.math.BigDecimal;

public class Article {
	
	private String name;
	private String description;
	private Category category;
	private BigDecimal price;
	private DeliveryPeriod deliveryPeriod;
	
	/**
	 * Constructor for {@link Article}.
	 * @param name article name
	 * @param description article description
	 * @param category article {@link Category}
	 * @param price article price
	 * @param deliveryPeriod the period of delivery
	 */
	public Article(String name, String description, Category category, BigDecimal price, DeliveryPeriod deliveryPeriod ) {
		super();
		this.name = name;
		this.description = description;
		this.category = category;
		this.price = price;
		this.deliveryPeriod = deliveryPeriod;
	}

	public String getName() {
		return name;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public DeliveryPeriod getDeliveryPeriod() {
		return deliveryPeriod;
	}
	
	@Override
	public String toString() {
		return "Article [name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	
}
