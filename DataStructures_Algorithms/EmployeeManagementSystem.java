// Exercise 4: Employee Management System

/*
------------------------------------------------------------
1. Understanding Array Representation
------------------------------------------------------------

What is an Array?
-----------------
An array is a collection of elements stored in
contiguous memory locations.

Example:
Index : 0   1   2   3
Value : A   B   C   D

Memory Representation:
----------------------
Each element is stored one after another in memory.

Advantages of Arrays:
---------------------
1. Fast Access using index
2. Easy traversal
3. Memory efficient
4. Simple implementation

Example:
arr[0], arr[1], arr[2]

Access Time:
-------------
O(1) -> Constant Time


Disadvantages of Arrays:
------------------------
1. Fixed Size
2. Insertion/Deletion is costly
3. Memory wastage possible
4. Searching is slow for unsorted arrays


------------------------------------------------------------
2. Setup
------------------------------------------------------------

Create Employee class with:
1. employeeId
2. name
3. position
4. salary

Use an array to store employee records.

------------------------------------------------------------
3. Implementation
------------------------------------------------------------
*/


class Employee {

    int employeeId;
    String name;
    String position;
    double salary;


    Employee(int employeeId,
             String name,
             String position,
             double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }


    void display() {

        System.out.println(
                employeeId + " | "
                + name + " | "
                + position + " | "
                + salary
        );
    }
}



public class EmployeeManagementSystem {


    // ARRAY TO STORE EMPLOYEES

    static Employee[] employees = new Employee[10];

    static int count = 0;


    // ADD EMPLOYEE

    static void addEmployee(Employee employee) {

        if (count < employees.length) {

            employees[count] = employee;

            count++;

            System.out.println("Employee Added Successfully");
        }

        else {

            System.out.println("Array is Full");
        }
    }


    // SEARCH EMPLOYEE

    static Employee searchEmployee(int employeeId) {

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == employeeId) {

                return employees[i];
            }
        }

        return null;
    }


    // TRAVERSE EMPLOYEES

    static void traverseEmployees() {

        System.out.println("\n===== EMPLOYEE RECORDS =====");

        for (int i = 0; i < count; i++) {

            employees[i].display();
        }
    }


    // DELETE EMPLOYEE

    static void deleteEmployee(int employeeId) {

        int index = -1;


        // FIND EMPLOYEE INDEX

        for (int i = 0; i < count; i++) {

            if (employees[i].employeeId == employeeId) {

                index = i;

                break;
            }
        }


        // IF EMPLOYEE FOUND

        if (index != -1) {

            // SHIFT ELEMENTS LEFT

            for (int i = index; i < count - 1; i++) {

                employees[i] = employees[i + 1];
            }

            employees[count - 1] = null;

            count--;

            System.out.println("Employee Deleted Successfully");
        }

        else {

            System.out.println("Employee Not Found");
        }
    }


    // MAIN METHOD

    public static void main(String[] args) {


        // ADD EMPLOYEES

        addEmployee(new Employee(
                101,
                "Rahul",
                "Manager",
                75000
        ));

        addEmployee(new Employee(
                102,
                "Sneha",
                "Developer",
                60000
        ));

        addEmployee(new Employee(
                103,
                "Kiran",
                "Tester",
                50000
        ));


        // DISPLAY EMPLOYEES

        traverseEmployees();


        // SEARCH EMPLOYEE

        System.out.println("\n===== SEARCH EMPLOYEE =====");

        Employee emp = searchEmployee(102);

        if (emp != null) {

            emp.display();
        }

        else {

            System.out.println("Employee Not Found");
        }


        // DELETE EMPLOYEE

        System.out.println("\n===== DELETE EMPLOYEE =====");

        deleteEmployee(102);


        // DISPLAY UPDATED RECORDS

        traverseEmployees();
    }
}


/*
------------------------------------------------------------
4. Analysis
------------------------------------------------------------

Time Complexity of Operations
-----------------------------

1. Add Employee
----------------
employees[count] = employee

Time Complexity:
O(1)

Reason:
Insertion at end is constant time.


2. Search Employee
-------------------
Linear Search through array

Best Case    : O(1)
Worst Case   : O(n)

Reason:
May need to traverse all employees.


3. Traverse Employees
----------------------
Loop through array

Time Complexity:
O(n)

Reason:
Every employee is visited once.


4. Delete Employee
-------------------
1. Search employee -> O(n)
2. Shift elements  -> O(n)

Total Complexity:
O(n)


------------------------------------------------------------
Limitations of Arrays
------------------------------------------------------------

1. Fixed Size
--------------
Cannot grow dynamically.

2. Costly Insertions/Deletions
-------------------------------
Requires shifting elements.

3. Memory Wastage
------------------
Unused spaces remain allocated.

4. Searching is Slow
---------------------
Linear search required in unsorted arrays.


------------------------------------------------------------
When to Use Arrays
------------------------------------------------------------

Arrays are suitable when:
1. Size is fixed
2. Fast index access is needed
3. Memory efficiency is important
4. Frequent insertions/deletions are NOT required


------------------------------------------------------------
Conclusion
------------------------------------------------------------

Arrays provide:
1. Fast access
2. Simple implementation
3. Efficient memory usage

However:
- They are not flexible for dynamic data.

For large employee systems:
- ArrayList
- LinkedList
- HashMap
are usually better choices.

*/