/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.dto;

import com.springdata.first.model.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DepartmentDto {
    
    private Integer id;
    private String name;
    private Integer num;
    
    public static DepartmentDto toDto(Department Entity){
        return DepartmentDto.builder()
                .id(Entity.getId())
                .name(Entity.getName())
                .num(Entity.getNum())
                .build();
        
    }
    
}
