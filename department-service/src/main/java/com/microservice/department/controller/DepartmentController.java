package com.microservice.department.controller;

import com.microservice.department.model.Department;
import com.microservice.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping("")
    private Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    private Department findDepartmentById(@PathVariable Long departmentId){
        return departmentService.findDepartmentById(departmentId);
    }
}
