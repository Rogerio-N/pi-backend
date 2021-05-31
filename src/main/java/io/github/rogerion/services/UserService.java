package io.github.rogerion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.rogerion.dto.UserDTO;
import io.github.rogerion.entities.User;
import io.github.rogerion.repositories.UserRepository;

@Service
public class UserService{
	
	@Autowired
	public UserRepository userRepo;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll(){
		
		List<User> entityList = userRepo.findAll();
		List<UserDTO> dtoList = new ArrayList<UserDTO>();
		
		for(int i = 0; i<entityList.size();i++) {
			
			//Converting a Entity User into a UserDTO with UserDTO constructor
			UserDTO temp = new UserDTO(entityList.get(i));
			dtoList.add(temp);
			
		}
		
		return dtoList;
	}
	
	public UserDTO insert(UserDTO user) {
		//Converting a DTO user into a User by constructor method
		User userEntity = new User(user.getId(),user.getNome(),user.getEmail(),user.getPassword());
		//Saving this new user in BD
		userEntity = userRepo.save(userEntity);
		//Returning to Controller a DTO user
		return new UserDTO(userEntity);
	}
	
	public void remove(Integer id) {
		userRepo.deleteById(id);
	}
	
//	public void update(User user, Integer id, String email, String name, String password){
//		Optional<User> userOptional = userRepo.findById(id);
//		
//		if(userOptional.isPresent()) {
//			user.setEmail(email);
//			user.setNome(name);
//			user.setPassword(password);
//			
//			userRepo.save(user);
//		}
//	}
	
	
}
