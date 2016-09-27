package org.egov.bootcamp;

import java.util.Arrays;
import java.util.List;

import org.egov.bootcamp.exception.InValidInputException;

public class StringCalculator {
	String valid_pattern = "^\\d+(?>[\\+\\*\\-]\\d+)*$";

	public int calculate(String expression) {

		expression = santizie(expression);
		if (!validate(expression))
			throw new InValidInputException();
		else if (expression.contains("+")) {
			return add(expression);
		} else if (expression.contains("-")) {
			return subtraction(expression);

		} else if (expression.contains("*")) {

			return multiplication(expression);
		} else
			return Integer.parseInt(expression);
	}

	private String santizie(String expression) {
		return expression.replaceAll("\\s", "");
	}

	private boolean validate(String expression) {
		return expression.matches(valid_pattern);
	}

	private int add(String expression) {
		List<String> operands = Arrays.asList(expression.split("\\+"));
		return operands.stream().map((operand) -> Integer.parseInt(operand)).mapToInt(Integer::intValue).sum();
	}

	private int subtraction(String expression) {
		Integer result = 0;
		Boolean check = true;
		List<String> operands = Arrays.asList(expression.split("\\-"));
		for (String operand : operands) {
			if (check) {
				result = Integer.parseInt(operand);
				check = false;
			} else
				result = result - Integer.parseInt(operand);
		}
		return result;
	}

	private int multiplication(String expression) {
		Integer result = 1;
		List<String> operands = Arrays.asList(expression.split("\\*"));
		for (String operand : operands) {
			result = result * Integer.parseInt(operand);
		}
		return result;
	}

}
