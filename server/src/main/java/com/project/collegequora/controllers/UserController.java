package com.project.collegequora.controllers;

//import com.project.collegequora.Response;
import com.project.collegequora.repository.SubjectRepository;
import com.project.collegequora.repository.SystemUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	SystemUserRepository userRepository;

    @Autowired
	SubjectRepository subjectRepository;
    
    /*
	@PostMapping("/register")
	public Response register(@RequestBody User user)
    {
        userRepository.save(user);
        return new Response(200, "registration successfull",subjectRepository.findAllByDeptId(user.getDeptId()));
	
           
    }
	@PostMapping("/login")
    public Response login(@RequestBody User user)
    {
        if(userRepository.findByEmail(user.getEmail()).equals(user)){
            return new Response(200,"login successful",subjectRepository.findAllByDeptId(user.getDeptId()));
        }
        else{
            return new Response(404,"user not found",new User());
        }
    }
    */
}
            
     