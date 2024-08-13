package com.example.EmployeeManagementSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENT")

@NamedQueries({
        @NamedQuery(name = "Department.fetchByName", query = "SELECT D FROM Department D WHERE D.name = :name"),
        @NamedQuery(name = "Department.fetchDepartmentByNameContaining", query = "SELECT D FROM Department D WHERE D.name LIKE CONCAT('%',:pattern,'%')")
})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

}
