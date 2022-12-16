package at.edu.c02.calculator;


import java.util.HashMap;

public interface Calculator {

	enum Operation {
		add, sub, mul, div, mod, sin, cos, dotproduct, store, load
	};

	void push(double value);
	
	double pop() throws CalculatorException;

	void storeResult(double result);

	void storeResult(String name, double value);

	double loadResult();

	double loadResult(String name) throws StoreException;
	
	double perform(Operation op) throws CalculatorException;
	
	void clear(); 
}
