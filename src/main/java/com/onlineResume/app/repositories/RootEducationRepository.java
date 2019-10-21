package com.onlineResume.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineResume.app.models.RootEducation;
import com.onlineResume.app.models.RootExperience;

public interface RootEducationRepository extends MongoRepository<RootEducation,String> {
	public RootEducation findByUid(String uid);
}
