package com.springboot.department.service;

import com.springboot.department.entity.Department;
import com.springboot.department.exception.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public void addDepartment(Department department);

   public List<Department> getAllDepartments();

   public Department getDepartmentById(Long id) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long id);

   public Department updateDepartment(Long departmentId, Department department);

   public List<Department> getDepartmentByName(String departmentName);

   public List<Department> getDepartmentByAddress(String address);

   public String deleteAll();
}
