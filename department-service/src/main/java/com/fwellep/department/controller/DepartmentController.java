package com.fwellep.department.controller;

import com.fwellep.department.entity.Department;
import com.fwellep.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    public List <Department> getAllDepartments(){
        log.info("Inside getAllDepartments method of DepartmentController");
        return departmentService.getAllDepartments();
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside findDepartmentById method of DepartmentController");
        return departmentService.findDepartmentById(departmentId);
    }

    @PutMapping("/{id}")
    public void updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        log.info("Inside updateDepartment method of DepartmentController");
        departmentService.updateDepartment(departmentId, department);

    }

    @DeleteMapping("/{id}")
    public void deleteDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside deleteDepartmentById method of DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
    }
}
