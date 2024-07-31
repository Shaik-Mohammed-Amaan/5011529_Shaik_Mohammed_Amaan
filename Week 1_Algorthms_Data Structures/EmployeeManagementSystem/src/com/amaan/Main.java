package com.amaan;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee(101, "Ram", "Manager", 30000);
        Employee employee2 = new Employee(102, "Sam", "Software Developer", 50000);
        Employee employee3 = new Employee(103, "Rajesh", "Designer", 15000);
        EmployeeManagement employeeManagement = new EmployeeManagement(3);

        employeeManagement.addEmployee(employee1);
        employeeManagement.addEmployee(employee2);
        employeeManagement.addEmployee(employee3);

        System.out.println("Traversing the employees");
        employeeManagement.traverseEmployees();

        System.out.println(employeeManagement.searchEmployeeById(102));

        employeeManagement.deleteEmployeeById(103);

        System.out.println(employeeManagement.searchEmployeeById(103));

        System.out.println("Traversing the employees");
        employeeManagement.traverseEmployees();

    }
}
