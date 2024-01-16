package com.example.tcs.assessment.services;

import com.example.tcs.assessment.entities.Department;

import java.util.List;

public interface IDepartmentService {
    public List<Department> findAll();

    public Department findById(Integer id);

    public void save(Department department);

    public void delete(Department department);

}
