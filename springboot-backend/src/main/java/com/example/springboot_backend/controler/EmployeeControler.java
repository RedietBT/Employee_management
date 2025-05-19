package com.example.springboot_backend.controler;

import com.example.springboot_backend.model.Employee;
import com.example.springboot_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //get employee by ID
//    @GetMapping("{id}")
//    public Employee getEmployeeById(@PathVariable Long id){
//        return repository.findById(id)
//                .orElseThrow();
//    }
}
