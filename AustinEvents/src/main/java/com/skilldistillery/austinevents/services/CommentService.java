package com.skilldistillery.austinevents.services;

import java.util.List;

import com.skilldistillery.austinevents.entities.Comment;

public interface CommentService {

	List<Comment> findAllComments(int eventId);

	Comment findById(int id);

	Comment createComment(int id, Comment comment); 

	boolean deleteComment(int commentId); 
	
}
