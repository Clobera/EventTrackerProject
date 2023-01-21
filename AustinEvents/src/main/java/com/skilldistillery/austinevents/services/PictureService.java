package com.skilldistillery.austinevents.services;

import java.util.List;

import com.skilldistillery.austinevents.entities.Picture;

public interface PictureService {

	List<Picture> findAllPictures(int eventId);

	Picture findById(int id);

	Picture createPicture(int id, Picture pic); 

	boolean deletePicture(int pictureId); 
}
