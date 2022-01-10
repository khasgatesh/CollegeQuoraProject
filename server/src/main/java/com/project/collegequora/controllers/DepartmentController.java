package com.project.collegequora.controllers;

import java.util.List;

import com.project.collegequora.Response;
import com.project.collegequora.models.Department;
import com.project.collegequora.repository.DepartmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @PostMapping("/addDepartment")
    public Response addDepartment(@RequestBody Department department)
    {
        if(departmentRepository.count()>0){
            List<Department> data = departmentRepository.findAll();
            for(Department dept: data){
                if(dept.getDept_id().equals(department.getDept_id())){
                    
                    return new Response(400,"Department Id Already exists",dept);
                }
            }
        }   
        departmentRepository.save(department);
        return new Response(200,"Department saved Successfully", "");
    }

    @GetMapping("/findDepartments")
    public Response findUser()
    {
        List<Department> dept=departmentRepository.findAll();
        return new Response(200,"Fetched successfully", dept);
    }
}
