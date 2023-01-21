package com.skilldistillery.austinevents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.austinevents.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	List<Comment> findByEvent_Id(int eventId);

}
