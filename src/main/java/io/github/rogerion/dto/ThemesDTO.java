package io.github.rogerion.dto;

import java.io.Serializable;

import io.github.rogerion.entities.Themes;

public class ThemesDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String photo;
	
	public ThemesDTO() {
		super();
	}
	
	public ThemesDTO(Integer id, String name, String photo) {
		super();
		this.id = id;
		this.name = name;
		this.photo = photo;
	}
	
	public ThemesDTO(Themes entity) {
		super();
		this.id = entity.getId();
		this.name = entity.getName();
		this.photo = entity.getPhoto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ThemesDTO other = (ThemesDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
