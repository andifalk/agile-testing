package tdd.samples.mockito.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import tdd.samples.mockito.dao.PersonDao;
import tdd.samples.mockito.entity.AddressBuilder;
import tdd.samples.mockito.entity.Person;
import tdd.samples.mockito.entity.PersonBuilder;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceMockTest {
	
	@Mock
	private PersonDao personDao;
	
	@InjectMocks
	private PersonService cut = new PersonService();

	@Before
	public void setUp() throws Exception {
		
		when(personDao.findAll()).thenReturn(Collections.singletonList(new Person("firstName", "lastName", new Date(), new ArrayList<>())));
		
		when(personDao.save(any(Person.class))).thenAnswer(new Answer<Person>() {
			@Override
			public Person answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();
				assertThat("Should have given expected number of arguments", arguments.length, is(1));
				Person person = invocation.getArgumentAt(0, Person.class);
				return person;
			}
		});
	}

	@Test
	public void verifyCommaSeparatedList() {
		String commaseparated = cut.getPersonsCommaSeparated();
		assertThat("Should have got a valid comma separated list", commaseparated, is(notNullValue()));
		assertThat("Should have got a non-empty comma separated list", commaseparated.length(), is(greaterThan(0)));
		
		verify(personDao).findAll();
	}

	@Test
	public void verifyAddPerson() {
		Person person = cut.addPerson("Hans", "Muster");
		assertThat("Should have got a valid person", person, is(notNullValue()));
		assertThat("Should have got expected person", person.getLastName(), is("Muster"));
		
		verify(personDao, times(1)).save(any(Person.class));
		verifyNoMoreInteractions(personDao);
	}
	
	@Test
	public void verifySavePerson() {
		Person person = new PersonBuilder()
			.withFirstName("Hans")
			.withLastName("Maier")
			.with(new AddressBuilder().asDefaultAddress().build())
			.build();
		
		person = cut.save(person);
		
		assertThat("Should have saved the person", person, is(notNullValue()));
		verify(personDao, times(1)).save(any(Person.class));
		verifyNoMoreInteractions(personDao);
	}
	
	@Test
	public void verifySaveLotsOfPersons() {
		Person person;
		
		for(int i=0; i < 500000; i++) {
			person = cut.save(new PersonBuilder()
							.with(new AddressBuilder().asDefaultAddress().build())
							.build());
			assertThat("Should have saved the person", person, is(notNullValue()));
		}	
		verify(personDao, times(500000)).save(any(Person.class));
		verifyNoMoreInteractions(personDao);
	}	

}
