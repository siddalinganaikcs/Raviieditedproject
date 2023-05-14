package com.example.demo.Exception;

import com.example.demo.entity.Admin;

public class EmailandpasswordinvalidException extends RuntimeException {

	public EmailandpasswordinvalidException(String email) {
		super("Email and password Are Not Invaled pls Check Again");
		 
	}

	
	
}
