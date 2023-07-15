package com.springboot.department.repository;

import com.springboot.department.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


// JpaRepository<Entity, Type of the primary key>  - It has all the Methods through which we can perform the CRUD operations

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public List<Department> findByDepartmentNameIgnoreCase(String name);

    public List<Department> findByDepartmentCodeIgnoreCase(String code);

    public List<Department> findByDepartmentAddressIgnoreCase(String address);
}
