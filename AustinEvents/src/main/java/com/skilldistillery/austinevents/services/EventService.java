package com.skilldistillery.austinevents.services;

import java.util.List;

import com.skilldistillery.austinevents.entities.Event;

public interface EventService {
	
	List<Event> allEvents();
	
	Event getEvent(int eventId);
	
	Event createEvent(Event event);
	
	Event updateEvent(int eventId, Event updates);
	
	boolean deleteEvent(int eventId);

}
