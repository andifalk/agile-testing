package tdd.samples.mockito.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import tdd.samples.mockito.dao.PersonDao;
import tdd.samples.mockito.entity.Person;

public class PersonService {
	private PersonDao personDao;
	
	private List<Person> persons = new ArrayList<Person>();
	
	public PersonService() {
		super();
		for (int i=0; i < 50000; i++) {
			persons.add(new Person("firstName" + i, "lastName" + i, new Date(), new ArrayList<>()));
		}
	}
	
	public String getPersonsCommaSeparated() {
		return personDao.findAll()
			.stream()
			.map(person -> person.getDisplayName())
			.collect(Collectors.joining(","));
	}
	
	public Person addPerson(String firstName, String lastName) {
		Person person = new Person(firstName, lastName, new Date(), new ArrayList<>());
		return personDao.save(person);
	}
	
	public Person save(Person person) {
		return personDao.save(person);
	}
	
	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	

}
