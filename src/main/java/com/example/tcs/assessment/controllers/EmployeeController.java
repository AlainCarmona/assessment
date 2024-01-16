package com.example.tcs.assessment.controllers;

import com.example.tcs.assessment.entities.Department;
import com.example.tcs.assessment.entities.Employee;
import com.example.tcs.assessment.services.DepartmentService;
import com.example.tcs.assessment.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Employee>> findAll (){
        try {
            List<Employee> employees = employeeService.findAll();
            return ResponseEntity.ok(employees);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find-by-employee-number")
    public ResponseEntity<Employee> findById (@RequestParam Integer employeeNumber){
        try {
            Employee employee = employeeService.findByEmployeeNumber(employeeNumber);
            return ResponseEntity.ok(employee);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> create (
            @RequestParam Integer employeeNumber,
            @RequestParam Integer accountNumber,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Integer age,
            @RequestParam Integer department
    ){
        try {
            int id = employeeService.findAll().size() + 1;
            employeeService.save(Employee.builder()
                    .id(id)
                    .employeeNumber(employeeNumber)
                    .accountNumber(accountNumber)
                    .firstName(firstName)
                    .lastName(lastName)
                    .age(age)
                    .department(Department.builder().id(department).build())
                    .build());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update (
            @RequestParam Integer id,
            @RequestParam Integer employeeNumber,
            @RequestParam Integer accountNumber,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam Integer age,
            @RequestParam Integer department
    ){
        try {
            employeeService.save(Employee.builder()
                    .id(id)
                    .employeeNumber(employeeNumber)
                    .accountNumber(accountNumber)
                    .firstName(firstName)
                    .lastName(lastName)
                    .age(age)
                    .department(Department.builder().id(department).build())
                    .build());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Employee> delete (
            @RequestParam Integer employeeNumber
    ){
        try {
            Employee employee = employeeService.findByEmployeeNumber(employeeNumber);
            employeeService.delete(employee);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
