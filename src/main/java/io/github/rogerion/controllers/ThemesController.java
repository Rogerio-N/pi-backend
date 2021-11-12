package io.github.rogerion.controllers;

import java.util.List;

import io.github.rogerion.dto.ComplaintDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.rogerion.dto.ThemesDTO;
import io.github.rogerion.services.ThemesService;

@RestController
@RequestMapping(value="/api/v2/themes")
public class ThemesController {

	@Autowired
	private ThemesService service;
	
	@GetMapping
	@CrossOrigin(origins = {"http://localhost:8080","http://localhost:5500"})
	public ResponseEntity<List<ThemesDTO>> findAll(){
		List<ThemesDTO> finalList = service.findAll();
		return ResponseEntity.ok().body(finalList);
	}

	@PostMapping
	public ResponseEntity<ThemesDTO> insert(@RequestBody ThemesDTO themes){

		themes = service.insert(themes);
		return ResponseEntity.ok().body(themes);

	}
	
}
