package com.project.collegequora.controllers;



import javax.mail.internet.MimeMessage;

import com.project.collegequora.Response;
import com.project.collegequora.models.SystemUser;
import com.project.collegequora.repository.SystemUserRepository;
import com.project.collegequora.response.JWTResponseData;
import com.project.collegequora.security.JwtTokenUtil;
import com.project.collegequora.service.SystemUserDetailsService;
import com.project.collegequora.service.SystemUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class WebController 
{
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private SystemUserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
    @Autowired
    PasswordEncoder passwordEncoder;

	@Autowired
	SystemUserDetailsService systemUserService;

	@Autowired
	SystemUserRepository systemUserRepository;


	@PostMapping("/register")
    public Response addUsers(@RequestBody SystemUser user)
    {

        boolean val=systemUserService.addUser(user);
        if(val){
            return new Response(400,"User already exist",user);
        }
        return new Response(200,"User Saved successfully",user);
    }
    
/*
	@PostMapping("/register")
	public ResponseEntity saveUser(@RequestBody SystemUser user) 
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		SendVerifyMail(user.getName(),user.getEmail(),121);
		SystemUser newUser = userService.saveUser(user);
		if (newUser == null)
			return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		else
			return ResponseEntity.ok(newUser);
	}

	*/

	
	private boolean SendVerifyMail(String name,String email,int otp) 
	{
		try {
			SimpleMailMessage msg = new SimpleMailMessage();
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
	        messageHelper.setFrom("justsample4mail@gmail.com");
	        messageHelper.setTo(email);
	        messageHelper.setSubject("Verification Mail from PatientWeb");
	        messageHelper.setText("<b>Hello</b>", true);
	        javaMailSender.send(mimeMessage);
			return true;
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}



	@PostMapping("/login")
	public ResponseEntity verifyUser(@RequestBody SystemUser user) 
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

			SystemUser newUser = userService.getByEmail(user.getEmail());
			final String token = jwtTokenUtil.generateToken(newUser);

			return ResponseEntity.ok(new JWTResponseData(true, token, "Login Successfully"));
		} catch (DisabledException e) {
			return ResponseEntity.ok(new JWTResponseData(false, "", "User Disabled !"));
		} catch (BadCredentialsException e) {
			return ResponseEntity.ok(new JWTResponseData(false, "", "Invalid User !"));
		}
	}

	/*

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody SystemUser user) 
	{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));

			Optional<SystemUser> userdata = systemUserRepository.findById(user.getEmail());
            boolean userpresent=systemUserRepository.existsById(hospitals.getHospitalid());
            if(userpresent){
                String hosdatais=systemUserDetailsService.gethosid(hospitals);
			final String token = jwtTokenUtil.generateToken(hosdatais);

			return ResponseEntity.ok(new JWTResponseData(true, token, "Login Successfully"));
            }
		} catch (DisabledException e) {
			return ResponseEntity.ok(new JWTResponseData(false, "", "User Disabled !"));
		} catch (BadCredentialsException e) {
			return ResponseEntity.ok(new JWTResponseData(false, "", "Invalid User !"));
		}
        return null;
	}

	*/
}
