package com.boku.shop;

import com.boku.products.Product;
import java.util.ArrayList;
import java.util.List;

/**
 * The ShoppingBasket populates product information.
 */
public class ShoppingBasket {

  private List<Product> productList;

  public ShoppingBasket() {
    productList = new ArrayList<>();
  }

  public void addItemToCart(Product product) {
    productList.add(product);
  }

  public List<Product> getItemsFromCart() {
    return productList;
  }

  public int getCartSize() {
    return productList.size();
  }
}
