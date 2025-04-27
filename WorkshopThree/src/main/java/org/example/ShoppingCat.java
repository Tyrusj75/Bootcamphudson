package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCat {
    private List<Product> products; // Store inventory
    private List<Product> cart; // Shopping cart

    public ShoppingCat(List<Product> products) {
        this.products = products;
        this.cart = new ArrayList<>();
    }

    // Add product to cart
    public void addProductToCart(Product product) {
        cart.add(product);
        System.out.println(product.getProductName() + " added to cart.");
    }

    // Remove product from cart by SKU
    public void removeProduct(String sku) {
        Product productToRemove = null;
        for (Product product : cart) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            cart.remove(productToRemove);
            System.out.println(productToRemove.getProductName() + " removed from cart.");
        } else {
            System.out.println("Product with SKU " + sku + " not found in cart.");
        }
    }

    // View all products in the cart
    public void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Products in your cart:");
            for (Product product : cart) {
                System.out.println(product.getProductName() + " - $" + product.getPrice());
            }
        }
    }

    // Get total price of the cart
    public double getCartTotal() {
        return cart.stream().mapToDouble(Product::getPrice).sum();
    }

    // Search products by name, price, or department
    public List<Product> searchProducts(String query) {
        return products.stream()
                .filter(product -> product.getProductName().toLowerCase().contains(query.toLowerCase())
                        || product.getDepartment().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Product> searchProductsByPrice(double price) {
        return products.stream()
                .filter(product -> product.getPrice() == price)
                .collect(Collectors.toList());
    }
}