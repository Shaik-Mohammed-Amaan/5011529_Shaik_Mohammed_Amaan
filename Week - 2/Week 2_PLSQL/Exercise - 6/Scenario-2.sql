DECLARE
    annual_fee CONSTANT NUMBER := 50;
    
    CURSOR acc_cursor IS
        SELECT AccountID, Balance
        FROM Accounts;
    
    acc_rec acc_cursor%ROWTYPE;
    
BEGIN
    OPEN acc_cursor;
    
    LOOP
        FETCH acc_cursor INTO acc_rec;
        EXIT WHEN acc_cursor%NOTFOUND;
        
        UPDATE Accounts
        SET Balance = Balance - annual_fee,
            LastModified = SYSDATE
        WHERE AccountID = acc_rec.AccountID;
        
        DBMS_OUTPUT.PUT_LINE('Account ID: ' || acc_rec.AccountID || ' - New Balance: ' || (acc_rec.Balance - annual_fee));
    END LOOP;
    
    CLOSE acc_cursor;
    
    COMMIT;
END;
/
