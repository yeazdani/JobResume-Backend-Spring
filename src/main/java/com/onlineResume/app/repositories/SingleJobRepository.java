package com.onlineResume.app.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.onlineResume.app.models.SingleJob;

public interface SingleJobRepository extends MongoRepository<SingleJob,String>{
//	List<SingleJob> findByLimit(Pageable pageable);
    public List<SingleJob> findByUid(String uid);
}
