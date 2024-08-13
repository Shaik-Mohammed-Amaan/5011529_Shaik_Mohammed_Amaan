package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.projections.EmployeeFullNameProjection;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployeeDetails(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployeeById(int id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getByName(String name) {
        return employeeRepository.fetchByName(name);
    }

    public List<Employee> getByDepartmentName(String deptName) {
        return employeeRepository.fetchByDepartmentName(deptName);
    }

    public Employee getByEmail(String email) {
        return employeeRepository.fetchByEmail(email);
    }

    //Pagination
    public Page<Employee> getAllEmployeesByPagination(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return employeeRepository.findAll(pageable);
    }

    //Sorting
    public List<Employee> getAllEmployeesBySorting(String field){
        return employeeRepository.findAll(Sort.by(Sort.Direction.ASC,field));

    }

    //Pagination and Sorting
    public Page<Employee> getAllEmployeesByPaginationAndSorting(int pageNo,int pageSize,String[] sort){
        Sort.Direction direction = sort[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(direction,sort[0]));
        return employeeRepository.findAll(pageable);
    }

    //Projection
    public List<EmployeeFullNameProjection> getProjectionByDepartmentName(String departmentName){
        return employeeRepository.findByDepartmentName(departmentName);
    }

}
