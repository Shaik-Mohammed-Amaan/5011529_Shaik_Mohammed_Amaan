ALTER TABLE Customers MODIFY IsVIP VARCHAR(5);


ALTER TABLE Customers MODIFY IsVIP DEFAULT 'FALSE';


DECLARE
    CURSOR customer_cursor IS
        SELECT CustomerID
        FROM Customers
        WHERE Balance > 10000;
        
    v_customer_id Customers.CustomerID%TYPE;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO v_customer_id;
        EXIT WHEN customer_cursor%NOTFOUND;

        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = v_customer_id;
    END LOOP;
    CLOSE customer_cursor;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP status updated for customers with a balance over $10,000.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/