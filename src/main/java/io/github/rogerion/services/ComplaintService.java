package io.github.rogerion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.github.rogerion.entities.User;
import io.github.rogerion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.github.rogerion.dto.ComplaintDTO;
import io.github.rogerion.entities.Complaint;
import io.github.rogerion.repositories.ComplaintRepository;

@Service
public class ComplaintService {

	@Autowired
	public ComplaintRepository repo;

	public UserRepository userRepo;
	
	@Transactional(readOnly = true)
	public List<ComplaintDTO> findAll(){
		
		List<Complaint> entityList = repo.findAll();
		List<ComplaintDTO> dtoList = new ArrayList<ComplaintDTO>();
		
		for(int i = 0; i<entityList.size();i++) {
			
			//Converting a Entity User into a UserDTO with UserDTO constructor
			ComplaintDTO temp = new ComplaintDTO(entityList.get(i));
			dtoList.add(temp);
			
		}
		
		return dtoList;
	}
	
	public ComplaintDTO insert(ComplaintDTO c) {
		Complaint complaintEntity = new Complaint(c.getId(),c.getThemes(),c.getCEP(),
				c.getStatus(),c.getDescricao(),c.getNumero(),c.getEndereco(),
				c.getDataEnvio(),c.getDataFim(),c.getUser(),c.getImageUrl());
		complaintEntity = repo.save(complaintEntity);
		return new ComplaintDTO(complaintEntity);
	}

	public Optional<Complaint> findById(Integer id){
		Optional<Complaint> complaintOptional = repo.findById(id);

		if(complaintOptional.isPresent()){
			return complaintOptional;
		}
		return null;
	}

	public Optional<Complaint> findUserComplaint(Integer idUser, Integer idComplaint){

		Optional<User> userOptional = userRepo.findById(1);
		Optional<Complaint> complaintOptional = repo.findById(idComplaint);

		System.out.println(userOptional);
		System.out.println(complaintOptional);

		if(userOptional.isPresent() && complaintOptional.isPresent()){
			Integer complaintUserId = complaintOptional.get().getUser().getId();
			Integer searchUserId = userOptional.get().getId();
			if(complaintUserId.equals(searchUserId)){
				return complaintOptional;
			}

		}

		return Optional.empty();
	}
}
