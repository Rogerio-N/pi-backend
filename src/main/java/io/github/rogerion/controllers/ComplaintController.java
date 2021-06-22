package io.github.rogerion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.github.rogerion.dto.ComplaintDTO;
import io.github.rogerion.services.ComplaintService;
import io.github.rogerion.utilities.AcessaDisco;

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
	public ResponseEntity<ComplaintDTO> insert(@RequestBody ComplaintDTO complaint,MultipartFile imagem){
		
		complaint = service.insert(complaint,imagem);
		return ResponseEntity.ok().body(complaint);
		
	}
	
	@GetMapping("/protocolSearch")
	public ResponseEntity<List<ComplaintDTO>> findByProtocol(@RequestParam("protocol") String p){
		List<ComplaintDTO> finalList = service.findByProtocol(p);
		return ResponseEntity.ok().body(finalList);
	}
	
}
