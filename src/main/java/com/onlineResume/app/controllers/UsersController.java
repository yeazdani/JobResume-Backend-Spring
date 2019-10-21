package com.onlineResume.app.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.bson.internal.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.onlineResume.app.models.Experience;
import com.onlineResume.app.models.JobPost;
import com.onlineResume.app.models.Login;
import com.onlineResume.app.models.LoginSuccess;
import com.onlineResume.app.models.Photo;
import com.onlineResume.app.models.RootEducation;
import com.onlineResume.app.models.RootExperience;
import com.onlineResume.app.models.RootJobPost;
import com.onlineResume.app.models.RootSkills;
import com.onlineResume.app.models.SingleJob;
import com.onlineResume.app.models.UserInfo;
import com.onlineResume.app.models.Users;
import com.onlineResume.app.services.AppService;
import com.onlineResume.app.services.PhotoService;

@RestController
public class UsersController {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
			}
		};
	}

	@Autowired
	private AppService appService;

	@Autowired
	private PhotoService photoService;

	@RequestMapping(method=RequestMethod.POST, value="/signup")
	public void createUser(@RequestBody Users user) {
		appService.createUser(user);
	}

	@RequestMapping(method=RequestMethod.POST, value="/login")
	public LoginSuccess login(@RequestBody Login user) {
		return appService.login(user);
	}

	@RequestMapping("/userinfo")
	public Users userInfo(@RequestBody Users userInfo) {
		return	appService.userInfo(userInfo);
	}

	@RequestMapping("/user")
	public Optional<Users> getUser(@RequestParam String id) {
		return appService.getUser(id);
	}

	//Experience Endpoints section

	@RequestMapping(method=RequestMethod.POST, value="/experience")
	public void addExperience(@RequestBody RootExperience rootExperience) {
		appService.postExperience(rootExperience);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/experience")
	public void updateExperience(@RequestBody RootExperience rootExperience) {
		appService.updateExperience(rootExperience);
	}

	@RequestMapping("/experience")
	public RootExperience getExperience(@RequestParam String id) {
		return appService.getExperience(id);
	}


	//	Education Endpoints section

	@RequestMapping(method=RequestMethod.POST, value="/education")
	public void addEducation(@RequestBody RootEducation rootEducation) {
		appService.postEducation(rootEducation);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/education")
	public void updateEducation(@RequestBody RootEducation rootEducation) {
		appService.updateEducation(rootEducation);
	}

	@RequestMapping("/education")
	public RootEducation getEducation(@RequestParam String id) {
		return appService.getEducation(id);
	}

	//	Skills enpoints section

	@RequestMapping(method=RequestMethod.POST, value="/skills")
	public void addSkills(@RequestBody RootSkills rootSkills) {
		appService.postSkills(rootSkills);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/skills")
	public void putSkills(@RequestBody RootSkills rootSkills) {
		appService.putSkills(rootSkills);
	}

	@RequestMapping("/skills")
	public RootSkills getSkills(@RequestParam String id) {
		return appService.getSkills(id);
	}

	//	photo add and get endpoints

	@RequestMapping(method=RequestMethod.POST, value="/photos")
	public void addPhoto(@RequestParam("uid") String uid, 
			@RequestParam("image") MultipartFile image) 
					throws IOException {
		photoService.addPhoto(uid, image);
	}

	@RequestMapping("/photos")
	public String getPhoto(@RequestParam String uid) {
		Photo photo = photoService.getPhoto(uid);
		String s=Base64.encode(photo.getImage().getData());  
		return s;
	}

	//	job posting and getting endpoints

	@RequestMapping(method=RequestMethod.POST, value="/job")
	public void postJob(@RequestBody RootJobPost rootjobPost) {
		appService.postJob(rootjobPost);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/job")
	public void putJob(@RequestBody RootJobPost rootjobPost) {
		appService.putJob(rootjobPost);
	}

	@RequestMapping("/job")
	public RootJobPost getJob(@RequestParam String id) {
		return appService.getJob(id);
	}
	
	@RequestMapping("/jobs")
	public List<RootJobPost> getJobs() {
		return appService.getJobs();
	}
	
	@RequestMapping("/singlejobs")
	public List<SingleJob> getSingleJobs() {
		return appService.getSingleJobs();
	}
	
	@RequestMapping("/singlejob")
	public Optional<SingleJob> getJobById(@RequestParam String id) {
		return appService.getJobById(id);
	}
//	@RequestMapping("/singlejobslimits")
//	public List<SingleJob> getSingleJobsLimit(@RequestParam int from,@RequestParam int to) {
//		return appService.getSingleJobsLimit(from,to);
//	}

}
