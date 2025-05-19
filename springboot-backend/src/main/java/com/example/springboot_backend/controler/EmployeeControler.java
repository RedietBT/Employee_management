package com.example.springboot_backend.controler;

import com.example.springboot_backend.model.Employee;
import com.example.springboot_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
