/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.controller;

import com.springdata.first.Exceptions.EmployeeNotFoundException;
import com.springdata.first.model.Employee;
import com.springdata.first.dto.EmployeeDto;
import com.springdata.first.service.EmpService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {
    @Autowired
    private EmpService empService;
    
    @GetMapping ("/get-emp")
    public EmployeeDto getUser(@RequestParam Integer id){
        EmployeeDto dto;
           dto= empService.getUser(id);
           if(dto==null){
               throw new EmployeeNotFoundException("Oops can't get all employees with custom exception");
           }
        return dto;
    }
    
    @PostMapping ("/save-emp")
    public EmployeeDto save(@RequestBody EmployeeDto employee){
        return empService.saveemp(employee); 
    }
    
    @GetMapping ("/delete-emp")
    public void delete(@RequestParam Integer id){
        empService.delete(id);
    }
    
    @PostMapping ("/update-emp")
    public EmployeeDto update(@RequestBody EmployeeDto employee){
        return empService.saveemp(employee);
    }
    
    @GetMapping ("/get-all")
    public List <Employee> getAll() {
        return this.empService.getAll();
    }
    
}
