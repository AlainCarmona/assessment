package com.example.tcs.assessment.bootstrap;

import com.example.tcs.assessment.model.Department;
import com.example.tcs.assessment.model.Employee;
import com.example.tcs.assessment.repo.DepartmentRepository;
import com.example.tcs.assessment.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public void run(String... args){


        employeeRepository.save(new Employee(1,1232434, 5674423, "David", "Moreno", 25,new Department(2, "TI", "Av. Mario Colin 27")));

        employeeRepository.save(new Employee(2,2384534, 5664203, "Alain", "Carmona", 37,new Department(2, "TI", "Av. Mario Colin 27")));

        employeeRepository.save(new Employee(3,1232434, 5674423, "David", "Moreno", 40,new Department(3, "Finanzas", "Av. Mario Colin 25")));
    }

}
