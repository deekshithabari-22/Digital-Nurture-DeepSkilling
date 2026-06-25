// Exercise 6: Library Management System

/*
------------------------------------------------------------
1. Understanding Search Algorithms
------------------------------------------------------------

Searching:
-----------
Searching is the process of finding a specific element
from a collection of data.

In a Library Management System:
- Users search books by title or author.
- Efficient searching improves performance.


------------------------------------------------------------
Linear Search
------------------------------------------------------------

Definition:
-------------
Linear search checks elements one by one
until the target is found.

Working:
---------
1. Start from first element
2. Compare with target
3. Continue until match found or array ends

Example:
---------
Books:
Java, Python, DBMS, Networks

Search: DBMS

Comparisons:
Java -> Python -> DBMS

Advantages:
------------
1. Simple implementation
2. Works on unsorted data

Disadvantages:
---------------
1. Slow for large datasets


Time Complexity:
-----------------
Best Case    : O(1)
Average Case : O(n)
Worst Case   : O(n)


------------------------------------------------------------
Binary Search
------------------------------------------------------------

Definition:
-------------
Binary search repeatedly divides
the search space into half.

IMPORTANT:
-------------
Binary search works only on SORTED data.

Working:
---------
1. Find middle element
2. Compare with target
3. If target smaller -> search left half
4. If target larger -> search right half

Advantages:
------------
1. Very fast
2. Efficient for large datasets

Disadvantages:
---------------
1. Requires sorted data


Time Complexity:
-----------------
Best Case    : O(1)
Average Case : O(log n)
Worst Case   : O(log n)


------------------------------------------------------------
2. Setup
------------------------------------------------------------

Create Book class with:
1. bookId
2. title
3. author

------------------------------------------------------------
3. Implementation
------------------------------------------------------------
*/


class Book {

    int bookId;
    String title;
    String author;


    Book(int bookId,
         String title,
         String author) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }


    void display() {

        System.out.println(
                bookId + " | "
                + title + " | "
                + author
        );
    }
}



public class LibraryManagementSystem {


    // LINEAR SEARCH

    static Book linearSearch(Book[] books,
                             String targetTitle) {

        for (Book book : books) {

            if (book.title.equalsIgnoreCase(targetTitle)) {

                return book;
            }
        }

        return null;
    }


    // BINARY SEARCH

    static Book binarySearch(Book[] books,
                             String targetTitle) {

        int left = 0;
        int right = books.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int comparison =
                    books[mid].title.compareToIgnoreCase(
                            targetTitle
                    );


            // TITLE FOUND

            if (comparison == 0) {

                return books[mid];
            }


            // SEARCH RIGHT HALF

            else if (comparison < 0) {

                left = mid + 1;
            }


            // SEARCH LEFT HALF

            else {

                right = mid - 1;
            }
        }

        return null;
    }


    // DISPLAY BOOKS

    static void displayBooks(Book[] books) {

        for (Book book : books) {

            book.display();
        }

        System.out.println();
    }


    // MAIN METHOD

    public static void main(String[] args) {


        /*
        IMPORTANT:
        Array is sorted by title
        for Binary Search
        */

        Book[] books = {

                new Book(
                        101,
                        "Algorithms",
                        "Cormen"
                ),

                new Book(
                        102,
                        "DBMS",
                        "Korth"
                ),

                new Book(
                        103,
                        "Java",
                        "James Gosling"
                ),

                new Book(
                        104,
                        "Networks",
                        "Tanenbaum"
                ),

                new Book(
                        105,
                        "Python",
                        "Guido van Rossum"
                )
        };


        System.out.println("===== BOOK LIST =====");

        displayBooks(books);


        // LINEAR SEARCH

        System.out.println(
                "===== LINEAR SEARCH ====="
        );

        Book result1 =
                linearSearch(books, "Java");


        if (result1 != null) {

            System.out.println("Book Found:");

            result1.display();
        }

        else {

            System.out.println("Book Not Found");
        }



        // BINARY SEARCH

        System.out.println(
                "\n===== BINARY SEARCH ====="
        );

        Book result2 =
                binarySearch(books, "Python");


        if (result2 != null) {

            System.out.println("Book Found:");

            result2.display();
        }

        else {

            System.out.println("Book Not Found");
        }
    }
}


/*
------------------------------------------------------------
4. Analysis
------------------------------------------------------------

Linear Search Complexity
-------------------------

Best Case:
O(1)
(Book found at first position)

Average Case:
O(n)

Worst Case:
O(n)
(Book found at end or not found)


------------------------------------------------------------
Binary Search Complexity
------------------------------------------------------------

Best Case:
O(1)

Average Case:
O(log n)

Worst Case:
O(log n)


Why Binary Search is Faster?
-----------------------------
Because it eliminates half of the search space
after every comparison.


------------------------------------------------------------
When to Use Linear Search
------------------------------------------------------------

Use Linear Search when:
1. Data is unsorted
2. Dataset is small
3. Simplicity is preferred


------------------------------------------------------------
When to Use Binary Search
------------------------------------------------------------

Use Binary Search when:
1. Data is sorted
2. Dataset is large
3. Fast searching is required


------------------------------------------------------------
Comparison
------------------------------------------------------------

Linear Search:
---------------
- Simple
- Works on unsorted data
- Slow for large datasets

Binary Search:
----------------
- Faster
- Efficient for large datasets
- Requires sorted data


------------------------------------------------------------
Conclusion
------------------------------------------------------------

For a Library Management System:

1. Linear Search is suitable for:
   - Small collections
   - Unsorted books

2. Binary Search is suitable for:
   - Large sorted collections
   - Faster search performance

Binary Search is generally preferred
for large library databases.

*/