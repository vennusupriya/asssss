package com.books.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.demo.entities.Like;

public interface LikeBookRepo extends JpaRepository<Like, Integer>{
	List<Like> findByName(String name);
}
