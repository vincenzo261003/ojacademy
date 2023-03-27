package com.taskPalestra.GestionePalestra.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CorsoDto {

	private String codice;
	private String nome;
	private Integer duratacorso;
	private LocalDateTime datacorso;
	private String livellocorso;
	
	@JsonManagedReference
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private List<UtenteDto> elenco_iscritti = new ArrayList<UtenteDto>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDuratacorso() {
		return duratacorso;
	}

	public void setDuratacorso(Integer duratacorso) {
		this.duratacorso = duratacorso;
	}

	public LocalDateTime getDatacorso() {
		return datacorso;
	}

	public void setDatacorso(LocalDateTime datacorso) {
		this.datacorso = datacorso;
	}

	public String getLivellocorso() {
		return livellocorso;
	}

	public void setLivellocorso(String livellocorso) {
		this.livellocorso = livellocorso;
	}

	public List<UtenteDto> getElenco_iscritti() {
		return elenco_iscritti;
	}

	public void setElenco_iscritti(List<UtenteDto> elenco_iscritti) {
		this.elenco_iscritti = elenco_iscritti;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
}
