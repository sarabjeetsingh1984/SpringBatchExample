package com.mkyong.scheduler;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Dinesh Rajput
 *
 */

public class RunScheduler {
	
	private JobLauncher jobLauncher;
	 
	
	private Job job;
	
	public void run() {
	    try {
	    	int count = 1;
	    	if(count ==1)
			System.out.println("RunScheduler Starting* .....");
	    	System.out.println("Job name is "+ job.getName()); 
	    	count++;
	    	String dateParam = new Date().toString();
			JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
			System.out.println(dateParam);
			
			
			JobExecution execution = jobLauncher.run(job, param);
			System.out.println("RunScheduler loop number....."+ count);
			System.out.println("Exit Status : " + execution.getStatus());
	    } catch (Exception e) {
	    	//e.printStackTrace();
	    }
	  }
}
