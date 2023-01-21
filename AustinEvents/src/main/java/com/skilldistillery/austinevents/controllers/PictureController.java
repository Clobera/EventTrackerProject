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

import com.skilldistillery.austinevents.entities.Picture;
import com.skilldistillery.austinevents.services.PictureService;

@RestController
@RequestMapping("api")
public class PictureController {

	@Autowired
	private PictureService picService;
	
	@GetMapping(path = "events/{id}/pictures")
	public List<Picture> listPictures(@PathVariable int id) {
		List<Picture> pictures = picService.findAllPictures(id);

		return pictures;
	}

	@PostMapping(path = "events/{id}/pictures")
	public Picture createPicture(@PathVariable int id ,@RequestBody Picture pic, HttpServletResponse res, HttpServletRequest req) {
		try {
			picService.createPicture(id, pic);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			res.setHeader("Location", url.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			pic = null;
		}

		return pic;
	}

	@DeleteMapping(path = "events/{id}/pictures/{pid}")
	public void deletePicture(@PathVariable int pid, HttpServletResponse res) {
		try {
			if (picService.deletePicture(pid)) {
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
