package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Admin;

@Repository
public interface AdminRepo  extends JpaRepository<Admin, Long> {

	@Query(value = "select * from  admin where admin_email=?1" , nativeQuery = true)
	public Admin findByEmail(String email);
	
	@Query(value = "select * from  admin where admin_email=?1 and admin_password=?2" , nativeQuery = true)
	public Admin findByEmailPassword(String email ,String password);
	
	
	
}
