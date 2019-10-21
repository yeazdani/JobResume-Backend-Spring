package com.onlineResume.app.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineResume.app.models.Users;

@Repository
public interface UsersRepository extends MongoRepository<Users,String> {
     
	public Users findByEmail(String email);
//	public List<Users> findByName(String name);
    
}
