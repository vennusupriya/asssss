package com.books.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.demo.dao.LikeBookRepo;
import com.books.demo.entities.Like;

@Service
public class LikeBookService {
	
	@Autowired
	LikeBookRepo likeBookRepo;
	
	public void saveLikeBook(Like like) {
		likeBookRepo.save(like);
	}
	
	public List<Like> showLikeBooks(String name) {
		  List<Like> like = likeBookRepo.findByName(name);
	  	return like;
	  }
	
	public List<Like> showUserLikeBooks() {
		  List<Like> like = likeBookRepo.findAll();
	  	return like;
	  }

	public void deleteFromLike(Like like) {
		
		Optional <Like> likeList =likeBookRepo.findById(like.getLiked_book_id());
		
		if(likeList.isPresent()) {
			likeBookRepo.delete(likeList.get());
		}
		else {
			throw new RuntimeException("book not found");
		}
	}
}
