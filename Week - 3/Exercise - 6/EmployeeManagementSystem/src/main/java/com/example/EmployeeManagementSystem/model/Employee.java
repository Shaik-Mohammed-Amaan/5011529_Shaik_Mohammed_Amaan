package com.example.EmployeeManagementSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")

@NamedQueries({
        @NamedQuery(name = "Employee.fetchByName", query = "SELECT E FROM Employee E WHERE E.name = :name"),
        @NamedQuery(name = "Employee.fetchByDepartmentName", query = "SELECT E FROM Employee E WHERE E.department.name = :departmentName"),
        @NamedQuery(name = "Employee.fetchByEmail", query = "SELECT E FROM Employee E WHERE E.email = :email")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
