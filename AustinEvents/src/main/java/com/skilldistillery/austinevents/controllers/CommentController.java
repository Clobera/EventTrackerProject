package com.skilldistillery.austinevents.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.austinevents.entities.Comment;
import com.skilldistillery.austinevents.services.CommentService;

@RestController
@RequestMapping("api")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@GetMapping(path = "events/{id}/comments")
	public List<Comment> listComments(@PathVariable int id) {
		List<Comment> comments = commentService.findAllComments(id);

		return comments;
	}

	@PostMapping(path = "events/{id}/comments")
	public Comment createComment(@PathVariable int id ,@RequestBody Comment comment, HttpServletResponse res, HttpServletRequest req) {
		try {
			commentService.createComment(id, comment);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			res.setHeader("Location", url.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			comment = null;
		}

		return comment;
	}

	@DeleteMapping(path = "events/{id}/comments/{cid}")
	public void deleteComment(@PathVariable int cid, HttpServletResponse res) {
		try {
			if (commentService.deleteComment(cid)) {
				res.setStatus(204);
			}else {
				res.setStatus(404);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			
		}
		
	}

}
