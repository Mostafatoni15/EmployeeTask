/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.model;

import com.springdata.first.dto.DepartmentDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Table (name = "department")
@Entity
@Data
@Builder

public class Department {
    //id , name
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="department_id")
    private Integer id;
    @Column(name="department_name")
    private String name;
    @Column(name="number_of_employees")
    private Integer num; 
    
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employees;
    
    
    public static Department toEntity(DepartmentDto dto){
        return Department.builder()
                .id(dto.getId())
                .name(dto.getName())
                .num(dto.getNum())
                .build();
    }
    
    public Department() {
    }

    public Department(Integer id, String name, Integer num, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.employees = employees;
    }
    
}
