package com.onlineResume.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineResume.app.models.UserInfo;

public interface UsersInfoRepository extends MongoRepository<UserInfo,String>{

}
