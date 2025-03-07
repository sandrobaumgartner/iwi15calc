package at.edu.c02.calculator.parser;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Test;
import static org.mockito.Mockito.*;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.parser.Parser;

public class ParserTest {

	@Test(expected = IllegalArgumentException.class)
	public void testNullParser() {
		new Parser(null);
	}

	@Test(expected = FileNotFoundException.class)
	public void testParserInvalidFile() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("invalid"));
	}

	@Test
	public void testParserTest01Xml() throws Exception {

		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test01.xml"));
		
		verify(cal).push(1.0);
		verify(cal).push(2.0);
		verify(cal).perform(Operation.add);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest04Xml() throws Exception {
		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test04.xml"));

		verify(cal).push(16);
		verify(cal).push(6);
		verify(cal).perform(Operation.mod);

		verifyNoMoreInteractions(cal);
	}

	@Test
	public void testParserTest05Xml() throws Exception {
		Calculator cal = mock(Calculator.class);

		Parser parser = new Parser(cal);
		parser.parse(new File("src/test/resources/test05.xml"));

		verify(cal).push(50);
		verify(cal, times(2)).push(2);
		verify(cal).perform(Operation.div);
		verify(cal).push(0); // Mock result is always 0
		verify(cal).perform(Operation.mod);

		verifyNoMoreInteractions(cal);
	}
}
