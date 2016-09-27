package org.egov.bootcamp;

import static junit.framework.TestCase.assertEquals;

import org.egov.bootcamp.exception.InValidInputException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringCalculatorTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldThrowNullPointerExceptionIfInputIsNull() throws Exception {
		StringCalculator calculator = new StringCalculator();
		thrown.expect(NullPointerException.class);
		calculator.calculate(null);
	}

	@Test
	public void shouldThrowInValidInputExceptionIfInputIsEmpty() throws Exception {
		StringCalculator calculator = new StringCalculator();
		thrown.expect(InValidInputException.class);
		calculator.calculate("");
	}

	@Test
	public void shouldThrowInValidInputExceptionIfInputIsEmptyWithSpaces() throws Exception {
		StringCalculator calculator = new StringCalculator();
		thrown.expect(InValidInputException.class);
		calculator.calculate("            ");
	}

	@Test
	public void shouldRetrunSameValueIfInputIsWithOutOperator() throws Exception {
		StringCalculator calculator = new StringCalculator();
		assertEquals(1, calculator.calculate("1"));
	}

	@Test
	public void shouldRetrunSameValueIfInputIsWithOutOperatorWithSpaces() throws Exception {
		StringCalculator calculator = new StringCalculator();
		assertEquals(1, calculator.calculate("    1      "));
	}

	@Test
	public void shouldThrowInvalidInputExceptionIfInputPatternIsInvalid() throws Exception {
		StringCalculator calculator = new StringCalculator();
		thrown.expect(InValidInputException.class);
		calculator.calculate("1((((2");
		thrown.expect(InValidInputException.class);
		calculator.calculate("%%^&%((((2");
		thrown.expect(InValidInputException.class);
		calculator.calculate("1+");
		thrown.expect(InValidInputException.class);
		calculator.calculate("  1   2  ");

	}

	@Test
	public void shouldReturnAppropriateValueForAdditionOfTwoValues() {
		StringCalculator calculator = new StringCalculator();

		assertEquals(3, calculator.calculate("1+2"));
		assertEquals(3, calculator.calculate(" 1+2"));
		assertEquals(3, calculator.calculate("1 +2"));
		assertEquals(3, calculator.calculate("1+ 2"));
		assertEquals(3, calculator.calculate("1+2 "));
		assertEquals(15, calculator.calculate("1+2+3+4+5 "));
		
		
	}

	@Test
	public void shouldReturnAppropriateValueForsubtractionOfTwoValues() {
		StringCalculator calculator = new StringCalculator();

		assertEquals(1, calculator.calculate("2-1"));
		assertEquals(1, calculator.calculate("2 -1"));
		assertEquals(1, calculator.calculate("2- 1"));
		assertEquals(1, calculator.calculate("2-1 "));
		assertEquals(1, calculator.calculate(" 2 - 1 "));
		assertEquals(3, calculator.calculate("9-1-2-3"));
	}

	@Test
	public void shouldReturnAppropriateValueFormultiplicationOfTwoValues() {
		StringCalculator calculator = new StringCalculator();

		assertEquals(2, calculator.calculate("1*2"));
		assertEquals(2, calculator.calculate("1 *2"));
		assertEquals(2, calculator.calculate("1* 2"));
		assertEquals(2, calculator.calculate("1*2 "));
		assertEquals(2, calculator.calculate("   1  *  2  "));
		assertEquals(24, calculator.calculate("1*2*3*4"));
	}

}
