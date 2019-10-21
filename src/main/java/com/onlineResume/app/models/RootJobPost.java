package com.onlineResume.app.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("jobs")
public class RootJobPost {
	
	@Id
	private String id;
	private String uid;
	private List<JobPost> postJobs;
	
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
	public List<JobPost> getPostJobs() {
		return postJobs;
	}
	public void setPostJobs(List<JobPost> postJobs) {
		this.postJobs = postJobs;
	}
	

}
