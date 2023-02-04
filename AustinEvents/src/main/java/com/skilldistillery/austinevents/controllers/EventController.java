package com.skilldistillery.austinevents.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.austinevents.entities.Event;
import com.skilldistillery.austinevents.services.EventService;

@RestController
@RequestMapping("api")
@CrossOrigin({"*", "http://localhost/"})
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping(path = "events")
	public List<Event> listEvents() {
		List<Event> events = eventService.allEvents();
		return events;
	}

	@GetMapping(path = "events/{id}")
	public Event findEventById(@PathVariable int id) {
		Event event = eventService.getEvent(id);
		return event;
	}

	@PostMapping(path = "events")
	public Event createEvent(@RequestBody Event event, HttpServletResponse res, HttpServletRequest req) {

		try {
			eventService.createEvent(event);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			event = null;
		}

		return event;
	}

	@PutMapping(path = "events/{id}")
	public Event updateEvent(@PathVariable int id, @RequestBody Event updates, HttpServletResponse res) {
		Event event = new Event();
		try {
			if (updates == null) {
				res.setStatus(404);
			}
			event = eventService.updateEvent(id, updates);
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
		return event;
	}

	@DeleteMapping(path = "events/{id}")
	public void deleteEvent(@PathVariable int id, HttpServletResponse res){
		try {
			if (eventService.deleteEvent(id)) {
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}

}
