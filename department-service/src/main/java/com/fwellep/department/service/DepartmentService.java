package com.fwellep.department.service;

import com.fwellep.department.entity.Department;
import com.fwellep.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    public Department saveDepartment(Department department) {
        log.info("Inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(Long departmentId) {
        log.info("Inside findDepartmentById of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }

    public void deleteDepartmentById(Long departmentId) {
        log.info("Inside deleteDepartmentById method of departmentService");
        departmentRepository.deleteById(departmentId);
    }

    public void updateDepartment(Long departmentId, Department department) {
        log.info("Inside updateDepartment method of departmentService");
        if (departmentRepository.existsById(departmentId)){
            department.setDepartmentId(departmentId);
            departmentRepository.save(department);

        }
    }


}
