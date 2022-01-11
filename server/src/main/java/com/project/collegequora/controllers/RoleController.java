package com.project.collegequora.controllers;

import java.util.List;

import com.project.collegequora.Response;
import com.project.collegequora.models.Role;
import com.project.collegequora.repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RoleController {
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/addRole")
    public Response addRole(@RequestBody Role role)
    {
        if(roleRepository.count()>0){
            List<Role> data = roleRepository.findAll();
            for(Role rl: data){
                if(rl.getRole_id().equals(role.getRole_id())){
                    
                    return new Response(400,"Department Id Already exists",rl);
                }
            }
        }   
        roleRepository.save(role);
        return new Response(200, "Role saved Successfully", "");
    }

    @GetMapping("/findDepartments")
    public Response findUser()
    {
        List<Role> rl=roleRepository.findAll();
        return new Response(200,"Fetched successfully", rl);
    }
}
