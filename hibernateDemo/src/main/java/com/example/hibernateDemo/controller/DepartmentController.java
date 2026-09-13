package com.example.hibernateDemo.controller;

import com.example.hibernateDemo.entity.Department;
import com.example.hibernateDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    @PostMapping
//    public ResponseEntity<String> save(@RequestBody Department department) {
//departmentService.create(department);
//return ResponseEntity.ok("Department saved successfully");
//    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<String> remove(@PathVariable Long deptId) {
        departmentService.removeDept(deptId);
        return ResponseEntity.ok("Department deleted successfully");
    }

}
