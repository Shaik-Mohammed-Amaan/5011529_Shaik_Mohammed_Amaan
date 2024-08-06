CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_annual_interest_rate IN NUMBER,
    p_loan_duration_years IN NUMBER
) RETURN NUMBER
IS
    v_monthly_interest_rate NUMBER;
    v_number_of_months NUMBER;
    v_monthly_installment NUMBER;
BEGIN
    v_monthly_interest_rate := p_annual_interest_rate / 12 / 100;

    v_number_of_months := p_loan_duration_years * 12;

    IF v_monthly_interest_rate > 0 THEN
        v_monthly_installment := p_loan_amount * v_monthly_interest_rate / 
                                (1 - POWER(1 + v_monthly_interest_rate, -v_number_of_months));
    ELSE
        v_monthly_installment := p_loan_amount / v_number_of_months;
    END IF;

    RETURN v_monthly_installment;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
        RETURN NULL;
END CalculateMonthlyInstallment;
/
