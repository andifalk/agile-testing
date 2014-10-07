package tdd.samples.mockito.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import tdd.samples.mockito.entity.Address;

public class Person {

	private String firstName;
	private String lastName;
	private Date birthDate;
	
	private List<Address> addresses = new ArrayList<>();
	
	public Person(String firstName, String lastName, Date birthDate, List<Address> addresses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.addresses = addresses;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public String getDisplayName() {
		return firstName + " " + lastName;
	}
	
	public List<Address> getAddresses() {
		return addresses;
	}
	
	public void addAdress(Address address) {
		this.addresses.add(address);
	}

}
