DECLARE 
    v_customer_id   Loans.CustomerID%TYPE; 
    v_interest_rate Loans.InterestRate%TYPE; 
    v_age           NUMBER; 
    CURSOR loan_cursor IS 
        SELECT CustomerID, InterestRate 
        FROM Loans 
        WHERE CustomerID IN ( 
            SELECT CustomerID 
            FROM Customers 
            WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, DOB) / 12) > 60 
        ); 
BEGIN 
    OPEN loan_cursor; 
    LOOP 
        FETCH loan_cursor INTO v_customer_id, v_interest_rate; 
        EXIT WHEN loan_cursor%NOTFOUND; 
 
        UPDATE Loans 
        SET InterestRate = v_interest_rate - 1 
        WHERE CustomerID = v_customer_id; 
    END LOOP; 
    CLOSE loan_cursor; 
     
    COMMIT; 
    DBMS_OUTPUT.PUT_LINE('Interest rates updated for customers above 60 years old.'); 
EXCEPTION 
    WHEN OTHERS THEN 
        ROLLBACK; 
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM); 
END; 
/