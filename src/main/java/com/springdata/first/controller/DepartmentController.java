/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.controller;

import com.springdata.first.Exceptions.DepartmentNotFoundException;
import com.springdata.first.dto.DepartmentDto;
import com.springdata.first.model.Department;
import com.springdata.first.service.DepService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Departments")

public class DepartmentController {
    
    @Autowired
    private DepService depService;
    
    @GetMapping ("/get-dep")
    public DepartmentDto getId(@RequestParam Integer id){
        DepartmentDto dto;
           dto= depService.getId(id);
           if(dto==null){
               throw new DepartmentNotFoundException("Oops can't get all departments with custom exception");
           }
        return dto;
    }
    
    @PostMapping ("/save-dep")
    public DepartmentDto save(@RequestBody DepartmentDto department){
        return depService.savedep(department); 
    }
    
    @GetMapping ("/delete-dep")
    public void delete(@RequestParam Integer id){
        depService.delete(id);
    }
    
    @PostMapping ("/update-dep")
    public DepartmentDto update(@RequestBody DepartmentDto department){
        return depService.savedep(department);
    }
    
    @GetMapping ("/get-all")
    public List <Department> getAll() {
        return this.depService.getAll();
    }
    
    
}
