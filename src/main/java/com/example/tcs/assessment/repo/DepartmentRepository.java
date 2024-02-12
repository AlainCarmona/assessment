package com.example.tcs.assessment.repo;


import com.example.tcs.assessment.model.Department;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
