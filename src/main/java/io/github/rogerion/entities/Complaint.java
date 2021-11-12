package io.github.rogerion.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.sun.istack.NotNull;

import io.github.rogerion.dto.ComplaintDTO;


@Entity
@Table(name="tb_complaint")
@NamedQuery(name="findUserComplaint",
	query = "SELECT c FROM Complaint c WHERE  c.user_id = CAST(:userId as int)")
@NamedQuery(name="findSpecificUserComplaint",
	query = "SELECT c FROM Complaint c WHERE  c.user_id = CAST(:userId as int) AND c.id = CAST(:complaintId as int)")
public class Complaint implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="themes")
	private Themes themes;
	
	@Column(nullable = false,length = 10)
	private String CEP;
	
	@Column(nullable = false)
	private String status;
	
	private String descricao;

	//Numero do endereco
	@Column(nullable = false, length = 6)
	private Integer numero;

	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private Date dataEnvio;
	
	private Date dataFim;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user_id;

	@Column(nullable = false)
	private String imageUrl;
	
	public Complaint() {
		super();
	}
	
	public Complaint(Integer id){
		this.id = id;
	}

	public Complaint(Integer id, Themes themes, String cEP, String status, String descricao,
			Integer numero, String endereco, Date dataEnvio, Date dataFim, User user, String imageUrl) {
		super();
		this.id = id;
		this.themes = themes;
		this.CEP = cEP;
		this.status = status;
		this.descricao = descricao;
		this.numero = numero;
		this.endereco = endereco;
		this.dataEnvio = dataEnvio;
		this.dataFim = dataFim;
		this.user_id = user;
		this.imageUrl = imageUrl;
	}



	public Complaint(ComplaintDTO entity) {
		this.id = entity.getId();
		this.themes = entity.getThemes();
		this.CEP = entity.getCEP();
		this.status = entity.getStatus();
		this.descricao = entity.getDescricao();
		this.numero = entity.getNumero();
		this.endereco = entity.getEndereco();
		this.dataEnvio = entity.getDataEnvio();
		this.dataFim = entity.getDataFim();
		this.user_id = entity.getUser();
		this.imageUrl = entity.getImageUrl();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return user_id;
	}

	public void setUser(User user) {
		this.user_id = user;
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
