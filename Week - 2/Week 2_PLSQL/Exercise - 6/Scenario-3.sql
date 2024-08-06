DECLARE
    interest_rate_increase CONSTANT NUMBER := 1;

    CURSOR loan_cursor IS
        SELECT LoanID, InterestRate
        FROM Loans;
    
    loan_rec loan_cursor%ROWTYPE;
    
BEGIN
    OPEN loan_cursor;
    
    LOOP
        FETCH loan_cursor INTO loan_rec;
        EXIT WHEN loan_cursor%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate + interest_rate_increase,
            StartDate = StartDate
        WHERE LoanID = loan_rec.LoanID;
        
        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || loan_rec.LoanID || ' - New Interest Rate: ' || (loan_rec.InterestRate + interest_rate_increase));
    END LOOP;
    
    CLOSE loan_cursor;
    
    COMMIT;
END;
/
