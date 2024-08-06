CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN Employees.EmployeeID%TYPE,
    p_percentage IN NUMBER
)
IS
    e_employee_not_found EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_employee_not_found, -20001);
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_employee_not_found;
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary updated successfully for employee ID: ' || p_employee_id);

EXCEPTION
    WHEN e_employee_not_found THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' does not exist.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END UpdateSalary;
/
