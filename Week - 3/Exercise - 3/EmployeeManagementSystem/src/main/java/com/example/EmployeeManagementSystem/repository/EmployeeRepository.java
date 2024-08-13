package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    List<Employee> findByNameIs(String name);
    List<Employee> findByNameStartingWith(String prefix);
    List<Employee> findByNameEndingWith(String suffix);
    List<Employee> findByNameContaining(String infix);
    List<Employee> findByNameLike(String pattern);


    List<Employee> findByDepartmentName(String departmentName);

    Employee findByEmail(String email);

    List<Employee> findAll();

}
