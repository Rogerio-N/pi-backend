package io.github.rogerion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import io.github.rogerion.dto.ComplaintDTO;
import io.github.rogerion.entities.Complaint;
import io.github.rogerion.repositories.ComplaintRepository;
import io.github.rogerion.utilities.AcessaDisco;

@Service
public class ComplaintService {

	@Autowired
	public ComplaintRepository repo;
	
	@Autowired
	public AcessaDisco acesso;
	
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
		Complaint complaintEntity = new Complaint(c.getId(),c.getProtocol(),c.getThemes(),c.getCEP(),c.getStatus(),c.getDescricao(),c.getNumero(),c.getEndereco(),c.getDataEnvio(),c.getDataFim(),c.getUser(),c.getImageUrl());
		complaintEntity = repo.save(complaintEntity);
		return new ComplaintDTO(complaintEntity);
	}
	
	public List<ComplaintDTO> findByProtocol(String e){
		List<Complaint> list = repo.findByProtocol(e);
		List<ComplaintDTO> listDTO = new ArrayList<ComplaintDTO>();
		
		for(int i = 0; i<list.size();i++) {
			
			ComplaintDTO temp = new ComplaintDTO(list.get(i));
			listDTO.add(temp);
			
		}
		
		return listDTO;
	}
	
}
