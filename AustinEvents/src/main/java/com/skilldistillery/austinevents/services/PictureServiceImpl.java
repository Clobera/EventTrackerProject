package com.skilldistillery.austinevents.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.austinevents.entities.Event;
import com.skilldistillery.austinevents.entities.Picture;
import com.skilldistillery.austinevents.repositories.EventRepository;
import com.skilldistillery.austinevents.repositories.PictureRepository;

@Service
@Transactional
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureRepository picRepo;

	@Autowired
	private EventRepository eventRepo;

	@Override
	public List<Picture> findAllPictures(int eventId) {
		List<Picture> pictures = null;
		if (picRepo.findByEvent_Id(eventId).size() > 0) {
			pictures = picRepo.findByEvent_Id(eventId);
		}

		return pictures;
	}

	@Override
	public Picture findById(int id) {
		Optional<Picture> picOpt = picRepo.findById(id);
		Picture pic = null;
		if (picOpt.isPresent()) {
			pic = picOpt.get();
		}

		return pic;
	}

	@Override
	public Picture createPicture(int id, Picture pic) {
		Optional<Event> eventOpt = eventRepo.findById(id);
		if (eventOpt.isPresent()) {
			pic.setEvent(eventOpt.get());

			return picRepo.saveAndFlush(pic);
		}

		return null;
	}

	@Override
	public boolean deletePicture(int pictureId) {
		Picture deleteMe = findById(pictureId);
		boolean deleted = false;
		if (deleteMe != null) {
			picRepo.delete(deleteMe);
			deleted = true;
		}
		return deleted;
	}
}
