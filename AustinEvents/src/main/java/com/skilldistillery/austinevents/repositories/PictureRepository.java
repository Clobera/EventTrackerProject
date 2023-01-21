package com.skilldistillery.austinevents.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.austinevents.entities.Picture;

public interface PictureRepository extends JpaRepository<Picture, Integer> {

	List<Picture> findByEvent_Id(int eventId);
}
