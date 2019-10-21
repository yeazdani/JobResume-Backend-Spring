package com.onlineResume.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineResume.app.models.RootJobPost;

public interface RootPostJobRepository extends MongoRepository<RootJobPost,String>{
	public RootJobPost findByUid(String uid);

}
