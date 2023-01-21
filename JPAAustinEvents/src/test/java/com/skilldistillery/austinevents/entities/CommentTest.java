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

class CommentTest {


	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Comment comment; 
	
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
		comment = em.find(Comment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		comment = null;
	}

	@Test
	void test_Category_entity_mapping() {
		assertNotNull(comment);
		assertEquals("this is a test comment", comment.getContent());
		assertEquals("Carlos", comment.getName());
	}
	
	@Test
	void test_Comment_to_Event_ManyToOne_mapping() {
		assertNotNull(comment);
		assertEquals("Test", comment.getEvent().getName());
		assertEquals("Music", comment.getEvent().getType().getName());
	}

}
