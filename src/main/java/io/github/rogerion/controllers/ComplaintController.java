package io.github.rogerion.controllers;

import java.util.List;
import java.util.Optional;

import io.github.rogerion.entities.Complaint;
import io.github.rogerion.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.rogerion.dto.ComplaintDTO;
import io.github.rogerion.services.ComplaintService;

@RestController
@RequestMapping(value="/api/v2/complaint")
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

	@GetMapping(value = "find/")
	public ResponseEntity<Optional<Complaint>> findByComplaintId(@RequestParam Integer id){
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping(value="find/userComplaint")
	public ResponseEntity<Optional<Complaint>> findComplaintByUserId(@RequestParam (name="user_id") Integer idUser,User user, @RequestParam(name = "complaint_id") Integer idComplaint){
		return ResponseEntity.ok().body(service.findUserComplaint(idUser,idComplaint));
	}
	
}
