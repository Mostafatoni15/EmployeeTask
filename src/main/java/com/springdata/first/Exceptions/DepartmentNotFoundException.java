/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springdata.first.Exceptions;

/**
 *
 * @author lenovo
 */
public class DepartmentNotFoundException extends RuntimeException{
    
    public DepartmentNotFoundException(String message){
        super(message);
    }
    
}
