package com.example.EmployeeManagementSystem.repository.secondary;

import com.example.EmployeeManagementSystem.model.secondary.Department;
import com.example.EmployeeManagementSystem.projections.DepartmentDTO;
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

    //Projections
    @Query("SELECT new com.example.EmployeeManagementSystem.projections.DepartmentDTO(d.id, d.name) FROM Department d WHERE d.name LIKE %:pattern%")

    List<DepartmentDTO> findDepartmentProjectionByNameContaining(@Param("pattern") String pattern);
}
