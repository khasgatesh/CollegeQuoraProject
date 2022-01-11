package com.project.collegequora.repository;

import com.project.collegequora.models.Role;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String>{
    
}
