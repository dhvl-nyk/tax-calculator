package com.boku.shop;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.boku.billing.PaymentCounter;
import com.boku.billing.Receipt;
import com.boku.products.Product;

import static com.boku.util.Constants.INDIA;


/**
 * The ShoppingStore deals with getting a sales order and populating shopping basket and billing
 */
public class Store
{
	private ShoppingBasket shoppingBasket;
	private StoreShelf storeShelf;
	private PaymentCounter paymentCounter;
	private String country;
	
	public Store() {
		country = INDIA;
		shoppingBasket = new ShoppingBasket();
		storeShelf = new StoreShelf();
		paymentCounter = new PaymentCounter(country);
	}

	/**
	 * Gets the order
	 * @param orderItems
	 */
	public void getSalesOrder(List<String> orderItems)
	{
		orderItems.stream().forEach(orderItem -> {
			String[] split = orderItem.split(" ");
			String[] productName = Arrays.copyOfRange(split, 1, (split.length - 2) );
			String name = Arrays.stream(productName).collect(Collectors.joining(" "));
			double price = Double.parseDouble(split[split.length-1]);
			boolean imported = isImported(orderItem);
			int quantity = Integer.parseInt(split[0]);
			retrieveOrderAndCheckIn(name, price, imported, quantity);
		});
	}

	private boolean isImported(String orderItem) {
		if (orderItem.contains("imported")){
			return true;
		}
		return false;
	}

	/**
	 * Retrieves order items and places in cart.
	 */
	public void retrieveOrderAndCheckIn(String name, double price, boolean imported, int quantity)
	{
		Product product = storeShelf.searchAndRetrieveItemFromShelf(name, price, imported, quantity);
		shoppingBasket.addItemToCart(product);
	}
	
	/**
	 * Performs billing operation of purchased order and generates receipt.
	 */
	public void checkOut() {
		paymentCounter.billItemsInCart(shoppingBasket);
		Receipt receipt = paymentCounter.getReceipt();
		paymentCounter.printReceipt(receipt);
	}
	
	public ShoppingBasket getCart()
	{
		return shoppingBasket;
	}

	public PaymentCounter getPaymentCounter()
	{
		return paymentCounter;
	}

}

