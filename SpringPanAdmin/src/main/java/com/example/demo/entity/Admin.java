package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Admin_Id;
	
 
	private String Admin_Name;
	
 
	private String Admin_Email;
	
 
	private String Admin_Password;
	
	public long getAdmin_Id() {
		return Admin_Id;
	}
	public void setAdmin_Id(long admin_Id) {
		Admin_Id = admin_Id;
	}
	public String getAdmin_Name() {
		return Admin_Name;
	}
	public void setAdmin_Name(String admin_Name) {
		Admin_Name = admin_Name;
	}
	public String getAdmin_Email() {
		return Admin_Email;
	}
	public void setAdmin_Email(String admin_Email) {
		Admin_Email = admin_Email;
	}
	public String getAdmin_Password() {
		return Admin_Password;
	}
	public void setAdmin_Password(String admin_Password) {
		Admin_Password = admin_Password;
	}
	@Override
	public String toString() {
		return "Admin [Admin_Id=" + Admin_Id + ", Admin_Name=" + Admin_Name + ", Admin_Email=" + Admin_Email
				+ ", Admin_Password=" + Admin_Password + "]";
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(long admin_Id, String admin_Name, String admin_Email, String admin_Password) {
		super();
		Admin_Id = admin_Id;
		Admin_Name = admin_Name;
		Admin_Email = admin_Email;
		Admin_Password = admin_Password;
	}
	
	
	
}
