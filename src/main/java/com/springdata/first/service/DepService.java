/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.service;

import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.model.Department;
import com.springdata.first.repository.DepRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service

public class DepService {
    
    @Autowired
    private DepRepo depRepo;
    public DepartmentDto getId(Integer id){
        Optional <Department> dep = this.depRepo.findById(id);
        if(dep.isPresent())
            return DepartmentDto.toDto(dep.get());
        else
            return null;
    }
    
    public DepartmentDto save(DepartmentDto department){
        return DepartmentDto.toDto(depRepo.save(Department.toEntity(department)));
    }
    
    public DepartmentDto savedep(DepartmentDto department){
        return DepartmentDto.toDto(depRepo.save(Department.toEntity(department)));
    }
    
    public void delete(Integer id){
        this.depRepo.deleteById(id);
    }
    
    public List <Department> getAll() {
       return this.depRepo.findAll();
    }
}
