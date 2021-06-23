package io.github.rogerion.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import io.github.rogerion.dto.ComplaintDTO;


@Entity
@Table(name="tb_complaint")
public class Complaint implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private String protocol;
	
	@ManyToOne
	@JoinColumn(name="themes")
	private Themes themes;
	
	@NotNull
	private String CEP;
	
	@NotNull
	private String status;
	
	private String descricao;
	
	@NotNull
	private Integer numero;
	
	@NotNull
	private String endereco;
	
	@NotNull
	private Date dataEnvio;
	
	private Date dataFim;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@NotNull
	private String imageUrl;
	
	//Adicionar foto
	
	public Complaint() {
		super();
	}
	
	

	public Complaint(Integer id, String protocol, Themes themes, String cEP, String status, String descricao,
			Integer numero, String endereco, Date dataEnvio, Date dataFim, User user, String imageUrl) {
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
		this.imageUrl = imageUrl;
	}



	public Complaint(ComplaintDTO entity) {
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
		this.imageUrl = entity.getImageUrl();
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

	public void setCEP(String CEP) {
		this.CEP = CEP;
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

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
		Complaint other = (Complaint) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
