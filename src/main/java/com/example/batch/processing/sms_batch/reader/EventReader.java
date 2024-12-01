package com.example.batch.processing.sms_batch.reader;

import java.util.List;

import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.batch.processing.sms_batch.entity.Event;
import com.example.batch.processing.sms_batch.service.EventService;

@Component
public class EventReader implements ItemReader<Event> {
	
	@Autowired
	private EventService eventService;
	int i =0;

	@Override
	public Event read() throws Exception {
		System.out.println(" Reaader Event Called");
		// TODO Auto-generated method stub
		List<Event> list = eventService.getEvents("GripError");
		Event event;
		if (i <list.size()) {
			event = list.get(i);
			i++;
			return event;

		}
		i = 0;

		return null;
	}

}
