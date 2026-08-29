/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Author: Mudzanani Riise precious
 * Student Number: 26006661
 * Module: COM 1321 - Object Oriented Programming
 */


// 1. PRODUCT CLASS

class Product {

    private String productCode;
    private String productName;
    private String productCategory;
    private String warranty;
    private double price;
    private int stockLevel;
    private String supplier;

    public Product(String productCode, String productName, String productCategory,
                   String warranty, double price, int stockLevel, String supplier) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.warranty = warranty;
        this.price = price;
        this.stockLevel = stockLevel;
        this.supplier = supplier;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

   
    public void displayDetails() {
        System.out.println("PRODUCT CODE >>       " + productCode);
        System.out.println("PRODUCT NAME >>       " + productName);
        System.out.println("PRODUCT CATEGORY >>   " + productCategory);
        System.out.println("PRODUCT WARRANTY >>   " + warranty);
        System.out.println("PRODUCT PRICE >>      R " + price);
        System.out.println("PRODUCT LEVEL >>      " + stockLevel);
        System.out.println("PRODUCT SUPPLIER >>   " + supplier);
    }
}


// 2. REPORT DATA CLASS

class ReportData {

    private List<Product> products;
    private int totalProductCount;
    private double totalProductValue;
    private double averageProductValue;

    public ReportData(List<Product> products) {
        this.products = products;
        calculateTotals();
    }

    private void calculateTotals() {
        int count = products.size();
        double total = 0.0;

        for (Product product : products) {
            total += product.getPrice();
        }

        double average = (count > 0) ? (total / count) : 0.0;

        this.totalProductCount = count;
        this.totalProductValue = total;
        this.averageProductValue = average;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        calculateTotals();
    }

    public int getTotalProductCount() {
        return totalProductCount;
    }

    public void setTotalProductCount(int totalProductCount) {
        this.totalProductCount = totalProductCount;
    }

    public double getTotalProductValue() {
        return totalProductValue;
    }

    public void setTotalProductValue(double totalProductValue) {
        this.totalProductValue = totalProductValue;
    }

    public double getAverageProductValue() {
        return averageProductValue;
    }

    public void setAverageProductValue(double averageProductValue) {
        this.averageProductValue = averageProductValue;
    }

    public void printReport() {
        System.out.println("PRODUCT REPORT");
        System.out.println("=".repeat(60));

        int index = 1;
        for (Product product : products) {
            System.out.println("PRODUCT " + index);
            System.out.println("-".repeat(60));
            product.displayDetails();
            System.out.println("-".repeat(60));
            index++;
        }

        System.out.println("=".repeat(60));
        System.out.println("TOTAL PRODUCT COUNT: " + totalProductCount);
        System.out.println("TOTAL PRODUCT VALUE: R " + totalProductValue);
        System.out.printf("AVERAGE PRODUCT VALUE: R %.0f%n", averageProductValue);
        System.out.println("=".repeat(60));
    }
}


// 3. PRODUCTS MANAGEMENT CLASS

class Products {

    private List<Product> productList;
    private Scanner scanner;

    public Products(Scanner scanner) {
        this.productList = new ArrayList<>();
        this.scanner = scanner;
    }

    public int displayMenu() {
        int choice = -1;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println();
            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new product.");
            System.out.println("(2) Search for a product.");
            System.out.println("(3) Update a product.");
            System.out.println("(4) Delete a product.");
            System.out.println("(5) Print report.");
            System.out.println("(6) Exit Application.");
            System.out.print("Enter your choice >> ");

            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= 6) {
                    validChoice = true;
                } else {
                    System.out.println("Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 6.");
            }
        }

        return choice;
    }

    public void captureProduct() {
        System.out.println();
        System.out.println("CAPTURE A NEW PRODUCT");
        System.out.println("*".repeat(30));

        System.out.print("Enter the product code: ");
        String code = scanner.nextLine().trim();

        System.out.print("Enter the product name: ");
        String name = scanner.nextLine().trim();

        String category = selectProductCategory();
        String warranty = selectWarranty(name);

        double price = readDouble("Enter the price for " + name + " >> ");
        int stockLevel = readInt("Enter the stock level for " + name + " >> ");

        System.out.print("Enter the supplier for " + name + " >> ");
        String supplier = scanner.nextLine().trim();

        Product product = new Product(code, name, category, warranty, price, stockLevel, supplier);
        saveProduct(product);

        System.out.println("Product details has been saved successfully!!!");
    }

    public void saveProduct(Product product) {
        productList.add(product);
    }

    private String selectProductCategory() {
        String category = null;

        while (category == null) {
            System.out.println("Select the product category:");
            System.out.println("Desktop Computer - 1");
            System.out.println("Laptop - 2");
            System.out.println("Tablet - 3");
            System.out.println("Printer - 4");
            System.out.println("Gaming Console - 5");
            System.out.print("Product Category >> ");

            String input = scanner.nextLine().trim();

            
            switch (input) {
                case "1":
                    category = "Desktop Computer";
                    break;
                case "2":
                    category = "Laptop";
                    break;
                case "3":
                    category = "Tablet";
                    break;
                case "4":
                    category = "Printer";
                    break;
                case "5":
                    category = "Gaming Console";
                    break;
                default:
                    System.out.println("Invalid category. Please select a valid product category.");
            }
        }

        return category;
    }

    private String selectWarranty(String productName) {
        System.out.print("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years. ");
        String input = scanner.nextLine().trim();

        if (input.equals("1")) {
            return "6 months";
        } else {
            return "2 years";
        }
    }

    public void searchProduct() {
        System.out.println();
        System.out.print("Please enter the product code to search: ");
        String code = scanner.nextLine().trim();

        Product found = findProductByCode(code);

        if (found != null) {
            System.out.println("*".repeat(60));
            System.out.println("PRODUCT SEARCH RESULTS");
            System.out.println("*".repeat(60));
            found.displayDetails();
            System.out.println("*".repeat(60));
        } else {
            System.out.println("The product cannot be located. Invalid Product");
        }
    }

    public void deleteProduct() {
        System.out.println();
        System.out.print("Please enter the product code to delete: ");
        String code = scanner.nextLine().trim();

        Product found = findProductByCode(code);

        if (found == null) {
            System.out.println("The product cannot be located. Invalid Product");
            return;
        }

        System.out.print("Are you sure you want to delete " + found.getProductName() + "? (y) Yes, (n) No ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y")) {
            productList.remove(found);
            System.out.println("Product deleted successfully!!!");
        } else {
            System.out.println("Delete cancelled.");
        }
    }

    public void updateProduct() {
        System.out.println();
        System.out.print("Please enter the product code to update: ");
        String code = scanner.nextLine().trim();

        Product found = findProductByCode(code);

        if (found == null) {
            System.out.println("The product cannot be located. Invalid Product");
            return;
        }

        System.out.print("Update the warranty? (y) Yes, (n) No ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            String newWarranty = selectWarranty(found.getProductName());
            found.setWarranty(newWarranty);
        }

        System.out.print("Update the product price? (y) Yes, (n) No ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            double newPrice = readDouble("Enter the new price for " + found.getProductName() + " >> ");
            found.setPrice(newPrice);
        }

        System.out.print("Update the stock level? (y) Yes, (n) No ");
        if (scanner.nextLine().trim().equalsIgnoreCase("y")) {
            int newStock = readInt("Enter the new stock level for " + found.getProductName() + " >> ");
            found.setStockLevel(newStock);
        }

        System.out.println("Product details has been updated successfully!!!");
    }

    public void printReport() {
        System.out.println();
        ReportData report = new ReportData(productList);
        report.printReport();
    }

    public void exitApplication() {
        System.out.println();
        System.out.println("Thank you for using the Bright Future Technologies Application. Goodbye!");
    }

    private Product findProductByCode(String code) {
        for (Product product : productList) {
            if (product.getProductCode().equalsIgnoreCase(code)) {
                return product;
            }
        }
        return null;
    }

    private double readDouble(String prompt) {
        double value = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                value = Double.parseDouble(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }

        return value;
    }

    private int readInt(String prompt) {
        int value = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                value = Integer.parseInt(input);
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }

        return value;
    }
}

// 4. MAIN PUBLIC CLASS (MUST MATCH FILE NAME)

public class ASSIGNMENT1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Products products = new Products(scanner);
        boolean running = true;

        while (running) {
            System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
            System.out.println("*".repeat(40));
            System.out.print("Enter (1) to launch menu or any other key to exit ");
            String launchInput = scanner.nextLine().trim();

            if (!launchInput.equals("1")) {
                running = false;
                break;
            }

            boolean inMenu = true;
            while (inMenu) {
                int choice = products.displayMenu();

                
                switch (choice) {
                    case 1:
                        products.captureProduct();
                        break;
                    case 2:
                        products.searchProduct();
                        break;
                    case 3:
                        products.updateProduct();
                        break;
                    case 4:
                        products.deleteProduct();
                        break;
                    case 5:
                        products.printReport();
                        break;
                    case 6:
                        products.exitApplication();
                        inMenu = false;
                        running = false;
                        break;
                        
                }

                if (inMenu) {
                    System.out.print("Enter (1) to launch menu or any other key to exit ");
                    String again = scanner.nextLine().trim();
                    if (!again.equals("1")) {
                        inMenu = false;
                        running = false;
                    }
                }
            }
        }

        scanner.close();
    }
}