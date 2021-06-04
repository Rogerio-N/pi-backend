package io.github.rogerion.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="tb_complaint")
public class Complaint implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String protocol;
	@NotNull
	private Integer themeId;
	@NotNull
	private String CEP;
	@NotNull
	private String status;
	private String descricao;
	@NotNull
	private Integer numero;
	
	//Adicionar foto, endereco e data
}
