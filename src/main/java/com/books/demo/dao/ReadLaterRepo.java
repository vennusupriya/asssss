package com.books.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.demo.entities.ReadLater;

public interface ReadLaterRepo extends JpaRepository<ReadLater, Integer>{
	List<ReadLater> findByName(String name);
	
}
