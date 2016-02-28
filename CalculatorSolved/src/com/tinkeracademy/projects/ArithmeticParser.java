package com.tinkeracademy.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArithmeticParser {

	public enum Operator  {
			ADD,
			SUBTRACT,
			MULTIPLY,
			DIVIDE,
			NONE
	}
	
	public String addOperator;
	public String subtractOperator;
	public String multiplyOperator;
	public String divideOperator;
	
	public ArithmeticParser(String addOp, 
			String subtractOp, 
			String multiplyOp, 
			String divideOp) {
		addOperator = addOp;
		subtractOperator = subtractOp;
		multiplyOperator = multiplyOp;
		divideOperator = divideOp;
	}
	
	public Double evaluate(Stack<String> in) {
		List<String> inputs = new ArrayList<String>();
		inputs.addAll(in);
		Double result = parse(inputs);
		return result;
	}
	
	//Grammar:
	// expression = term | expression `+` term | expression `-` term
	// term = factor | term `*` factor | term `/` factor | term brackets
	// factor = number
	public Double parse(List<String> inputs) {
		double term = 0;
		double nextTerm = 0;
		Operator operator;
		while (!inputs.isEmpty()) {
			try {
				term = term + nextTerm(inputs);
				operator = nextOperator(inputs);
				switch (operator) {
					case ADD:
						nextTerm = nextTerm(inputs);
						term = term + nextTerm;
						break;
					case SUBTRACT:
						nextTerm = nextTerm(inputs);
						term = term - nextTerm;
						break;
					case NONE:
						break;
					default:
						throw new IllegalArgumentException();
				}
			} catch (IllegalArgumentException e) {
				return null;
			}
		}
		return term;
	}
	
	public Operator nextOperator(List<String> inputs) {
		if (!inputs.isEmpty()) {
			String input = inputs.remove(0);
			if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
				throw new IllegalArgumentException();
			}
			if (input == addOperator) {
				return Operator.ADD;
			}
			if (input == subtractOperator) {
				return Operator.SUBTRACT;
			}
			if (input == multiplyOperator) {
				return Operator.MULTIPLY;
			}
			if (input == divideOperator) {
				return Operator.DIVIDE;
			}
		}
		return Operator.NONE;
	}
	
	public double nextTerm(List<String> inputs) {
		double term = 0;
		double nextTerm = 0;
		while (!inputs.isEmpty()) {
			String input = inputs.remove(0);
			if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
				try {
					int digit = Integer.parseInt(input);
					term = term * 10 + digit;
				} catch (NumberFormatException e) {
					// This shouldn't happen
					System.out.println("Oops!");
				}
			} else {
				inputs.add(0, input);
				break;
			}
		}
		Operator operator = nextOperator(inputs);
		switch (operator) {
			case ADD:
				inputs.add(0, addOperator);
				break;
			case SUBTRACT:
				inputs.add(0, subtractOperator);
				break;
			case MULTIPLY:
				nextTerm = nextTerm(inputs);
				term = term * nextTerm;
				break;
			case DIVIDE:
				nextTerm = nextTerm(inputs);
				if (nextTerm == 0) {
					throw new IllegalArgumentException();
				}
				term = term / nextTerm;
				break;
			case NONE:
				break;
			default:
				throw new IllegalArgumentException();
		}
		return term;
	}
	
}
