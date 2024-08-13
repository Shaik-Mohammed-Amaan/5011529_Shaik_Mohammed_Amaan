package com.example.EmployeeManagementSystem.controller;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/departments/{deptId}")
    public Department getDepartmentById(@PathVariable int deptId) {
        return departmentService.getDepartmentById(deptId);
    }

    @PostMapping("/departments")
    public void addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);

    }

    @PutMapping("/departments")
    public void updateDepartmentDetails(@RequestBody Department department) {
        departmentService.updateDepartmentDetails(department);
    }

    @DeleteMapping("/departments/{deptId}")
    public void deleteDepartmentById(int deptId) {
        departmentService.deleteDepartmentById(deptId);
    }

    @GetMapping("/departments/name/{deptName}")
    public Department getDepartmentByName(@PathVariable String deptName) {
        return departmentService.getDepartmentByName(deptName);
    }
}
