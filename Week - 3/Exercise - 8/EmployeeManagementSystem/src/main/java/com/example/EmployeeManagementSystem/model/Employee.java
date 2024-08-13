package com.example.EmployeeManagementSystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE")
@EntityListeners(AuditingEntityListener.class)  // Enabling auditing for this entity

@NamedQueries({
        @NamedQuery(name = "Employee.fetchByName", query = "SELECT E FROM Employee E WHERE E.firstName = :name"),
        @NamedQuery(name = "Employee.fetchByDepartmentName", query = "SELECT E FROM Employee E WHERE E.department.name = :departmentName"),
        @NamedQuery(name = "Employee.fetchByEmail", query = "SELECT E FROM Employee E WHERE E.email = :email")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
