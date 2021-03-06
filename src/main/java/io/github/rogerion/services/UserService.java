package io.github.rogerion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.rogerion.dto.UserDTO;
import io.github.rogerion.entities.User;
import io.github.rogerion.repositories.UserRepository;

@Service
public class UserService{

	BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder(10);

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
		String userPasswordHash = bcrypt.encode(user.getPassword());
		User userEntity = new User(user.getId(),user.getName(),user.getEmail(),userPasswordHash);
		//Saving this new user in BD
		userEntity = userRepo.save(userEntity);
		//Returning to Controller a DTO user
		return new UserDTO(userEntity);
	}

	public void remove(Integer id) {
		
		Optional<User> optUser = userRepo.findById(id);
		
		if(optUser.isPresent()) {
			userRepo.deleteById(id);
		}
		
	}
	
	public User update(User user, Integer id, String email, String name, String password){
		Optional<User> userOptional = userRepo.findById(id);
		
		if(userOptional.isPresent()) {
			user.setId(id);
			
			user.setName(name);
			
			user.setEmail(email);

			password = bcrypt.encode(password);

			user.setPassword(password);
			
			return userRepo.save(user);
		}
		
		return null;
		
	}

	public Optional<User> findUserById(Integer id){
		Optional<User> userOptional = userRepo.findById(id);

		if(userOptional.isPresent()){
			return userRepo.findById(id);
		}else{
			return Optional.empty();
		}
	}

	public Optional<User> findUserByEmail(String email){
		Optional<User> user =  userRepo.findByEmail(email);
		if(user.isPresent()){
			return user;
		}
		return null;
	}

}
