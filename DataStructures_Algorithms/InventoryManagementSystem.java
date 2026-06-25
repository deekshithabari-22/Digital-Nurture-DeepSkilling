// Exercise 1: Inventory Management System

/*
------------------------------------------------------------
1. Understanding the Problem
------------------------------------------------------------

Why are Data Structures and Algorithms Important?
-------------------------------------------------

In a warehouse inventory system, thousands or even millions
of products may exist.

Efficient data structures and algorithms help in:

1. Fast product search
2. Quick updates
3. Efficient deletion
4. Reduced memory usage
5. Better performance for large inventories

Without efficient algorithms:
- Searching becomes slow
- Updates take more time
- System performance decreases


------------------------------------------------------------
Suitable Data Structures
------------------------------------------------------------

1. ArrayList
   - Dynamic array
   - Easy insertion
   - Slower searching (O(n))

2. HashMap
   - Stores data using key-value pairs
   - Very fast search, update, delete
   - Average complexity: O(1)

3. LinkedList
   - Efficient insertion/deletion
   - Slow searching

4. TreeMap
   - Stores data in sorted order
   - Complexity: O(log n)

For Inventory Management:
HashMap is most suitable because:
1. Fast retrieval
2. Fast updates
3. Fast deletion
4. ProductId can act as unique key


------------------------------------------------------------
2. Setup
------------------------------------------------------------

Create:
1. Product class
2. InventoryManagement class

Use:
HashMap<Integer, Product>

Key   -> productId
Value -> Product object


------------------------------------------------------------
3. Implementation
------------------------------------------------------------
*/

import java.util.HashMap;
import java.util.Map;


// PRODUCT CLASS

class Products {

    int productId;
    String productName;
    int quantity;
    double price;

    Products(int productId,
            String productName,
            int quantity,
            double price) {

        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }


    void display() {

        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Price        : " + price);
    }
}



// INVENTORY MANAGEMENT CLASS

public class InventoryManagementSystem {

    // HashMap for storing products

    static HashMap<Integer, Products> inventory =
            new HashMap<>();


    // ADD PRODUCT

    static void addProduct(Products product) {

        inventory.put(product.productId, product);

        System.out.println("Product Added Successfully");
    }


    // UPDATE PRODUCT

    static void updateProduct(int productId,
                              int newQuantity,
                              double newPrice) {

        if (inventory.containsKey(productId)) {

            Products product = inventory.get(productId);

            product.quantity = newQuantity;
            product.price = newPrice;

            System.out.println("Product Updated Successfully");
        }

        else {
            System.out.println("Product Not Found");
        }
    }


    // DELETE PRODUCT

    static void deleteProduct(int productId) {

        if (inventory.containsKey(productId)) {

            inventory.remove(productId);

            System.out.println("Product Deleted Successfully");
        }

        else {
            System.out.println("Product Not Found");
        }
    }


    // DISPLAY ALL PRODUCTS

    static void displayInventory() {

        System.out.println("\n===== INVENTORY =====");

        for (Map.Entry<Integer, Products> entry
                : inventory.entrySet()) {

            entry.getValue().display();

            System.out.println("---------------------");
        }
    }


    // MAIN METHOD

    public static void main(String[] args) {

        // ADD PRODUCTS

        addProduct(new Products(
                101,
                "Laptop",
                10,
                55000
        ));

        addProduct(new Products(
                102,
                "Phone",
                20,
                30000
        ));

        addProduct(new Products(
                103,
                "Keyboard",
                15,
                1500
        ));


        // DISPLAY INVENTORY

        displayInventory();


        // UPDATE PRODUCT

        updateProduct(102, 25, 32000);


        // DELETE PRODUCT

        deleteProduct(103);


        // DISPLAY UPDATED INVENTORY

        displayInventory();
    }
}


/*
------------------------------------------------------------
4. Analysis
------------------------------------------------------------

Time Complexity of HashMap Operations
-------------------------------------

1. Add Product
   inventory.put()

   Average Case : O(1)
   Worst Case   : O(n)

2. Update Product
   containsKey() + get()

   Average Case : O(1)
   Worst Case   : O(n)

3. Delete Product
   inventory.remove()

   Average Case : O(1)
   Worst Case   : O(n)


Why Worst Case is O(n)?
-------------------------------------
If many keys produce the same hash value,
collisions occur.

In extreme cases, traversal becomes linear.


------------------------------------------------------------
Optimization Techniques
------------------------------------------------------------

1. Use Good Hash Functions
   Reduces collisions.

2. Use HashMap Instead of ArrayList
   Faster retrieval and updates.

3. Use TreeMap if Sorted Data is Needed
   Complexity becomes O(log n).

4. Database Indexing
   Improves search performance in large systems.

5. Caching Frequently Accessed Products
   Reduces repeated computations.


------------------------------------------------------------
Conclusion
------------------------------------------------------------

HashMap is highly suitable for inventory systems because:
1. Fast insertion
2. Fast deletion
3. Fast updates
4. Efficient retrieval using productId

This makes the system scalable and efficient for large warehouses.

*/