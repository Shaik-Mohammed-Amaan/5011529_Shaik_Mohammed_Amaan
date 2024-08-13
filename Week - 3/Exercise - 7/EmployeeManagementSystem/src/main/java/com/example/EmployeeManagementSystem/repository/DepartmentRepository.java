package com.example.EmployeeManagementSystem.repository;

import com.example.EmployeeManagementSystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query(name = "Department.fetchByName")
    Department fetchByName(@Param("name") String name);

    @Query(name = "Department.fetchDepartmentByNameContaining")
    List<Department> fetchDepartmentByNameContaining(@Param("pattern") String pattern);


}
