package com.onlineResume.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineResume.app.models.RootExperience;
import com.onlineResume.app.models.Users;


public interface RootExperienceRepository extends MongoRepository<RootExperience,String>{
	public RootExperience findByUid(String uid);

}
