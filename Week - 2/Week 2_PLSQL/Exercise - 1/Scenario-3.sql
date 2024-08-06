DECLARE
    CURSOR loan_cursor IS
        SELECT l.LoanID, c.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;
        
    v_loan_id     Loans.LoanID%TYPE;
    v_customer_id Customers.CustomerID%TYPE;
    v_customer_name Customers.Name%TYPE;
    v_end_date    Loans.EndDate%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loan_id, v_customer_id, v_customer_name, v_end_date;
        EXIT WHEN loan_cursor%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || v_customer_name || ' (ID: ' || v_customer_id || 
                             ') has a loan (ID: ' || v_loan_id || ') due on ' || TO_CHAR(v_end_date, 'YYYY-MM-DD'));
    END LOOP;
    CLOSE loan_cursor;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/
