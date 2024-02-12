package com.example.tcs.assessment.controller;

import com.example.tcs.assessment.model.Employee;
import com.example.tcs.assessment.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository repo;

    @GetMapping("employee")
    public List<Employee> getAllEmployees(){
        return repo.findAll();
    }

    @GetMapping("employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id){
        return repo.findById(id).orElse(new Employee());
    }

    @PostMapping("employee")
    public Employee addEmployee(@RequestBody Employee employee){
        repo.save(employee);
        return employee;
    }

    @PutMapping("employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        repo.save(employee);
        return employee;
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmployee(@PathVariable("id") int id){
        repo.deleteById(id);
        return "record deleted";
    }

}
