package com.example.EmployeeManagementSystem.projections;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeFullNameProjection {
    @Value("#{target.firstName + ' ' + target.lastName}")
    String getFullName();
}
