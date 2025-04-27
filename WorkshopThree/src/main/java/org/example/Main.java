package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Loading csv file...");
        List<Product> products = FileLoader.readfile();

        for(Product product: products){
            System.out.println(product.getProductName());

            StoreApp storeApp = new StoreApp(products);
            storeApp.start();
        }

    }
}