package com.example.EmployeeManagementSystem.model.secondary;


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
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENT")
@EntityListeners(AuditingEntityListener.class)  // Enabling auditing for this entity

@NamedQueries({
        @NamedQuery(name = "Department.fetchByName", query = "SELECT D FROM Department D WHERE D.name = :name"),
        @NamedQuery(name = "Department.fetchDepartmentByNameContaining", query = "SELECT D FROM Department D WHERE D.name LIKE CONCAT('%',:pattern,'%')")
})
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

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
