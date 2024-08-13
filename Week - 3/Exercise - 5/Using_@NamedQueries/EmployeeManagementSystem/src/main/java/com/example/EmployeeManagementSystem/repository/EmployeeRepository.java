package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import jakarta.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(name = "Employee.fetchByName")
    List<Employee> fetchByName(@Param("name") String name);

    @Query(name = "Employee.fetchByDepartmentName")
    List<Employee> fetchByDepartmentName(@Param("departmentName") String departmentName);

    @Query(name = "Employee.fetchByEmail")
    Employee fetchByEmail(@Param("email") String email);

}
