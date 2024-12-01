package com.example.batch.processing.sms_batch.writer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.example.batch.processing.sms_batch.entity.Event;
import com.example.batch.processing.sms_batch.service.EventService;

@Component
public class EventWriter implements ItemWriter<Event> {
	
	private EventService eventService;

	@Override
	public void write(List<? extends Event> items) throws Exception {
		System.out.println("Event Writer called" + items);
		items.stream().forEach(event -> System.out.println(event.instanceId + event.eventName + event.alertId));
//		 TODO Auto-generated method stub
//		eventService.updateAll(items.stream().collect(Collectors.toList()));
		
	}
	
	

}
