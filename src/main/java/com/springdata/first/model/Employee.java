/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.model;

import com.springdata.first.dto.EmployeeDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Table (name = "employees")
@Entity
@Data
@Builder

public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="emp_id")
    private Integer id;
    @Column(name="first_name")
    private String firstname;
    @Column(name="last_name")
    private String lastname;
    private double salary;
    
    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    public static Employee toEntity(EmployeeDto dto){
        return Employee.builder()
                .id(dto.getId())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .salary(dto.getSalary())
                .build();
    }

    public Employee() {
    }

    public Employee(Integer id, String firstname, String lastname, double salary, Department department) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.salary = salary;
        this.department = department;
    }

  
    
}
