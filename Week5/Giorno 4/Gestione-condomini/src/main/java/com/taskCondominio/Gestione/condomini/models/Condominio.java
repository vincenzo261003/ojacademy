package com.taskCondominio.Gestione.condomini.models;

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
@Table(name = "Condomini")
public class Condominio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idcondominio;
	
	@Column
    private String indirizzo;
	
	@Column
    private String nome;
	
	@Column
    private String codice;
	
	@OneToMany(mappedBy = "condominio", fetch = FetchType.LAZY )
	private List<Utente> elenco_utenti;
	
	@OneToMany(mappedBy = "condominio", fetch = FetchType.LAZY )
	private List<Avviso> elenco_avvisi;
    
    public List<Avviso> getElenco_avvisi() {
		return elenco_avvisi;
	}

	public void setElenco_avvisi(List<Avviso> elenco_avvisi) {
		this.elenco_avvisi = elenco_avvisi;
	}

	public Condominio() {}

	public Integer getIdcondominio() {
		return idcondominio;
	}

	public void setIdcondominio(Integer idcondominio) {
		this.idcondominio = idcondominio;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public List<Utente> getElenco_utenti() {
		return elenco_utenti;
	}

	public void setElenco_utenti(List<Utente> elenco_utenti) {
		this.elenco_utenti = elenco_utenti;
	}
    
}