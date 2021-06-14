package com.mindtree.codingChallenge.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="Minds")
public class Minds {
@Id
private int mindId;
private String mindName;
private String role;
private String phoneNumber;
@OneToOne
private Track track;
public int getMindId() {
	return mindId;
}

public void setMindId(int mindId) {
	this.mindId = mindId;
}

public String getMindName() {
	return mindName;
}

public void setMindName(String mindName) {
	this.mindName = mindName;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public String getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}


public Track getTrack() {
	return track;
}

public void setTrack(Track track) {
	this.track = track;
}

public Minds() {
	super();
}

public Minds(int mindId, String mindName, String role, String phoneNumber) {
	super();
	this.mindId = mindId;
	this.mindName = mindName;
	this.role = role;
	this.phoneNumber = phoneNumber;
}
public Minds(int mindId, String mindName, String role, String phoneNumber, Track track) {
	super();
	this.mindId = mindId;
	this.mindName = mindName;
	this.role = role;
	this.phoneNumber = phoneNumber;
	this.track = track;
}


}