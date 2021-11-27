package com.books.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.demo.dao.LikeBookRepo;
import com.books.demo.dao.ReadLaterRepo;
import com.books.demo.dao.UserRepo;
import com.books.demo.entities.User;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	ReadLaterRepo readLaterRepo;

	@Autowired
	LikeBookRepo likeRepo;

	public void save(User user) {
		userRepo.save(user);
	}

	public User login(String name, String password) {
		User user = userRepo.findByNameAndPassword(name, password);
		return user;
	}

	public List<User> showUser() {
		List<User> user = userRepo.findAll();
		return user;
	}
}
