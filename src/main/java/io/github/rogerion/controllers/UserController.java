package io.github.rogerion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.rogerion.dto.UserDTO;
import io.github.rogerion.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	public UserService userServ;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){
		
		List<UserDTO> finalList= userServ.findAll();
		return ResponseEntity.ok().body(finalList);
		
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO user){
		
		user =userServ.insert(user);
		return ResponseEntity.ok().body(user);
		
	}
	
	@DeleteMapping(value="{id}")
	@ResponseBody
	public void remover(@RequestParam Integer id) {
		userServ.remove(id);
	}
	
	//Testando
	public List<UserDTO> listador(){
		return null;
	}
	
}
