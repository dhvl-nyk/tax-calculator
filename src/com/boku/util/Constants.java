package com.boku.util;

public class Constants {

  public static final String INDIA = "INDIA";
  public static final String INMEMORY = "INMEMORY";
  public static final String DATABASE = "DATABASE";

  public enum TaxRate {
    BOOK_TAX(0.0),
    FOOD_TAX(0.0),
    MEDICAL_TAX(0.0),
    MISC_TAX(0.10);

    private double itemTaxValue;

    TaxRate(double taxValue) {
      itemTaxValue = taxValue;
    }

    public double getTax() {
      return itemTaxValue;
    }
  }
}
