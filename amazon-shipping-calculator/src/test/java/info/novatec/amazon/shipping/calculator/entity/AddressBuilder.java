package info.novatec.amazon.shipping.calculator.entity;

public class AddressBuilder {
	private String street;
	private String postOfficeBox;
	private String zipCode;
	private String city;
	private Country country;

	public AddressBuilder() {
		this.street = "myStreet";
		this.postOfficeBox = null;
		this.zipCode = "12345";
		this.city = "myCity";
		this.country = Country.GERMANY;
	}
	
	public AddressBuilder withStreet(String street) {
		this.street = street;
		return this;
	}

	public AddressBuilder withPostOfficeBox(String postOfficeBox) {
		this.postOfficeBox = postOfficeBox;
		return this;
	}

	public AddressBuilder withZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}
	
	public AddressBuilder withCity(String city) {
		this.city = city;
		return this;
	}

	public AddressBuilder withCountry(Country country) {
		this.country = country;
		return this;
	}
	
	public Address build() {
		return new Address(street, postOfficeBox, zipCode, city, country);
	}

}
