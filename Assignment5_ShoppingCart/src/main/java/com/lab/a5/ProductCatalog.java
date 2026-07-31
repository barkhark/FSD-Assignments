package com.lab.a5;

import java.util.ArrayList;
import java.util.List;

/** Static in-memory catalog of products (no DB required for this assignment). */
public class ProductCatalog {
    private static final List<Product> PRODUCTS = new ArrayList<>();
    static {
        PRODUCTS.add(new Product(1, "Wireless Mouse", 499.00));
        PRODUCTS.add(new Product(2, "Mechanical Keyboard", 2499.00));
        PRODUCTS.add(new Product(3, "USB-C Hub", 1299.00));
        PRODUCTS.add(new Product(4, "27-inch Monitor", 15999.00));
        PRODUCTS.add(new Product(5, "Laptop Stand", 899.00));
    }
    public static List<Product> getAllProducts() { return PRODUCTS; }
    public static Product getById(int id) {
        for (Product p : PRODUCTS) if (p.getId() == id) return p;
        return null;
    }
}
