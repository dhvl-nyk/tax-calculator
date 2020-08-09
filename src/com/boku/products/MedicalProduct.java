package com.boku.products;


import com.boku.util.Constants;

import static com.boku.util.Constants.INDIA;

/**
 * MedicalProduct is an item belonging to the category 'Medical' in the shopping store.
 *
 */
public class MedicalProduct extends Product {


	public MedicalProduct()
	{
		super();
	}

	public MedicalProduct(String name, double price, boolean imported, int quantity)
	{
		super(name, price, imported, quantity);
		
	}

	/**
	 *
	 * @param name
	 * @param price
	 * @param imported
	 * @param quantity
	 * @return
	 */
	@Override
	public Product createProduct(String name, double price, boolean imported, int quantity) {
		 return new MedicalProduct(name, price, imported, quantity);
	}

	@Override
	public double getTaxValue(String country) {
		return country.equalsIgnoreCase(INDIA) ? Constants.TaxRate.MEDICAL_TAX.getTax() : 0;
	}

}
