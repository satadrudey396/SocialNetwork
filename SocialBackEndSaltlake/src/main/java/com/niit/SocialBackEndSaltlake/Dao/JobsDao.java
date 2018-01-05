package com.niit.SocialBackEndSaltlake.Dao;

import java.util.List;

import com.niit.SocialBackEndSaltlake.Model.Jobs;

public interface JobsDao {
	public boolean saveJobs(Jobs jobs);

	public boolean deleteJobs(Jobs jobs);

	public boolean updateJobs(Jobs jobs);

	public Jobs getJobs(int jobId);

	public List<Jobs> getAllJobs();
}
