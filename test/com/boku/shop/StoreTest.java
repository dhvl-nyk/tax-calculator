package com.boku.shop;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class StoreTest {

  private Store storeUnderTest;

  @Before
  public void setUp() {
    storeUnderTest = new Store();
  }

  @Test
  public void testretrieveOrderAndCheckIn() {
    // Run the test
    storeUnderTest.retrieveOrderAndCheckIn("chocolate bar", 0.0, false, 1);
    storeUnderTest.retrieveOrderAndCheckIn(
      "imported bottle of perfume",
      0.0,
      true,
      0
    );
    // Verify the results
    assertEquals(2, storeUnderTest.getCart().getCartSize());
  }
}
