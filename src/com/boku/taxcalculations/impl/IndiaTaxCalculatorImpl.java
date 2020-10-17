package com.boku.taxcalculations.impl;

import static com.boku.util.Constants.INDIA;

import com.boku.taxcalculations.ITaxCalculator;
import com.boku.util.Constants;
import com.boku.util.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class IndiaTaxCalculatorImpl implements ITaxCalculator {

  @Override
  public double calculateTax(double price, double localTax, boolean imported) {
    //Calculates basic sales tax
    double tax = price * localTax;

    //condition for import duty
    if (imported) {
      tax += (price * 0.05);
    }

    //rounds off to nearest 0.05
    tax = MathUtil.roundoff(tax, 0.05);

    return tax;
  }

  @Override
  public double getTaxBasedOnProductType(String country, String type) {
    if (type.equalsIgnoreCase("BookProduct")) return country.equalsIgnoreCase(
        INDIA
      )
      ? Constants.TaxRate.BOOK_TAX.getTax()
      : 0;
    if (
      type.equalsIgnoreCase("MiscellaneousProduct")
    ) return country.equalsIgnoreCase(INDIA)
      ? Constants.TaxRate.MISC_TAX.getTax()
      : 0;
    if (type.equalsIgnoreCase("FoodProduct")) return country.equalsIgnoreCase(
        INDIA
      )
      ? Constants.TaxRate.FOOD_TAX.getTax()
      : 0;
    if (
      type.equalsIgnoreCase("MedicalProduct")
    ) return country.equalsIgnoreCase(INDIA)
      ? Constants.TaxRate.MEDICAL_TAX.getTax()
      : 0; else return 0D;
  }
}
