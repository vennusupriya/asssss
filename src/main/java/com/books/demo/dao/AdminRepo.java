package com.books.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.demo.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	Admin findByNameAndPassword(String name, String password);
}