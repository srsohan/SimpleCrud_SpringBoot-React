
package com.employeeRegistration.backend.controller;

import com.employeeRegistration.backend.entity.EmployeeDetails;
import com.employeeRegistration.backend.exception.ResourceNotFoundException;
import com.employeeRegistration.backend.repository.EmployeeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employeedetails")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeDetailsController {

    @Autowired
    public EmployeeDetailsRepository employeeRepository;


    @GetMapping("/getAll")
    public List<EmployeeDetails> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping("/addDetailsEmployee")
    public EmployeeDetails createDetailsEmployee(@RequestBody EmployeeDetails employee) {
        return employeeRepository.save(employee);
    }



    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDetails> updateEmployeeDetails(@PathVariable Long id, @RequestBody EmployeeDetails employeeDetails) {
        EmployeeDetails employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employee.setEmployee(employeeDetails.getEmployee());
        // employee.setId(employeeDetails.getId());
        employee.setAddress(employeeDetails.getAddress());
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());

        // Update employeeDetail if needed

        EmployeeDetails updateEmployeeDetails = employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployeeDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeDetails(@PathVariable Long id) {
        EmployeeDetails employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        employeeRepository.delete(employee);
        return ResponseEntity.noContent().build();
    }

}
