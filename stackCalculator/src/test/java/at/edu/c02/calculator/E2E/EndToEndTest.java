package at.edu.c02.calculator.E2E;

import java.io.File;
import java.io.FileNotFoundException;

import at.edu.c02.calculator.logic.CalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.parser.Parser;

public class EndToEndTest {

    @Test
    public void testParserAndCalculator() throws Exception {
        Calculator calc = new CalculatorImpl();

        Parser parser = new Parser(calc);
        double result = parser.parse(new File("src/test/resources/test05.xml"));

        assertEquals(1, result, 0);
    }

    @Test
    public void testParserAndCalculator2() throws Exception {
        Calculator calc = new CalculatorImpl();

        Parser parser = new Parser(calc);
        double result = parser.parse(new File("src/test/resources/test06.xml"));

        assertEquals(20, result, 0);
    }

    @Test
    public void testSinusOperation() throws Exception {
        Calculator calc = new CalculatorImpl();

        Parser parser = new Parser(calc);
        double result = parser.parse(new File("src/test/resources/test07.xml"));

        assertEquals(1, result, 0.01);
    }

    @Test
    public void testCosinusOperation() throws Exception {
        Calculator calc = new CalculatorImpl();

        Parser parser = new Parser(calc);
        double result = parser.parse(new File("src/test/resources/test08.xml"));

        assertEquals(0, result, 0.01);
    }
}
