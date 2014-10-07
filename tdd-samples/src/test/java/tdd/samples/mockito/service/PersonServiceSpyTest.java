package tdd.samples.mockito.service;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import tdd.samples.mockito.dao.PersonDao;
import tdd.samples.mockito.dao.PersonDaoHashMap;

@RunWith(MockitoJUnitRunner.class)
public class PersonServiceSpyTest {
	
	@Spy
	private PersonDao personDao = new PersonDaoHashMap();
	
	private PersonService cut;

	@Before
	public void setUp() throws Exception {
		cut = new PersonService();
		cut.setPersonDao(personDao);
		
		//when(personDao.findAll()).thenReturn(Collections.singletonList(new Person("firstName", "lastName")));
	}

	@Test
	public void verifyCommaSeparatedList() {
		
		String commaseparated = cut.getPersonsCommaSeparated();
		assertThat("Should have got a valid comma separated list", commaseparated, is(notNullValue()));
		assertThat("Should have got a non-empty comma separated list", commaseparated.length(), is(greaterThan(10000)));
		
		verify(personDao).findAll();
		
	}

}
