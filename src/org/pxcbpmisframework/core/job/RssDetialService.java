package org.pxcbpmisframework.core.job;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class RssDetialService {

	public static void main(String[] args) throws SchedulerException {
		// init mail send job
		JobDetail jobDetail = new JobDetail("pxc", RssJob.class); // 要被执行的类
		jobDetail.getJobDataMap().put("attach", "ss");

		// trigger once and now
		SimpleTrigger trigger = new SimpleTrigger("trigger1");
		trigger.setStartTime(new Date()); // 启动时间
		trigger.setRepeatCount(0); // 重复次数
		trigger.setRepeatInterval(1000); // 间隔时间触发次数 no sense, for not throw

		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

		scheduler.scheduleJob(jobDetail, trigger);
		scheduler.start();

	}

	public void doTest() {
		System.out.println("It is " + new Date());
	}

}
