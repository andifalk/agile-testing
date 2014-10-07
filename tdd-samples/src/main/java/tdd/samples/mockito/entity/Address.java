package tdd.samples.mockito.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * An Address.
 */
public class Address {
	private String street;
	private String zipCode;
	private String city;
	private String email;
	private boolean defaultAddress;
	
	public Address() {
		super();
	}

	/**
	 * @param street
	 * @param zipCode
	 * @param city
	 * @param email
	 * @param defaultAddress
	 */
	public Address(String street, String zipCode, String city, String email,
			boolean defaultAddress) {
		super();
		this.street = street;
		this.zipCode = zipCode;
		this.city = city;
		this.email = email;
		this.defaultAddress = defaultAddress;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isDefaultAddress() {
		return defaultAddress;
	}
	
	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
		
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
			.append("street", street)
			.append("zipCode", zipCode)
			.append("city", city)
			.append("email",email)
			.append("default", defaultAddress)
			.build();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Address rhs = (Address) obj;
		
		return new EqualsBuilder()
					.appendSuper(super.equals(obj))
					.append(street, rhs.getStreet())
					.append(zipCode, rhs.getZipCode())
					.append(city, rhs.getCity())
					.append(email, rhs.getEmail())
					.append(defaultAddress, rhs.isDefaultAddress())
					.isEquals();
	}
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(19, 37)
					.append(street)
					.append(zipCode)
					.append(city)
					.append(email)
					.append(defaultAddress)
					.build();
	}

	
}
