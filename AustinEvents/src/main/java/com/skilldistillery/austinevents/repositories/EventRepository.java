package com.skilldistillery.austinevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.austinevents.entities.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
