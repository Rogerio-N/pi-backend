package io.github.rogerion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.rogerion.dto.ThemesDTO;
import io.github.rogerion.services.ThemesService;

@RestController
@RequestMapping(value="/themes")
public class ThemesController {

	@Autowired
	private ThemesService service;
	
	@GetMapping
	public ResponseEntity<List<ThemesDTO>> findAll(){
		List<ThemesDTO> finalList = service.findAll();
		return ResponseEntity.ok().body(finalList);
	}
	
}
