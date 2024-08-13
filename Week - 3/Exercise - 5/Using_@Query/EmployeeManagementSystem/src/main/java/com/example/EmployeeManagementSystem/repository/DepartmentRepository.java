package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(value = "SELECT D FROM Department D WHERE D.name = :name")
    Department fetchByName(@Param("name") String name);

    @Query(value = "SELECT D FROM Department D WHERE D.name LIKE %:pattern%")
    List<Department> fetchDepartmentByNameContaining(@Param("pattern") String pattern);


}
