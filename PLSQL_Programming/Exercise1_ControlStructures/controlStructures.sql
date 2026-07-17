
-- Scenario 1:
-- The bank wants to apply a discount to loan interest rates for customers above 60 years old.

SET SERVEROUTPUT ON;

DECLARE 
    v_age NUMBER;
BEGIN
    FOR cust IN (
        SELECT CustomerID,DOB
        FROM Customers
    )
    LOOP
        v_age:=TRUNC(MONTHS_BETWEEN(SYSDATE,cust.DOB)/12);
        IF v_age>60 THEN
            UPDATE Loans
            SET InterestRate=InterestRate-(InterestRate*0.01)
            WHERE CustomerID=cust.CustomerID;
            DBMS_OUTPUT.PUT_LINE('1% interest discount applied for Customer ID:'||cust.CustomerID);
            END IF;
    END LOOP;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated successfully.');
END;
/

-- Scenario 2:
-- A customer can be promoted to VIP status based on their balance.
ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);

SET SERVEROUTPUT ON;

BEGIN  
    FOR cust IN(
        SELECT CustomerID,balance
        FROM Customers
    )
    LOOP
        IF cust.Balance>10000 THEN
            UPDATE Customers
            SET IsVIP='TRUE'
            WHERE CustomerID=cust.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                'Customer'|| cust.CustomerID || 'promoted to VIP'
            );

        END IF;
    END LOOP;
    COMMIT;
END;
/

-- Scenario 3:
-- The bank wants to send reminders to customers whose loans are due within the next 30 days.
SET SERVEROUTPUT ON;
BEGIN
    FOR loan_rec IN(
        SELECT c.CustomerID,c.Name, l.LoanID, l.EndDate
        FROM Customers c
        JOIN Loans l
        ON c.CustomerID=l.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE+30
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Remainder: Dear'
            || loan_rec.Name
            ||', your loan with Loan ID'
            || loan_rec.LoanID
            || 'is due on'
            || TO_CHAR(loan_rec.EndDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/