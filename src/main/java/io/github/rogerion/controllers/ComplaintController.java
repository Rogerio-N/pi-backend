package io.github.rogerion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rogerion.dto.ComplaintDTO;
import io.github.rogerion.services.ComplaintService;

@RestController
@RequestMapping(value="/complaint")
public class ComplaintController {

	@Autowired
	public ComplaintService service;
	
	@GetMapping
	public ResponseEntity<List<ComplaintDTO>> findAll(){
		
		List<ComplaintDTO> finalList= service.findAll();
		return ResponseEntity.ok().body(finalList);
		
	}
	
	@PostMapping
	public ResponseEntity<ComplaintDTO> insert(@RequestBody ComplaintDTO complaint){
		
		complaint = service.insert(complaint);
		return ResponseEntity.ok().body(complaint);
		
	}
	
}
