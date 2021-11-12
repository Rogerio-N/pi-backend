package io.github.rogerion.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.rogerion.dto.UserDTO;
import io.github.rogerion.entities.User;
import io.github.rogerion.services.UserService;

@RestController
@RequestMapping(value="/api/v2/users")
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
	
	@DeleteMapping(value="/delete/")
	public void remover(@RequestParam Integer id) {
		userServ.remove(id);
	}
	
	@PutMapping(value="/update/")
	public ResponseEntity<User> update (@RequestBody User user, @RequestParam Integer id){
		user = userServ.update(user, id, user.getEmail(), user.getName(), user.getPassword());
		return ResponseEntity.ok().body(user);
	}

	@GetMapping(value="/find")
	public ResponseEntity<Optional<User>> findUserByEmail(@Param (value= "email") String email){
		Optional<User> user = userServ.findUserByEmail(email);
		return ResponseEntity.ok().body(user);
	}
}
