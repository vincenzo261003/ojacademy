package com.lez02.refactor.models;

public class Prodotto {

	private Integer prodottoID;
	private String codice;
	private String nome;
	private Integer quantita;
	private String categoria;
	private Float prezzo;
	
	public Prodotto() {
		
	}
	public Prodotto(String codice, String nome, Integer quantita, String categoria, Float prezzo) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.quantita = quantita;
		this.categoria = categoria;
		this.prezzo = prezzo;
	}
	public Integer getProdottoID() {
		return prodottoID;
	}
	public void setProdottoID(Integer prodottoID) {
		this.prodottoID = prodottoID;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getQuantita() {
		return quantita;
	}
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Float prezzo) {
		this.prezzo = prezzo;
	}
	
	@Override
	public String toString() {
		return "Prodotto [prodottoID=" + prodottoID + ", codice=" + codice + ", nome=" + nome + ", quantita=" + quantita
				+ ", categoria=" + categoria + ", prezzo=" + prezzo + "]";
	}
	
	
	
	
	
}
