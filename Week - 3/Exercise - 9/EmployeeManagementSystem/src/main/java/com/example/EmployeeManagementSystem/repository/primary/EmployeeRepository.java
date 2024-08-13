package com.example.EmployeeManagementSystem.repository.primary;

import com.example.EmployeeManagementSystem.model.primary.Employee;
import com.example.EmployeeManagementSystem.projections.EmployeeFullNameProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    //Pagination
    Page<Employee> findAll(Pageable pageable);

    //Sorting
    List<Employee> findAll(Sort sort);

    //Projection
    List<EmployeeFullNameProjection> findByDepartmentName(String departmentName);

}
