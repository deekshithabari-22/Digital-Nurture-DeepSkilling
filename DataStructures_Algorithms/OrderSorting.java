// Exercise 3: Sorting Customer Orders

/*
------------------------------------------------------------
1. Understanding Sorting Algorithms
------------------------------------------------------------

Sorting:
Sorting arranges data in a specific order
(ascending or descending).

In an e-commerce platform,
sorting customer orders by total price helps:
1. Prioritize high-value orders
2. Generate reports
3. Improve analytics


------------------------------------------------------------
Different Sorting Algorithms
------------------------------------------------------------

1. Bubble Sort
----------------
- Repeatedly swaps adjacent elements
- Largest element moves to the end in each pass

Time Complexity:
Best Case    : O(n)
Average Case : O(n²)
Worst Case   : O(n²)

Advantages:
- Simple to understand

Disadvantages:
- Very slow for large datasets


2. Insertion Sort
-------------------
- Inserts elements into correct position

Time Complexity:
Best Case    : O(n)
Average Case : O(n²)
Worst Case   : O(n²)

Good for:
- Small datasets


3. Quick Sort
----------------
- Divide and Conquer algorithm
- Selects pivot and partitions array

Time Complexity:
Best Case    : O(n log n)
Average Case : O(n log n)
Worst Case   : O(n²)

Advantages:
- Very fast in practice
- Efficient for large datasets


4. Merge Sort
----------------
- Divides array into halves
- Merges sorted halves

Time Complexity:
Best/Average/Worst : O(n log n)

Advantages:
- Stable sorting
- Predictable performance

Disadvantages:
- Requires extra memory


------------------------------------------------------------
2. Setup
------------------------------------------------------------

Create Order class with:
1. orderId
2. customerName
3. totalPrice

------------------------------------------------------------
3. Implementation
------------------------------------------------------------
*/


class Order {

    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId,
          String customerName,
          double totalPrice) {

        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }


    void display() {

        System.out.println(
                orderId + " | "
                + customerName + " | "
                + totalPrice
        );
    }
}



public class OrderSorting {


    // DISPLAY ORDERS

    static void displayOrders(Order[] orders) {

        for (Order order : orders) {
            order.display();
        }

        System.out.println();
    }


    // BUBBLE SORT

    static void bubbleSort(Order[] orders) {

        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (orders[j].totalPrice >
                        orders[j + 1].totalPrice) {

                    // Swap

                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }


    // QUICK SORT

    static void quickSort(Order[] orders,
                          int low,
                          int high) {

        if (low < high) {

            int pivotIndex =
                    partition(orders, low, high);

            quickSort(orders, low, pivotIndex - 1);

            quickSort(orders, pivotIndex + 1, high);
        }
    }


    // PARTITION METHOD

    static int partition(Order[] orders,
                         int low,
                         int high) {

        double pivot = orders[high].totalPrice;

        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (orders[j].totalPrice < pivot) {

                i++;

                // Swap

                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        // Place pivot in correct position

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }


    // MAIN METHOD

    public static void main(String[] args) {


        Order[] orders1 = {

                new Order(101, "Rahul", 5000),
                new Order(102, "Anjali", 12000),
                new Order(103, "Vikram", 7000),
                new Order(104, "Sneha", 3000),
                new Order(105, "Kiran", 15000)
        };


        // Separate copy for Quick Sort

        Order[] orders2 = {

                new Order(101, "Rahul", 5000),
                new Order(102, "Anjali", 12000),
                new Order(103, "Vikram", 7000),
                new Order(104, "Sneha", 3000),
                new Order(105, "Kiran", 15000)
        };


        System.out.println("===== ORIGINAL ORDERS =====");

        displayOrders(orders1);


        // BUBBLE SORT

        bubbleSort(orders1);

        System.out.println("===== BUBBLE SORT =====");

        displayOrders(orders1);


        // QUICK SORT

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("===== QUICK SORT =====");

        displayOrders(orders2);
    }
}


/*
------------------------------------------------------------
4. Analysis
------------------------------------------------------------

Bubble Sort Complexity
----------------------

Best Case    : O(n)
Average Case : O(n²)
Worst Case   : O(n²)

Why Slow?
----------
Bubble Sort repeatedly compares and swaps adjacent elements.

For large datasets:
- Too many comparisons
- Too many swaps


------------------------------------------------------------
Quick Sort Complexity
------------------------------------------------------------

Best Case    : O(n log n)
Average Case : O(n log n)
Worst Case   : O(n²)

Why Faster?
-------------
Quick Sort:
1. Divides array into smaller parts
2. Sorts efficiently using recursion
3. Reduces unnecessary comparisons


------------------------------------------------------------
Why Quick Sort is Preferred
------------------------------------------------------------

1. Much Faster for Large Data
2. Better Average Performance
3. Efficient Memory Usage
4. Widely Used in Real Applications

Bubble Sort:
- Good only for learning
- Not suitable for large e-commerce systems


------------------------------------------------------------
Conclusion
------------------------------------------------------------

For an e-commerce platform:

Quick Sort is preferred because:
1. Faster execution
2. Better scalability
3. Efficient handling of thousands of orders

Bubble Sort is simple but inefficient for large datasets.

*/