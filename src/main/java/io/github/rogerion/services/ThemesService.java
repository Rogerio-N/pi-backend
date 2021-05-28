package io.github.rogerion.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.rogerion.dto.ThemesDTO;
import io.github.rogerion.entities.Themes;
import io.github.rogerion.repositories.ThemesRepository;

@Service
public class ThemesService {

	@Autowired
	private ThemesRepository repo;
	
	@Transactional(readOnly = true)
	public List<ThemesDTO> findAll(){
		
		List<Themes> themesEntity = repo.findAll();
		List<ThemesDTO> themesDTO = new ArrayList<ThemesDTO>();
		
		for(int i=0; i<themesEntity.size();i++) {
			//Convert the entity Theme into ThemeDTO
			ThemesDTO temp = new ThemesDTO(themesEntity.get(i));
			//Adding the converted Entity into the list of themesDTO
			themesDTO.add(temp);
		}
		
		return themesDTO;
	}
	
}
