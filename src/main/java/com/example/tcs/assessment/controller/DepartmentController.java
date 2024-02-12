package com.example.tcs.assessment.controller;

import com.example.tcs.assessment.model.Department;
import com.example.tcs.assessment.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentRepository repo;

    @GetMapping("department")
    public List<Department> getAllDepartments(){
        return repo.findAll();
    }
}
