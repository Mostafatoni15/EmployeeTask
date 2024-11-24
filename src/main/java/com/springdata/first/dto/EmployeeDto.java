/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.dto;

import com.springdata.first.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDto {
    
    private Integer id;
    private String firstname;
    private String lastname;
    private double salary;
    
    public static EmployeeDto toDto(Employee Entity){
        return EmployeeDto.builder()
                .id(Entity.getId())
                .firstname(Entity.getFirstname())
                .lastname(Entity.getLastname())
                .salary(Entity.getSalary())
                .build();
        
    }
}
