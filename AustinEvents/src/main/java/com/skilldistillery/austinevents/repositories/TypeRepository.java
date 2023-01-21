package com.skilldistillery.austinevents.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.austinevents.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Integer> {

}
