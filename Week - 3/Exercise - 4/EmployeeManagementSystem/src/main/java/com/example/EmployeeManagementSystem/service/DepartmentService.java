package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(int id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void updateDepartmentDetails(Department department) {
        departmentRepository.save(department);
    }

    public void deleteDepartmentById(int id) {
        departmentRepository.deleteById(id);
    }

    public Department getDepartmentByName(String deptName) {
        return departmentRepository.findByNameIs(deptName);
    }
}
