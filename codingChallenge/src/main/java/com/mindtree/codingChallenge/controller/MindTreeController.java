package com.mindtree.codingChallenge.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.codingChallenge.entity.Minds;
import com.mindtree.codingChallenge.entity.Track;
import com.mindtree.codingChallenge.exceptions.MindIdNotFoundException;
import com.mindtree.codingChallenge.exceptions.ServiceException;
import com.mindtree.codingChallenge.service.ServiceInterface;

@RestController
@RequestMapping("/mindTree")
public class MindTreeController {
	@Autowired
	private ServiceInterface service;
	@PostMapping("/addTrack")
	public ResponseEntity<?> addTrack(@RequestBody Track track) {
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			service.addTrack(track);
			map.put("message:","added successfully");
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/addMind/{id}")
	public ResponseEntity<?> addMind(@RequestBody Minds mind,@PathVariable("id") int trackId) {
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			service.addMind(mind,trackId);
			map.put("message:","added successfully");
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/getMinds/{name}")
	public ResponseEntity<?> getMindsinTrack(@PathVariable("name") String trackName) {
		List<Minds> mindsList=new ArrayList<>();
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			mindsList=service.getMindsInASpecificTrack(trackName);
			map.put("message:",mindsList);
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);}
	
	
	}
	@PutMapping("/updatePhoneNumber/{id}/{phoneNumber}")
	public ResponseEntity<?> updatePhoneNo(@PathVariable("id") int id,@PathVariable("phoneNumber") String phoneNumber) 
	{
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			
			map.put("message:",service.updatePhoneNumber(id,phoneNumber));
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (MindIdNotFoundException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);}
	
		
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMind(@PathVariable("id") int mindId) {
		
		Map<String,Object> map=new LinkedHashMap<>();
		try {
			service.deleteMind(mindId);
			map.put("message:","Successfully deleted");
			return new ResponseEntity<>(map,HttpStatus.CREATED);
		} catch (MindIdNotFoundException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage());
			map.put("message:","Failed");
			return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);}
	
			
		
		
	}
}
