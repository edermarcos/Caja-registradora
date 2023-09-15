package org.example.models;

public abstract class Product implements Cloneable {
  private String name;
  private int amount;
  private double price;

  public Product() {
  }

  public Product(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    if (amount < 0) {
      throw new IllegalArgumentException("Amount cannot be negative");
    }

    this.amount = amount;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    if (price < 0) {
      throw new IllegalArgumentException("Price cannot be negative");
    }
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product{" +
            "name='" + name + '\'' +
            ", amount=" + amount +
            ", price=" + price +
            '}';
  }

//  @Override
//  public Product clone() {
//    try {
//      Product clone = (Product) super.clone();
//      // TODO: copy mutable state here, so the clone can't change the internals of the original
//      return clone;
//    } catch (CloneNotSupportedException e) {
//      throw new AssertionError();
//    }
//  }
  public Product clone() {
    try {
      return (Product) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError(e);
    }
  }
}
