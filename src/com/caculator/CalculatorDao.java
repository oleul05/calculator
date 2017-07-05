package com.caculator;

import java.text.DecimalFormat;

public class CalculatorDao {
	
	public static double add (double num1, double num2) { //Pass the two number as parameter
		double addition = num1 + num2; //Add two number
		addition =Double.parseDouble(new DecimalFormat("##.####").format(addition)); //Only show two decimal after floating point
		return addition; //return the result
	}
	
	public static double sub (double num1, double num2) {
		double subtraction = num1 - num2;
		subtraction =Double.parseDouble(new DecimalFormat("##.####").format(subtraction));
		return subtraction;
	}
	
	public static double multiplication (double num1, double num2) {
		double multiplication = num1 * num2;
		return multiplication;
	}
	
	public static double div (double num1, double num2) {
		double division = num1 / num2;
		division =Double.parseDouble(new DecimalFormat("##.####").format(division));
		return division;
	}
}
