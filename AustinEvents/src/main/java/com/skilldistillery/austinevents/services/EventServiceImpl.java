package com.skilldistillery.austinevents.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.austinevents.entities.Event;
import com.skilldistillery.austinevents.repositories.EventRepository;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepo;

	@Override
	public List<Event> allEvents() {
		List<Event> events = eventRepo.findAll();
		return events;
	}

	@Override
	public Event getEvent(int eventId) {
		Optional<Event> eventOPT = eventRepo.findById(eventId);
		Event event = null;
		if (eventOPT.isPresent()) {
			event = eventOPT.get();
		}
		
		return event;
	}

	@Override
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}

	@Override
	public Event updateEvent(int eventId, Event updates) {
		Event event = getEvent(eventId);
		if(event != null) {
			event.setName(updates.getName());
		}
		
		return event;
	}

	@Override
	public boolean deleteEvent(int eventId) {
		Event deleteMe = getEvent(eventId);
		boolean deleted = false;
		if (deleteMe != null) {
			eventRepo.delete(deleteMe);
			deleted = true;
		}
		return deleted;
	}

}
