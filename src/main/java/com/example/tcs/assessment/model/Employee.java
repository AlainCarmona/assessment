package com.example.tcs.assessment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private long employeeNumber;

    private int accountNumber;
    private String firstName;
    private String lastName;
    private int age;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

}
