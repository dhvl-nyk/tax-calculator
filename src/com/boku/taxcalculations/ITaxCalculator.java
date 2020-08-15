package com.boku.taxcalculations;

public interface ITaxCalculator
{
	double calculateTax(double price, double tax, boolean imported);

	double getTaxBasedOnProductType(String country, String type);

}
