package org.example;

import java.util.List;
import java.util.Scanner;

public class StoreApp {
    private ShoppingCat shoppingCat;
    private Scanner scanner;

    public StoreApp(List<Product> products) {
        this.shoppingCat = new ShoppingCat(products);
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Store Home Screen ---");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> displayProducts();
                case 2 -> displayCart();
                case 3 -> {
                    System.out.println("Exiting the application...");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayProducts() {
        boolean backToHome = false;
        while (!backToHome) {
            System.out.println("\n--- Products ---");
            List<Product> products = shoppingCat.searchProducts(""); // Display all products
            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                System.out.println((i + 1) + ". " + product.getProductName() + " - $" + product.getPrice());
            }
            System.out.println("Options:");
            System.out.println("1. Search/Filter Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Go Back to Home Screen");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter search query: ");
                    String query = scanner.nextLine();
                    List<Product> filteredProducts = shoppingCat.searchProducts(query);
                    if (filteredProducts.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        System.out.println("Filtered Products:");
                        for (Product product : filteredProducts) {
                            System.out.println(product.getProductName() + " - $" + product.getPrice());
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter product number to add to cart: ");
                    int productNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    if (productNumber > 0 && productNumber <= products.size()) {
                        shoppingCat.addProductToCart(products.get(productNumber - 1));
                    } else {
                        System.out.println("Invalid product number.");
                    }
                }
                case 3 -> backToHome = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void displayCart() {
        boolean backToHome = false;
        while (!backToHome) {
            System.out.println("\n--- Cart ---");
            shoppingCat.viewCart();
            System.out.println("Total: $" + shoppingCat.getCartTotal());
            System.out.println("Options:");
            System.out.println("1. Check Out");
            System.out.println("2. Remove Product from Cart");
            System.out.println("3. Go Back to Home Screen");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.println("Checking out...");
                    System.out.println("Total amount: $" + shoppingCat.getCartTotal());
                    shoppingCat = new ShoppingCat(shoppingCat.searchProducts("")); // Reset cart
                    System.out.println("Thank you for shopping!");
                }
                case 2 -> {
                    System.out.print("Enter SKU of product to remove: ");
                    String sku = scanner.nextLine();
                    shoppingCat.removeProduct(sku);
                }
                case 3 -> backToHome = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
