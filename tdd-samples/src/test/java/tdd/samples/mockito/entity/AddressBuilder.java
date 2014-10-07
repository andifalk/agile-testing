package tdd.samples.mockito.entity;

public class AddressBuilder {
	private Address innerAddress;
	
	public AddressBuilder() {
		innerAddress = new Address("street", "zipCode", "city", "test@example.com", false);
	}
	
	public AddressBuilder withStreet(String street) {
		innerAddress.setStreet(street);
		return this;
	}
	
	public AddressBuilder withZipCode(String zipCode) {
		innerAddress.setZipCode(zipCode);
		return this;
	}
	
	public AddressBuilder withCity(String city) {
		innerAddress.setCity(city);
		return this;
	}
	
	public AddressBuilder withEmail(String email) {
		innerAddress.setEmail(email);
		return this;
	}
	
	public AddressBuilder asDefaultAddress() {
		innerAddress.setDefaultAddress(true);
		return this;
	}
	
	public Address build() {
		return innerAddress;
	}
}
