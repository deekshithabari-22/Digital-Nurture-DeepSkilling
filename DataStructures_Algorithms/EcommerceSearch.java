// Exercise 2: E-commerce Platform Search Function

/*
------------------------------------------------------------
1. Understanding Asymptotic Notation
------------------------------------------------------------

Big O Notation:
Big O notation is used to measure the efficiency of an algorithm
based on the size of input data.

It tells us how the execution time grows as input size increases.

Common Complexities:
O(1)    -> Constant Time
O(log n)-> Logarithmic Time
O(n)    -> Linear Time
O(n²)   -> Quadratic Time

Why is it important?
In an e-commerce platform, thousands or millions of products
may exist. Efficient searching improves:
1. Faster response time
2. Better user experience
3. Reduced server load

------------------------------------------------------------
Best, Average, Worst Cases
------------------------------------------------------------

Linear Search:
- Best Case    : O(1)
  Product found at first position

- Average Case : O(n)
  Product found somewhere in middle

- Worst Case   : O(n)
  Product found at end or not found


Binary Search:
(Binary Search requires sorted data)

- Best Case    : O(1)
  Product found at middle

- Average Case : O(log n)

- Worst Case   : O(log n)

------------------------------------------------------------
2. Setup
------------------------------------------------------------
Create Product class with:
1. productId
2. productName
3. category

------------------------------------------------------------
3. Implementation
------------------------------------------------------------
Implement:
1. Linear Search
2. Binary Search

Store products:
- Normal array for Linear Search
- Sorted array for Binary Search

------------------------------------------------------------
4. Analysis
------------------------------------------------------------

Time Complexity Comparison:

Linear Search:
Best    -> O(1)
Average -> O(n)
Worst   -> O(n)

Binary Search:
Best    -> O(1)
Average -> O(log n)
Worst   -> O(log n)

Which is better for E-commerce Platforms?

Binary Search is better because:
1. Faster for large datasets
2. Reduces search time significantly
3. More scalable

Linear Search is simple but inefficient for huge product lists.

Real-world platforms additionally use:
1. Database Indexing
2. Hashing
3. Elasticsearch
4. BSTs

*/


class Product {

    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Category     : " + category);
    }
}


public class EcommerceSearch {

    // LINEAR SEARCH
    static Product linearSearch(Product[] products, int targetId) {

        for (Product product : products) {

            if (product.productId == targetId) {
                return product;
            }
        }

        return null;
    }


    // BINARY SEARCH
    static Product binarySearch(Product[] products, int targetId) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }

            else if (products[mid].productId < targetId) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return null;
    }


    public static void main(String[] args) {

        // Product Array
        // (Sorted by productId for Binary Search)

        Product[] products = {

            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shoes", "Fashion"),
            new Product(103, "Phone", "Electronics"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Bag", "Fashion")
        };


        int targetId = 104;


        // LINEAR SEARCH

        System.out.println("===== LINEAR SEARCH =====");

        Product linearResult = linearSearch(products, targetId);

        if (linearResult != null) {

            System.out.println("Product Found");
            linearResult.display();

        } else {

            System.out.println("Product Not Found");
        }


        // BINARY SEARCH

        System.out.println("\n===== BINARY SEARCH =====");

        Product binaryResult = binarySearch(products, targetId);

        if (binaryResult != null) {

            System.out.println("Product Found");
            binaryResult.display();

        } else {

            System.out.println("Product Not Found");
        }
    }
}