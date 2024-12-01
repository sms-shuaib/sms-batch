package com.example.batch.processing.sms_batch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.batch.processing.sms_batch.dao.EventDao;
import com.example.batch.processing.sms_batch.entity.Event;

@Service
public class EventService {
	
	@Autowired
	private EventDao eventDao;
	
	
	public List<Event> getEvents(String eventName) {
		List<Event> listEvents = eventDao.getEvents(eventName);
		listEvents.stream().forEach( event -> System.out.println(event.instanceId + event.eventName + event.alertId));
		return listEvents;
	}
	
	public void updateAll(List<Event> list) {
		eventDao.saveAll(list);
	}

}
