package com.gestioneannunci.Gestione.annunci.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Utenti")
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idutente;
	
	@Column
	private String username;
	
	@Column
	private String pass;
	
	@Column
	private String email;
	
	@Column
	private String telefono;
	
	@OneToMany(mappedBy = "autore", fetch = FetchType.LAZY )
	private List<Annuncio> elencoAnnunci;

	public Integer getIdutente() {
		return idutente;
	}

	public void setIdutente(Integer idutente) {
		this.idutente = idutente;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Annuncio> getElencoAnnunci() {
		return elencoAnnunci;
	}

	public void setElencoAnnunci(List<Annuncio> elencoAnnunci) {
		this.elencoAnnunci = elencoAnnunci;
	}
	
}
