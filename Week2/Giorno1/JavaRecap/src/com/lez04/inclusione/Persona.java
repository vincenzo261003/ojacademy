package com.lez04.inclusione;

public class Persona {

	private String nominativo;
	
	private Indirizzo spedizione;
	private Indirizzo fatturazione;
	
	public Persona(String nominativo, Indirizzo spedizione, Indirizzo fatturazione) {
		super();
		this.nominativo = nominativo;
		this.spedizione = spedizione;
		this.fatturazione = fatturazione;
	}
	
	public String getNominativo() {
		return nominativo;
	}
	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}
	public Indirizzo getSpedizione() {
		return spedizione;
	}
	public void setSpedizione(Indirizzo spedizione) {
		this.spedizione = spedizione;
	}
	public Indirizzo getFatturazione() {
		return fatturazione;
	}
	public void setFatturazione(Indirizzo fatturazione) {
		this.fatturazione = fatturazione;
	}
	@Override
	public String toString() {
		return "Persona [nominativo=" + nominativo + ", spedizione=" + spedizione + ", fatturazione=" + fatturazione
				+ "]";
	}
	
	
}
