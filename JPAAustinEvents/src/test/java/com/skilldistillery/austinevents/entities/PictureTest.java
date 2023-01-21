package com.skilldistillery.austinevents.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PictureTest {


	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Picture picture; 
	
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
		picture = em.find(Picture.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		picture = null;
	}

	@Test
	void test_Category_entity_mapping() {
		assertNotNull(picture);
		assertEquals("https://media.istockphoto.com/id/825383494/photo/business-man-pushing-large-stone-up-to-hill-business-heavy-tasks-and-problems-concept.jpg?s=612x612&w=0&k=20&c=wtqvbQ6OIHitRVDPTtoT_1HKUAOgyqa7YzzTMXqGRaQ=", picture.getUrl());
		assertEquals("test picture description", picture.getPictureDescription());
	}
	
	@Test
	void test_Picture_to_Event_ManyToOne_mapping() {
		assertNotNull(picture);
		assertEquals("Test", picture.getEvent().getName());
		assertEquals("Live Music", picture.getEvent().getType().getName());
	}

}
