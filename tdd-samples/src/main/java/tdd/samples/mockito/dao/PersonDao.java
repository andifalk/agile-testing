package tdd.samples.mockito.dao;

import java.util.List;

import tdd.samples.mockito.entity.Person;

public interface PersonDao {
	/**
	 * Finds all {@link Person}s.
	 * @return list of {@link Person}s
	 */
	List<Person> findAll();
	
	/**
	 * Finds {@link Person} by its first and last name.
	 * @param firstName first name
	 * @param lastName last name
	 * @return {@link Person} if one is found
	 */
	Person findOne(String firstName, String lastName);
	
	/**
	 * Store a {@link Person}.
	 * @param person {@link Person} to store
	 * @return the stored Person
	 */
	Person save(Person person);
	
	/**
	 * Deletes a Person from database.
	 * @param person to delete
	 */
	void delete(Person person);	
}
