package tdd.samples.mockito.entity;

import java.util.ArrayList;
import java.util.Date;

public class PersonBuilder {
	private static long index = 0;

	private Person innerPerson;
	
	public PersonBuilder() {
		index++;
		innerPerson = new Person("firstName" + index, "lastName" + index, 
						new Date(), new ArrayList<Address>());
	}
	
	public PersonBuilder withFirstName(String firstName) {
		innerPerson.setFirstName(firstName);
		return this;
	}
	
	public PersonBuilder withLastName(String lastName) {
		innerPerson.setLastName(lastName);
		return this;
	}
	
	public PersonBuilder withBirthDate(Date birthDate) {
		innerPerson.setBirthDate(birthDate);
		return this;
	}

	public PersonBuilder with(Address address) {
		innerPerson.addAdress(address);
		return this;
	}
	
	public Person build() {
		return innerPerson;
	}
}
