package Albergo.Task02.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Alberghi")
public class Albergo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idAlbergo;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String contattoTelefonico;
	
	@Column
	private Integer stelle;
	
	@OneToMany(mappedBy = "struttura", fetch = FetchType.EAGER)
	private List<Stanza> elencoStanze;

	public Albergo(String nome, String email, String contattoTelefonico, Integer stelle) {
		super();
		this.nome = nome; 
		this.email = email;
		this.contattoTelefonico = contattoTelefonico;
		this.stelle = stelle;
	}
	
	public Albergo() {}

	public Integer getIdAlbergo() {
		return idAlbergo;
	}

	public void setIdAlbergo(Integer idAlbergo) {
		this.idAlbergo = idAlbergo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContattoTelefonico() {
		return contattoTelefonico;
	}

	public void setContattoTelefonico(String contattoTelefonico) {
		this.contattoTelefonico = contattoTelefonico;
	}

	public Integer getStelle() {
		return stelle;
	}

	public void setStelle(Integer stelle) {
		this.stelle = stelle;
	}

	public List<Stanza> getElencoStanze() {
		return elencoStanze;
	}

	public void setElencoStanze(List<Stanza> elencoStanze) {
		this.elencoStanze = elencoStanze;
	}

	@Override
	public String toString() {
		String elenco = "\n";
		for (Stanza x: elencoStanze)
			elenco += x.getDettagli() + "\n";
		return "Albergo [idAlbergo=" + idAlbergo + ", nome=" + nome + ", email=" + email + ", contattoTelefonico="
				+ contattoTelefonico + ", stelle=" + stelle + ", \nelencoStanze=" + elenco + "]";
	}
	
	public String dettagli() {
		return "Albergo [idAlbergo=" + idAlbergo + ", nome=" + nome + ", email=" + email + ", contattoTelefonico="
				+ contattoTelefonico + ", stelle=" + stelle + "]";
	}
	
}
