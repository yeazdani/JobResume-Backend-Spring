package com.onlineResume.app.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("singleJobs")
public class SingleJob {
	@Id
	private String id;
	private String uid;
	private JobPost job;
	
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
	public JobPost getJob() {
		return job;
	}
	public void setJob(JobPost job) {
		this.job = job;
	}
	
}
