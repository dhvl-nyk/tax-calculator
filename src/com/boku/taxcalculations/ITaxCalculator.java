package com.boku.taxcalculations;

public interface ITaxCalculator
{
	public double calculateTax(double price, double tax, boolean imported);
	
}
