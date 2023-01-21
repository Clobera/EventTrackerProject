package com.skilldistillery.austinevents.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.austinevents.entities.Comment;
import com.skilldistillery.austinevents.entities.Event;
import com.skilldistillery.austinevents.repositories.CommentRepository;
import com.skilldistillery.austinevents.repositories.EventRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private EventRepository eventRepo;

	@Override
	public List<Comment> findAllComments(int eventId) {
		List<Comment> comments = null;
		if (commentRepo.findByEvent_Id(eventId).size() > 0) {
			comments = commentRepo.findByEvent_Id(eventId);
		}

		return comments;
	}

	@Override
	public Comment findById(int id) {
		Optional<Comment> commentOpt = commentRepo.findById(id);
		Comment comment = null;
		if (commentOpt.isPresent()) {
			comment = commentOpt.get();
		}

		return comment;
	}

	@Override
	public Comment createComment(int id, Comment comment) {
		Optional<Event> eventOpt = eventRepo.findById(id);
		if (eventOpt.isPresent()) {
			comment.setEvent(eventOpt.get());

			return commentRepo.saveAndFlush(comment);
		}

		return null;
	}

	@Override
	public boolean deleteComment(int commentId) {
		Comment deleteMe = findById(commentId);
		boolean deleted = false;
		if (deleteMe != null) {
			commentRepo.delete(deleteMe);
			deleted = true;
		}
		return deleted;
	}

}
