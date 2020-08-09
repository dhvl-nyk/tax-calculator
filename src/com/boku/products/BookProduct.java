package com.boku.products;


import com.boku.util.Constants;

import static com.boku.util.Constants.INDIA;


public class BookProduct extends Product {

	public BookProduct() {
		super();
	}


	public BookProduct(String name, double price, boolean imported, int quantity) {
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
		return new BookProduct(name, price, imported, quantity);
	}

	@Override
	public double getTaxValue(String country) {
			return country.equalsIgnoreCase(INDIA) ? Constants.TaxRate.BOOK_TAX.getTax() : 0;
	}
}
