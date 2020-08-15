package com.boku.billing;

import java.util.List;

import com.boku.products.Product;
import com.boku.shop.ShoppingBasket;
import com.boku.taxcalculations.ITaxCalculator;
import com.boku.taxcalculations.TaxCalculator;

/**
 * The PaymentCounter  performs billing of items in the cart and generates the receipt.
 */
public class PaymentCounter
{

	private BillGenerator bill;
	private Receipt receipt;
	private List<Product> productList;
	private String country;
	
	public PaymentCounter(String country) {
		this.country = country;
	}
	
	public void billItemsInCart(ShoppingBasket cart) {
		productList = cart.getItemsFromCart();
		
		for(Product product : productList)
		{
			bill = getBill(country);

			if (product != null) {
				//computes the total tax of product by a regional tax rates
				double productTax = bill.calculateTax(product.getPrice(), product.getTaxValue(country, product.getType()), product.isImported());

				//computes the product price with tax
				double taxedCost = bill.calcTotalProductPrice(product.getPrice(), productTax);

				product.setTaxedCost(taxedCost);
			}
		}
		
	}
	
	public Receipt getReceipt()
	{
		double totalTax = bill.calcTotalTax(productList);
		double totalAmount = bill.calcTotalAmount(productList);
		receipt = bill.createNewReceipt(productList, totalTax, totalAmount);
		return receipt;
	}
	
	public void printReceipt(Receipt receipt)
	{
		bill.generateReceipt(receipt);
	}
	
	public BillGenerator getBill(String strategy)
	{
		TaxCalculator taxCalculator = new TaxCalculator();
		ITaxCalculator taxCal = taxCalculator.getTaxCalculator(strategy);
		return new BillGenerator(taxCal);
	}

}
