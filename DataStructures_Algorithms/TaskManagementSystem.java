// Exercise 5: Task Management System

/*
------------------------------------------------------------
1. Understanding Linked Lists
------------------------------------------------------------

What is a Linked List?
-----------------------
A linked list is a linear data structure where
elements are connected using pointers (references).

Each node contains:
1. Data
2. Address of next node


------------------------------------------------------------
Types of Linked Lists
------------------------------------------------------------

1. Singly Linked List
----------------------
Each node points to the next node only.

Example:
[A] -> [B] -> [C] -> null

Advantages:
- Less memory usage
- Simple implementation

Disadvantages:
- Cannot traverse backward


2. Doubly Linked List
----------------------
Each node has:
1. Previous pointer
2. Next pointer

Example:
null <- [A] <-> [B] <-> [C] -> null

Advantages:
- Forward and backward traversal

Disadvantages:
- Extra memory required


------------------------------------------------------------
Why Linked Lists?
------------------------------------------------------------

Linked lists are useful when:
1. Data changes frequently
2. Dynamic memory allocation is needed
3. Insertions/deletions are frequent


------------------------------------------------------------
2. Setup
------------------------------------------------------------

Create Task class with:
1. taskId
2. taskName
3. status

Implement:
Singly Linked List for managing tasks


------------------------------------------------------------
3. Implementation
------------------------------------------------------------
*/


// TASK NODE CLASS

class Task {

    int taskId;
    String taskName;
    String status;

    Task next;


    Task(int taskId,
         String taskName,
         String status) {

        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;

        this.next = null;
    }


    void display() {

        System.out.println(
                taskId + " | "
                + taskName + " | "
                + status
        );
    }
}



// SINGLY LINKED LIST CLASS

public class TaskManagementSystem {


    // HEAD POINTER

    Task head = null;


    // ADD TASK

    void addTask(int taskId,
                 String taskName,
                 String status) {

        Task newTask =
                new Task(taskId, taskName, status);


        // IF LIST IS EMPTY

        if (head == null) {

            head = newTask;
        }

        else {

            Task temp = head;

            while (temp.next != null) {

                temp = temp.next;
            }

            temp.next = newTask;
        }

        System.out.println("Task Added Successfully");
    }


    // SEARCH TASK

    Task searchTask(int taskId) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == taskId) {

                return temp;
            }

            temp = temp.next;
        }

        return null;
    }


    // TRAVERSE TASKS

    void traverseTasks() {

        System.out.println("\n===== TASK LIST =====");

        Task temp = head;

        while (temp != null) {

            temp.display();

            temp = temp.next;
        }
    }


    // DELETE TASK

    void deleteTask(int taskId) {


        // EMPTY LIST

        if (head == null) {

            System.out.println("Task List is Empty");

            return;
        }


        // DELETE HEAD NODE

        if (head.taskId == taskId) {

            head = head.next;

            System.out.println("Task Deleted Successfully");

            return;
        }


        // SEARCH NODE

        Task temp = head;

        while (temp.next != null
                && temp.next.taskId != taskId) {

            temp = temp.next;
        }


        // TASK FOUND

        if (temp.next != null) {

            temp.next = temp.next.next;

            System.out.println("Task Deleted Successfully");
        }

        else {

            System.out.println("Task Not Found");
        }
    }


    // MAIN METHOD

    public static void main(String[] args) {


        TaskManagementSystem taskList =
                new TaskManagementSystem();


        // ADD TASKS

        taskList.addTask(
                101,
                "Design Database",
                "Pending"
        );

        taskList.addTask(
                102,
                "Develop API",
                "In Progress"
        );

        taskList.addTask(
                103,
                "Testing",
                "Pending"
        );


        // DISPLAY TASKS

        taskList.traverseTasks();


        // SEARCH TASK

        System.out.println("\n===== SEARCH TASK =====");

        Task task = taskList.searchTask(102);

        if (task != null) {

            task.display();
        }

        else {

            System.out.println("Task Not Found");
        }


        // DELETE TASK

        System.out.println("\n===== DELETE TASK =====");

        taskList.deleteTask(102);


        // DISPLAY UPDATED TASK LIST

        taskList.traverseTasks();
    }
}


/*
------------------------------------------------------------
4. Analysis
------------------------------------------------------------

Time Complexity of Operations
-----------------------------

1. Add Task
-------------
Traversal required to reach end

Time Complexity:
O(n)

If tail pointer is used:
O(1)


2. Search Task
---------------
Traverse linked list sequentially

Best Case    : O(1)
Worst Case   : O(n)


3. Traverse Tasks
------------------
Visit every node once

Time Complexity:
O(n)


4. Delete Task
---------------
1. Search node -> O(n)
2. Update links -> O(1)

Overall Complexity:
O(n)


------------------------------------------------------------
Advantages of Linked Lists Over Arrays
------------------------------------------------------------

1. Dynamic Size
----------------
Linked lists grow dynamically.

Arrays have fixed size.


2. Efficient Insertions/Deletions
----------------------------------
No shifting required.

Arrays require shifting elements.


3. Better Memory Utilization
-----------------------------
Memory allocated as needed.


4. Easy Implementation of Dynamic Data
---------------------------------------
Useful when data changes frequently.


------------------------------------------------------------
Disadvantages of Linked Lists
------------------------------------------------------------

1. Extra Memory Needed
-----------------------
Pointers consume additional memory.


2. No Direct Access
--------------------
Cannot access elements using index.

Traversal required.


3. Slower Searching
--------------------
Requires sequential traversal.


------------------------------------------------------------
When to Use Linked Lists
------------------------------------------------------------

Use linked lists when:
1. Frequent insertions/deletions occur
2. Dynamic data size is needed
3. Memory allocation should be flexible


------------------------------------------------------------
Conclusion
------------------------------------------------------------

Linked Lists are highly suitable for
task management systems because:
1. Tasks can be added dynamically
2. Deletion is efficient
3. Memory usage is flexible

They are better than arrays for dynamic data operations.

*/