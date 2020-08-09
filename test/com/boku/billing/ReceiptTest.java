package com.boku.billing;

import com.boku.products.BookProduct;
import com.boku.products.FoodProduct;
import com.boku.products.MedicalProduct;
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
    private MedicalProduct medicalProduct;
    private FoodProduct foodProduct;

    @Before
    public void setUp() {
        medicalProduct = new MedicalProduct("book", 10.01, true, 1);
        foodProduct = new FoodProduct("packet of headache pills", 20.10, false, 1);
        productList.add(medicalProduct);
        productList.add(foodProduct);
        receiptUnderTest = new Receipt(productList, 2.00, 30.20);
    }

    @Test
    public void testGetTotalNumberOfItems() {
        assertEquals(2.00, receiptUnderTest.getTotalSalesTax(), 0.0);
        assertEquals(30.20, receiptUnderTest.getTotalAmount(), 0.0);

    }

}
