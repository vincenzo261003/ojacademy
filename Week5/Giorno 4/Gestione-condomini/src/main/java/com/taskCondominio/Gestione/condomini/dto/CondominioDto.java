package com.taskCondominio.Gestione.condomini.dto;

import java.util.List;

import com.taskCondominio.Gestione.condomini.models.Avviso;

public class CondominioDto {

    private String indirizzo;
    private String nome;
    private String codice;
    private List<UtenteDto> elenco_utenti;
    private List<Avviso> elenco_avvisi;
    
    public CondominioDto () {}

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

	public List<UtenteDto> getElenco_utenti() {
		return elenco_utenti;
	}

	public void setElenco_utenti(List<UtenteDto> elenco_utenti) {
		this.elenco_utenti = elenco_utenti;
	}

	public List<Avviso> getElenco_avvisi() {
		return elenco_avvisi;
	}

	public void setElenco_avvisi(List<Avviso> elenco_avvisi) {
		this.elenco_avvisi = elenco_avvisi;
	}
	
}
