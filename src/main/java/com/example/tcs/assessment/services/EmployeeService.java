package com.example.tcs.assessment.services;

import com.example.tcs.assessment.entities.Department;
import com.example.tcs.assessment.entities.Employee;
import com.example.tcs.assessment.repositories.DepartmentRepository;
import com.example.tcs.assessment.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public void save(Employee employee) {
    	employeeRepository.save(employee);
    }

    public void delete(Employee employee) {
    	employeeRepository.delete(employee);
    }

    public Employee findByEmployeeNumber(Integer employeeNumber) {
        return employeeRepository.findByEmployeeNumber(employeeNumber);
    }
}
