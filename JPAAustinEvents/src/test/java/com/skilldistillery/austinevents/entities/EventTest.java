package com.skilldistillery.austinevents.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {


	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Event event; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAAustinEvents");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		event = em.find(Event.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		event = null;
	}

	@Test
	void test_Category_entity_mapping() {
		assertNotNull(event);
		assertEquals("Test", event.getName());
		assertEquals("EMOs", event.getAddress());
		assertEquals(LocalDate.of(2023, 01, 01), event.getStartDate());
		assertEquals(LocalDate.of(2023, 01, 01), event.getEndDate());
	}
	
	@Test
	void test_Event_to_Type_ManyToOne_mapping() {
		assertNotNull(event);
		assertEquals("Live Music", event.getType().getName());
	}

}
