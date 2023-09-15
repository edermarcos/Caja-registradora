package org.example;

import org.example.models.Product;
import org.example.storage.Database;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {
    Database database = new Database();
    Product product = database.getByIndex(0);
    System.out.println(Arrays.toString(database.getAll()));
  }
}