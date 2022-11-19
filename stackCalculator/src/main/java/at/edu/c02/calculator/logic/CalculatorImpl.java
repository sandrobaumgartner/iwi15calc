package at.edu.c02.calculator.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;


public class CalculatorImpl implements Calculator {

	private Stack<Double> stack_ = new Stack<Double>();

	@Override
	public double perform(Operation op) throws CalculatorException {
		if(op.equals(Operation.dotproduct)) {
			return this.performDotProduct();
		}

		double b = pop();
		double a = 0;

		if (!(op.equals(Operation.sin) || op.equals(Operation.cos))) {
			a = pop();
		}

		switch (op) {
		case add:
			return a + b;
		case sub:
			return a - b;
		case div:
			double c = a / b;
			if (Double.isInfinite(c))
				throw new CalculatorException("Division by zero");
			return c;
		case mul:
			return a * b;
		case mod:
			if (b == 0) {
				throw new CalculatorException("Modulo division by zero");
			}
			return a % b;
		case sin:
			b *= Math.PI/180;
			return Math.sin(b);
		case cos:
			b *= Math.PI/180;
			return Math.cos(b);
		}
		return 0;
	}

	public double performDotProduct() throws CalculatorException{
		ArrayList<Double> numbers = new ArrayList<>();
		ArrayList<Double> vector1 = new ArrayList<>();
		ArrayList<Double> vector2 = new ArrayList<>();

		try {
			while(true) {
				numbers.add(pop());
			}
		} catch (CalculatorException e) {
			Collections.reverse(numbers);
			int size = numbers.get(numbers.size() - 1).intValue();
			numbers.remove(numbers.size() - 1);

			if (size < 1) {
				throw new CalculatorException("Scalar size cannot be negative");
			}

			for (int i = 0; i < size; i++) {
				vector1.add(numbers.get(i));
			}

			for (int i = size; i < numbers.size(); i++) {
				vector2.add(numbers.get(i));
			}

			double result = 0;
			for (int i = 0; i < vector1.size(); i++) {
				result += vector1.get(i) * vector2.get(i);
			}

			return result;
		}
	}

	@Override
	public double pop() throws CalculatorException {
		if (stack_.isEmpty())
			throw new CalculatorException();
		return stack_.pop();
	}

	@Override
	public void push(double v) {
		stack_.push(v);
	}

	@Override
	public void clear() {
		stack_.clear();
	}

}
