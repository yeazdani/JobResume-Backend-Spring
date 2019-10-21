package com.onlineResume.app.models;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("photos")
public class Photo {
	@Id
	private String id;

	private String uid;

	private Binary image;
	
	public Photo(String uid) {
		this.uid = uid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}


	public Binary getImage() {
		return image;
	}

	public void setImage(Binary image) {
		this.image = image;
	}
	
	
}
