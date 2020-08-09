package com.boku.products;

public abstract class Product
{
	
	protected String name;
	protected double price;
	protected Boolean imported;
	protected int quantity;
	protected double taxedCost;

	public Product() {
		this.name = "";
		this.price = 0.0;
		this.imported = false;
		this.quantity = 0;
		this.taxedCost = 0.0;
	}
	
	public Product(String name, double price, boolean imported, int quantity) {
		this.name = name;
		this.price = price * quantity;
		this.imported = imported;
		this.quantity = quantity;
	}

	public abstract Product createProduct(String name, double price, boolean imported, int quantity);

	public abstract double getTaxValue(String country);

	public String getName()
	{
		return name;
	}

 	public double getPrice() {
		return price;
	}

	/**
	 * Calculates the price for the number of items mentioned in the quantity.
	 */
	public void setPrice(double price) {
		this.price = price * quantity;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
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
