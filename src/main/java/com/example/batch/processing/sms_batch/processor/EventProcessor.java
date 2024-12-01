package com.example.batch.processing.sms_batch.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.batch.processing.sms_batch.entity.Event;

@Component
public class EventProcessor implements ItemProcessor<Event, Event> {

	@Override
	public Event process(Event event) throws Exception {
		System.out.println("Processor event called" + event.instanceId + event.eventName + event.alertId);
//		List<Event> list = new ArrayList<Event>();
		event.alertId = Integer.valueOf(new Random().nextInt(9000));
//		list.add(event);
		// TODO Auto-generated method stub
		return event;
	}

}
