package com.project.collegequora.controllers;

import java.util.List;

import com.project.collegequora.Response;
import com.project.collegequora.models.User;
import com.project.collegequora.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	UserRepository userRepository;

	@PostMapping("/register")
	public Response addUser(@RequestBody User user)
    {
	if(userRepository.count()>0)
        {
            List<User> list= userRepository.findAll();
            for (User user2 : list) {
                if(user2.getEmail().equals(user.getEmail())){
                    return new Response(400, "Already exists", user2);
                }
                }
            }
            userRepository.save(user);
        return new Response(200, "registration successfull", "user saved");
    }
/*
	@PostMapping("/login")
	public Response logIn(@RequestBody User verifyuser) {

		User user = userRepository.findByEmail(verifyuser.getEmail());
		if (user.getPassword().equals(verifyuser.getPassword())) {
			return new Response(200, "success");
		}
		return new Response(500, "register first");
	}

*/
	@PostMapping("/login")
    public Response login(@RequestBody User user)
    {
        if(userRepository.count()>0){
            List<User> data = userRepository.findAll();
            for(User us: data){
                if(us.getEmail().equals(user.getEmail()) &&us.getPassword().equals(user.getPassword())){
                    return new Response(200,"Logged in successfully", us);
                }
            }
        }       
        return new Response(400,"data Not found", "please enter valid details");
    }

	@GetMapping("/findUsers")
    public Response findUser()
    {
        List<User> us=userRepository.findAll();
        return new Response(200,"Fetched successfully", us);
    }
}