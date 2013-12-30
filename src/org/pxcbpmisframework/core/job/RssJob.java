package org.pxcbpmisframework.core.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class RssJob implements Job{

	public void execute(JobExecutionContext context) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println(context.getTrigger().getNextFireTime());
	}

}
