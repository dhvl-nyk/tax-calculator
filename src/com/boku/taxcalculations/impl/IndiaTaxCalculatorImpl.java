package com.boku.taxcalculations.impl;

import com.boku.taxcalculations.ITaxCalculator;
import com.boku.util.MathUtil;

public class IndiaTaxCalculatorImpl implements ITaxCalculator
{

	@Override
	public double calculateTax(double price, double localTax, boolean imported)
	{
		//Calculates basic sales tax
		double tax = price * localTax;
		
		//condition for import duty
		if(imported == true)
		{
			tax += (price * 0.05);
		}
		
		//rounds off to nearest 0.05
		tax = MathUtil.roundoff(tax, 0.05);
		
		return tax;
	}

}
