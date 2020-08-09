package com.boku.products;
import com.boku.util.Constants;

import static com.boku.util.Constants.INDIA;

public class MiscellaneousProduct extends Product {


	/**
	 * Default constructor to initialize a new miscellaneous product.
	 */
	public MiscellaneousProduct() {
		super();
	}

	public MiscellaneousProduct(String name, double price, boolean imported, int quantity)
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
		return new MiscellaneousProduct(name, price, imported, quantity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getTaxValue(String country) {
		return country.equalsIgnoreCase(INDIA) ? Constants.TaxRate.MISC_TAX.getTax() : 0;
	}
}
