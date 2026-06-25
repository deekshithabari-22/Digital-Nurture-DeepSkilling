// Exercise 7: Financial Forecasting

/*
------------------------------------------------------------
1. Understanding Recursive Algorithms
------------------------------------------------------------

Recursion:
Recursion is a programming technique where a method calls itself
to solve smaller instances of the same problem.

A recursive function has:
1. Base Case
   -> Stops recursion

2. Recursive Case
   -> Function calls itself with smaller input

Why Recursion?
Recursion simplifies problems that can be divided into smaller
subproblems.

Examples:
1. Factorial
2. Fibonacci Series
3. Tree Traversal
4. Financial Forecasting

------------------------------------------------------------
Scenario
------------------------------------------------------------

We want to predict future financial values using past growth rates.

Formula:

Future Value = Current Value × (1 + Growth Rate)

If repeated for multiple years:

FV(n) = FV(n-1) × (1 + growthRate)

This naturally fits recursion.

------------------------------------------------------------
2. Setup
------------------------------------------------------------

Create a recursive method:
futureValueRecursive()

Inputs:
1. currentValue
2. growthRate
3. numberOfYears

------------------------------------------------------------
3. Implementation
------------------------------------------------------------
*/

public class FinancialForecasting {

    /*
    Recursive Method to Predict Future Value

    Parameters:
    currentValue -> Present financial amount
    growthRate   -> Annual growth rate
    years        -> Number of years
    */

    static double futureValueRecursive(double currentValue,
                                       double growthRate,
                                       int years) {

        // BASE CASE
        if (years == 0) {
            return currentValue;
        }

        // RECURSIVE CASE
        return futureValueRecursive(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1
        );
    }


    /*
    Optimized Recursive Method
    Uses formula directly:
    FV = PV * (1 + rate)^years
    */

    static double optimizedFutureValue(double currentValue,
                                       double growthRate,
                                       int years) {

        // BASE CASE
        if (years == 0) {
            return currentValue;
        }

        // Divide and Conquer Optimization
        double half = optimizedFutureValue(
                currentValue,
                growthRate,
                years / 2
        );

        if (years % 2 == 0) {
            return half * half / currentValue;
        }
        else {
            return (half * half * (1 + growthRate)) / currentValue;
        }
    }


    public static void main(String[] args) {

        double presentValue = 10000;

        // 10% annual growth
        double growthRate = 0.10;

        int years = 5;


        System.out.println("===== FINANCIAL FORECASTING =====");

        double futureValue = futureValueRecursive(
                presentValue,
                growthRate,
                years
        );

        System.out.println("Present Value : " + presentValue);
        System.out.println("Growth Rate   : " + (growthRate * 100) + "%");
        System.out.println("Years         : " + years);

        System.out.println("\nPredicted Future Value (Recursive): "
                + futureValue);


        // Optimized Version

        double optimizedValue = presentValue *
                Math.pow((1 + growthRate), years);

        System.out.println("Predicted Future Value (Optimized): "
                + optimizedValue);
    }
}


/*
------------------------------------------------------------
4. Analysis
------------------------------------------------------------

Recursive Algorithm Time Complexity:
------------------------------------

futureValueRecursive()

For every year:
-> One recursive call is made

Therefore:

Time Complexity  : O(n)
Space Complexity : O(n)

Where n = number of years


Why Space Complexity is O(n)?
Because recursive calls are stored in the call stack.


------------------------------------------------------------
Optimization
------------------------------------------------------------

Problem with Basic Recursion:
-----------------------------
If recursion repeatedly calculates the same values,
it causes excessive computation.

For large inputs:
1. More recursive calls
2. Higher memory usage
3. Slower execution


Ways to Optimize:
-----------------

1. Memoization
   Store previously calculated results.

2. Dynamic Programming
   Build solutions iteratively.

3. Mathematical Formula
   Use:
   FV = PV × (1 + rate)^years

4. Divide and Conquer
   Reduce repeated calculations.


------------------------------------------------------------
Conclusion
------------------------------------------------------------

Basic Recursion:
- Simple
- Easy to understand
- Good for learning

Optimized Methods:
- Faster
- Better for real-world financial systems
- Handle large forecasting periods efficiently

*/