# Extreme IT Products Application

> **Module:** COM 1321 – Object-Oriented Programming  
> **Assignment:** Assignment 1  
> **Institution:** University of Venda  
> **Author:** Mudzanani Riise precious
> **Student Number:** 26006661  

---

## Overview

**Extreme IT Products** is a local IT hardware supplier. This application was built for their new outlet to help staff **capture, search, update, delete, and report** on the products they sell. 

It is a fully menu-driven console application designed using Object-Oriented Programming (OOP) principles. Everything is navigated using numeric menu selections, and all product data is securely kept in memory for the duration of the program run.

---

##  Features

* **Interactive Navigation:** Displays a welcome banner and a clear, user-friendly main menu.
* **Product Capture:** Captures product details including:
  * Product Code
  * Product Name
  * Category *(with input validation loop for choices 1–5)*
  * Warranty *(applies 6-month or 2-year warranty based on input)*
  * Price *(validates numeric inputs)*
  * Stock Level *(validates integer inputs)*
  * Supplier Name
* **Product Search:** Instant lookup of products by product code (case-insensitive).
* **Product Update:** Selectively update warranty, price, and/or stock level for existing products.
* **Product Deletion:** Removes a product from memory after user confirmation (`y`/`n`).
* **Detailed Reporting:** Generates a full inventory report featuring:
  * Detailed layout for each item
  * Total product count
  * Total combined inventory value
  * Average product value
* **Robust Error Handling:** Re-prompts the user on invalid menu choices, categories, or non-numeric entries without crashing.

---

## Class Structure

The program is structured into dedicated classes, each maintaining clear separation of responsibilities:

| Class | Responsibility |
| :--- | :--- |
| **`Product`** | Data model storing one product's attributes with encapsulation (private fields, getters/setters, and display methods). |
| **`ReportData`** | Aggregates and calculates summary totals (count, total value, average value) and prints formatted reports. |
| **`Products`** | Core business logic manager. Contains the dynamic `ArrayList<Product>` and methods: `displayMenu()`, `captureProduct()`, `saveProduct()`, `searchProduct()`, `updateProduct()`, `deleteProduct()`, `printReport()`, and `exitApplication()`. |
| **`ASSIGNMENT1` / `Main`** | Main entry point containing the loop execution and dispatching menu choices. |

> **Note:** An `ArrayList<Product>` is utilized inside the `Products` class because the total number of products captured isn't known in advance.


# Run the application
java -cp bin com.mycompany.assignment1.ASSIGNMENT1
