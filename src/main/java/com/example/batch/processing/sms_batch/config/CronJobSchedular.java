package com.example.batch.processing.sms_batch.config;

import java.util.HashMap;
import java.util.Map;

import javax.batch.runtime.JobExecution;

import org.springframework.batch.core.Entity;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronJobSchedular {

	@Autowired
	private JobLauncher jobLauncher;
	
	
	@Autowired
	private Job eventJob;
	
		
	@Scheduled(cron = "0 0/1 * 1/1 * ?")
	public void eventJobSchedule() {
		Map<String, JobParameter> params = new HashMap<String, JobParameter>();
		params.put("currentTime", new JobParameter(System.currentTimeMillis()));
		
		JobParameters jobParameters = new JobParameters(params);
		
		try {
			JobExecution jobExecution = 
					(JobExecution) jobLauncher.run(eventJob, jobParameters);
			System.out.println("Job Execution ID = " + ((Entity) jobExecution).getId());
		}catch(Exception e) {
			System.out.println("Exception while starting job");
		}
	}

}
