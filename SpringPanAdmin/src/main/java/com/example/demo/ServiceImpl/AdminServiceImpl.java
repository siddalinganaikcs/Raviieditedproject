package com.example.demo.ServiceImpl;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.AdminNotFoundException;
import com.example.demo.Exception.ConfirmFassword_Not_Matched;
import com.example.demo.Exception.EmailandpasswordinvalidException;
import com.example.demo.Repository.AdminRepo;
import com.example.demo.Service.AdminService;
import com.example.demo.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepo adminRepo;
	
	
	@Autowired
	private JavaMailSender mailsender;
	 
	
	@Override
	public Object adminsignup(Admin admin) {
		Admin email =adminRepo.findByEmail(admin.getAdmin_Email());
		
		if(email ==null) {
			adminRepo.save(admin);
			SimpleMailMessage mess = new SimpleMailMessage();
			mess.setFrom("siddalinganaikcs@gmail.com");
			mess.setTo(admin.getAdmin_Email());
			mess.setSubject("you are login successfully");
			mess.setText("you are login succesfully");
			
			mailsender.send(mess);
			return adminRepo.save(admin);
		}
		else {
			 try {
				 throw new AdminNotFoundException(admin);
			 }
			 catch (AdminNotFoundException e){
				 return e.getMessage();
			 }
		}
			 
	}

	@Override
	public Object adminlogin(String email, String pwd) {
		 
		 
	Admin pass=	adminRepo.findByEmailPassword(email, pwd);
	
	System.out.println(email+" "+pwd);
	
	if(pass!=null)
	{
		
		return pass;
		
	}else {
		
		try {
			throw new EmailandpasswordinvalidException(email);
		}
		catch(EmailandpasswordinvalidException f) { 
			return f.getMessage();
		}
	}
		

	}
	@Override
	public Object adminforgetpass(String emil, String password, String conformpassword) {
	
		Admin bbb = adminRepo.findByEmail(emil);
		
		if(bbb!=null  && password.equals(conformpassword))
		{ 

				bbb.setAdmin_Password(password);
				bbb.setAdmin_Email(emil);
				 
				   SimpleMailMessage mess = new SimpleMailMessage();
				   mess.setFrom("siddalinganaikcs@gmail.com");
				   mess.setTo(emil);
				   mess.setSubject("password successfully update");
				   mess.setText("password successfully update");
				   
				   mailsender.send(mess);
				 adminRepo.save(bbb);
				 return bbb;}
		else
		{
			try
			{
				throw new ConfirmFassword_Not_Matched(conformpassword);
			}
			catch(ConfirmFassword_Not_Matched g)
			{
				return g.getMessage();
			}
			
		}
	}


 
}
