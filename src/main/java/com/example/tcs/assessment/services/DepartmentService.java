package com.example.tcs.assessment.services;

import com.example.tcs.assessment.entities.Department;
import com.example.tcs.assessment.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    @Override
    public Department findById(Integer id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public void save(Department department) {
    	departmentRepository.save(department);
    }

    @Override
    public void delete(Department department) {
    	departmentRepository.delete(department);
    }
}
