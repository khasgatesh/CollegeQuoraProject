package com.project.collegequora.service;


import java.util.List;

import com.project.collegequora.models.SystemUser;
import com.project.collegequora.models.SystemUserDetails;
import com.project.collegequora.repository.SystemUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;  
@Service
public class SystemUserDetailsService implements UserDetailsService 
{
	@Autowired
	SystemUserRepository userRepository;

	public boolean addUser(SystemUser user){
        if(userRepository.count() > 0)
        {
            List<SystemUser> data = userRepository.findAll();
            for(SystemUser sys: data){
                if(sys.getUserId().equals(user.getUserId())){
                    
                    return true;
                }
            }
        }   
        userRepository.save(user);
        return false;
    }

	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException 
	{
		SystemUser user = userRepository.findByEmail(email);
		System.out.println("user : "+user);
		
		return new SystemUserDetails(user);
	}
}