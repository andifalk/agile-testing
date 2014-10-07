package tdd.samples.rules;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class TimeoutRuleTest {
	
	@Mock
	private MyService cut;
	
	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Test
	public final void verifyOperationA() throws MyExceptionA, FileNotFoundException, IOException {
		when(cut.operationA(anyString())).thenAnswer(new Answer<String>() {
			@Override
			public String answer(InvocationOnMock invocation) throws Throwable {
				File newFile = temporaryFolder.newFile("myNewFile");
				try (FileWriter writer = new FileWriter(newFile)) {
					writer.write("test");
					writer.flush();
				}
				
				return invocation.getArgumentAt(0, String.class);
			}
		});

		cut.operationA("testA");
		
		Path path = Paths.get(temporaryFolder.getRoot().getPath(), "myNewFile");
		System.out.println(path.toFile().getPath());
		
		assertThat("Created file should exist", 
				Files.exists(path), 
				is(true));
		
		String content;
		try ( BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
			content = reader.readLine();
		}
		
		assertThat("Got expected content", content, is("test"));
	}

}
