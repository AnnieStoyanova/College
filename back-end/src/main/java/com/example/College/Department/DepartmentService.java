package com.example.College.Department;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Optional<Department> findById(Long id){
        return departmentRepo.findById(id);
    }

    public void addNewDepartment(Department department) {
        departmentRepo.saveAndFlush(department);
    }

    public List<Department> findAll(){
        return departmentRepo.findAll();
    }

    @Transactional
    public void deleteDepartment(Long departmentId) {
        boolean exists = departmentRepo.existsById(departmentId);
        if(!exists){
            throw new IllegalArgumentException("Department with id" + departmentId + "does not exist");
        }
        departmentRepo.deleteById(departmentId);
    }


}
