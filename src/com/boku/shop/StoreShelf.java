package com.boku.shop;
import java.util.*;

import com.boku.products.*;


/**
 * The StoreShelf stores all the different categories of product.
 */
public class StoreShelf {

	/** The product items mapped to their respective categories */
	private HashMap<String, Product> productItems;
	
	
	public StoreShelf()
	{
		productItems = new HashMap<>();
		populateProductItems("book", new BookProduct());
		populateProductItems("music CD" , new MiscellaneousProduct());
		populateProductItems("chocolate bar", new FoodProduct());
		populateProductItems("imported box of chocolates" , new FoodProduct());
		populateProductItems("box of imported chocolates" , new FoodProduct());
		populateProductItems("imported bottle of perfume", new MiscellaneousProduct());
		populateProductItems("bottle of perfume", new MiscellaneousProduct());
		populateProductItems("packet of headache pills", new MedicalProduct());
	}
	
	public void populateProductItems(String productItem, Product productCategory)
	{
		productItems.put(productItem, productCategory);
		
	}
	public Product searchAndRetrieveItemFromShelf(String name, double price, boolean imported, int quantity)
	{
		Product productItem = null;
		if (productItems.containsKey(name))
			productItem = productItems.get(name).createProduct(name, price, imported, quantity);
		return productItem;
	}

}

