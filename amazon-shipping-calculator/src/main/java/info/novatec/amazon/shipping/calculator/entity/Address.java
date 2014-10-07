package info.novatec.amazon.shipping.calculator.entity;


public class Address {

	private String street;
	private String postofficebox;
	private String zipCode;
	private String city;
	private Country county;

	public Address() {
		super();
	}
	
	public Address(String street, String postofficebox, String zipCode,
			String city, Country county) {
		super();
		this.street = street;
		this.postofficebox = postofficebox;
		this.zipCode = zipCode;
		this.city = city;
		this.county = county;
	}

	/**
	 * @return the street
	 */
	public final String getStreet() {
		return street;
	}

	/**
	 * @return the postofficebox
	 */
	public final String getPostofficebox() {
		return postofficebox;
	}

	/**
	 * @return the zipCode
	 */
	public final String getZipCode() {
		return zipCode;
	}

	/**
	 * @return the city
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * @return the county
	 */
	public final Country getCounty() {
		return county;
	}

	
}
