package info.novatec.amazon.shipping.calculator.entity;

import java.util.HashSet;
import java.util.Set;

public class CustomerBuilder {
	private String firstName;
	private String lastName;
	private String email;
	private CustomerType type;
	private Set<Address> addresses;
	
	public CustomerBuilder() {
		this.firstName = "myFirstName";
		this.lastName = "myLastName";
		this.email = "test@example.com";
		this.type = CustomerType.STANDARD;
		this.addresses = new HashSet<>();
	}
	
	public CustomerBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public CustomerBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public CustomerBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	
	public CustomerBuilder asStandardCustomer() {
		this.type = CustomerType.STANDARD;
		return this;
	}

	public CustomerBuilder asPrimeCustomer() {
		this.type = CustomerType.PRIME;
		return this;
	}
	
	public CustomerBuilder withCustomerType(CustomerType customerType) {
		this.type = customerType;
		return this;
	}

	public CustomerBuilder withAddress(Address address) {
		this.addresses.add(address);
		return this;
	}

	public Customer build() {
		return new Customer(firstName, lastName, email, type, addresses);
	}

}
