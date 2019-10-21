package com.onlineResume.app.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineResume.app.models.JobPost;

public interface AllJobsRepository extends MongoRepository<JobPost,String> {

}
