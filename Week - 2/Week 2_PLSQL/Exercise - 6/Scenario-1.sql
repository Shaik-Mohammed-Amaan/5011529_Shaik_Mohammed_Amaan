DECLARE
    CURSOR trans_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE t.TransactionDate BETWEEN TRUNC(SYSDATE, 'MM') AND LAST_DAY(SYSDATE);
    
    trans_rec trans_cursor%ROWTYPE;
    
BEGIN
    OPEN trans_cursor;
    
    LOOP
        FETCH trans_cursor INTO trans_rec;
        EXIT WHEN trans_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || trans_rec.CustomerID);
        DBMS_OUTPUT.PUT_LINE('Customer Name: ' || trans_rec.Name);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || TO_CHAR(trans_rec.TransactionDate, 'YYYY-MM-DD'));
        DBMS_OUTPUT.PUT_LINE('Transaction Amount: ' || trans_rec.Amount);
        DBMS_OUTPUT.PUT_LINE('Transaction Type: ' || trans_rec.TransactionType);
        DBMS_OUTPUT.PUT_LINE('-----------------------------------');
    END LOOP;
    
    CLOSE trans_cursor;
END;
/
