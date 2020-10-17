package com.boku.billing;

import com.boku.products.Product;
import java.util.List;

/**
 * The Receipt is final bill to be displayed
 */
public class Receipt {

  private List<Product> productList;

  private double totalSalesTax;

  private double totalAmount;

  public Receipt(List<Product> prod, double totalTax, double totalAmount) {
    productList = prod;
    totalSalesTax = totalTax;
    this.totalAmount = totalAmount;
  }

  public double getTotalSalesTax() {
    return totalSalesTax;
  }

  public double getTotalAmount() {
    return totalAmount;
  }

  @Override
  public String toString() {
    String receipt = "";

    for (Product prod : productList) {
      receipt += (prod != null) ? (prod.toString() + "\n") : "";
    }

    receipt += "Sales Taxes:  " + totalSalesTax + "\n";
    receipt += "Total: " + totalAmount + "\n";

    return receipt;
  }
}
