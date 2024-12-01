package com.example.batch.processing.sms_batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.batch.processing.sms_batch.entity.Event;
import com.example.batch.processing.sms_batch.processor.EventProcessor;
import com.example.batch.processing.sms_batch.reader.EventReader;
import com.example.batch.processing.sms_batch.writer.EventWriter;

@Configuration
public class JobScheduleConfig {
	
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	
	@Autowired
	private EventProcessor eventProcessor;
	
	@Autowired
	private EventReader eventReader;
	
	@Autowired
	private EventWriter eventWriter;
	
	
	@Bean
	public Job eventJob() {
	 return this.jobBuilderFactory.get("Event Job").incrementer(new RunIdIncrementer()).start(eventStep()).build();
	}
	
	
	@Bean
	public Step eventStep() {
		return stepBuilderFactory.get("Event Step").<Event, Event>chunk(5).reader(eventReader).processor(eventProcessor).writer(eventWriter).build();
	}

}
