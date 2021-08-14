package io.github.rogerion.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

import io.github.rogerion.dto.ThemesDTO;

@Entity
@Table(name="tb_themes")
public class Themes implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 50)
	private String name;
	@Column(nullable = false)
	private String photo;
	
	@OneToMany(mappedBy = "themes")
	private List <Complaint> complaint;
	
	public Themes() {
		super();
	}
	
	public Themes(Integer id) {
		super();
		this.id = id;
	}
	
	public Themes(Integer id, String nome, String photo) {
		super();
		this.id = id;
		this.name = nome;
		this.photo = photo;
	}
	
	public Themes(ThemesDTO entity) {
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
		Themes other = (Themes) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
