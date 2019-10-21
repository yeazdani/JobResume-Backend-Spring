package com.onlineResume.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineResume.app.models.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String>{
	public Photo findByUid(String uid);
}
