CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
IS
    CURSOR savings_accounts_cursor IS
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'SAVINGS';

    v_account_id Accounts.AccountID%TYPE;
    v_balance    Accounts.Balance%TYPE;
BEGIN
    OPEN savings_accounts_cursor;

    LOOP
        FETCH savings_accounts_cursor INTO v_account_id, v_balance;
        EXIT WHEN savings_accounts_cursor%NOTFOUND;

        v_balance := v_balance * 1.01;

        UPDATE Accounts
        SET Balance = v_balance
        WHERE AccountID = v_account_id;
    END LOOP;

    CLOSE savings_accounts_cursor;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Monthly interest processed for all savings accounts.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END ProcessMonthlyInterest;
/
