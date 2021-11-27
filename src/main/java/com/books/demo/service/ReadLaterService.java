package com.books.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.demo.dao.ReadLaterRepo;
import com.books.demo.entities.ReadLater;

@Service
public class ReadLaterService {

	@Autowired
	ReadLaterRepo readLaterRepo;

	public void saveReadLater(ReadLater readLater) {
		readLaterRepo.save(readLater);
	}

	public List<ReadLater> showReadLater(String name) {
		List<ReadLater> readLater = readLaterRepo.findByName(name);
		return readLater;
	}

	public List<ReadLater> showUserReadLater() {
		List<ReadLater> readLater =readLaterRepo.findAll();
		return readLater;
	}

	public void deleteFromReadLater(ReadLater readLater) {
		
		Optional <ReadLater> readLaterList =readLaterRepo.findById(readLater.getReadID());
		
		if(readLaterList.isPresent()) {
			readLaterRepo.delete(readLaterList.get());
		}
		else {
			throw new RuntimeException("book not found");
		}
	}

}
