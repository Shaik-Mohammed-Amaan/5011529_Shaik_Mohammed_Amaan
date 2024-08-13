package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    List<Employee> findByNameIs(String name);


    List<Employee> findByDepartmentName(String departmentName);

    Employee findByEmail(String email);

    List<Employee> findAll();

}
