package tdd.samples.mockito.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tdd.samples.mockito.entity.Person;

public class PersonDaoHashMap implements PersonDao {
	private Map<String, Person> personsMap;
	
	public PersonDaoHashMap() {
		personsMap = new HashMap<>();
		for (int i=0; i < 50000; i++) {
			personsMap.put("firstName" + i + "lastName" + i, new Person("firstName" + i, "lastName" + i, new Date(), new ArrayList<>()));
		}
	}

	@Override
	public List<Person> findAll() {
		return new ArrayList<Person>(personsMap.values());
	}

	@Override
	public Person save(Person person) {
		personsMap.put(person.getFirstName() + person.getLastName(), person);
		return person;
	}

	@Override
	public Person findOne(String firstName, String lastName) {
		return personsMap.get(firstName + lastName);
	}
	
	@Override
	public void delete(Person person) {
		Person personToDelete = personsMap.get(person.getFirstName() + person.getLastName());
		if (personToDelete != null) {
			personsMap.remove(person.getFirstName() + person.getLastName());
		}
	}	

}
