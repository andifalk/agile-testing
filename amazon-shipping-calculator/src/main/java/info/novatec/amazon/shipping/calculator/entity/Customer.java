package info.novatec.amazon.shipping.calculator.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	
	private String firstName;
	private String lastName;
	private String email;
	private CustomerType type;
	private Set<Address> addresses;

	public Customer() {
		super();
		this.addresses = new HashSet<Address>();
	}

	/**
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param type
	 * @param addresses
	 */
	public Customer(String firstName, String lastName, String email,
			CustomerType type, Set<Address> addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
		this.addresses = addresses;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final String getEmail() {
		return email;
	}

	public final CustomerType getType() {
		return type;
	}

	public final Set<Address> getAddresses() {
		return addresses;
	}
	
	public void addAddress(Address address) {
		this.addresses.add(address);
	}

}
