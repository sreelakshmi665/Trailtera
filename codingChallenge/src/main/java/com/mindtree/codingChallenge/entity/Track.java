package com.mindtree.codingChallenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="track")
public class Track {
	@Id
private int trackId;
private String trackName;
private int noOfMinds;

public int getTrackId() {
	return trackId;
}
public void setTrackId(int trackId) {
	this.trackId = trackId;
}
public String getTrackName() {
	return trackName;
}
public void setTrackName(String trackName) {
	this.trackName = trackName;
}
public int getNoOfMinds() {
	return noOfMinds;
}
public void setNoOfMinds(int noOfMinds) {
	this.noOfMinds = noOfMinds;
}
public Track() {
	super();
}
public Track(int trackId, String trackName, int noOfMinds) {
	super();
	this.trackId = trackId;
	this.trackName = trackName;
	this.noOfMinds = noOfMinds;
}

}
