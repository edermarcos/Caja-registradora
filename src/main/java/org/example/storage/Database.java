package org.example.storage;

import org.example.models.Meat;
import org.example.models.Potato;
import org.example.models.Product;
import org.example.models.Rice;

import java.util.ArrayList;
import java.util.List;

public class Database {
  private final Product[] products;
  private List<Product> purchases;
  private List<Product> sales;

  public Database() {
    products = new Product[]{
            new Potato("French fries").clone(),
            new Rice("Tia Rosa").clone(),
            new Meat("Lomo fino").clone()
    };
    purchases = new ArrayList<>();
    sales = new ArrayList<>();
  }

  private void validateIndex(int index) {
    if (index < 0 || index >= products.length) {
      throw new IllegalArgumentException("Index out of bounds");
    }
  }

  public Product getByIndex(int index) {
    validateIndex(index);
    return products[index].clone();
  }

  public Product[] getAll() {
    return products;
  }

  private Product getTempByClassName(String className) {
    switch (className) {
      case "Potato":
        return products[0];

      case "Rice":
        return products[1];

      case "Meat":
        return products[2];

      default:
        throw new IllegalArgumentException("Invalid product type");
    }
  }

  public void addPurchase(Product product) {
    Product temp = getTempByClassName(product.getClass().getSimpleName());
    temp.setAmount(temp.getAmount() + product.getAmount());
    temp.setPrice(product.getPrice());

    purchases.add(product);
  }

  public void addSale(Product product) {
    Product temp = getTempByClassName(product.getClass().getSimpleName());
    temp.setAmount(temp.getAmount() - product.getAmount());

    product.setPrice(temp.getPrice() * 1.25);
    sales.add(product);
  }

  public List<Product> getPurchases() {
    return purchases;
  }

  public List<Product> getSales() {
    return sales;
  }
}
