package org.example;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    public static List<Product> readfile(){
       try{
           FileReader fileReader = new FileReader("src/main/resources/products.csv");
           BufferedReader bufferedReader = new BufferedReader(fileReader);

           bufferedReader.readLine();

           String input;

           List<Product> productList = new ArrayList<>();
           while((input = bufferedReader.readLine()) != null){

                   String[] row = input.split("\\|");
                   String sku = row[0];
                   String productName = row[1];
                   double price = Double.parseDouble(row[2]);
                   String department = row[3];
                   Product product = new Product(sku, productName, price, department);
                   productList.add(product);
               }

               bufferedReader.close();

               return productList;
       }
       catch(IOException ex){
               System.out.println("Failed to read file");
               ex.printStackTrace();
               return new ArrayList<>();

       }

}
    }