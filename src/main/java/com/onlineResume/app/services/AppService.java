package com.onlineResume.app.services;

import java.util.List;
import java.util.Optional;
import java.util.Date;
import com.onlineResume.app.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.onlineResume.app.models.Experience;
import com.onlineResume.app.models.JobPost;
import com.onlineResume.app.models.Login;
import com.onlineResume.app.models.LoginSuccess;
import com.onlineResume.app.models.PostSuccess;
import com.onlineResume.app.models.RootEducation;
import com.onlineResume.app.models.RootExperience;
import com.onlineResume.app.models.RootJobPost;
import com.onlineResume.app.models.RootSkills;
import com.onlineResume.app.models.SingleJob;
import com.onlineResume.app.models.UserInfo;
import com.onlineResume.app.models.Users;
import com.onlineResume.app.repositories.UsersRepository;
import com.onlineResume.app.repositories.AllJobsRepository;
import com.onlineResume.app.repositories.RootEducationRepository;
import com.onlineResume.app.repositories.RootExperienceRepository;
import com.onlineResume.app.repositories.RootPostJobRepository;
import com.onlineResume.app.repositories.RootSkillsRepository;
import com.onlineResume.app.repositories.SingleJobRepository;
import com.onlineResume.app.repositories.UsersInfoRepository;
import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Service
public class AppService{

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private RootExperienceRepository rootExperienceRepository;

	@Autowired
	private RootEducationRepository rootEducationRepository;

	@Autowired
	private RootSkillsRepository rootSkillsRepository;

	@Autowired
	private RootPostJobRepository rootPostJobRepository;

	@Autowired
	private SingleJobRepository singleJobRepository;

	@Autowired
	private AllJobsRepository allJobsRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Users createUser(Users user) {
		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		//		new Users(user.getFirst_name(),user.getLast_name(),user.getEmail(),encryptedPassword)
		return usersRepository.save(user);
	}

	public Optional<Users> getUser(String userId) {
		return usersRepository.findById(userId);
	}

	public Users userInfo(Users userInfo) {
		Users user = usersRepository.findByEmail(userInfo.getEmail());

		user.setFirst_name(userInfo.getFirst_name());
		user.setLast_name(userInfo.getLast_name());
		user.setPhone(userInfo.getPhone());
		user.setCurrent_title(userInfo.getCurrent_title());
		user.setLocation(userInfo.getLocation());

		return usersRepository.save(user);
	}

	public LoginSuccess login(Login user) {
		if(usersRepository.findByEmail(user.getEmail())!=null && passwordEncoder
				.matches(user.getPassword(), usersRepository.findByEmail(user.getEmail()).getPassword())) {

			String id=usersRepository.findByEmail(user.getEmail()).getId();
			String first_name=usersRepository.findByEmail(user.getEmail()).getFirst_name();
			String last_name=usersRepository.findByEmail(user.getEmail()).getLast_name();
			String email=usersRepository.findByEmail(user.getEmail()).getEmail();
			//generating JSON Web Token
			String token = JWT.create()
					.withSubject(first_name)
					.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
					.sign(HMAC512(JwtProperties.SECRET.getBytes()));

			return new LoginSuccess(id,first_name,last_name,email,token,"Login Success");
		}else {
			return new LoginSuccess(null,null,null,null,null,"Login Failure");
		}
	}

	//Experience Endpoints section

	public RootExperience postExperience(RootExperience rootExperience) {
		return rootExperienceRepository.save(rootExperience);
	}
	public RootExperience updateExperience(RootExperience experience) {
		RootExperience obj=rootExperienceRepository.findByUid(experience.getUid());
		obj.setExperience(experience.getExperience());
		return rootExperienceRepository.save(obj);
	}
	public RootExperience getExperience(String id) {
		RootExperience obj=rootExperienceRepository.findByUid(id);
		return obj;
	}

	//Education Endpoints section


	public RootEducation postEducation(RootEducation rootEducation) {
		return rootEducationRepository.save(rootEducation);
	}

	public RootEducation updateEducation(RootEducation education) {
		RootEducation obj=rootEducationRepository.findByUid(education.getUid());
		obj.setEducation(education.getEducation());
		return rootEducationRepository.save(obj);
	}
	public RootEducation getEducation(String id) {
		RootEducation obj=rootEducationRepository.findByUid(id);
		return obj;
	}

	//	Skills endpoints section

	public RootSkills postSkills(RootSkills rootSkills) {
		return rootSkillsRepository.save(rootSkills);
	}

	public RootSkills putSkills(RootSkills rootSkills) {
		RootSkills obj=rootSkillsRepository.findByUid(rootSkills.getUid());
		obj.setSkills(rootSkills.getSkills());
		return rootSkillsRepository.save(obj);
	}

	public RootSkills getSkills(String uid) {
		return rootSkillsRepository.findByUid(uid);
	}

	//	jobpost and getting endPoints

	public void postJob(RootJobPost rootJobPost) {

		SingleJob singleJob=new SingleJob();
		singleJob.setJob(rootJobPost.getPostJobs().get(rootJobPost.getPostJobs().size()-1));
		singleJob.setUid(rootJobPost.getUid());
		singleJobRepository.save(singleJob);

		rootPostJobRepository.save(rootJobPost);
	}

	public void putJob(RootJobPost rootJobPost) {

		SingleJob singleJob=new SingleJob();
		singleJob.setJob(rootJobPost.getPostJobs().get(rootJobPost.getPostJobs().size()-1));
		singleJob.setUid(rootJobPost.getUid());
		singleJobRepository.save(singleJob);


		RootJobPost obj=rootPostJobRepository.findByUid(rootJobPost.getUid());
		obj.setPostJobs(rootJobPost.getPostJobs());
		rootPostJobRepository.save(obj);
	}

	public RootJobPost getJob(String uid) {
		return rootPostJobRepository.findByUid(uid);
	}
	public List<RootJobPost> getJobs() {
		return rootPostJobRepository.findAll();
	}
	public List<SingleJob> getSingleJobs() {
		return singleJobRepository.findAll();
	}
	public Optional<SingleJob> getJobById(String id) {
		return singleJobRepository.findById(id);
	}
//	public List<SingleJob> getSingleJobsLimit(int from,int to) {
//		return singleJobRepository.findByLimit(new PageRequest(from,to));
//
//	}
}
