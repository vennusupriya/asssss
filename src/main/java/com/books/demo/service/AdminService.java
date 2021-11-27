package com.books.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.demo.dao.AdminRepo;
import com.books.demo.entities.Admin;

@Service
public class AdminService {
	@Autowired
	AdminRepo adminRepo;
	
	public void save(Admin admin) {
		adminRepo.save(admin);
	}	
	
	
	public Admin adminLogin(String name, String password) {
		Admin admin = adminRepo.findByNameAndPassword(name, password);
	  	return admin;
	  }
}

