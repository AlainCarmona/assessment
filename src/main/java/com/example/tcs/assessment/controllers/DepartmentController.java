package com.example.tcs.assessment.controllers;

import com.example.tcs.assessment.entities.Department;
import com.example.tcs.assessment.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @GetMapping("/find-all")
    public ResponseEntity<List<Department>> findAll (){
        try {
            List<Department> departments = service.findAll();
            return ResponseEntity.ok(departments);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<Department> findById (@RequestParam Integer id){
        try {
            Department department = service.findById(id);
            return ResponseEntity.ok(department);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Department> create (
            @RequestParam String name,
            @RequestParam String address
    ){
        try {
            int id = service.findAll().size() + 1;
            service.save(Department.builder()
                    .id(id)
                    .name(name)
                    .address(address)
                    .build());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Department> delete (
            @RequestParam Integer id
    ){
        try {
            Department department = service.findById(id);
            service.delete(department);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<Department> update (
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam String address
    ){
        try {
            Department department = service.findById(id);
            department.setName(name);
            department.setAddress(address);
            service.save(department);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
