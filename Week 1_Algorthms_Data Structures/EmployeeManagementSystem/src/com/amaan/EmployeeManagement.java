package com.amaan;

public class EmployeeManagement {
    private Employee[] employees;
    private int length;
    private static int i = 0;

    public EmployeeManagement(int length) {
        this.length = length;
        employees = new Employee[this.length];
    }

    public void addEmployee(Employee employee) {
        employees[i++] = employee;
    }

    public Employee searchEmployeeById(int employeeId) {
        for (int i = 0; i < length; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < length; i++) {
            System.out.println(employees[i]);
        }
    }

    public boolean deleteEmployeeById(int employeeId) {
        for (int i = 0; i < length; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                // Shift elements to the left
                for (int j = i; j < length - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--length] = null;
                return true;
            }
        }
        return false;
    }
}
