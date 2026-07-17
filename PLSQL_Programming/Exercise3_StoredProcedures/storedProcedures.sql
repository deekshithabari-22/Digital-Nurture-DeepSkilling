-- Scenario 1:
-- The bank needs to process monthly interest for all savings accounts.
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS 
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance*0.01)
    WHERE AccountType='Savings';
    COMMIT;
    DBMS_OUTPUT.PUT_LINE(
        'Monthly interest processed successfully.'
    );
END;
/

-- Scenario 2:
--  The bank wants to implement a bonus scheme for employees based on their performance.
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus
(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
)
AS
BEGIN
    UPDATE Employees
    SET Salary=Salary+(Salary*p_bonus_percent/100)
    WHERE Department=p_department;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus update successfully for'
                || p_department
                || 'department.');
END;
/

-- Scenario 3:
-- Customers should be able to transfer funds between their accounts.
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_source_account IN NUMBER,
    p_destination_account IN NUMBER,
    p_amount IN NUMBER
)
AS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID=p_source_account;

    IF v_balance>=p_amount THEN
        UPDATE Accounts
        SET Balance=Balance-p_amount
        WHERE AccountID=p_source_account;

        UPDATE Accounts
        SET Balance=Balance+p_amount
        WHERE AccountID=p_destination_account;
        COMMIT;
        DBMS_OUTPUT.PUT_LINE(
            'Transfer completed successfully.'
        );
    ELSE 
        DBMS_OUTPUT.PUT_LINE(
            'Insufficient balance.'
        );
        ROLLBACK;
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE(
            'Account not found.'
        );
        ROLLBACK;

    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(
            'Error: ' || SQLERRM
        );
        ROLLBACK;
END;
/