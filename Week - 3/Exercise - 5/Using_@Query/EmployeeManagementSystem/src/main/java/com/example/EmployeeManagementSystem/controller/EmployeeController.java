package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @PutMapping("/employees")
    public void updateEmployeeDetails(@RequestBody Employee employee) {
        employeeService.updateEmployeeDetails(employee);
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteEmployeeById(@PathVariable int empId) {
        employeeService.deleteEmployeeById(empId);
    }

    @GetMapping("/employees/name/{empName}")
    public List<Employee> getByName(@PathVariable String empName) {
        return employeeService.getByName(empName);
    }

    @GetMapping("/employees/department/{deptName}")
    public List<Employee> getByDepartmentName(@PathVariable String deptName) {
        return employeeService.getByDepartmentName(deptName);
    }

    @GetMapping("/employees/email/{emailId}")
    public Employee getByEmail(@PathVariable String emailId) {
        return employeeService.getByEmail(emailId);
    }

}
