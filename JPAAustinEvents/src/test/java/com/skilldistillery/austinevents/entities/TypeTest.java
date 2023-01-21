package com.skilldistillery.austinevents.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TypeTest {

	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Type type; 
	
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
		type = em.find(Type.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		type = null;
	}

	@Test
	void test_Type_entity_mapping() {
		assertNotNull(type);
		assertEquals("Music", type.getName());
	}
	
	@Test
	void test_Type_to_Event_OneToMany_mapping() {
		assertNotNull(type);
		assertTrue(type.getEvents().size() > 0);
	}

}
