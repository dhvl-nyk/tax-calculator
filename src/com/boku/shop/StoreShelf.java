package com.boku.shop;
import java.util.*;

import com.boku.dao.IInputProvider;
import com.boku.dao.InputService;
import com.boku.products.*;

/**
 * The StoreShelf stores all the different categories of product.
 */
public class StoreShelf {
	InputService inputService = new InputService();
	/** The product items mapped to their respective categories */
	private HashMap<String, String> productItems;
	public StoreShelf(String inputType)
	{
		productItems = inputService.getInputProvider(inputType).fetchInput();
	}
	public Product searchAndRetrieveItemFromShelf(String name, double price, boolean imported, int quantity)
	{
		Product productItem = null;
		if (productItems.containsKey(name)) {
			String productType = productItems.get(name);
			productItem = new Product(name, price, imported, quantity, productType);
		}
		return productItem;
	}
}