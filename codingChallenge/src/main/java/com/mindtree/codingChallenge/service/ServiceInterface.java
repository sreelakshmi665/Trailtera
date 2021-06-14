package com.mindtree.codingChallenge.service;

import java.util.List;

import com.mindtree.codingChallenge.entity.Minds;
import com.mindtree.codingChallenge.entity.Track;
import com.mindtree.codingChallenge.exceptions.MindIdNotFoundException;
import com.mindtree.codingChallenge.exceptions.ServiceException;

public interface ServiceInterface {

	void addTrack(Track track) throws ServiceException;

	void addMind(Minds mind, int trackId) throws ServiceException;

	List<Minds> getMindsInASpecificTrack(String trackName) throws ServiceException;

	Minds updatePhoneNumber(int id, String phoneNumber) throws MindIdNotFoundException;

	void deleteMind(int mindId) throws MindIdNotFoundException;

}
