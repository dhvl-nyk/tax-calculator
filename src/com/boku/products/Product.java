package com.boku.products;

import com.boku.taxcalculations.ITaxCalculator;
import com.boku.taxcalculations.impl.IndiaTaxCalculatorImpl;

public class Product
{

	protected String name;
	protected double price;
	protected Boolean imported;
	protected int quantity;
	protected double taxedCost;
	protected String type;

	ITaxCalculator taxCalculator = new IndiaTaxCalculatorImpl();

	public Product(String name, double price, boolean imported, int quantity, String type) {
		this.name = name;
		this.price = price * quantity;
		this.imported = imported;
		this.quantity = quantity;
		this.type = type;
	}

	public double getTaxValue(String country, String type) {
		return taxCalculator.getTaxBasedOnProductType(country, type);
	}

	public String getName()
	{
		return name;
	}

 	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}
	/**
	 * Calculates the price for the number of items mentioned in the quantity.
	 */
	public boolean isImported() {
		return imported;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTaxedCost() {
		return taxedCost;
	}

	public void setTaxedCost(double taxedCost) {
		this.taxedCost = taxedCost;
	}

	@Override
	public String toString() {
		return (quantity + " " + isImported(imported) + " " + name + " : " + taxedCost);
	}
	
	public String isImported(boolean imported) {
		return imported == false ? "" :"imported";
	}
}
