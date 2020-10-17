package com.boku.taxcalculations;

import static com.boku.util.Constants.INDIA;

import com.boku.taxcalculations.impl.IndiaTaxCalculatorImpl;
import java.util.HashMap;

/**
 * The TaxCalculator returns suitable tax calc logic for a particular region.
 *
 */
public class TaxCalculator {

  private HashMap<String, ITaxCalculator> taxCalculators;

  public TaxCalculator() {
    taxCalculators = new HashMap<>();
    registerCalculator(INDIA, new IndiaTaxCalculatorImpl());
  }

  public void registerCalculator(String strategy, ITaxCalculator taxCalc) {
    taxCalculators.put(strategy, taxCalc);
  }

  public ITaxCalculator getTaxCalculator(String strategy) {
    ITaxCalculator taxCalc = taxCalculators.get(strategy);
    return taxCalc;
  }
}
