package com.springboot.department.controller;

import com.springboot.department.entity.Department;
import com.springboot.department.exception.DepartmentNotFoundException;
import com.springboot.department.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping(value = "/departments")
    public Department addDepartment(@Valid @RequestBody Department department) {
        departmentService.addDepartment(department);
        return department;
    }

    @GetMapping(value = "/departments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping(value = "/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping(value = "/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully!!!";
    }

    @PutMapping(value = "/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {

        return departmentService.updateDepartment(departmentId, department);
    }

    @GetMapping(value = "/departments/name/{name}")
    public List<Department> getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.getDepartmentByName(departmentName);
    }

    @GetMapping(value = "/departments/address/{address}")
    public List<Department> getDepartmentByAddress(@PathVariable ("address") String address) {
        return departmentService.getDepartmentByAddress(address);
    }

    @DeleteMapping("/departments/delete")
    public ResponseEntity<String> deleteAll() {
        String deleteMessage = departmentService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body(deleteMessage);
    }

}
