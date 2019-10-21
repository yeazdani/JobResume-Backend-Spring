package com.onlineResume.app.services;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.onlineResume.app.models.Photo;
import com.onlineResume.app.repositories.PhotoRepository;

@Service
public class PhotoService {
	@Autowired
	private PhotoRepository photoRepo;

	public void addPhoto(String uid, MultipartFile file) throws IOException { 
		Photo photo = new Photo(uid); 
		photo.setImage(
				new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
		photoRepo.insert(photo); 
	}

	public Photo getPhoto(String uid) { 
		return photoRepo.findById(uid).get(); 
	}
}
