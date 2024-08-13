package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.secondary.Department;
import com.example.EmployeeManagementSystem.projections.DepartmentDTO;
import com.example.EmployeeManagementSystem.repository.secondary.DepartmentRepository;
import org.springframework.stereotype.Service;

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
        return departmentRepository.fetchByName(deptName);
    }

    public List<Department> getDepartmentByNameContaining(String pattern){
        return departmentRepository.fetchDepartmentByNameContaining(pattern);
    }

    //Projection
    public List<DepartmentDTO> getDepartmentProjectionByNameContaining(String pattern){
        return departmentRepository.findDepartmentProjectionByNameContaining(pattern);
    }
}
