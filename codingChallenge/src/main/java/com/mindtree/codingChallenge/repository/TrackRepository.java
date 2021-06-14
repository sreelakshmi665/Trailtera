package com.mindtree.codingChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mindtree.codingChallenge.entity.Track;



public interface TrackRepository extends JpaRepository<Track,Integer>{
	@Query("SELECT t from track t where t.trackName=?1")
	public Track getTrackByName(String trackName);
}