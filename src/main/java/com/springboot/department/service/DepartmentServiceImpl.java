package com.springboot.department.service;


import com.springboot.department.entity.Department;
import com.springboot.department.exception.DepartmentNotFoundException;
import com.springboot.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public void addDepartment(Department department) {
        repository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department = repository.findById(id);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException(String.format("Department not found for department id : %d", id));
        }

        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {

        // Fetch the old department from the DB using id
        Department dbDepartment = repository.findById(departmentId).get();

        // check in the department which parameter do we want to update
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            dbDepartment.setDepartmentName(department.getDepartmentName());
        }

        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            dbDepartment.setDepartmentCode(department.getDepartmentCode());
        }

        if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            dbDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        return repository.save(dbDepartment);
    }

    @Override
    public List<Department> getDepartmentByName(String departmentName) {
        return repository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public List<Department> getDepartmentByAddress(String address) {
        return repository.findByDepartmentAddressIgnoreCase(address);
    }

    @Override
    public String deleteAll() {
        repository.deleteAll();
        return "Successfully flushed the database";
    }


}
