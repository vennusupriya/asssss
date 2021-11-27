package com.books.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.demo.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	User findByNameAndPassword(String name, String password);
}
