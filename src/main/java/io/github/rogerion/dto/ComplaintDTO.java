package io.github.rogerion.dto;

import java.io.Serializable;
import java.util.Date;

import io.github.rogerion.entities.Complaint;
import io.github.rogerion.entities.Themes;
import io.github.rogerion.entities.User;

public class ComplaintDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String protocol;
	private Themes themes;
	private String CEP;
	private String status;
	private String descricao;
	private Integer numero;
	private String endereco;
	private Date dataEnvio;
	private Date dataFim;
	private User user;
	
	//Adicionar foto
	
	public ComplaintDTO() {
		super();
	}
	

	public ComplaintDTO(Integer id, String protocol, Themes themes, String cEP, String status, String descricao,
			Integer numero, String endereco, Date dataEnvio, Date dataFim,User user) {
		super();
		this.id = id;
		this.protocol = protocol;
		this.themes = themes;
		this.CEP = cEP;
		this.status = status;
		this.descricao = descricao;
		this.numero = numero;
		this.endereco = endereco;
		this.dataEnvio = dataEnvio;
		this.dataFim = dataFim;
		this.user = user;
	}



	public ComplaintDTO(Complaint entity) {
		super();
		this.id = entity.getId();
		this.protocol = entity.getProtocol();
		this.themes = entity.getThemes();
		this.CEP = entity.getCEP();
		this.status = entity.getStatus();
		this.descricao = entity.getDescricao();
		this.numero = entity.getNumero();
		this.endereco = entity.getEndereco();
		this.dataEnvio = entity.getDataEnvio();
		this.dataFim = entity.getDataFim();
		this.user = entity.getUser();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public Themes getThemes() {
		return themes;
	}

	public void setThemes(Themes themes) {
		this.themes = themes;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	
	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		ComplaintDTO other = (ComplaintDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
