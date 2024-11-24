/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.service;

import com.springdata.first.model.Employee;
import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.repository.EmpRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {
    
    @Autowired
    private EmpRepo empRepo;
    public EmployeeDto getUser(Integer id){
        Optional <Employee> emp = this.empRepo.findById(id);
        if(emp.isPresent())
            return EmployeeDto.toDto(emp.get());
        else
            return null;
    }
    
    public EmployeeDto save(EmployeeDto employee){
        return EmployeeDto.toDto(empRepo.save(Employee.toEntity(employee)));
    }
    
    public EmployeeDto saveemp(EmployeeDto employee){
        return EmployeeDto.toDto(empRepo.save(Employee.toEntity(employee)));
    }
    
    public void delete(Integer id){
        this.empRepo.deleteById(id);
    }
    
    public List <Employee> getAll() {
       return this.empRepo.findAll();
    }
    
}
