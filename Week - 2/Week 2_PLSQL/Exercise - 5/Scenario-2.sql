CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LoggedDate DATE
);



CREATE SEQUENCE AuditLog_SEQ
START WITH 1
INCREMENT BY 1;



CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        AuditID,
        TransactionID,
        AccountID,
        TransactionDate,
        Amount,
        TransactionType,
        LoggedDate
    ) VALUES (
        AuditLog_SEQ.NEXTVAL, 
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.TransactionDate,
        :NEW.Amount,
        :NEW.TransactionType,
        SYSDATE
    );
END;
/
