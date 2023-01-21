package com.skilldistillery.austinevents.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.austinevents.entities.Type;
import com.skilldistillery.austinevents.repositories.TypeRepository;

@Service
@Transactional
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeRepository typeRepo;
	
	@Override
	public List<Type> allTypes(){
		return typeRepo.findAll();
	}
	
}
