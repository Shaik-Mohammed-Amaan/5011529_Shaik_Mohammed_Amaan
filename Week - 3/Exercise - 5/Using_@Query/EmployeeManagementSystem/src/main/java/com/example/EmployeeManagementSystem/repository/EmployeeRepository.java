package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT E FROM Employee E WHERE E.name = :name")
    List<Employee> fetchByName(@Param("name") String name);

    @Query(value = "SELECT E FROM Employee E WHERE E.department.name = :departmentName")
    List<Employee> fetchByDepartmentName(@Param("departmentName") String departmentName);

    @Query(value = "SELECT E FROM Employee E WHERE E.email = :email")
    Employee fetchByEmail(@Param("email") String email);

}
