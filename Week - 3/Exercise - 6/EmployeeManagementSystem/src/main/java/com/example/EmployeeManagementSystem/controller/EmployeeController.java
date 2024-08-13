package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    //Pagination
    @GetMapping("/employees/search")
    public Page<Employee> getAllEmployeesByPagination( @RequestParam(defaultValue = "0") int pageNo,
                                                       @RequestParam(defaultValue = "10") int pageSize){
        return employeeService.getAllEmployeesByPagination(pageNo,pageSize);

    }

    //Sorting
    @GetMapping("employees/sort")
    public List<Employee> getAllEmployeesBySorting(@RequestParam(defaultValue = "id") String field){
        return employeeService.getAllEmployeesBySorting(field);
    }

    //Pagination and Sorting
    @GetMapping("employees/search/sort")
    public Page<Employee> getAllEmployeesByPaginationAndSorting( @RequestParam(defaultValue = "0") int pageNo,
                                                                 @RequestParam(defaultValue = "10") int pageSize,
                                                                 @RequestParam(defaultValue = "id,asc") String[] field){
        Sort.Direction direction = field[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(direction,field[0]));
        return employeeService.getAllEmployeesByPaginationAndSorting(pageNo,pageSize,field);
    }
}
