package com.mindtree.codingChallenge.service.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.codingChallenge.entity.Minds;
import com.mindtree.codingChallenge.entity.Track;
import com.mindtree.codingChallenge.exceptions.MindIdNotFoundException;
import com.mindtree.codingChallenge.exceptions.ServiceException;
import com.mindtree.codingChallenge.exceptions.TrackIdNotFoundException;
import com.mindtree.codingChallenge.repository.MindRepository;
import com.mindtree.codingChallenge.repository.TrackRepository;
import com.mindtree.codingChallenge.service.ServiceInterface;
@Service
public class MindTreeImplementation implements ServiceInterface{
	@Autowired
	private TrackRepository trackRepo;
	@Autowired
	private MindRepository mindRepo;
	@Override
	public void addTrack(Track track) throws ServiceException {
		try {
			trackRepo.save(track);
		}catch(Exception e) {
			throw new ServiceException(e.getMessage());}
	
	}

	@Override
	public void addMind(Minds mind, int trackId) throws ServiceException {
		Track track=trackRepo.findById(trackId).orElse(null);
		try{
			if(track==null)
				 throw new TrackIdNotFoundException("Id not found");
			mind.setTrack(track);
			mindRepo.save(mind);
		}catch(TrackIdNotFoundException e) {
			throw new ServiceException(e.getMessage());}
		
		
	}

	@Override
	public List<Minds> getMindsInASpecificTrack(String trackName) throws ServiceException {
		List<Minds> mindsList =new ArrayList<>();
		Track  track=trackRepo.getTrackByName(trackName);
		try {
		int trackId=track.getTrackId();
		for(Minds val:mindRepo.findAll())
		{
			if(val.getTrack().getTrackId()==trackId)
			{
				mindsList.add(val);
			}
		}
		}catch(Exception e) {throw new ServiceException("No minds in the track");}
		
		return mindsList;
	}

	@Override
	public Minds updatePhoneNumber(int id, String phoneNumber) throws MindIdNotFoundException {
		Minds mind=mindRepo.findById(id).orElse(null);
		try
		{
			mind.setPhoneNumber(phoneNumber);
			mindRepo.save(mind);
		}catch(Exception e) {throw new MindIdNotFoundException("No id found");}
		return mind;
	}

	@Override
	public void deleteMind(int mindId) throws MindIdNotFoundException {
		try
		{
			mindRepo.deleteById(mindId);
		}catch(Exception e) {
			throw new MindIdNotFoundException("No id found");
	}

}
}
