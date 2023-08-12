package com.employeeRegistration.backend.repository;

import com.employeeRegistration.backend.entity.Employee;
import com.employeeRegistration.backend.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails,Long> {
    EmployeeDetails findByEmployee(Employee employee);
}
