package com.example.springboot_backend.controler;

import com.example.springboot_backend.exception.ResourceNotFoundException;
import com.example.springboot_backend.model.Employee;
import com.example.springboot_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeControler {

    @Autowired
    private EmployeeRepository repository;

    //get all employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    //create employee rest api
    @PostMapping("/employees")
    public Employee createEmployee (@RequestBody Employee employee){
        return repository.save(employee);
    }

    //get employee by ID rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee>  getEmployeeById (@PathVariable Long id){
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this Id :" + id));
        return ResponseEntity.ok(employee);
    }

    //update employees rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody  Employee employeeDetails){
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this Id :" + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        Employee updateEmployee = repository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }

}
