package com.example.batch.processing.sms_batch.entity;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="event")
@Entity
@Data
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="instance_id")
	public Integer instanceId;
	
	@Column(name="event_name")
	public String eventName;
	
	@Column(name="component")
	public String component;
	
	@Column(name="severity")
	public Integer severity;
	
	@Column(name="alert_id")
	public Integer alertId;
	
	
	
	

}
