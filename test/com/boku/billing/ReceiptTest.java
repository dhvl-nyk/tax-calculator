package com.boku.billing;

import com.boku.products.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReceiptTest {

    private Receipt receiptUnderTest;
    private List<Product> productList =  new ArrayList<>();
    private Product product;

    @Before
    public void setUp() {
        product = new Product("book", 10.01, true, 1, "bookProduct");
        productList.add(product);
        product = new Product("packet of headache pills", 20.10, false, 1, "MedicalProduct");
        productList.add(product);
        receiptUnderTest = new Receipt(productList, 2.00, 30.20);
    }

    @Test
    public void testGetTotalNumberOfItems() {
        assertEquals(2.00, receiptUnderTest.getTotalSalesTax(), 0.0);
        assertEquals(30.20, receiptUnderTest.getTotalAmount(), 0.0);

    }

}
