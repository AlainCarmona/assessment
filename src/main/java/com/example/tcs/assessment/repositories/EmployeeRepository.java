package com.example.tcs.assessment.repositories;
import com.example.tcs.assessment.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByEmployeeNumber(Integer employeeNumber);
}