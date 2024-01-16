package com.example.tcs.assessment.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer employeeNumber;
    private Integer accountNumber;
    @ManyToOne
    @JoinColumn(name = "department")
    private Department department;
    private String firstName;
    private String lastName;
    private Integer age;
}
