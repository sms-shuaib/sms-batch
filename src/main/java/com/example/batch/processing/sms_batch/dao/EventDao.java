package com.example.batch.processing.sms_batch.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.batch.processing.sms_batch.entity.Event;



public interface EventDao extends CrudRepository<Event, Integer> {
	
	@Query(value="SELECT * from event e where e.event_name= :eventName", nativeQuery = true)
	public List<Event> getEvents(@Param("eventName") String eventName);
	

}
