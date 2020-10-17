package com.boku.billing;

import com.boku.products.Product;
import com.boku.taxcalculations.ITaxCalculator;
import com.boku.util.MathUtil;
import java.util.List;

/**
 * The BillGenerator computes the product's total cost.
 */
public class BillGenerator {

  ITaxCalculator taxCalculator;

  public BillGenerator(ITaxCalculator taxCalc) {
    taxCalculator = taxCalc;
  }

  /**
   * Calculates the total product tax using tax calculator.
   */
  public double calculateTax(
    double price,
    double basicSalesTax,
    boolean imported
  ) {
    double totalProductTax = taxCalculator.calculateTax(
      price,
      basicSalesTax,
      imported
    );
    return totalProductTax;
  }

  /**
   * Calculates the taxed cost of the product which is the sum of the original price and tax value.
   */
  public double calcTotalProductPrice(double productPrice, double tax) {
    return MathUtil.truncate(productPrice + tax);
  }

  public double calcTotalTax(List<Product> prodList) {
    double totalTax = 0.0;

    //Calculates the tax value which is the difference between the producuct with tax and orginal
    // shelf product price.
    for (Product product : prodList) totalTax +=
      (product != null) ? (product.getTaxedCost() - product.getPrice()) : 0.0;

    return MathUtil.truncate(totalTax);
  }

  /**
   * Computes the net amount of all the products
   */
  public double calcTotalAmount(List<Product> productList) {
    double totalAmount = 0.0;

    for (Product product : productList) totalAmount +=
      (product != null) ? product.getTaxedCost() : 0.0;

    return MathUtil.truncate(totalAmount);
  }

  public Receipt createNewReceipt(
    List<Product> productList,
    double totalTax,
    double totalAmount
  ) {
    return new Receipt(productList, totalTax, totalAmount);
  }

  public void generateReceipt(Receipt r) {
    String receipt = r.toString();
    System.out.println(receipt);
  }
}
