package com.onlineResume.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineResume.app.models.RootSkills;

public interface RootSkillsRepository extends MongoRepository<RootSkills,String>{
	public RootSkills findByUid(String uid);

}

