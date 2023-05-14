package com.example.demo.Service;

import com.example.demo.entity.Admin;

public interface AdminService {

	public Object adminsignup(Admin admin);
	
	public Object adminlogin(String email , String password);
	
	public Object adminforgetpass(String emil,String password,String conformpassword);
	
}
