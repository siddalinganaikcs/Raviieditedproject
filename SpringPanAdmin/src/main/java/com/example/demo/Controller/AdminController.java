package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.AdminService;
import com.example.demo.entity.Admin;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminservice;
	
	@PostMapping("/adminsignup") 
	ResponseEntity<?> adminsignup(@RequestBody Admin admin){
		Object signup = adminservice.adminsignup(admin); 
		if(signup!="Admin not found exception") 
		{ 
			return ResponseEntity.status(200).body("Admin successfully  signup");
		}
		else 
		{ 
			return ResponseEntity.status(400).body(adminservice.adminsignup(admin));
	    }
	}
	
	@GetMapping("/adminlogin") 
	
	ResponseEntity<Object> adminlogin(@RequestHeader String email ,@RequestHeader String pwd){
		Object login = adminservice.adminlogin(email, pwd); 
		
		if(login!= "Email and password Are Not Invaled pls Check Again")
		{ 
			return ResponseEntity.status(200).body("Admin login successfully");
		}
		else 
		{ 
			return ResponseEntity.status(400).body(adminservice.adminlogin(email, pwd));
	    }
	}
	
	@GetMapping("adminforgetpassword")
	ResponseEntity<?> adminforgrtpass(@RequestHeader String email ,
			@RequestHeader String password,@RequestHeader String conformpassword)
	{
		
		 Object login = adminservice.adminforgetpass(email, password, conformpassword);
		  
		 if(login !=  "Conform Password not mached")
		 {
			 return ResponseEntity.status(200).body("password successfully update");
		 }
		 else
		 {
			 return ResponseEntity.status(400).body(adminservice.adminforgetpass(email, password, conformpassword));
		 }
	}
	
}
 