package com.example.tcs.assessment.services;

import com.example.tcs.assessment.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee> findAll();

    public void save(Employee employee);

    public void delete(Employee employee);

    public Employee findByEmployeeNumber(Integer employeeNumber);
}
