package com.example.demo.Exception;

import com.example.demo.entity.Admin;

public class AdminNotFoundException extends RuntimeException {

	public AdminNotFoundException(Admin message) {
		super("Admin not found exception");
		// TODO Auto-generated constructor stub
	}

	
}
