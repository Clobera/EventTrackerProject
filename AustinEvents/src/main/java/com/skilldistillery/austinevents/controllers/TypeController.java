package com.skilldistillery.austinevents.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.austinevents.entities.Type;
import com.skilldistillery.austinevents.services.TypeService;


@RestController
@RequestMapping("api")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	@GetMapping(path = "types")
	public List<Type> listCategories() {
		
		return typeService.allTypes();
	}

}
