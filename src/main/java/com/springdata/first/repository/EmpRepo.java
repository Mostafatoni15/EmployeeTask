package com.springdata.first.repository;

import com.springdata.first.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



/**
 *
 * @author lenovo
 */
public interface EmpRepo extends JpaRepository<Employee, Integer>{
    
}